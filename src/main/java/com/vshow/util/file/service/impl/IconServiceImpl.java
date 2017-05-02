package com.vshow.util.file.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.vshow.util.file.service.IconService;

@Service("iconService")
public class IconServiceImpl implements IconService{

	@Override
	public JSONObject delete(String picUidName,String realPath) {
		JSONObject jobj = new JSONObject();
        File imageFile = new File(realPath + "/" + picUidName);
        imageFile.delete();
        jobj.put("code", 0);
        return jobj;
	}

	@Override
	public JSONObject upload(MultipartFile picFileMpf, String realPath) {
		JSONObject jobj = new JSONObject();
        String newFilenameBase = UUID.randomUUID().toString();
        String originalFileExtension = picFileMpf.getOriginalFilename().substring(picFileMpf.getOriginalFilename().lastIndexOf("."));
        String newFilename = newFilenameBase + originalFileExtension;
        String storageDirectory = realPath;
        
        File imagesDirectory = new File(storageDirectory);

        try {
            if (!imagesDirectory.exists()) {
                imagesDirectory.mkdirs();
            }
            File newFile = new File(storageDirectory + "/" + newFilename);
            newFile = new File(newFile.getAbsolutePath());
            picFileMpf.transferTo(newFile);
            jobj.put("fileName", newFilename);
            jobj.put("code", 0);
        } catch (IOException e) {
            jobj.put("code", 1);
            jobj.put("errMsg", e.getMessage());
            e.printStackTrace();
        }
        return jobj;
	}

}
