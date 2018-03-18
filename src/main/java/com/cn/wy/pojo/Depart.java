package com.cn.wy.pojo;

public class Depart {
    private Long departid;

    private String departname;

    private String departinfo;

    public Long getDepartid() {
        return departid;
    }

    public void setDepartid(Long departid) {
        this.departid = departid;
    }

    public String getDepartname() {
        return departname;
    }

    public void setDepartname(String departname) {
        this.departname = departname == null ? null : departname.trim();
    }

    public String getDepartinfo() {
        return departinfo;
    }

    public void setDepartinfo(String departinfo) {
        this.departinfo = departinfo == null ? null : departinfo.trim();
    }
}