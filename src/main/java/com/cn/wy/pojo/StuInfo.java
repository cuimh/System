package com.cn.wy.pojo;

public class StuInfo {
    private Long id;

    private String stuNo;

    private String stuname;

    private String sex;

    private Long zid;

    private Long departid;

    private Integer stuclass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Long getZid() {
        return zid;
    }

    public void setZid(Long zid) {
        this.zid = zid;
    }

    public Long getDepartid() {
        return departid;
    }

    public void setDepartid(Long departid) {
        this.departid = departid;
    }


    public Integer getStuclass() {
        return stuclass;
    }

    public void setStuclass(Integer stuclass) {
        this.stuclass = stuclass;
    }
}