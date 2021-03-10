package com.shop.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 作者：zhanwei
 * 时间:21/03/05  09:23
 * 描述：
 */
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("HelloServlet无参构造函数");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("HelloServlet被初始化");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法专门用来处理请求与响应
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问");
        //请求分发
        //请求信息的获取
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        //获取请求方式
        String method=request.getMethod();
        switch (method){
            case "GET":
                System.out.println("本次请求基于GET请求方式");
                break;
            case "POST":
                System.out.println("本次请求基于POST请求方式");
                break;
            case "PUT":
                System.out.println("本次请求基于PUT请求方式");
                break;
            case "DELETE":
                System.out.println("本次请求基于DELETE请求方式");
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet被摧毁");
    }
}
