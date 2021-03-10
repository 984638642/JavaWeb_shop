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
 * 时间:21/03/07  12:03
 * 描述：
 */
@WebServlet("/demo04")
public class Demo04Servlet extends HttpServlet {
    List<User> userList;
    ServletContext context;

    public Demo04Servlet() {
        userList = new ArrayList<>();
        context = null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        if (userList.contains(user)) {
            user=userList.get(userList.indexOf(user));
            user.setLoginCount(user.getLoginCount()+1);
            writer.append("<h1>"+user.getUserName()+"登录成功！</h1>");
            writer.write("<h1>该用户第" + user.getLoginCount() + "次登录！</h1>");
            Integer count= (Integer) context.getAttribute("count");
            context.setAttribute("count",count==null?1:count+1);
            writer.write("<h1>您是第" + context.getAttribute("count") + "个登录成功的用户！</h1>");
            if(user.getLastTime()!=null){
                writer.write("<h1>上次登录时间：" + user.getLastTime() + "</h1>");
            }
            user.setLastTime(new SimpleDateFormat("yyyy-MM-DD hh:mm:ss").format(new Date()));
        } else {
            writer.append("<h1>账号或密码错误</h1>");
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        userList.add(new User(username, password));
        userList.add(new User("123", "123"));
        userList.add(new User("1234", "1234"));
        userList.add(new User("12345", "12345"));
        userList.add(new User("123456", "123456"));
    }
}
