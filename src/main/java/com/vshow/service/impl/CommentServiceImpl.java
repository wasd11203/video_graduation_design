package com.vshow.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vshow.entity.Comment;
import com.vshow.mapper.CommentMapper;
import com.vshow.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<Comment> getCommentListByVid(Map<String, Object> map) {
		return commentMapper.selectCommentsByVid(map);
	}

	@Override
	public int addComment(Map<String, Object> map) {
		
		Long time = System.currentTimeMillis();
		Integer dcId = new Integer(time.intValue());
		
		map.put("dcId", dcId);
		map.put("dcIntime", new Date());
		map.put("isDel", 0);
		map.put("fabulousCounts", 0);
		
		return commentMapper.insertComment(map);
	}

	@Override
	public int updateComment(Map<String, Object> map) {
		
		return commentMapper.updateComment(map);
	}

}
