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
import com.vshow.entity.Comment;
import com.vshow.service.CommentService;

/**
 * 评论 Controller
 *
 * @author ganzhigang
 * time: 2017年4月30日 下午11:00:32
 *
 */
@Controller("commentController")
@RequestMapping("/comment")
public class CommentController extends BasicController{

	@Value("${result.pageSize}")
	private String resultPageSize;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/list/json")
	@ResponseBody
	public JSONObject getCommentList(String vId,Integer curPage){

		logger.info("根据视频Id:[{}]列出视频对应的评论",vId);
		
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = new Integer(vId);
		
		Integer pageSize = new Integer(resultPageSize);
		
		int startIndex = (curPage-1)*pageSize;
		
		map.put("vId", id);
		map.put("startIndex", startIndex);
		map.put("pageSize", pageSize);
		
		List<Comment> comments = commentService.getCommentListByVid(map);
		int count = commentService.getCommentsCountByVid(map);
		jobj.put("list", comments);
		jobj.put("count", count);
		
		return jobj;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public JSONObject creatComment(String vId,String dcComment,String vuId){
		
		logger.info("访客:[{}]为视频Id:[{}]增加评论内容为[{}]",vuId,vId,dcComment);
		
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer videoId = new Integer(vId);
		Integer visitorId = new Integer(vuId);
		
		map.put("vId", videoId);
		map.put("vuId", visitorId);
		map.put("dcComment", dcComment);
		
		int row = commentService.addComment(map);
		if(row > 0){
			jobj.put("code", 0);
		}else{
			jobj.put("code", 1);
		}
		
		return jobj;
	}
	
	@RequestMapping("/fabs")
	@ResponseBody
	public JSONObject changeCommentArgs(String dcId,String upFab){
		logger.info("评论Id:[{}],点赞数(+/-):[{}]",dcId,upFab);
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		
		Integer id = new Integer(dcId);
		Integer up = new Integer(upFab);
		map.put("dcId", id);
		map.put("upFab", up);
		
		int row = commentService.updateComment(map);
		
		if(row > 0){
			jobj.put("code", 0);
		}else{
			jobj.put("code", 1);
		}
		
		return jobj;
	}
	
}
