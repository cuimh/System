package com.cn.wy.pojo;

public class Score {
    private Long id;

    private String stuno;

    private Double teacherid;

    private Double coursrid;

    private Float score;

    private Float credit;

    private Integer flag;
    


	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno == null ? null : stuno.trim();
    }

    public Double getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Double teacherid) {
        this.teacherid = teacherid;
    }

    public Double getCoursrid() {
        return coursrid;
    }

    public void setCoursrid(Double coursrid) {
        this.coursrid = coursrid;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}