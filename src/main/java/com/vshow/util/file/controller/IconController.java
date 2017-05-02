package com.vshow.util.file.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.vshow.controller.BasicController;
import com.vshow.util.file.service.IconService;

@Controller
public class IconController extends BasicController{

	@Value("${uploadIconPath}")
	private String directory;
	
	@Autowired
	private IconService iconService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public JSONObject upload(MultipartFile picFileMpf, HttpServletRequest req){
		logger.debug("上传的文件为：[{}]",picFileMpf);
		String realPath = req.getSession().getServletContext().getRealPath("/");
		realPath += File.separator+directory;
		JSONObject jobj = iconService.upload(picFileMpf, realPath);
				
		return jobj;
	}
	
}
