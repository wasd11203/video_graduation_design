package com.vshow.mapper;

import java.util.List;
import java.util.Map;

import com.vshow.entity.Comment;

/**
 * 视频评论 Mapper
 *
 * @author ganzhigang
 * time: 2017年4月29日 下午4:24:46
 *
 */
public interface CommentMapper {

	/**
	 * 根据 视频Id查询评论列表
	 * @param map
	 * @return
	 */
	public List<Comment> selectCommentsByVid(Map<String, Object> map);

	/**
	 * 插入一条评论
	 * @param map
	 * @return
	 */
	public int insertComment(Map<String, Object> map);
	
	/**
	 * 更新评论 点赞数等。。
	 * @param map
	 * @return
	 */
	public int updateComment(Map<String, Object> map);
	
}
