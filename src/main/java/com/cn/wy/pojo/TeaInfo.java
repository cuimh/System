package com.cn.wy.pojo;

public class TeaInfo {
    private Long id;

    private String tername;

    private Integer sex;

    private String note;

    private Long departid;

    private String teaNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTername() {
        return tername;
    }

    public void setTername(String tername) {
        this.tername = tername == null ? null : tername.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Long getDepartid() {
        return departid;
    }

    public void setDepartid(Long departid) {
        this.departid = departid;
    }

    public String getTeaNo() {
        return teaNo;
    }

    public void setTeaNo(String teaNo) {
        this.teaNo = teaNo == null ? null : teaNo.trim();
    }
}