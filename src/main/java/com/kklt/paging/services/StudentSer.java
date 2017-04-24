package com.kklt.paging.services;

import com.kklt.paging.entity.Page;
import com.kklt.paging.entity.Student;

import java.util.List;

/**
 * Created by root on 17-4-21.
 */
public interface StudentSer {
    /**
     * 根据查询出来的学生进行分页返回数据,使用sublist的方式
     * @param student
     * @param pageSize
     * @param pageNumber
     * @return
     */
    public Page<Student> getOnePageByStudent(Student student, Integer pageSize, Integer pageNumber);
}
