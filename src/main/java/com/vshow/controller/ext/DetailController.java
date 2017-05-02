package com.vshow.controller.ext;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.vshow.controller.BasicController;
import com.vshow.entity.ResourceDetail;
import com.vshow.service.ResourceService;

/**
 * 详细信息 Controller
 *
 * @author ganzhigang
 * time: 2017年4月30日 下午9:14:35
 *
 */
@Controller("detailController")
@RequestMapping("/detail")
public class DetailController extends BasicController{

	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/resource")
	@ResponseBody
	public ResourceDetail loadResourceDetail(String vId){
		logger.info("根据视频Id:[{}]列出视频信息,并且视频的播放次数 +1",vId);
		Map<String, Object> map = new HashMap<String, Object>() ;
		Integer id = new Integer(vId);
		
		map.put("vId", id);
		map.put("upCounts", 1);
		
		ResourceDetail detail = resourceService.getResourceById(map);
		resourceService.updateResourceById(map);
		
		return detail;
	}
	
	@RequestMapping("/video/fabs")
	@ResponseBody
	public JSONObject changeVideoArgument(String upFab,String vId){
		
		logger.info("为视频Id:[{}],点赞 (+1/-1):[{}]",vId,upFab);
		
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>() ;
		Integer fab = new Integer(upFab);
		Integer id = new Integer(vId);
		
		map.put("upFab", fab);
		map.put("vId", id);
		int row = resourceService.updateResourceById(map);
		if(row > 0 ){
			jobj.put("code", 0);
		}else{
			jobj.put("code", 1);
		}
		
		return jobj;
	}
	
}
