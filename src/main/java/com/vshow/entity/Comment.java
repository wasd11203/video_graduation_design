package com.vshow.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论(针对的是直接评论)
 *
 * @author ganzhigang
 * time: 2017年4月30日 上午9:58:17
 *
 */
public class Comment implements Serializable{

	private static final long serialVersionUID = 2270258858002275006L;

	private Integer dcId;
	private Integer vId;
	private String dcComment;
	private Date dcIntime;
	private Integer isDel;
	private Integer fabulousCounts;
	private VisitorUser vUser;

	public Comment(){
		
	}

	public Integer getDcId() {
		return dcId;
	}

	public void setDcId(Integer dcId) {
		this.dcId = dcId;
	}

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public String getDcComment() {
		return dcComment;
	}

	public void setDcComment(String dcComment) {
		this.dcComment = dcComment;
	}

	public Date getDcIntime() {
		return dcIntime;
	}

	public void setDcIntime(Date dcIntime) {
		this.dcIntime = dcIntime;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getFabulousCounts() {
		return fabulousCounts;
	}

	public void setFabulousCounts(Integer fabulousCounts) {
		this.fabulousCounts = fabulousCounts;
	}

	public VisitorUser getvUser() {
		return vUser;
	}

	public void setvUser(VisitorUser vUser) {
		this.vUser = vUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dcComment == null) ? 0 : dcComment.hashCode());
		result = prime * result + ((dcId == null) ? 0 : dcId.hashCode());
		result = prime * result
				+ ((dcIntime == null) ? 0 : dcIntime.hashCode());
		result = prime * result
				+ ((fabulousCounts == null) ? 0 : fabulousCounts.hashCode());
		result = prime * result + ((isDel == null) ? 0 : isDel.hashCode());
		result = prime * result + ((vId == null) ? 0 : vId.hashCode());
		result = prime * result + ((vUser == null) ? 0 : vUser.hashCode());
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
		Comment other = (Comment) obj;
		if (dcComment == null) {
			if (other.dcComment != null)
				return false;
		} else if (!dcComment.equals(other.dcComment))
			return false;
		if (dcId == null) {
			if (other.dcId != null)
				return false;
		} else if (!dcId.equals(other.dcId))
			return false;
		if (dcIntime == null) {
			if (other.dcIntime != null)
				return false;
		} else if (!dcIntime.equals(other.dcIntime))
			return false;
		if (fabulousCounts == null) {
			if (other.fabulousCounts != null)
				return false;
		} else if (!fabulousCounts.equals(other.fabulousCounts))
			return false;
		if (isDel == null) {
			if (other.isDel != null)
				return false;
		} else if (!isDel.equals(other.isDel))
			return false;
		if (vId == null) {
			if (other.vId != null)
				return false;
		} else if (!vId.equals(other.vId))
			return false;
		if (vUser == null) {
			if (other.vUser != null)
				return false;
		} else if (!vUser.equals(other.vUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [dcId=" + dcId + ", vId=" + vId + ", dcComment="
				+ dcComment + ", dcIntime=" + dcIntime + ", isDel=" + isDel
				+ ", fabulousCounts=" + fabulousCounts + ", vUser=" + vUser
				+ "]";
	}
	

}
