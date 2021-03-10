package com.shop.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者：zhanwei
 * 时间:21/03/06  18:37
 * 描述：
 */
@WebServlet("/login3")
public class Demo03Servlet extends HttpServlet {
    List<User> userList = new ArrayList<>();
    ServletContext context;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(request.getParameter("username"), request.getParameter("password"));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (userList.contains(user)) {
            user=userList.get(userList.indexOf(user));
            writer.append("<h1>" + user.getUserName() + "登录成功！</h1>");
            Integer count= (Integer) context.getAttribute("count");
            if(count==null){
                count=0;
            }
            writer.append("<h1>您是该网址第"+(++count)+"个登录的用户</h1>");
            writer.append("<h1>该用户第"+(user.getLoginCount()+1)+"次登录</h1>");
            if (user.getLastTime() != null) {
                writer.append("<h1>上次登录时间："+user.getLastTime()+"</h1>");
            }
            context.setAttribute("count",count);
            user.setLoginCount(user.getLoginCount()+1);
            user.setLastTime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
        } else {
            writer.append("<h1>账号或者密码不正确！</h1>");
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
        userList.add(new User(context.getInitParameter("username"), context.getInitParameter("password"),
                null, null));
        userList.add(new User("123", "123", null, null));
        userList.add(new User("1234", "1234", null, null));
        userList.add(new User("12345", "12345", null, null));
        userList.add(new User("123456", "123456", null, null));
    }
}
