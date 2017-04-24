package com.kklt.paging.dao.impl;

import com.kklt.paging.dao.StudentDao;
import com.kklt.paging.db.JdbcConnectionUtil;
import com.kklt.paging.dictionary.StudentSex;
import com.kklt.paging.entity.Page;
import com.kklt.paging.entity.Student;
import com.mysql.jdbc.JDBC4Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 17-4-21.
 */
public class StudentDaoImpl implements StudentDao{

    /**
     * 根据页码和单页的记录数查询出单页的数据
     * @param student
     * @return
     */
    public List<Student> findByStudent(Student student) {
        //1. 获取数据库连接
        Connection connection = JdbcConnectionUtil.getConnection();
        //2.定义sql参数数列表
        List<Object> paramList = new ArrayList<Object>();
        //3. 拼接sql语句
        StringBuffer stringBuffer = new StringBuffer(
                "select id,name,sex,age,address from student where 1=1 ");
        if (student!=null){
            //判断是否根据输入的学生id进行查询
            if (student.getId()!=null){
                stringBuffer.append("and id=? ");
                paramList.add(student.getId()+"");

            }
            //判断是否根据姓名进行模糊匹配
            if (student.getName()!=null&&student.getName()!=" "){
                stringBuffer.append("and name like ? ");
                paramList.add("%"+student.getName()+"%");
            }
            //判断是否根据学生的性别进行匹配
            if (student.getSex()!=null&&
                    (student.getSex()==StudentSex.FEMALE||student.getSex()==StudentSex.MALE)){
                stringBuffer.append("and sex=? ");
                paramList.add(student.getSex()+"");
            }
        }
        //4.根据预编译的sql语句进行查询并返回结果
        List<Student> studentList =null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString());
            if (paramList!=null&&!paramList.isEmpty()){
                int i = 1;
                for (Object object:paramList){
                    preparedStatement.setString(i, (String) object);
                    i++;
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            //结果的列号是从1开始的,查询出来的结果放入学生对象中
            studentList = getStudentListUtil(resultSet);
        } catch (Exception e) {
            throw new RuntimeException("查询失败");
        }finally {
            //关闭数据库连接
            JdbcConnectionUtil.closeConnection(connection);
        }

        return studentList;
    }

    /**
     * 讲查询的结果放入学生对象的链表中
     * @param resultSet
     * @return
     */
    private List<Student> getStudentListUtil(ResultSet resultSet){
        if (resultSet==null){
            return null;
        }
        //存放查询出来的学生结果
        List<Student> studentList = new LinkedList<Student>();
        try {
            while (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setSex(resultSet.getInt(3));
                student.setAge(resultSet.getByte(4));
                student.setAddress(resultSet.getString(5));
                /*System.out.println(student.toString());*/
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return studentList;
    }

}
