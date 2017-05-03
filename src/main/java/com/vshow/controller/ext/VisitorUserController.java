package com.vshow.controller.ext;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.vshow.controller.BasicController;
import com.vshow.service.VisitorUserService;
import com.vshow.util.http.GetIP;

/**
 * 访客 Controller
 *
 * @author ganzhigang time: 2017年4月30日 下午11:14:02
 *
 */
@Controller("visitorUserController")
@RequestMapping("/visitor")
public class VisitorUserController extends BasicController{

	@Autowired
	private VisitorUserService visitorUserService;

	@RequestMapping("/create")
	@ResponseBody
	public JSONObject addVisitorUser(String phone, String nickname,
			HttpServletRequest req) {
		
		String ip = GetIP.getIp(req);
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		
		logger.info("新增访客--phone:[{}] nickname:[{}]",phone,nickname,ip);

		map.put("vuPhone", phone);
		map.put("vuNickname", nickname);
		map.put("vuIp", ip);

		Integer vuId = visitorUserService.addVisitorUser(map);
		if (vuId != null) {
			jobj.put("code", 0);
			jobj.put("vuId", vuId);
		} else {
			jobj.put("code", 1);
		}
		return jobj;
	}

}
