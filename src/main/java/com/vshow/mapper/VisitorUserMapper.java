package com.vshow.mapper;

import java.util.Map;

/**
 * 访客 Mapper
 *
 * @author ganzhigang
 * time: 2017年4月29日 下午4:24:46
 *
 */
public interface VisitorUserMapper {

	/**
	 * 新增访客
	 * @param map
	 * @return
	 */
	public int insertVisitorUser(Map<String, Object> map);
	
	/**
	 * 根据 昵称查询是否该昵称已经存在
	 * @param map
	 * @return
	 */
	public int selectCountByNickname(Map<String, Object> map);
	
}
