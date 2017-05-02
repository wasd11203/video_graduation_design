package com.vshow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 所有controller 都应该继承自此Controller<br />
 *  此Controller中包含 了一些公共的属性如：logger等 
 * @author ganzhigang
 * 时间：2017年4月2日 下午4:35:52
 */
public class BasicController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

}
