package com.zhkj.shopmall.shoppingbackstage.shopping_backstage_tools;

import java.util.List;

public class Page<T> {
    private Integer totalPageCount;//总页数

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {

        this.totalPageCount = totalPageCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }
    /*
     * 若当前页小于1则等于1，若当前页大于总页数则等于总页数，否则赋值
     * */
    public void setCurrentPage(Integer currentPage) {
        if(currentPage!=null&&currentPage<=1){
            this.currentPage=1;
        }else if(totalCount!=null&&currentPage>totalPageCount){
            this.currentPage=this.totalPageCount;
        }else{
            this.currentPage = currentPage;}
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Integer getTotalCount() {
        return totalCount;
    }
    /*
     * 若总条数大于0则赋值，如果总条数除余每页条数等于0则总页数等于总条数除以每页条数否则+1
     * */
    public void setTotalCount(Integer totalCount) {
        if(totalCount!=null&&totalCount>0){
            this.totalCount = totalCount;
            this.totalPageCount=totalCount%perPage==0?(this.totalCount/perPage):(this.totalCount/perPage)+1;
        }
    }
    private Integer currentPage;//当前页
    private Integer perPage;//每页显示的条数
    private List<T>records;//集合
    private  Integer totalCount;//总条数
}
