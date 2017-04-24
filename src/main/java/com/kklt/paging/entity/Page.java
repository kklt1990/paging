package com.kklt.paging.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by root on 17-4-20.
 */
public class Page<T> implements Serializable {
    /**
     * pageSize 每一页有多少条数据
     */
    private Integer pageSize;
    /**
     * currentPageNumber 当前页的页码
     */
    private Integer currentPageNumber;
    /**
     * totalSize 一共有多少条数据
     */
    private Integer totalRecordSize;
    /**
     * totalPageSize 一共有多少页
     */
    private Integer totalPageSize;
    /**
     * currentPageRecord 当前页的记录集合
     */
    private List<T> currentPageRecord;

    /**
     * 无参的构造方法
     */
    public Page() {
    }

    /**
     * 所有参数的构造方法
     *
     * @param pageSize
     * @param currentPageNumber
     * @param totalRecordSize
     * @param totalPageSize
     * @param currentPageRecord
     */
    public Page(Integer pageSize, Integer currentPageNumber, Integer totalRecordSize, Integer totalPageSize, List<T> currentPageRecord) {
        this.pageSize = pageSize;
        this.currentPageNumber = currentPageNumber;
        this.totalRecordSize = totalRecordSize;
        this.totalPageSize = totalPageSize;
        this.currentPageRecord = currentPageRecord;
    }

    /**
     * 根据查询出来的学生信息列表和，一页的页码和要查询的页，初始化新的页面信息
     * @param studentList
     * @param pageSize
     * @param pageNumber
     */
    public Page(List<T> studentList,Integer pageSize,Integer pageNumber){
        if (studentList!=null&&!studentList.isEmpty()){
            //记录总条数
            int size = studentList.size();
            totalRecordSize = size;
            //所有记录一共可以分成几页
            totalPageSize = (int)Math.ceil((double)size/(double)pageSize);
            //要查询第几页的信息
            if (pageNumber>totalPageSize){
                currentPageNumber = totalPageSize;
            }else {
                currentPageNumber=pageNumber;
            }
            if (currentPageNumber<1){
                currentPageNumber = 1;
            }

            //要查询页的开始位置
            int startIndex = pageSize*(currentPageNumber-1);
            //要查询的记录的结束的位置
            int endIndex = pageSize*currentPageNumber>= totalRecordSize?totalRecordSize:(startIndex+pageSize);
            List<T> studentList1 = studentList.subList(startIndex, endIndex);
            setCurrentPageRecord(studentList1);
            //当前页的记录条数
            this.pageSize = endIndex-startIndex;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(Integer currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public Integer getTotalRecordSize() {
        return totalRecordSize;
    }

    public void setTotalRecordSize(Integer totalRecordSize) {
        this.totalRecordSize = totalRecordSize;
    }

    public Integer getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(Integer totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public List<T> getCurrentPageRecord() {
        return currentPageRecord;
    }

    public void setCurrentPageRecord(List<T> currentPageRecord) {
        this.currentPageRecord = currentPageRecord;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", currentPageNumber=" + currentPageNumber +
                ", totalRecordSize=" + totalRecordSize +
                ", totalPageSize=" + totalPageSize +
                ", currentPageRecord=" + currentPageRecord +
                '}';
    }
}
