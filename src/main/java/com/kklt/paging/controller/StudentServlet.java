package com.kklt.paging.controller;

import com.kklt.paging.dao.StudentDao;
import com.kklt.paging.dao.impl.StudentDaoImpl;
import com.kklt.paging.entity.Page;
import com.kklt.paging.entity.Student;
import com.kklt.paging.services.impl.StudentSerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 17-4-22.
 */
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取分页的参数
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String sex = req.getParameter("sex");
        String name = req.getParameter("stuName");
        String pageNumber = req.getParameter("pageNumber");

        //将获取的参数进行封装
        Student student = new Student();
        if (id!=null&&id.trim()!=""){
            student.setId(Integer.valueOf(id));
        }
        if(sex!=null){
            student.setSex(Integer.valueOf(sex));
            req.setAttribute("sex",sex);
        }
        if (name!=null&&name.trim()!=""){
            student.setName(name);
            req.setAttribute("stuName",name);
        }
        if(pageNumber==null||pageNumber.trim()==""){
            pageNumber = "1";
        }
        //获取页面数据
        StudentDao studentDao = new StudentDaoImpl();
        StudentSerImpl studentSer = new StudentSerImpl();
        studentSer.setStudentDao(studentDao);
        Page<Student> onePageByStudent = studentSer.getOnePageByStudent(student,
                10, Integer.valueOf(pageNumber));
        //重定向到展示页面
        req.setAttribute("page", onePageByStudent);
        req.getRequestDispatcher("/jsp/subListStudent.jsp").forward(req, resp);


    }
}




