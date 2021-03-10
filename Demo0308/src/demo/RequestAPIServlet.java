package demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：zhanwei
 * 时间:21/03/08  09:52
 * 描述：
 */
@WebServlet("/Request")
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的资源路径 URI
        System.out.println("URI="+req.getRequestURI());
        //2.获取请求的统一资源定位 URL
        System.out.println("URL="+req.getRequestURL());
        //3.获取客户端的IP地址
        System.out.println("客户端IP地址="+req.getRemoteHost());
        System.out.println("客户端getRemoteAddR="+req.getRemoteAddr());
        //4.获取请求头
        System.out.println("请求头="+req.getHeader("Cookie"));
        //5.获取请求方式的GET或者POST
        System.out.println("请求方式："+req.getMethod());

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
