package com.vshow.service;

import java.util.Map;

/**
 * 访客业务层接口
 *
 * @author ganzhigang
 * time: 2017年4月30日 下午8:36:45
 *
 */
public interface VisitorUserService {

	/**
	 * 新增访客
	 * @param map
	 * @return
	 */
	public int addVisitorUser(Map<String, Object> map);
	
	
}
