package com.vshow.entity.nav;

import java.io.Serializable;
import java.util.List;

/**
 * 一级导航 实体 
 * 
 * @author ganzhigang
 * time: 2017年4月29日 上午10:46:29
 *
 */
public class TopNav implements Serializable{

	private static final long serialVersionUID = 6076639338177994246L;
	
	/**
	 * 一级菜单Id
	 */
	private Integer vTopId;
	/**
	 * 一级菜单名称
	 */
	private String vTopName;
	
	/**
	 * 一级菜单图标地址
	 */
	private String vTopIcon;
	
	/**
	 * 一级菜单下的二级菜单列表
	 */
	private List<SecNav> secList;
	
	public TopNav(){
		
	}

	public Integer getvTopId() {
		return vTopId;
	}

	public void setvTopId(Integer vTopId) {
		this.vTopId = vTopId;
	}

	public String getvTopName() {
		return vTopName;
	}

	public void setvTopName(String vTopName) {
		this.vTopName = vTopName;
	}

	public String getvTopIcon() {
		return vTopIcon;
	}

	public void setvTopIcon(String vTopIcon) {
		this.vTopIcon = vTopIcon;
	}

	public List<SecNav> getSecList() {
		return secList;
	}

	public void setSecList(List<SecNav> secList) {
		this.secList = secList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((secList == null) ? 0 : secList.hashCode());
		result = prime * result + ((vTopIcon == null) ? 0 : vTopIcon.hashCode());
		result = prime * result + ((vTopId == null) ? 0 : vTopId.hashCode());
		result = prime * result + ((vTopName == null) ? 0 : vTopName.hashCode());
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
		TopNav other = (TopNav) obj;
		if (secList == null) {
			if (other.secList != null)
				return false;
		} else if (!secList.equals(other.secList))
			return false;
		if (vTopIcon == null) {
			if (other.vTopIcon != null)
				return false;
		} else if (!vTopIcon.equals(other.vTopIcon))
			return false;
		if (vTopId == null) {
			if (other.vTopId != null)
				return false;
		} else if (!vTopId.equals(other.vTopId))
			return false;
		if (vTopName == null) {
			if (other.vTopName != null)
				return false;
		} else if (!vTopName.equals(other.vTopName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TopNav [vTopId=" + vTopId + ", vTopName=" + vTopName + ", vTopIcon=" + vTopIcon + ", secList=" + secList
				+ "]";
	}
}
