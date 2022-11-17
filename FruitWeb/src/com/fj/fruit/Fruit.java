package com.fj.fruit;

/**
 * Copyright (C), 2017-2022
 * <author>          <time>              <version>
 * 冯俊        2022/8/1 11:52    since 1.0.0
 */
public class Fruit {
    private Integer fid;
    private String fname;
    private Integer prcie;
    private Integer count;
    private String remark;
    public Fruit() {
    }

    public Fruit(Integer fid, String fname, Integer prcie, Integer count, String remark) {
        this.fid = fid;
        this.fname = fname;
        this.prcie = prcie;
        this.count = count;
        this.remark = remark;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getPrcie() {
        return prcie;
    }

    public void setPrcie(Integer prcie) {
        this.prcie = prcie;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
