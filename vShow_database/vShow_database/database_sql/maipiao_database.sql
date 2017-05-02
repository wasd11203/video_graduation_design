/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/4/28 16:27:14                           */
/*==============================================================*/


DROP TABLE IF EXISTS V_COMMENT_NEXT;

DROP TABLE IF EXISTS V_DIRECT_COMMENT;

DROP TABLE IF EXISTS V_MANAGER;

DROP TABLE IF EXISTS V_SEC_CATEGORY;

DROP TABLE IF EXISTS V_TOP_CATEGORY;

DROP TABLE IF EXISTS V_VIDEO_INFO;

DROP TABLE IF EXISTS V_VISITOR_USER;

/*==============================================================*/
/* Table: V_COMMENT_NEXT                                        */
/*==============================================================*/
CREATE TABLE V_COMMENT_NEXT
(
   VC_ID                INT NOT NULL COMMENT '评论_ID',
   TARGET_ID            INT COMMENT '父级评论_ID',
   VC_COMMENT           VARCHAR(256) COMMENT '评论内容',
   VC_INTIME            TIMESTAMP COMMENT '评论时间',
   ISDEL                INT COMMENT '删除标识',
   FABULOUS_COUNTS      INT COMMENT '点赞数',
   VU_ID                INT COMMENT '访客_ID',
   PRIMARY KEY (VC_ID)
);

ALTER TABLE V_COMMENT_NEXT COMMENT '评论表---次级以及所有下级评论表';

/*==============================================================*/
/* Table: V_DIRECT_COMMENT                                      */
/*==============================================================*/
CREATE TABLE V_DIRECT_COMMENT
(
   DC_ID                INT NOT NULL COMMENT '评论_ID',
   VI_ID                INT COMMENT '视频_ID',
   DC_COMMENT           VARCHAR(256) COMMENT '评论内容',
   DC_INTIME            TIMESTAMP COMMENT '评论时间',
   ISDEL                INT COMMENT '删除标识',
   FABULOUS_COUNTS      INT COMMENT '点赞数',
   VU_ID                INT COMMENT '访客_ID',
   PRIMARY KEY (DC_ID)
);

ALTER TABLE V_DIRECT_COMMENT COMMENT '评论表--直接评论';

/*==============================================================*/
/* Table: V_MANAGER                                             */
/*==============================================================*/
CREATE TABLE V_MANAGER
(
   M_ID                 INT NOT NULL COMMENT '管理员_ID',
   M_NICKNAME           VARCHAR(32) COMMENT '昵称',
   M_NAME               VARCHAR(32) COMMENT '姓名',
   M_PHONE              VARCHAR(16) COMMENT '手机号',
   M_PASSWORD           VARCHAR(64) COMMENT '密码',
   M_INTIME             TIMESTAMP COMMENT '注册时间',
   M_PIC                VARCHAR(128) COMMENT '用户头像',
   PRIMARY KEY (M_ID)
);

ALTER TABLE V_MANAGER COMMENT '网站管理员';

/*==============================================================*/
/* Table: V_SEC_CATEGORY                                        */
/*==============================================================*/
CREATE TABLE V_SEC_CATEGORY
(
   V_SEC_ID             INT NOT NULL COMMENT '视频二级分类_ID',
   V_SEC_NAME           VARCHAR(32) COMMENT '视频二级分类名称',
   V_TOP_ID             INT COMMENT '视频一级分类_ID',
   PRIMARY KEY (V_SEC_ID)
);

ALTER TABLE V_SEC_CATEGORY COMMENT '视频二级分类';

/*==============================================================*/
/* Table: V_TOP_CATEGORY                                        */
/*==============================================================*/
CREATE TABLE V_TOP_CATEGORY
(
   V_TOP_ID             INT NOT NULL COMMENT '一级分类ID',
   V_TOP_NAME           VARCHAR(32) COMMENT '一级分类名称',
   PRIMARY KEY (V_TOP_ID)
);

ALTER TABLE V_TOP_CATEGORY COMMENT '视频一级分类：电视剧，综艺电影，运动等。。。';

/*==============================================================*/
/* Table: V_VIDEO_INFO                                          */
/*==============================================================*/
CREATE TABLE V_VIDEO_INFO
(
   VI_ID                INT NOT NULL COMMENT '视频_ID',
   VI_TITLE             VARCHAR(128) COMMENT '视频标题',
   VI_NAME              VARCHAR(128) COMMENT '视频名称',
   VI_PIC               VARCHAR(128) COMMENT '视频显示图片',
   VI_INTRODUCE         VARCHAR(256) COMMENT '视频介绍',
   VI_PATH              VARCHAR(128) COMMENT '视频地址',
   PLAY_COUNTS          INT COMMENT '播放次数',
   DURATION             BIGINT COMMENT '视频时长',
   FABULOUS_COUNTS      INT COMMENT '点赞数',
   ISDEL                INT COMMENT '删除标识(1:删除；0:未删除)',
   V_SEC_ID             INT COMMENT '二级分类_ID',
   M_ID                 INT COMMENT '管理员_ID',
   PRIMARY KEY (VI_ID)
);

ALTER TABLE V_VIDEO_INFO COMMENT '视频信息';

/*==============================================================*/
/* Table: V_VISITOR_USER                                        */
/*==============================================================*/
CREATE TABLE V_VISITOR_USER
(
   VU_ID                INT NOT NULL COMMENT '访客_ID',
   VU_PHONE             VARCHAR(16) COMMENT '访客电话号码',
   VU_NICKNAME          VARCHAR(16) COMMENT '访客昵称',
   VU_INTIME            TIMESTAMP COMMENT '访客来访时间',
   VU_IP                VARCHAR(64) COMMENT '访客使用的IP',
   PRIMARY KEY (VU_ID)
);

ALTER TABLE V_VISITOR_USER COMMENT '访客 表';

