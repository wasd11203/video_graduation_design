package com.vshow.controller.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.vshow.controller.BasicController;
import com.vshow.entity.Resource;
import com.vshow.entity.nav.TopNav;
import com.vshow.service.ResourceService;

/**
 * 首页相关控制器
 *
 * @author ganzhigang
 * time: 2017年4月29日 下午4:22:51
 *
 */
@Controller("homeController")
@RequestMapping("/home")
public class HomeController extends BasicController{

	@Value("${home.pageSize}")
	private String homePageSize;

	@Value("${result.pageSize}")
	private String resultPageSize;
	
	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/list/json")
	@ResponseBody
	public List<TopNav> listResourceRoughlyList(){
		logger.info("列出大致的视频列表");
		Map<String, Object> map = new HashMap<String, Object>() ;
		int pageSize = Integer.parseInt(homePageSize);
		map.put("pageSize", pageSize);
		return resourceService.getNavAndResource(map);
	}
	
	@RequestMapping("/listByNav")
	@ResponseBody
	public JSONObject listResourceListByNav(String vTopId,String vSecId,int curPage){
		logger.info("根据导航菜单Top:[{}],Sec:[{}] 列出视频列表的第:[{}]页,可列出[{}]个视频",vTopId,vSecId,curPage,homePageSize);
		Map<String, Object> map = new HashMap<String, Object>() ;
		JSONObject jobj = new JSONObject();
		int vTop = Integer.parseInt(vTopId);
		int pageSize = Integer.parseInt(resultPageSize);
		int start = (curPage-1) * pageSize;
		Integer vSec = null;
		
		map.put("vTopId", vTop);
		
		if(vSecId != null && !vSecId.trim().isEmpty()){
			vSec = Integer.parseInt(vSecId);
		}else{
			TopNav top = resourceService.getSecNavByTopId(map);
			vSec = top.getSecList().get(0).getvSecId();
			jobj.put("top", top);
		}
		
		map.put("vSecId", vSec);
		map.put("startIndex", start);
		map.put("pageSize", pageSize);
		
		List<Resource> res = resourceService.getResourceListByNav(map);
		int counts = resourceService.getResourceByNavCounts(map);
		
		jobj.put("code", 0);
		jobj.put("list", res);
		jobj.put("count", counts);
		
		return jobj;
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public JSONObject searchByMark(String keywords,int curPage){
		
		logger.info("根据关键字:[{}] 列出视频列表的第:[{}]页,可列出[{}]个视频",keywords,curPage,resultPageSize);
		
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>() ;
		int pageSize = Integer.parseInt(resultPageSize);
		int start = (curPage-1) * pageSize;
		
		map.put("keywords", keywords);
		map.put("startIndex", start);
		map.put("pageSize", pageSize);
		
		List<Resource> res = resourceService.getResourceListByKeywords(map);
		int count = resourceService.getResourceByKeywordsCount(map);
		
		jobj.put("list", res);
		jobj.put("count", count);
		
		return jobj;
	}
	
}
