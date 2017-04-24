package com.kklt.paging.dao.impl;

import com.kklt.paging.dao.StudentDao;
import com.kklt.paging.entity.Student;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 17-4-21.
 */
public class StudentDaoImplTest {
    @Test
    public void findAPage() throws Exception {
        Student student = new Student();
        student.setName("小");
        student.setSex(1);
        new StudentDaoImpl().findByStudent(student);
    }

}