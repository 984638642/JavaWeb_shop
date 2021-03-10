package com.shop.Servlet;

import com.shop.bean.User;
import com.shop.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：zhanwei
 * 时间:21/03/09  20:39
 * 描述：
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    UserService userService = null;
    ServletContext context = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tip = null;
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        switch (userService.Login(user)) {
            case -1:
                tip = "账号不存在！";
                break;
            case 0:
                response.sendRedirect("/pages/user/login_success.html");
                return;
            case 1:
                tip = "密码错误！";
                break;
            default:
        }
        context.setAttribute("tip", tip);
        response.sendRedirect("/pages/user/login.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/pages/user/login.html");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
        userService = new UserService();
    }
}
