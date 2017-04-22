package com.kklt.paging.dao;

import com.kklt.paging.entity.Page;
import com.kklt.paging.entity.Student;

import java.util.List;

/**
 * Created by root on 17-4-21.
 */
public interface StudentDao {
    /**
     * 根据id查找学生
     * @return
     */
    public Student findById(Integer id);

    /**
     * 查找所有的学生
     * @return
     */
    public List<Student> findAll();

    public Page<Student> findAPage(Student student,Integer pageNumber,Integer pageSize);

}
