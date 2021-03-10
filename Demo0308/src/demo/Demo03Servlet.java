package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：zhanwei
 * 时间:21/03/08  15:12
 * 描述：
 */
@WebServlet(name = "Demo03Servlet", urlPatterns = "/demo03.do")
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求重定向的第一种方案
        //设置影响状态码302 表示重定向（原网址已搬迁）
        response.setStatus(302);
        //设置响应头，说明新的地址在哪里
        //访问站外网址：可行
//        response.setHeader("Location","https://www.baidu.com");
        //访问站内资源：可行
        // 因为请求重定向的地址 是发给浏览器进行解析 所以/按照浏览器的方式进行解释
//        response.setHeader("Location","/demo02.do");
        //请求重定向的第二种方案：建议使用
//        response.sendRedirect("http://localhost:8080/demo02.do");
        response.sendRedirect("https://www.baidu.com");
    }
}
