package com.shop.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：zhanwei
 * 时间:21/03/05  14:12
 * 描述：
 */
public class Demo02Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext类的四个作用
        //1.获取web.xml中配置的上下文参数context-param
        //ServletContext对象在整个工程中只有一个
        //所有不同类中调用getServletContext方法，获取到是同一个对象
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        Integer age = Integer.valueOf(context.getInitParameter("age"));
        System.out.println("username：" + username);
        System.out.println("password：" + password);
        System.out.println("age：" + age);
        //2.获取当前的工程路径，格式：/工程路径
        System.out.println("当前工程路径：" + context.getContextPath());
        //3.获取工程部署后再服务器硬盘上的绝对路径
        System.out.println("工程部署的路径：" + context.getRealPath("/"));
        System.out.println("login.html的路径" + context.getRealPath("/login.html"));
    }

    ServletContext context = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
        System.out.println("servlet-name：" + config.getServletName());
        System.out.println("user：" + config.getInitParameter("username"));
        System.out.println("url：" + config.getInitParameter("url"));
    }
}
