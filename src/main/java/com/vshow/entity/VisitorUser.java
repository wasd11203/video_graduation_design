package com.vshow.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 访客信息
 *
 * @author ganzhigang
 * time: 2017年4月30日 上午9:54:20
 *
 */
public class VisitorUser implements Serializable{

	private static final long serialVersionUID = 4857415339224975716L;
	/**
	 * 访客id
	 */
	private Integer vuId;
	/**
	 * 访客的用户名
	 */
	private String vuNickname;
	/**
	 * 访客创建时间
	 */
	private Date vuIntime;
	
	public VisitorUser(){
		
	}

	public Integer getVuId() {
		return vuId;
	}

	public void setVuId(Integer vuId) {
		this.vuId = vuId;
	}

	public String getVuNickname() {
		return vuNickname;
	}

	public void setVuNickname(String vuNickname) {
		this.vuNickname = vuNickname;
	}

	public Date getVuIntime() {
		return vuIntime;
	}

	public void setVuIntime(Date vuIntime) {
		this.vuIntime = vuIntime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vuId == null) ? 0 : vuId.hashCode());
		result = prime * result
				+ ((vuIntime == null) ? 0 : vuIntime.hashCode());
		result = prime * result
				+ ((vuNickname == null) ? 0 : vuNickname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitorUser other = (VisitorUser) obj;
		if (vuId == null) {
			if (other.vuId != null)
				return false;
		} else if (!vuId.equals(other.vuId))
			return false;
		if (vuIntime == null) {
			if (other.vuIntime != null)
				return false;
		} else if (!vuIntime.equals(other.vuIntime))
			return false;
		if (vuNickname == null) {
			if (other.vuNickname != null)
				return false;
		} else if (!vuNickname.equals(other.vuNickname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VisitorUser [vuId=" + vuId + ", vuNickname=" + vuNickname
				+ ", vuIntime=" + vuIntime + "]";
	}

}
