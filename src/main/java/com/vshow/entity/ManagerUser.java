package com.vshow.entity;

import java.io.Serializable;

/**
 * 管理者----基本信息 Entity
 *
 * @author ganzhigang
 * time: 2017年4月29日 下午4:33:12
 *
 */
public class ManagerUser implements Serializable{
	
	private static final long serialVersionUID = -3853089283660508078L;
	private Integer mId;
	private String mNickname;
	private String mPic;
	
	public ManagerUser(){
		
	}

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getmNickname() {
		return mNickname;
	}

	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}

	public String getmPic() {
		return mPic;
	}

	public void setmPic(String mPic) {
		this.mPic = mPic;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mId == null) ? 0 : mId.hashCode());
		result = prime * result
				+ ((mNickname == null) ? 0 : mNickname.hashCode());
		result = prime * result + ((mPic == null) ? 0 : mPic.hashCode());
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
		ManagerUser other = (ManagerUser) obj;
		if (mId == null) {
			if (other.mId != null)
				return false;
		} else if (!mId.equals(other.mId))
			return false;
		if (mNickname == null) {
			if (other.mNickname != null)
				return false;
		} else if (!mNickname.equals(other.mNickname))
			return false;
		if (mPic == null) {
			if (other.mPic != null)
				return false;
		} else if (!mPic.equals(other.mPic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ManagerUser [mId=" + mId + ", mNickname=" + mNickname
				+ ", mPic=" + mPic + "]";
	}
	
}
