package com.shop.servlet;

import java.util.Objects;

/**
 * 作者：zhanwei
 * 时间:21/03/05  15:40
 * 描述：
 */
public class User {
    private String userName;    //账户名
    private String password;    //密码
    private String lastTime;    //最后登录时间
    private Integer loginCount; //登录次数

    /**
     * 无参构造
     */
    public User() {
    }

    /**
     * 有参构造
     *
     * @param userName   用户名
     * @param password   密码
     * @param lastTime   最后登录时间
     * @param loginCount 登录次数
     */
    public User(String userName, String password, String lastTime, String loginCount) {
        this.userName = userName;
        this.password = password;
        this.lastTime = lastTime;
        //如果传入的次数为null，则改为0
        if (loginCount == null) {
            this.loginCount = 0;
        } else {
            this.loginCount = Integer.valueOf(loginCount);
        }
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.lastTime = null;
        this.loginCount = 0;
    }

    /**
     * 重写equals方法
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastTime='" + lastTime + '\'' +
                ", loginCount=" + loginCount +
                '}';
    }
}
