package com.vshow.mapper;

import java.util.List;
import java.util.Map;

import com.vshow.entity.Resource;
import com.vshow.entity.ResourceDetail;
import com.vshow.entity.nav.TopNav;

/**
 * 视频资源 Mapper
 *
 * @author ganzhigang
 * time: 2017年4月29日 下午4:24:46
 *
 */
public interface ResourceMapper {

	/**
	 * 获取菜单以及每个菜单下的指定个数的视频
	 * @return
	 */
	public List<TopNav> selectNavAndResource(Map<String, Object> map);
	
	/**
	 * 获取指定的一级菜单,二级菜单下的视频列表
	 * @param map
	 * @return
	 */
	public List<Resource> selectResourceByNav(Map<String, Object> map);
	
	/**
	 * 获取指定菜单下的二级菜单
	 * @param map
	 * @return
	 */
	public TopNav selectSecNavByTopId(Map<String, Object> map);
	
	/**
	 * 根据关键字查询 视频列表
	 * @param map
	 * @return
	 */
	public List<Resource> selectResourceByKeywords(Map<String, Object> map);
	
	/**
	 * 获取根据关键字可查询到的视频总数
	 * @param map
	 * @return
	 */
	public int selectResourceByKeywordsCount(Map<String, Object> map);
	
	/**
	 * 根据 视频id查找视频
	 * @param map
	 * @return
	 */
	public ResourceDetail selectResourceById(Map<String, Object> map);
	
	/**
	 * 根据 视频 id 更新视频信息
	 * @param map
	 * @return
	 */
	public int updateResourceById(Map<String, Object> map);
	
}
