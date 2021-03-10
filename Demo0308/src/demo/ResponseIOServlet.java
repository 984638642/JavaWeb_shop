package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 作者：zhanwei
 * 时间:21/03/08  15:02
 * 描述：
 */
@WebServlet(name = "ResponseIOServlet",urlPatterns = "/ResponseIO.do")
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应的乱码解决
        //方案一：不推荐
        //设置服务器字符为UTF-8
//        response.setCharacterEncoding("UTF-8");
        //设置响应头，设置浏览器也使用UTF-8
//        response.setHeader("content-Type","text/html;charset=UTF-8");
        //方案二：推荐使用
        //它会同时设置服务器跟客户端都使用UTF-8字符来编码
        //该方法一定要在获取流对象之前使用才有效
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer=response.getWriter();
        writer.write("<h1>响应的字符串内容</h1>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
