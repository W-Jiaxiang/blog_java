package com.emptyx.service.user;

import com.emptyx.entity.User;

/**
 * @Author emptyx
 * @Date 2022/6/20 12:56
 */
public interface UserService {

    public int addUser(User user);

    public User queryUserPassword(User user);

}
