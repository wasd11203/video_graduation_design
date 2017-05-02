package com.vshow.service;

import java.util.List;
import java.util.Map;

import com.vshow.entity.Comment;

/**
 * 评论 业务层接口
 *
 * @author ganzhigang
 * time: 2017年4月30日 下午8:40:41
 *
 */
public interface CommentService {

	/**
	 * 根据 视频Id查询评论列表
	 * @param map
	 * @return
	 */
	public List<Comment> getCommentListByVid(Map<String, Object> map);

	/**
	 * 插入一条评论
	 * @param map
	 * @return
	 */
	public int addComment(Map<String, Object> map);
	
	/**
	 * 更新评论 点赞数等。。
	 * @param map
	 * @return
	 */
	public int updateComment(Map<String, Object> map);
}
