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
public class TestCommentMapper {

	@Autowired
	private CommentMapper commentMapper;
	
	@Test
	public void test1(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vId", 12);
		
		Object jobj = new Object();
		jobj = JSON.toJSON(commentMapper.selectCommentsByVid(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test2(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dcId", 4);
		map.put("vId", 12);
		map.put("dcComment", "AAAAAA");
		map.put("dcIntime", new Date());
		map.put("isDel", 0);
		map.put("fabulousCounts", 0);
		map.put("vuId", 4);
		
		Object jobj = new Object();
		jobj = JSON.toJSON(commentMapper.insertComment(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test3(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dcId", 4);
		map.put("vId", 12);
		map.put("dcComment", "AAAAAA");
		map.put("dcIntime", new Date());
		map.put("isDel", 0);
		map.put("upfab", 0);
		map.put("vuId", 4);
		
		Object jobj = new Object();
		jobj = JSON.toJSON(commentMapper.updateComment(map));
		System.out.println(jobj);
	}
	

}
