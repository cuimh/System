package com.cn.wy.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class User implements Serializable{
	private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String pwd;

    private String relname;

    private String positionid;

    private String instructions;

    private Date createtime;
    
    private Integer flag; //状态

    public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public List<Persission> getMenus() {
		return menus;
	}

	public void setMenus(List<Persission> menus) {
		this.menus = menus;
	}

	public List<Persission> getMainMenus() {
		return mainMenus;
	}

	public void setMainMenus(List<Persission> mainMenus) {
		this.mainMenus = mainMenus;
	}

	private Date modifytime;
    
    private List<Persission> menus; //ְλ�б�
    
	private List<Persission> mainMenus; //��Ҫְλ�б�
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname == null ? null : relname.trim();
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid == null ? null : positionid.trim();
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions == null ? null : instructions.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}