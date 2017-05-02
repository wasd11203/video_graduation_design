package com.vshow.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.vshow.WebApplicationConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=WebApplicationConfiguration.class)// 指定spring-boot的启动类  
public class TestNavService {

	@Autowired
	private NavService navService;
	
	@Test
	public void test(){
		Object jobj = new Object();
		jobj = JSON.toJSON(navService.getTopNav());
		System.out.println(jobj);
	}
	
}
