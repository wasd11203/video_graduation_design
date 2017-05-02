package com.vshow.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.vshow.WebApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=WebApplicationConfiguration.class)// 指定spring-boot的启动类  
public class TestVisitorUserMapper {

	@Autowired
	private VisitorUserMapper visitorUserMapper;
	
	@Test
	public void test(){
		Object jobj = new Object();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vuId", 4);
		map.put("vuPhone", 12);
		map.put("vuNickname", "DD");
		map.put("vuIntime", new Date());
		map.put("vuIp", "127.0.0.1");
		
		jobj = JSON.toJSON(visitorUserMapper.insertVisitorUser(map));
		System.out.println(jobj);
	}
	
}
