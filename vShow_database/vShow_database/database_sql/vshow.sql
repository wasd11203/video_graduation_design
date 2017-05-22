/*
Navicat MySQL Data Transfer

Source Server         : localhost:3306
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : vshow

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-05-22 08:58:47
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
  `DC_INTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `ISDEL` int(11) DEFAULT NULL COMMENT '删除标识',
  `FABULOUS_COUNTS` int(11) DEFAULT NULL COMMENT '点赞数',
  `VU_ID` int(11) DEFAULT NULL COMMENT '访客_ID',
  PRIMARY KEY (`DC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表--直接评论';

-- ----------------------------
-- Records of v_direct_comment
-- ----------------------------
INSERT INTO `v_direct_comment` VALUES ('-673694865', '12', '干的不错！！！', '2017-05-16 09:28:38', '0', '0', '-673694966');
INSERT INTO `v_direct_comment` VALUES ('1', '12', 'asdfasdf', '2017-05-16 09:28:06', '0', '7', '1');
INSERT INTO `v_direct_comment` VALUES ('2', '12', '可以的，', '2017-05-16 09:30:00', '0', '8', '2');
INSERT INTO `v_direct_comment` VALUES ('354471599', '5', 'a', '2017-05-17 14:38:11', '0', '0', '354471504');
INSERT INTO `v_direct_comment` VALUES ('422843961', '4', 'jhhhhh', '2017-05-18 09:37:43', '0', '0', '422843911');
INSERT INTO `v_direct_comment` VALUES ('430762517', '4', 'sadf', '2017-05-18 11:49:42', '0', '0', '430762463');

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
  `M_INTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `M_PIC` varchar(128) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网站管理员';

-- ----------------------------
-- Records of v_manager
-- ----------------------------
INSERT INTO `v_manager` VALUES ('1', 'Admin', 'AA', '18257155845', '123456', '2017-05-16 17:53:25', 'http://127.0.0.1:8081/monitor/upload/icon/d1d6a3d4-56d1-48d5-ae30-3eef06637c5e.png');
INSERT INTO `v_manager` VALUES ('2', 'Admin2', 'BG', '13502849614', '123456', '2017-05-17 18:41:14', 'http://127.0.0.1:8081/monitor/upload/icon/a7426792-c253-4539-8f3a-1f4e95b335a8.png');

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
  `V_TOP_ICON` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`V_TOP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视频一级分类：电视剧，综艺电影，运动等。。。';

-- ----------------------------
-- Records of v_top_category
-- ----------------------------
INSERT INTO `v_top_category` VALUES ('1', '剧集', 'static/images/jj.png');
INSERT INTO `v_top_category` VALUES ('2', '电影', 'static/images/dy.png');
INSERT INTO `v_top_category` VALUES ('3', '体育', 'static/images/ty.png');
INSERT INTO `v_top_category` VALUES ('4', '搞笑', 'static/images/gx.png');
INSERT INTO `v_top_category` VALUES ('5', '综艺', 'static/images/zy.png');

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
  `INTIME` timestamp NULL DEFAULT NULL COMMENT '视频入库时间',
  `DISCOMMENT` int(11) DEFAULT '0' COMMENT '禁止品论标识',
  `INVALID` int(11) unsigned zerofill DEFAULT NULL COMMENT '视频是否上架标识：0 有效，1 无效',
  PRIMARY KEY (`VI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视频信息';

-- ----------------------------
-- Records of v_video_info
-- ----------------------------
INSERT INTO `v_video_info` VALUES ('1', '正义的电视剧', '人民的名义', 'static/images/r1.jpg', '主演：陆毅，张丰毅', 'http://static.videogular.com/assets/videos/videogular.mp4', '110', '100', '100', '0', '1001', '1', '2017-05-17 18:09:42', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('2', '修仙', '折天记', 'static/images/r1.jpg', '主演：鹿晗，古力娜扎', 'http://static.videogular.com/assets/videos/videogular.mp4', '100', '100', '100', '0', '1001', '1', '2017-05-17 18:09:58', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('3', '都市', '御姐归来', 'static/images/r1.jpg', '主演：安以轩，朱一龙', 'http://static.videogular.com/assets/videos/videogular.mp4', '115', '100', '100', '0', '1001', '1', '2017-05-17 18:09:58', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('4', '医护', '外科风云', 'static/images/r1.jpg', '主演：靳东，白百合', 'http://static.videogular.com/assets/videos/videogular.mp4', '168', '100', '98', '0', '1001', '1', '2017-05-17 18:26:13', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('5', '高能', '太阳的后裔', 'static/images/r1.jpg', '主演：宋仲基，宋慧乔', 'http://static.videogular.com/assets/videos/videogular.mp4', '131', '100', '100', '0', '1002', '1', '2017-05-17 18:09:59', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('6', '奇幻', '来自星星的你', 'static/images/r1.jpg', '导演：张太侑', 'http://static.videogular.com/assets/videos/videogular.mp4', '100', '100', '100', '0', '1002', '1', '2017-05-17 18:10:00', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('7', '言情', '请回答1988', 'static/images/r1.jpg', '导演：申元浩', 'http://static.videogular.com/assets/videos/videogular.mp4', '100', '100', '100', '0', '1002', '1', '2017-05-17 18:10:00', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('8', '精彩瞬间', '保罗集锦 29分8助真正的领袖带领快船返航洛杉矶抢7', 'static/images/r1.jpg', '保罗--领袖', 'http://static.videogular.com/assets/videos/videogular.mp4', '100', '100', '100', '0', '3004', '1', '2017-05-17 18:10:01', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('9', '精彩!!!', '刷不停！詹姆斯进球数超韦斯特升第19位', 'static/images/r1.jpg', '詹姆斯--升第19位', 'http://static.videogular.com/assets/videos/videogular.mp4', '100', '100', '100', '0', '3004', '1', '2017-05-17 18:10:03', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('10', 'TOP时刻', 'NBA五佳球 沃尔送钉板大帽保罗杂耍上篮', 'static/images/r1.jpg', '上篮', 'http://static.videogular.com/assets/videos/videogular.mp4', '100', '100', '100', '0', '3004', '1', '2017-05-17 18:09:48', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('11', '创意', '这想象力没谁了！盘点常规赛10大最具创意过人', 'static/images/r1.jpg', '过人', 'http://static.videogular.com/assets/videos/videogular.mp4', '103', '100', '100', '0', '3004', '1', '2017-05-17 18:09:49', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('12', '集锦', '勇士110', 'static/images/r1.jpg', '库里---集锦', 'http://static.videogular.com/assets/videos/videogular.mp4', '39', '1000', '1', '0', '3004', '1', '2017-05-17 18:25:17', '0', '00000000000');
INSERT INTO `v_video_info` VALUES ('421538095', '追忆艾弗森', '艾弗森', 'http://127.0.0.1:8081/monitor/upload/imgs/9c26e7d0-5ebe-4d5b-9f2b-0fbb174aac05.jpg', '祭艾弗森无处安放的青春', 'http://127.0.0.1:8081/monitor/upload/videos/bb1f4e6f-3d92-441d-93ed-ff4d705820a1.mp4', '8', null, '0', '0', '3004', '1', '2017-05-18 09:15:57', '0', '00000000000');

-- ----------------------------
-- Table structure for `v_visitor_user`
-- ----------------------------
DROP TABLE IF EXISTS `v_visitor_user`;
CREATE TABLE `v_visitor_user` (
  `VU_ID` int(11) NOT NULL COMMENT '访客_ID',
  `VU_PHONE` varchar(16) DEFAULT NULL COMMENT '访客电话号码',
  `VU_NICKNAME` varchar(16) DEFAULT NULL COMMENT '访客昵称',
  `VU_INTIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '访客来访时间',
  `VU_IP` varchar(64) DEFAULT NULL COMMENT '访客使用的IP',
  PRIMARY KEY (`VU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访客 表';

-- ----------------------------
-- Records of v_visitor_user
-- ----------------------------
INSERT INTO `v_visitor_user` VALUES ('-673694966', '15727575679', 'CC', '2017-05-17 18:39:06', '169.254.13.139');
INSERT INTO `v_visitor_user` VALUES ('1', '15727575679', 'AA', '2017-04-30 09:51:33', '127.0.0.1');
INSERT INTO `v_visitor_user` VALUES ('2', '18257155845', 'BB', '2017-04-30 09:53:11', '127.0.0.1');
INSERT INTO `v_visitor_user` VALUES ('422843911', '18257155845', 'xxx', '2017-05-18 09:37:43', '169.254.13.139');
INSERT INTO `v_visitor_user` VALUES ('430762463', '18257155845', 'sadf', '2017-05-18 11:49:41', '169.254.13.139');

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
