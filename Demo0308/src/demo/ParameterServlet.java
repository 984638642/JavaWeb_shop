package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 作者：zhanwei
 * 时间:21/03/08  10:20
 * 描述：
 */
@WebServlet("/Parameter")
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        //doGet请求的中文乱码解决
        //1.先以iso8859-1进行编码
        //2.再以utf-8进行编码
        username = new String(username.getBytes("iso-8859-1"), "utf-8");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("username=" + username);
        System.out.println("password=" + password);
        System.out.println("hobby=" + Arrays.asList(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST请求的中文乱码解决
        //设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        req.setCharacterEncoding("UTF-8");
        //获取ServletRequest对象中参数username的值
        String username = req.getParameter("username");
        //获取ServletRequest对象中参数password的值
        String password = req.getParameter("password");
        //获取ServletRequest对象中参数hobby的值
        String[] hobbies = req.getParameterValues("hobby");
        //register01.html
        System.out.println("用户名:" + username);
        System.out.println("密码:" + password);
        //如果直接打印将显示地址，用Arrays工具类将数组转为Array集合，Array集合内有toString方法
        System.out.println("兴趣爱好:" + Arrays.asList(hobbies));
    }
}
