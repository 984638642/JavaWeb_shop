package com.shop.test;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.service.UserService;
import org.junit.Test;

/**
 * 作者：zhanwei
 * 时间:21/03/09  17:25
 * 描述：
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    UserService userService=new UserService();
    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void insert() {
        User user = new User("12345", "12345", "12345@qq.com");
        System.out.println(userService.insert(user));
//        System.out.println(userDao.insert(user));
    }
}
