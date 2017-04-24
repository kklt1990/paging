package com.kklt.paging.services.impl;

import com.kklt.paging.dao.StudentDao;
import com.kklt.paging.dao.impl.StudentDaoImpl;
import com.kklt.paging.entity.Page;
import com.kklt.paging.entity.Student;
import com.kklt.paging.services.StudentSer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 17-4-22.
 */
public class StudentSerImplTest {
    @Test
    public void getOnePageByStudentList() throws Exception {
        Student student = new Student();
        StudentDao studentDao = new StudentDaoImpl();
        StudentSerImpl studentSer = new StudentSerImpl();
        studentSer.setStudentDao(studentDao);
        Page<Student> onePageByStudent = studentSer.getOnePageByStudent(student, 3, 2);
        System.out.println(onePageByStudent.toString());
    }

}