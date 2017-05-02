package com.vshow.entity.nav;

import java.io.Serializable;
import java.util.List;

import com.vshow.entity.Resource;

/**
 * 二级导航 实体
 *
 * @author ganzhigang
 * time: 2017年4月29日 上午10:47:34
 *
 */
public class SecNav implements Serializable{

	private static final long serialVersionUID = 6005259412851047303L;
	
	/**
	 * 二级菜单id
	 */
	private Integer vSecId;
	/**
	 * 二级菜单名称
	 */
	private String vSecName;
	
	/**
	 * 二级菜单所属的一级菜单Id
	 */
	private Integer vTopId;
	
	/**
	 * 二级菜单下的资源列表
	 */
	private List<Resource> videos;

	public Integer getvSecId() {
		return vSecId;
	}

	public void setvSecId(Integer vSecId) {
		this.vSecId = vSecId;
	}

	public String getvSecName() {
		return vSecName;
	}

	public void setvSecName(String vSecName) {
		this.vSecName = vSecName;
	}

	public Integer getvTopId() {
		return vTopId;
	}

	public void setvTopId(Integer vTopId) {
		this.vTopId = vTopId;
	}

	public List<Resource> getVideos() {
		return videos;
	}

	public void setVideos(List<Resource> videos) {
		this.videos = videos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vSecId == null) ? 0 : vSecId.hashCode());
		result = prime * result
				+ ((vSecName == null) ? 0 : vSecName.hashCode());
		result = prime * result + ((vTopId == null) ? 0 : vTopId.hashCode());
		result = prime * result + ((videos == null) ? 0 : videos.hashCode());
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
		SecNav other = (SecNav) obj;
		if (vSecId == null) {
			if (other.vSecId != null)
				return false;
		} else if (!vSecId.equals(other.vSecId))
			return false;
		if (vSecName == null) {
			if (other.vSecName != null)
				return false;
		} else if (!vSecName.equals(other.vSecName))
			return false;
		if (vTopId == null) {
			if (other.vTopId != null)
				return false;
		} else if (!vTopId.equals(other.vTopId))
			return false;
		if (videos == null) {
			if (other.videos != null)
				return false;
		} else if (!videos.equals(other.videos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SecNav [vSecId=" + vSecId + ", vSecName=" + vSecName
				+ ", vTopId=" + vTopId + ", videos=" + videos + "]";
	}
	
}
