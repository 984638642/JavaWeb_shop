package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 作者：zhanwei
 * 时间:21/03/08  14:13
 * 描述：
 */
@WebServlet(name = "FileDownloadServlet01", urlPatterns = "/fileDownload.do")
public class FileDownloadServlet01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //实现文件下载
        //获取ServletResponse对象的输出流
        OutputStream outputStream = response.getOutputStream();
        //用来表示 服务器端 需要传输给浏览器端的文件
        File file = new File("C:\\Users\\Administrator\\Desktop\\1.jpg");
        //通过响应 设置响应头 告诉浏览器 要下载文件
        response.setHeader("content-disposition", "attachment;fileName=" + new String("张三.jpg".getBytes("utf-8"), "ISO8859-1"));
        //获取文件输入流，将File类写入流中
        InputStream inputStream = new FileInputStream(file);
        //每次传递1kb
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            //将输入流的比特写入输出流
            outputStream.write(buffer);
            //刷新输出流
            outputStream.flush();
        }
        //关闭输入流
        inputStream.close();
        //关闭输出流
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("禁止访问");
    }
}
