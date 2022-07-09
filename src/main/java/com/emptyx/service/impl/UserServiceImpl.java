package com.emptyx.service.impl;

import com.emptyx.dao.user.UserDao;
import com.emptyx.entity.User;
import com.emptyx.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author emptyx
 * @Date 2022/6/20 13:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public User queryUserPassword(User user) {
        return userDao.selectByAccount(user);
    }
}
