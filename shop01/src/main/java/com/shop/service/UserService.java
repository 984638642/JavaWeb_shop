package com.shop.service;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;

/**
 * 作者：zhanwei
 * 时间:21/03/09  18:04
 * 描述：
 */
public class UserService {
    UserDao userDao = new UserDaoImpl();

    /**
     * @param user
     * @return 账号已存在为-1，添加成功为0，添加出错为1
     */
    public int insert(User user) {
        User user1 = userDao.queryUserByUsername(user.getUsername());
        if (user1 == null) {
            if (userDao.insert(user) == 1) {
                return 0;
            }
            return 1;
        } else {
            return -1;
        }
    }

    /**
     *
     * @param user
     * @return 账号不存在返回-1，密码正确返回0，密码错误返回1
     */
    public int Login(User user) {
        User user1 = userDao.queryUserByUsername(user.getUsername());
        if (user1 != null) {
            if(user.equals(user1)){
                return 0;
            }else{
                return 1;
            }
        } else {
            return -1;
        }
    }
}
