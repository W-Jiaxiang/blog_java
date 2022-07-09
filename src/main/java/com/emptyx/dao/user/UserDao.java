package com.emptyx.dao.user;

import com.emptyx.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author emptyx
 * @Date 2022/6/20 12:39
 */
//@Repository
@Mapper
public interface UserDao {

    int insert(User user);

    User selectByAccount(User user);

}
