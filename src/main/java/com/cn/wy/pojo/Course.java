package com.cn.wy.pojo;

public class Course {
    private Long courseid;

    private Long teacherno;

    private String coursename;

    private String coursetime;

    private Long courseaddress;

    private String courseabout;

    private Float coursegrade;

    private Long departid;

    private Long classno;
    

	public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public Long getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(Long teacherno) {
        this.teacherno = teacherno;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime == null ? null : coursetime.trim();
    }


    public Long getCourseaddress() {
		return courseaddress;
	}

	public void setCourseaddress(Long courseaddress) {
		this.courseaddress = courseaddress;
	}

	public String getCourseabout() {
        return courseabout;
    }

    public void setCourseabout(String courseabout) {
        this.courseabout = courseabout == null ? null : courseabout.trim();
    }

    public Float getCoursegrade() {
        return coursegrade;
    }

    public void setCoursegrade(Float coursegrade) {
        this.coursegrade = coursegrade;
    }

    public Long getDepartid() {
        return departid;
    }

    public void setDepartid(Long departid) {
        this.departid = departid;
    }

    public Long getClassno() {
        return classno;
    }

    public void setClassno(Long classno) {
        this.classno = classno;
    }
}