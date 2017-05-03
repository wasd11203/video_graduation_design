/*
Navicat MySQL Data Transfer

Source Server         : localhost:3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : vshow

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-05-03 19:02:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `v_comment_next`
-- ----------------------------
DROP TABLE IF EXISTS `v_comment_next`;
CREATE TABLE `v_comment_next` (
  `VC_ID` int(11) NOT NULL COMMENT '评论_ID',
  `TARGET_ID` int(11) DEFAULT NULL COMMENT '父级评论_ID',
  `VC_COMMENT` varchar(256) DEFAULT NULL COMMENT '评论内容',
  `VC_INTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `ISDEL` int(11) DEFAULT NULL COMMENT '删除标识',
  `FABULOUS_COUNTS` int(11) DEFAULT NULL COMMENT '点赞数',
  `VU_ID` int(11) DEFAULT NULL COMMENT '访客_ID',
  PRIMARY KEY (`VC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表---次级以及所有下级评论表';

-- ----------------------------
-- Records of v_comment_next
-- ----------------------------

-- ----------------------------
-- Table structure for `v_direct_comment`
-- ----------------------------
DROP TABLE IF EXISTS `v_direct_comment`;
CREATE TABLE `v_direct_comment` (
  `DC_ID` int(11) NOT NULL COMMENT '评论_ID',
  `VI_ID` int(11) DEFAULT NULL COMMENT '视频_ID',
  `DC_COMMENT` varchar(256) DEFAULT NULL COMMENT '评论内容',
  `DC_INTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `ISDEL` int(11) DEFAULT NULL COMMENT '删除标识',
  `FABULOUS_COUNTS` int(11) DEFAULT NULL COMMENT '点赞数',
  `VU_ID` int(11) DEFAULT NULL COMMENT '访客_ID',
  PRIMARY KEY (`DC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表--直接评论';

-- ----------------------------
-- Records of v_direct_comment
-- ----------------------------
INSERT INTO `v_direct_comment` VALUES ('1', '12', '干的好，', '2017-05-03 19:00:59', '0', '7', '1');
INSERT INTO `v_direct_comment` VALUES ('2', '12', '可以的，', '2017-05-03 19:01:05', '0', '8', '2');

-- ----------------------------
-- Table structure for `v_manager`
-- ----------------------------
DROP TABLE IF EXISTS `v_manager`;
CREATE TABLE `v_manager` (
  `M_ID` int(11) NOT NULL COMMENT '管理员_ID',
  `M_NICKNAME` varchar(32) DEFAULT NULL COMMENT '昵称',
  `M_NAME` varchar(32) DEFAULT NULL COMMENT '姓名',
  `M_PHONE` varchar(16) DEFAULT NULL COMMENT '手机号',
  `M_PASSWORD` varchar(64) DEFAULT NULL COMMENT '密码',
  `M_INTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `M_PIC` varchar(128) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站管理员';

-- ----------------------------
-- Records of v_manager
-- ----------------------------
INSERT INTO `v_manager` VALUES ('1', 'Admin', 'AA', '15727575679', '123456', '2017-04-29 17:25:11', null);

-- ----------------------------
-- Table structure for `v_sec_category`
-- ----------------------------
DROP TABLE IF EXISTS `v_sec_category`;
CREATE TABLE `v_sec_category` (
  `V_SEC_ID` int(11) NOT NULL COMMENT '视频二级分类_ID',
  `V_SEC_NAME` varchar(32) DEFAULT NULL COMMENT '视频二级分类名称',
  `V_TOP_ID` int(11) DEFAULT NULL COMMENT '视频一级分类_ID',
  PRIMARY KEY (`V_SEC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视频二级分类';

-- ----------------------------
-- Records of v_sec_category
-- ----------------------------
INSERT INTO `v_sec_category` VALUES ('1001', '内地', '1');
INSERT INTO `v_sec_category` VALUES ('1002', '韩剧', '1');
INSERT INTO `v_sec_category` VALUES ('1003', '美剧', '1');
INSERT INTO `v_sec_category` VALUES ('1004', '自制剧', '1');
INSERT INTO `v_sec_category` VALUES ('1005', '网剧', '1');
INSERT INTO `v_sec_category` VALUES ('2001', '网络电影', '2');
INSERT INTO `v_sec_category` VALUES ('2002', '预告片', '2');
INSERT INTO `v_sec_category` VALUES ('3001', '网球', '3');
INSERT INTO `v_sec_category` VALUES ('3002', '棒球', '3');
INSERT INTO `v_sec_category` VALUES ('3003', '高尔夫', '3');
INSERT INTO `v_sec_category` VALUES ('3004', '篮球', '3');
INSERT INTO `v_sec_category` VALUES ('3005', '足球', '3');
INSERT INTO `v_sec_category` VALUES ('4001', '欢乐精选', '4');
INSERT INTO `v_sec_category` VALUES ('4002', '搞笑达人', '4');
INSERT INTO `v_sec_category` VALUES ('4003', '雷人囧事', '4');
INSERT INTO `v_sec_category` VALUES ('4004', '奇闻趣事', '4');
INSERT INTO `v_sec_category` VALUES ('4005', '爆笑节目', '4');
INSERT INTO `v_sec_category` VALUES ('5001', '播报', '5');
INSERT INTO `v_sec_category` VALUES ('5002', '情感', '5');
INSERT INTO `v_sec_category` VALUES ('5003', '访谈', '5');
INSERT INTO `v_sec_category` VALUES ('5004', '脱口秀', '5');

-- ----------------------------
-- Table structure for `v_top_category`
-- ----------------------------
DROP TABLE IF EXISTS `v_top_category`;
CREATE TABLE `v_top_category` (
  `V_TOP_ID` int(11) NOT NULL COMMENT '一级分类ID',
  `V_TOP_NAME` varchar(32) DEFAULT NULL COMMENT '一级分类名称',
  PRIMARY KEY (`V_TOP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视频一级分类：电视剧，综艺电影，运动等。。。';

-- ----------------------------
-- Records of v_top_category
-- ----------------------------
INSERT INTO `v_top_category` VALUES ('1', '剧集');
INSERT INTO `v_top_category` VALUES ('2', '电影');
INSERT INTO `v_top_category` VALUES ('3', '体育');
INSERT INTO `v_top_category` VALUES ('4', '搞笑');
INSERT INTO `v_top_category` VALUES ('5', '综艺');

-- ----------------------------
-- Table structure for `v_video_info`
-- ----------------------------
DROP TABLE IF EXISTS `v_video_info`;
CREATE TABLE `v_video_info` (
  `VI_ID` int(11) NOT NULL COMMENT '视频_ID',
  `VI_TITLE` varchar(128) DEFAULT NULL COMMENT '视频标题',
  `VI_NAME` varchar(128) DEFAULT NULL COMMENT '视频名称',
  `VI_PIC` varchar(128) DEFAULT NULL COMMENT '视频显示图片',
  `VI_INTRODUCE` varchar(256) DEFAULT NULL COMMENT '视频介绍',
  `VI_PATH` varchar(128) DEFAULT NULL COMMENT '视频地址',
  `PLAY_COUNTS` int(11) DEFAULT NULL COMMENT '播放次数',
  `DURATION` bigint(20) DEFAULT NULL COMMENT '视频时长',
  `FABULOUS_COUNTS` int(11) DEFAULT NULL COMMENT '点赞数',
  `ISDEL` int(11) DEFAULT NULL COMMENT '删除标识(1:删除；0:未删除)',
  `V_SEC_ID` int(11) DEFAULT NULL COMMENT '二级分类_ID',
  `M_ID` int(11) DEFAULT NULL COMMENT '管理员_ID',
  PRIMARY KEY (`VI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视频信息';

-- ----------------------------
-- Records of v_video_info
-- ----------------------------
INSERT INTO `v_video_info` VALUES ('1', '正义的电视剧', '人民的名义', '', '主演：陆毅，张丰毅', 'http://static.videogular.com/assets/videos/videogular.webm', '100', '100', '100', '0', '1001', '1');
INSERT INTO `v_video_info` VALUES ('2', '修仙', '折天记', '', '主演：鹿晗，古力娜扎', 'http://static.videogular.com/assets/videos/videogular.webm', '100', '100', '100', '0', '1001', '1');
INSERT INTO `v_video_info` VALUES ('3', '都市', '御姐归来', '', '主演：安以轩，朱一龙', '', '111', '100', '100', '0', '1001', '1');
INSERT INTO `v_video_info` VALUES ('4', '医护', '外科风云', '', '主演：靳东，白百合', '', '119', '100', '100', '0', '1001', '1');
INSERT INTO `v_video_info` VALUES ('5', '高能', '太阳的后裔', '', '主演：宋仲基，宋慧乔', '', '100', '100', '100', '0', '1002', '1');
INSERT INTO `v_video_info` VALUES ('6', '奇幻', '来自星星的你', '', '导演：张太侑', '', '100', '100', '100', '0', '1002', '1');
INSERT INTO `v_video_info` VALUES ('7', '言情', '请回答1988', '', '导演：申元浩', '', '100', '100', '100', '0', '1002', '1');
INSERT INTO `v_video_info` VALUES ('8', '精彩瞬间', '保罗集锦 29分8助真正的领袖带领快船返航洛杉矶抢7', null, '保罗--领袖', '', '100', '100', '100', '0', '3004', '1');
INSERT INTO `v_video_info` VALUES ('9', '精彩!!!', '刷不停！詹姆斯进球数超韦斯特升第19位', '', '詹姆斯--升第19位', '', '100', '100', '100', '0', '3004', '1');
INSERT INTO `v_video_info` VALUES ('10', 'TOP时刻', 'NBA五佳球 沃尔送钉板大帽保罗杂耍上篮', '', '上篮', '', '100', '100', '100', '0', '3004', '1');
INSERT INTO `v_video_info` VALUES ('11', '创意', '这想象力没谁了！盘点常规赛10大最具创意过人', '', '过人', '', '102', '100', '100', '0', '3004', '1');
INSERT INTO `v_video_info` VALUES ('12', '集锦', '勇士110', null, '库里---集锦', '', '50', '1000', '18', '0', '3004', '1');

-- ----------------------------
-- Table structure for `v_visitor_user`
-- ----------------------------
DROP TABLE IF EXISTS `v_visitor_user`;
CREATE TABLE `v_visitor_user` (
  `VU_ID` int(11) NOT NULL COMMENT '访客_ID',
  `VU_PHONE` varchar(16) DEFAULT NULL COMMENT '访客电话号码',
  `VU_NICKNAME` varchar(16) DEFAULT NULL COMMENT '访客昵称',
  `VU_INTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '访客来访时间',
  `VU_IP` varchar(64) DEFAULT NULL COMMENT '访客使用的IP',
  PRIMARY KEY (`VU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访客 表';

-- ----------------------------
-- Records of v_visitor_user
-- ----------------------------
INSERT INTO `v_visitor_user` VALUES ('1', '15727575679', 'AA', '2017-04-30 09:51:33', '127.0.0.1');
INSERT INTO `v_visitor_user` VALUES ('2', '18257155845', 'BB', '2017-04-30 09:53:11', '127.0.0.1');

-- ----------------------------
-- Function structure for `getChildLst`
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildLst`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getChildLst`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN
	DECLARE
		sTemp VARCHAR (1000);

DECLARE
	sTempChd VARCHAR (1000);


SET sTemp = '$';


SET sTempChd = cast(rootId AS CHAR);


WHILE sTempChd IS NOT NULL DO

SET sTemp = concat(sTemp, ',', sTempChd);

SELECT
	group_concat(id) INTO sTempChd
FROM
	comment
WHERE
	FIND_IN_SET(target_id, sTempChd) > 0;


END
WHILE;

RETURN sTemp; 
 END
;;
DELIMITER ;
