package com.Itransition.personalHub.User;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Date;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl mUserService;

    @GetMapping("/user/{username}")
    public ResponseEntity<Long> getUserId(@PathVariable String username) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/{username}").toUriString());
        return ResponseEntity.ok(mUserService.getUserId(username));
    }

    @PostMapping("/user/save")
    public ResponseEntity<Boolean> saveUser(@RequestBody UserEntity userEntity) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString());
        return ResponseEntity.created(uri).body(mUserService.saveUser(userEntity));
    }

    @PutMapping("/user/update/{username}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity, @PathVariable String username) {
        mUserService.updateUser(userEntity, username);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable String username) {
        mUserService.deleteUser(username);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/user/status/{username}")
    public ResponseEntity<?> changeRole(@PathVariable String username) {
        mUserService.changeRole(username);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        mUserService.refreshToken(request, response);
    }
}