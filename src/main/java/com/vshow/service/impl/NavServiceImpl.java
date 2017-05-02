package com.vshow.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vshow.mapper.NavMapper;
import com.vshow.service.NavService;

@Service("navService")
public class NavServiceImpl implements NavService{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private NavMapper navMapper;
	
	@Override
	public List<Map<String, Object>> getTopNav() {
		return navMapper.selectTopNav();
	}

}
