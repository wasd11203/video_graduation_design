package com.vshow.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vshow.entity.Resource;
import com.vshow.entity.ResourceDetail;
import com.vshow.entity.nav.TopNav;
import com.vshow.mapper.ResourceMapper;
import com.vshow.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<TopNav> getNavAndResource(Map<String, Object> map) {

		return resourceMapper.selectNavAndResource(map);
	}

	@Override
	public List<Resource> getResourceListByNav(Map<String, Object> map) {

		return resourceMapper.selectResourceByNav(map);
	}

	@Override
	public List<Resource> getResourceListByKeywords(Map<String, Object> map) {
		return resourceMapper.selectResourceByKeywords(map);
	}

	@Override
	public ResourceDetail getResourceById(Map<String, Object> map) {
		return resourceMapper.selectResourceById(map);
	}

	@Override
	public int updateResourceById(Map<String, Object> map) {
		return resourceMapper.updateResourceById(map);
	}

	@Override
	public int getResourceByKeywordsCount(Map<String, Object> map) {
		
		return resourceMapper.selectResourceByKeywordsCount(map);
	}

	@Override
	public TopNav getSecNavByTopId(Map<String, Object> map) {
		return resourceMapper.selectSecNavByTopId(map);
	}

}
