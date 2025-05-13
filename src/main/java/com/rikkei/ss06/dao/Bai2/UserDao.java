package com.rikkei.ss06.dao.Bai2;

import com.rikkei.ss06.model.User;

public interface UserDao {
    boolean register(User user);
    User login(String username, String password);
    boolean checkUsernameExists(String username);
}
