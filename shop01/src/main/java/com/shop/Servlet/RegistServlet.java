package com.shop.Servlet;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
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
 * 时间:21/03/09  18:09
 * 描述：
 */
@WebServlet(name = "RegistServlet", urlPatterns = "/regist.do")
public class RegistServlet extends HttpServlet {
    UserService userService = null;
    ServletContext context = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = (String) context.getAttribute("code");
        String tip = null;
        if (code != context.getAttribute("code")) {
            tip = "验证码错误！";
            System.out.println(tip);
            request.setAttribute("tip", tip);
            response.sendRedirect("/pages/user/regist.html");
            return;
        }
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        switch (userService.insert(user)) {
//        switch (0) {
            case -1:
                tip = "账号已存在！";
                break;
            case 0:
                response.sendRedirect("/pages/user/regist_success.html");
                return;
            case 1:
                tip = "添加出错！";
                break;
            default:
        }
        request.setAttribute("tip", tip);
        response.sendRedirect("/pages/user/regist.html");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/pages/user/regist.html");
    }
}
