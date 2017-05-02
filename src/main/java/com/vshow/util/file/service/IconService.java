package com.vshow.util.file.service;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

public interface IconService {
	
	public static final String SEC_DIRECTORY = "headIcon";
	
	/**
	 * 删除指定的目录下的指定文件
	 * @param picUidName
	 * @param realPath
	 * @return
	 */
	public JSONObject delete(String picUidName,String realPath);
	/**
	 * 将文件上传到指定的目录下
	 * @param picUidName
	 * @param realPath
	 * @return
	 */
	public JSONObject upload(MultipartFile picFileMpf,String realPath);
}
