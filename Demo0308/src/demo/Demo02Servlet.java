package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：zhanwei
 * 时间:21/03/08  11:36
 * 描述：
 */
@WebServlet(name = "Demo02Servlet", urlPatterns = "/demo02.do")
public class Demo02Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet2(柜台2)的Post请求");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //提示信息
        System.out.println("Servlet2(柜台2)的Get请求");
        //获取请求参数(办事材料) 查看
        //获取demo01.do转发过来的ServletRequest对象里的username的值
        String username = request.getParameter("username");
        //打印username的值
        System.out.println("username=" + username);
        //提示信息
        System.out.println("在Servlet2(柜台2)中查看参数");
        //查看柜台1 是否盖章
        System.out.println("在柜台1是否有章：" + request.getAttribute("key1"));
        System.out.println("在柜台2是否有章：" + request.getAttribute("key2"));
        //处理自己的业务
        System.out.println("Servlet2处理自己的业务");
        //如果柜台1有章的话，盖上柜台2的章
        if (request.getAttribute("key1") != null) {
            request.setAttribute("key2", "柜台2的公章");
        }
    }
}
