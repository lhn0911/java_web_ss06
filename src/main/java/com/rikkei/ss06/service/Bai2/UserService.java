package com.rikkei.ss06.service.Bai2;

import com.rikkei.ss06.model.User;

public interface UserService {
    boolean register(User user);
    User login(String username, String password);
    boolean checkUsernameExists(String username);
}
