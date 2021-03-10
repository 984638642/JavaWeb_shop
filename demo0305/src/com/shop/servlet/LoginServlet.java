package com.shop.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 作者：zhanwei
 * 时间:21/03/05  11:14
 * 描述：
 * 需求：当用户登录成功后，在浏览器页面上提示用户，您是第几个登录成功的用户
 * 拓展：弄一个集合，摸你数据库，登录在集合中校验。用户登录成功后，
 * 获取到用户上次登录的时间（如果之前没有登录，就不现实时间），该用户第几次登录
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //ServletContext对象
    ServletContext context;
    //用户集合
    List<User> userList = new ArrayList<>();

    /**
     * 表单Post方式
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //User对象
        User user = new User();
        //获取表单提交的账户名
        user.setUserName(request.getParameter("username"));
        //获取表单提交的密码
        user.setPassword(request.getParameter("password"));
        //修改ServletResponse类型，避免中文乱码
        response.setContentType("text/html;charset=utf-8");
        //获取Writer对象，用于传输给前端
        Writer writer = response.getWriter();
        //判断账户密码是否存在
        if (userList.contains(user)) {
            //获取对应在数组中的用户
            user=userList.get(userList.indexOf(user));
            //记录所有用户登录过多少次
            Integer count = (Integer) context.getAttribute("count");
            //如果为空则为0
            if (count == null) {
                count = 0;
            }
            //提示信息
            writer.write("<h1>" + user.getUserName() + "登录成功</h1>");
            writer.write("<h1>该用户第" + (user.getLoginCount() + 1) + "次登录</h1>");
            writer.write("<h1>您是第" + (++count) + "个登录成功的用户</h1>");
            if (user.getLastTime() != null) {
                writer.write("<h1>上次登录的时间：" + (user.getLastTime()) + "</h1>");
            }
            //将所有用户登录的次数保存为ServletContext对象的属性
            context.setAttribute("count", count);
            //保存登录次数
            user.setLoginCount(user.getLoginCount() + 1);
            //保存登录时间为当前时间
            user.setLastTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        } else {
            //提示信息
            writer.write("<h1>用户名或密码错误</h1>");
        }
    }

    /**
     * 初始化
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        //获得ServletContext对象
        context = config.getServletContext();
        //添加用户数据到集合模仿数据库
        userList.add(new User(context.getInitParameter("username"), context.getInitParameter("password"),
                null, null));
        userList.add(new User("123", "123", null, "2"));
        userList.add(new User("1234", "1234", null, "3"));
        userList.add(new User("12345", "12345", null, "4"));
    }
}
