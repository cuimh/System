package com.cn.wy.pojo;

public class Classroom {
    private Long id;

    private Integer classNo;

    private Integer calsspeople;

    private String classaddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public Integer getCalsspeople() {
        return calsspeople;
    }

    public void setCalsspeople(Integer calsspeople) {
        this.calsspeople = calsspeople;
    }

    public String getClassaddress() {
        return classaddress;
    }

    public void setClassaddress(String classaddress) {
        this.classaddress = classaddress == null ? null : classaddress.trim();
    }
}