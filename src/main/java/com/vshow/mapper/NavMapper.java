package com.vshow.mapper;

import java.util.List;
import java.util.Map;

/**
 * 导航 Mapper
 *
 * @author ganzhigang
 * time: 2017年4月29日 上午11:01:02
 *
 */
public interface NavMapper {
	
	/**
	 * 查询一级菜单
	 * @return
	 */
	public List<Map<String,Object>> selectTopNav();
}
