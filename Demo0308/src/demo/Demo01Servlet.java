package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：zhanwei
 * 时间:21/03/08  11:27
 * 描述：部门1 盖完章要去部门2
 */
@WebServlet(name = "Demo01Servlet", urlPatterns = "/demo01.do")
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //提示信息
        System.out.println("Servlet1(柜台1)的Get请求");
        //获取ServletRequest对象中ParameterName为username的值
        String username = request.getParameter("username");
        //提示信息
        System.out.println("在Servlet1(柜台1)中查看参数");
        //给一个材料盖章 并传递给Servlet2(柜台2) 去查看
        /**
         * 域对象：本质跟Map一样 键值对保存数据
         * 主要方法：getAttribute() setAttribute()
         * JavaWeb 4个域对象，在作用上都相同 不同之处在于 作用于大小
         * 从大到小如下：
         * 1.ServletContext:作用域 整个Web工程
         * 2.HttpSESSION:作用域 单次会话
         * 3.HttpRequest:作用域 单次请求
         * 4.PageContext:作用域 单个JSP页面
         */
        //给ServletRequest对象加一个属性，Key值为柜台1的公章
        request.setAttribute("key1", "柜台1的公章");
        //问路：在Servlet2怎么走(柜台2)怎么走
        /**
         * 请求转发的路径 也必须以/开头
         * 请求转发的固定写法，要修改的话 只能修改"/demo02.do",这个代表请求转发的路径
         */
        //将ServletRequest对象与ServletResponse对象转发给demo02.do
        request.getRequestDispatcher("/demo02.do").forward(request,resp);
        //请求转发，只能访问工程内部的资源路径，不能访问工程外的链接
//        request.getRequestDispatcher("https://www.baidu.com/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet1(柜台1)的Post请求");
    }
}
