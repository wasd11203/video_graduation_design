package com.vshow.entity;

import java.io.Serializable;

/**
 * 资源 ----基本信息 Entity
 *
 * @author ganzhigang
 * time: 2017年4月29日 下午4:27:33
 *
 */
public class Resource implements Serializable{

	private static final long serialVersionUID = 321970315889987900L;
	/**
	 * 视频id
	 */
	private Integer vId;
	/**
	 * 视频标题
	 */
	private String vTitle;
	
	/**
	 * 视频名称
	 */
	private String vName;
	
	/**
	 * 视频显示图片
	 */
	private String vPic;

	/**
	 * 视频时长
	 */
	private Long duration;	
	
	/**
	 * 视频发布者
	 */
	private ManagerUser managerUser;
	
	public Resource(){
		
	}

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvPic() {
		return vPic;
	}

	public void setvPic(String vPic) {
		this.vPic = vPic;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public ManagerUser getManagerUser() {
		return managerUser;
	}

	public void setManagerUser(ManagerUser managerUser) {
		this.managerUser = managerUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result
				+ ((managerUser == null) ? 0 : managerUser.hashCode());
		result = prime * result + ((vId == null) ? 0 : vId.hashCode());
		result = prime * result + ((vName == null) ? 0 : vName.hashCode());
		result = prime * result + ((vPic == null) ? 0 : vPic.hashCode());
		result = prime * result + ((vTitle == null) ? 0 : vTitle.hashCode());
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
		Resource other = (Resource) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (managerUser == null) {
			if (other.managerUser != null)
				return false;
		} else if (!managerUser.equals(other.managerUser))
			return false;
		if (vId == null) {
			if (other.vId != null)
				return false;
		} else if (!vId.equals(other.vId))
			return false;
		if (vName == null) {
			if (other.vName != null)
				return false;
		} else if (!vName.equals(other.vName))
			return false;
		if (vPic == null) {
			if (other.vPic != null)
				return false;
		} else if (!vPic.equals(other.vPic))
			return false;
		if (vTitle == null) {
			if (other.vTitle != null)
				return false;
		} else if (!vTitle.equals(other.vTitle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Resource [vId=" + vId + ", vTitle=" + vTitle + ", vName="
				+ vName + ", vPic=" + vPic + ", duration=" + duration
				+ ", managerUser=" + managerUser + "]";
	}
	
}
