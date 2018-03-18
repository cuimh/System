package com.cn.wy.pojoDto;

public class MajorDto {
	private Long id;

    private String majorno;

    private String majorname;

    private Long departid;
    
    private String departname;

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
		this.majorno = majorno;
	}

	public String getMajorname() {
		return majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

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
		this.departname = departname;
	}
}
