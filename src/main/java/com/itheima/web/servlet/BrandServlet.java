package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @Auther: 胡桃
 * @Date: 2022-11-14 21:59
 * @Description: com.itheima.web.servlet
 * @version: 1.0
 */
@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private final BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Brand> brands = brandService.selectAll();
        String brands_json = JSON.toJSONString(brands);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(brands_json);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String json = reader.readLine();

        Brand brand = JSON.parseObject(json, Brand.class);

        brandService.add(brand);

        response.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String json_ids = reader.readLine();

        System.out.println("json_ids = " + json_ids);

        int[] ids = JSON.parseObject(json_ids, int[].class);

        brandService.deleteByIds(ids);

        response.getWriter().write("success");
    }

    public void selectPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String _currentPage = request.getParameter("currentPage");
        String _size = request.getParameter("size");
        int currentPage = Integer.parseInt(_currentPage);
        int size = Integer.parseInt(_size);

        PageBean<Brand> brandPageBean = brandService.selectPage(currentPage, size);

        String brands_json = JSON.toJSONString(brandPageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(brands_json);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String _currentPage = request.getParameter("currentPage");
        String _size = request.getParameter("size");
        int currentPage = Integer.parseInt(_currentPage);
        int size = Integer.parseInt(_size);

        BufferedReader reader = request.getReader();
        String line = reader.readLine();

        Brand brand = JSON.parseObject(line, Brand.class);

        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, size, brand);

        String jsonString = JSON.toJSONString(brandPageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
