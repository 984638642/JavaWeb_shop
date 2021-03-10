package com.shop.Servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 作者：zhanwei
 * 时间:21/03/08  15:44
 * 描述：
 */
@WebServlet(name = "VerifyCodeServlet", urlPatterns = "/VerifyCode.do")
public class VerifyCodeServlet extends HttpServlet {
    ServletContext context;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.使用bufferedImage创建图片
         * 2.Graphics绘制内容
         * 绘制显示区域
         * 绘制随机字符
         * 绘制干扰性
         * 3.使用ImageIO将BufferedImage写到浏览器
         * 必须使用response.getOutputStream
         */
        //1.高和宽
        int height = 30;
        int width = 80;
        //验证码中可能会出现的字符
        String data = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        //随机数对象
        Random random = new Random();
        //2.创建一个图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //3.获得画板
        Graphics g = image.getGraphics();
        //4.填充一个矩形
        //填充背景颜色为黑色，整个填充
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        //填充背景颜色为白色，距离边框1px填充，形成一个黑色边框，内部是白色的图片
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, width - 2, height - 2);
        //设置验证码字体
        g.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 25));
        //5.生成4位验证码
        String code = "";
        for (int i = 0; i < 4; i++) {
            //设置随机颜色
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            //随机数
            int index = random.nextInt(data.length());
            //获得随机字
            String str = data.substring(index, index + 1);
            //将字写入code中用于验证
            code += str;
            //写入
            g.drawString(str, width / 6 * (i + 1), 20);
        }
        //6.生成干扰线
        for (int i = 0; i < 3; i++) {
            //设置随机颜色
            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            //绘制随机线
            g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
            //随机点
            g.drawOval(random.nextInt(width), random.nextInt(height), 2, 2);
        }
        //将图片响应给浏览器
        ImageIO.write(image, "jpg", response.getOutputStream());
        //将验证码存入ServletContext对象的属性中
        context.setAttribute("code", code);
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        context = config.getServletContext();
    }
}
