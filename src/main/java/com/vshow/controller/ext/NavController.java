package com.vshow.controller.ext;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vshow.controller.BasicController;
import com.vshow.service.NavService;

/**
 * 导航栏菜单 控制层
 *
 * @author ganzhigang
 * time: 2017年4月29日 上午11:13:58
 *
 */
@Controller("navController")
@RequestMapping("/nav")
public class NavController extends BasicController{

	@Autowired
	private NavService navService;
	
	@RequestMapping("/list/top")
	@ResponseBody
	public List<Map<String, Object>> getTopNavList(){
		logger.info("列出一级菜单");
		return navService.getTopNav();
	}
	
}
