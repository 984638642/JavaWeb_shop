package com.shop.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zhanwei
 * 时间:21/03/05  16:08
 * 描述：
 */
public class text {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("root", "root", null, "1"));
        users.add(new User("123", "123", null, "2"));
        users.add(new User("1234", "1234", null, "3"));
        users.add(new User("12345", "12345", null, "4"));
        User user = new User("123", "123", null, null);
//        System.out.println(users.contains(user));
//        users.forEach(u-> System.out.println(u));
        if (users.contains(user)) {
            user=users.get(users.indexOf(user));
            user.setLoginCount(0);
        } else {

        }
        users.forEach(u-> System.out.println(u));
        System.out.println(user);
    }
}
