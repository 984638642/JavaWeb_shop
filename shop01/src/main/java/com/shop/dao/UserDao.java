package com.shop.dao;

import com.shop.bean.User;

/**
 * 作者：zhanwei
 * 时间:21/03/09  16:41
 * 描述：
 */
public interface UserDao {
    /**
     *
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);
    public int insert(User user);
}
