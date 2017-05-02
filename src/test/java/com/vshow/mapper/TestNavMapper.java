package com.vshow.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.vshow.WebApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=WebApplicationConfiguration.class)// 指定spring-boot的启动类  
public class TestNavMapper {

	@Autowired
	private NavMapper navMapper;
	
	@Test
	public void test(){
		Object jobj = new Object();
		jobj = JSON.toJSON(navMapper.selectTopNav());
		System.out.println(jobj);
	}
	
}
