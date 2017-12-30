package com.zsb.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*@interface声明的是注解，可以ctrl+左键或者ctrl+b进入查看
 * annotation
 * 声明注解类中的方法是使用注解时的属性，注解不会改变程序的编译方式，
 * java编译器对于包含注解和不包含注解的code 会生成相同的VM指令
 * */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**/
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String currentTime = dateFormat.format(new Date());

        req.setAttribute("now",currentTime);
        //请求调度器，通过请求调度器，调度一个参数到想要调度的服务器位置
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp");
        //服务器接过客户端发来的请求，传递到参数调度的位置
        requestDispatcher.forward(req,resp);
    }
}
