package com.vshow.service.impl;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vshow.mapper.VisitorUserMapper;
import com.vshow.service.VisitorUserService;

@Service("visitorUserService")
public class VisitorUserServiceImpl implements VisitorUserService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private VisitorUserMapper visitorMapper;
	
	@Override
	public Integer addVisitorUser(Map<String, Object> map) {
		Long time = System.currentTimeMillis();
		Integer vuId = new Integer(time.intValue());
		
		map.put("vuId", vuId);
		map.put("vuIntime", new Date());
		
		int row = visitorMapper.insertVisitorUser(map);
		
		if(row > 0){
			return vuId;
		}else{
			return null;
		}
		
	}

	@Override
	public int getCountByNickname(Map<String, Object> map) {
		return visitorMapper.selectCountByNickname(map);
	}

}
