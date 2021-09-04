package com.lee.community.entity;

public class Page {
    //当前页码
    private int current=1;
    //每页显示条数
    private int limit=6;
    //总数
    private int rows;
    //查询路径(用于分页复用)
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>=1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1 && limit<=100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //起始行
    public int getOffset(){
        return (current-1)*limit;
    }

    //总页数
    public int getTotal(){
        if(rows%limit==0){
            return rows/limit;
        }
        else{
            return rows/limit+1;
        }
    }
    //起始页(当前页前2页)
    public int getFrom(){
        int from=current-2;
        return from < 1 ? 1 : from;
    }
    //截止页(当前页后2页)
    public int getTo(){
        int to=current+2;
        int total=getTotal();
        return to > total ? total:to;
    }
}
