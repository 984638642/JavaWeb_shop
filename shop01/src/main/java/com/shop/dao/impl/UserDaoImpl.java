package com.shop.dao.impl;

import com.shop.bean.User;
import com.shop.dao.BaseDao;
import com.shop.dao.UserDao;

/**
 * 作者：zhanwei
 * 时间:21/03/09  16:43
 * 描述：
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`, `username`, `password`, `email` from T_user where `username` = ?";
        return super.queryForOne(User.class, sql, username);
    }

    @Override
    public int insert(User user) {
        String sql = "insert into T_user(`username`,`password`,`email`) values(?,?,?)";
        return super.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }


}
