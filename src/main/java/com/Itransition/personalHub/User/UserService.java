package com.Itransition.personalHub.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    boolean saveUser (UserEntity userEntity);
    void deleteUser (String username);
    void updateUser (UserEntity userEntity, String username);
    UserEntity getUser (String username);
    void changeRole (String username);

    void refreshToken(HttpServletRequest request, HttpServletResponse response);
}
