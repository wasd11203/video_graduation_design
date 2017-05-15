package com.vshow.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 视频的详细信息
 *
 * @author ganzhigang
 * time: 2017年4月30日 上午9:38:04
 *
 */
public class ResourceDetail implements Serializable{

	private static final long serialVersionUID = 6869032377007450202L;
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
	 * 视频介绍
	 */
	private String vIntroduce;
	/**
	 * 视频地址
	 */
	private String vPath;
	/**
	 * 视频播放次数
	 */
	private String playCounts;
	/**
	 * 视频时长
	 */
	private Long duration;	
	
	/**
	 * 点赞数
	 */
	private Integer fabulousCounts;
	/**
	 * 删除标识
	 */
	private Integer isDel;
	
	/**
	 * 上下架标识
	 */
	private Integer invalid;
	/**
	 * 可被评论标识
	 */
	private Integer disComment;
	
	/**
	 * 入库时间
	 */
	private Date inTime;
	
	/**
	 * 视频所属的二级菜单Id
	 */
	private Integer vSecId;

	/**
	 * 视频发布者
	 */
	private ManagerUser managerUser;
	
	public ResourceDetail(){
		
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

	public String getvIntroduce() {
		return vIntroduce;
	}

	public void setvIntroduce(String vIntroduce) {
		this.vIntroduce = vIntroduce;
	}

	public String getvPath() {
		return vPath;
	}

	public void setvPath(String vPath) {
		this.vPath = vPath;
	}

	public String getPlayCounts() {
		return playCounts;
	}

	public void setPlayCounts(String playCounts) {
		this.playCounts = playCounts;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Integer getFabulousCounts() {
		return fabulousCounts;
	}

	public void setFabulousCounts(Integer fabulousCounts) {
		this.fabulousCounts = fabulousCounts;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Integer getInvalid() {
		return invalid;
	}

	public void setInvalid(Integer invalid) {
		this.invalid = invalid;
	}

	public Integer getDisComment() {
		return disComment;
	}

	public void setDisComment(Integer disComment) {
		this.disComment = disComment;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Integer getvSecId() {
		return vSecId;
	}

	public void setvSecId(Integer vSecId) {
		this.vSecId = vSecId;
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
				+ ((disComment == null) ? 0 : disComment.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result
				+ ((fabulousCounts == null) ? 0 : fabulousCounts.hashCode());
		result = prime * result + ((inTime == null) ? 0 : inTime.hashCode());
		result = prime * result + ((invalid == null) ? 0 : invalid.hashCode());
		result = prime * result + ((isDel == null) ? 0 : isDel.hashCode());
		result = prime * result
				+ ((managerUser == null) ? 0 : managerUser.hashCode());
		result = prime * result
				+ ((playCounts == null) ? 0 : playCounts.hashCode());
		result = prime * result + ((vId == null) ? 0 : vId.hashCode());
		result = prime * result
				+ ((vIntroduce == null) ? 0 : vIntroduce.hashCode());
		result = prime * result + ((vName == null) ? 0 : vName.hashCode());
		result = prime * result + ((vPath == null) ? 0 : vPath.hashCode());
		result = prime * result + ((vPic == null) ? 0 : vPic.hashCode());
		result = prime * result + ((vSecId == null) ? 0 : vSecId.hashCode());
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
		ResourceDetail other = (ResourceDetail) obj;
		if (disComment == null) {
			if (other.disComment != null)
				return false;
		} else if (!disComment.equals(other.disComment))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (fabulousCounts == null) {
			if (other.fabulousCounts != null)
				return false;
		} else if (!fabulousCounts.equals(other.fabulousCounts))
			return false;
		if (inTime == null) {
			if (other.inTime != null)
				return false;
		} else if (!inTime.equals(other.inTime))
			return false;
		if (invalid == null) {
			if (other.invalid != null)
				return false;
		} else if (!invalid.equals(other.invalid))
			return false;
		if (isDel == null) {
			if (other.isDel != null)
				return false;
		} else if (!isDel.equals(other.isDel))
			return false;
		if (managerUser == null) {
			if (other.managerUser != null)
				return false;
		} else if (!managerUser.equals(other.managerUser))
			return false;
		if (playCounts == null) {
			if (other.playCounts != null)
				return false;
		} else if (!playCounts.equals(other.playCounts))
			return false;
		if (vId == null) {
			if (other.vId != null)
				return false;
		} else if (!vId.equals(other.vId))
			return false;
		if (vIntroduce == null) {
			if (other.vIntroduce != null)
				return false;
		} else if (!vIntroduce.equals(other.vIntroduce))
			return false;
		if (vName == null) {
			if (other.vName != null)
				return false;
		} else if (!vName.equals(other.vName))
			return false;
		if (vPath == null) {
			if (other.vPath != null)
				return false;
		} else if (!vPath.equals(other.vPath))
			return false;
		if (vPic == null) {
			if (other.vPic != null)
				return false;
		} else if (!vPic.equals(other.vPic))
			return false;
		if (vSecId == null) {
			if (other.vSecId != null)
				return false;
		} else if (!vSecId.equals(other.vSecId))
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
		return "ResourceDetail [vId=" + vId + ", vTitle=" + vTitle + ", vName="
				+ vName + ", vPic=" + vPic + ", vIntroduce=" + vIntroduce
				+ ", vPath=" + vPath + ", playCounts=" + playCounts
				+ ", duration=" + duration + ", fabulousCounts="
				+ fabulousCounts + ", isDel=" + isDel + ", invalid=" + invalid
				+ ", disComment=" + disComment + ", inTime=" + inTime
				+ ", vSecId=" + vSecId + ", managerUser=" + managerUser + "]";
	}
	
}
