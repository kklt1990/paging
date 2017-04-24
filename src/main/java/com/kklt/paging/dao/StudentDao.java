package com.kklt.paging.dao;

import com.kklt.paging.entity.Page;
import com.kklt.paging.entity.Student;

import java.util.List;

/**
 * Created by root on 17-4-21.
 */
public interface StudentDao {

    /**
     * 根据输入的学生的信息查询出匹配的学生的列表
     * @param student
     * @return
     */
    public List<Student> findByStudent(Student student);

}
