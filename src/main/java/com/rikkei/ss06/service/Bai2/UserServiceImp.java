package com.rikkei.ss06.service.Bai2;

import com.rikkei.ss06.dao.Bai2.UserDao;
import com.rikkei.ss06.dao.Bai2.UserDaoImp;
import com.rikkei.ss06.model.User;

public class UserServiceImp implements UserService{
    private final UserDao userDao;

    public UserServiceImp() {
        userDao = new UserDaoImp();
    }
    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return userDao.checkUsernameExists(username);
    }
}
