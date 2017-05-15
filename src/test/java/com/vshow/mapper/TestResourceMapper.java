package com.vshow.mapper;

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
public class TestResourceMapper {

	@Autowired
	private ResourceMapper resourceMapper;
	
	@Test
	public void test1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", 5);
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceMapper.selectNavAndResource(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test2(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keywords", "高能");
		map.put("startIndex", 0);
		map.put("pageSize", 1);
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceMapper.selectResourceByKeywords(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test3(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vTitile", "集锦");
		map.put("vName", "勇士110");
		map.put("vPic", null);
		map.put("vIntroduce", "库里---集锦");
		map.put("vPath", "https://v.qq.com/x/cover/sjgx9f43wde9z0t/r0018m0puzt.html?");
		map.put("upCounts", 1);
		map.put("duration", 1000);
		map.put("upFab", 1);
		map.put("isDel", 0);
		map.put("vSecId", 3004);
		map.put("mId", 1);
		map.put("vId", 12);
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceMapper.updateResourceById(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test4(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vId", 12);
		
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceMapper.selectResourceById(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test5(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vTopId", 1);
		map.put("vSecId", 1001);
		map.put("startIndex", 0);
		map.put("pageSize", 2);
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceMapper.selectResourceByNav(map));
		System.out.println(jobj);
	}
	
}
