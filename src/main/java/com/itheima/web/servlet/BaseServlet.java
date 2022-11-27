package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 胡桃
 * @Date: 2022-11-14 21:57
 * @Description: com.itheima.web.servlet
 * @version: 1.0
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI(); // /brand-case/brand/selectAll

        int index = uri.lastIndexOf('/');
        String substring = uri.substring(index + 1);

        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            Method method = aClass.getMethod(substring, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
