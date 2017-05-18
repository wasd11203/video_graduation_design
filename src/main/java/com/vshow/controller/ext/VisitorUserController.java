package com.vshow.controller.ext;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.vshow.controller.BasicController;
import com.vshow.service.VisitorUserService;
import com.vshow.util.http.GetIP;
import com.vshow.util.http.HttpUtil;
import com.vshow.util.random.RandomNum;

/**
 * 访客 Controller
 *
 * @author ganzhigang time: 2017年4月30日 下午11:14:02
 *
 */
@Controller("visitorUserController")
@RequestMapping("/visitor")
public class VisitorUserController extends BasicController{

	@Value("${char.source.pool}")
	private String sourcePool;
	
	@Value("${ali.dayu.sdk.url}")
	private String url;
	
	@Value("${ali.dayu.sdk.appkey}")
	private String appkey;
	
	@Value("${ali.dayu.sdk.secret}")
	private String secret;
	
	@Value("${ali.dayu.sdk.extend}")
	private String extend;
	
	@Value("${ali.dayu.sdk.smsType}")
	private String smsType;
	
	@Value("${ali.dayu.sdk.tempLateCode}")
	private String tempLateCode;
	
	@Value("${ali.dayu.sdk.freeSignName}")
	private String freeSignName;
	
	@Autowired
	private VisitorUserService visitorUserService;

	@RequestMapping("/create")
	@ResponseBody
	public JSONObject addVisitorUser(String phone, String nickname,String verifyCode,HttpServletRequest req) {
		
		String ip = GetIP.getIp(req);
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		
		Cookie[] cookies = req.getCookies();
		String realCode = null ; 
		
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals(phone)){
					realCode = cookie.getValue();
				}
			}
		}
		
		if(realCode != null){
			if(!realCode.equals(verifyCode.trim())){
				jobj.put("code", 3);
				jobj.put("msg", "验证码错误");
				
				return jobj;
			}
		}else{
			jobj.put("code", 2);
			jobj.put("msg", "验证码可能已经失效");
			return jobj;
		}
		
		logger.info("新增访客--phone:[{}], nickname:[{}] ,访客输入验证码:[{}],请求中获取验证码:[{}] ",phone,nickname,verifyCode,realCode);

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

	@RequestMapping("/send")
	@ResponseBody
	public JSONObject sendVisitorVerifyCode(String phone,HttpServletRequest req,HttpServletResponse res) {
		
		String code = RandomNum.randomCheckCode(sourcePool);
		Cookie cookie = new Cookie(phone, code);
		// 60S 内有效
		cookie.setMaxAge(60);
		res.addCookie(cookie);
		logger.debug("CONTROLLER-- 向号码:[{}]发送验证码:[{}]",phone,code);
		
		JSONObject resJson = null;
		JSONObject param = new JSONObject();
		param.put("code", code);
		
		try {
			resJson = HttpUtil.alihttpPost(url, appkey, secret, extend, smsType, phone, tempLateCode, freeSignName, param);
		} catch (ApiException e) {
			
			e.printStackTrace();
		}
		
		return resJson;
	}
	
	@RequestMapping("/check_name")
	@ResponseBody
	public JSONObject checkNickname(String nickname){
		
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nickname", nickname);
		
		int count = visitorUserService.getCountByNickname(map);
		
		if(count>0){
			jobj.put("code", 1);
			jobj.put("msg", "昵称已被使用");
		}else{
			jobj.put("code", 0);
			jobj.put("msg", "昵称可以使用");
		}
		return jobj;
	}
	
}
