package com.kklt.paging.entity;

import java.io.Serializable;

/**
 * Created by root on 17-4-20.
 */
public class Student implements Serializable{
    /**
     * id 学生的id
     */
    private Integer id;
    /**
     * name 学生的姓名
     */
    private String name;
    /**
     * age 学生的年龄
     */
    private Byte age;
    /**
     * sex 学生的性别
     */
    private Integer sex;
    /**
     * address 学生的地址
     */
    private String address;

    /**
     * 空的构造方法
     */
    public Student() {
    }

    /**
     * 所有参数的构造方法
     * @param id
     * @param name
     * @param age
     * @param sex
     * @param address
     */
    public Student(Integer id, String name, Byte age, Integer sex, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                '}';
    }
}
