package com.kklt.paging.services.impl;

import com.kklt.paging.dao.StudentDao;
import com.kklt.paging.entity.Page;
import com.kklt.paging.entity.Student;
import com.kklt.paging.services.StudentSer;

import java.util.List;

/**
 * Created by root on 17-4-22.
 */
public class StudentSerImpl implements StudentSer{
    //注入studentDao,什么时候初始化
    private StudentDao studentDao;
    public Page<Student> getOnePageByStudent(Student student,Integer pageSize,Integer pageNumber) {
        List<Student> studentList = studentDao.findByStudent(student);
        Page<Student> studentPage = new Page<Student>(studentList,pageSize,pageNumber);
        return  studentPage;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
