package com.shop.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：zhanwei
 * 时间:21/03/05  10:19
 * 描述：
 */
public class HelloServlet2 extends HttpServlet {
    //只设计用来处理get请求，只要重写doGet即可 其他方法不用考虑
    //因为在父类中 所有do方法都是400,、405，默认不允许客户端访问
    //所有我们只需要重写 允许访问的方法即可

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
