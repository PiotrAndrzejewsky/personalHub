package com.Itransition.personalHub.User;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static com.Itransition.personalHub.security.CustomAuthenticationFilter.*;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository mUserRepository;
    @Autowired
    private PasswordEncoder mPasswordEncoder;

    @Override
    public boolean saveUser(UserEntity userEntity) {
        if (!doesUserExist(userEntity.getUsername())) {
            userEntity.setPassword(mPasswordEncoder.encode(userEntity.getPassword()));
            mUserRepository.save(userEntity);
            return true;
        }
        throw new UsernameNotFoundException("Username already taken");
    }

    @Override
    public void deleteUser(String username) {
        if (doesUserExist(username)) {
            mUserRepository.delete(mUserRepository.findByUsername(username).get());
        }
    }

    @Override
    public void updateUser(UserEntity userEntity, String username) {
        if (doesUserExist(username)) {
            deleteUser(username);
            saveUser(userEntity);
        }
        throw new UsernameNotFoundException("User was not found in the database");
    }

    @Override
    public UserEntity getUser(String username) {
        if (doesUserExist(username)) {
            return mUserRepository.findByUsername(username).get();
        }
        throw new UsernameNotFoundException("User was not found in the database");
    }

    @Override
    public void changeRole(String username) {
        UserEntity userEntity = getUser(username);
        userEntity.setAdmin(!userEntity.getAdmin());
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring("Bearer ".length());
            JWTVerifier jwtVerifier = JWT.require(ALGORITHM).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            String username = decodedJWT.getSubject();
            String accessToken = createToken(username, EXPIRATION_DATE, request.getRequestURL().toString());
            String refreshToken = createToken(username, EXPIRATION_DATE * 5, request.getRequestURL().toString());
            response.setHeader("access_token", accessToken);
            response.setHeader("refresh_token", refreshToken);
        }
        else {
            throw new RuntimeException("refresh token is missing");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = getUser(username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new User(username, userEntity.getPassword(), authorities);
    }

    public boolean doesUserExist(String username) {
        Optional<UserEntity> userEntity = mUserRepository.findByUsername(username);
        return userEntity.isPresent();
    }
}
