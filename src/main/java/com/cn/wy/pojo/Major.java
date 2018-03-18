package com.cn.wy.pojo;

public class Major {
    private Long id;

    private String majorno;

    private String majorname;

    private Long departid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMajorno() {
        return majorno;
    }

    public void setMajorno(String majorno) {
        this.majorno = majorno == null ? null : majorno.trim();
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname == null ? null : majorname.trim();
    }

    public Long getDepartid() {
        return departid;
    }

    public void setDepartid(Long departid) {
        this.departid = departid;
    }
}