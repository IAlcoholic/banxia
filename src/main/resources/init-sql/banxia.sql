# -----------
# -- user 用户表
# -----------
CREATE TABLE user (
  user_id Integer(8) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  user_name varchar(32) NOT NULL COMMENT '用户名',
  user_pwd varchar(32) NOT NULL COMMENT '用户密码',
  user_phone int(12)  COMMENT '用户手机号码',
  user_sex varchar(6)  COMMENT '用户性别',
  user_qq mediumint(9)  COMMENT '用户QQ号码',
  user_email varchar(64)  COMMENT '用户EMAIL地址',
  user_address varchar(255)  COMMENT '用户地址',
  user_last_login_ip varchar(15)  COMMENT '用户上一次登录IP地址',
  user_birthday int(13)  COMMENT '用户生日',
  user_signature varchar(255)  COMMENT '自我描述',
  user_image_url varchar(255)  COMMENT '用户头像存储路径',
  user_register_time int(13)  COMMENT '用户注册时间',
  user_register_ip varchar(15)  COMMENT '用户注册时IP地址',
  user_last_update_time int(13)  COMMENT '用户上次更新博客时间',
  user_power varchar(255) COMMENT '拥有权限',
  PRIMARY KEY (user_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

#
# ---------------------------
# --article_sort 文章分类表
# ---------------------------
CREATE TABLE article_sort (
  sort_article_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '文章自增ID',
  user_id mediumint(8) NOT NULL COMMENT '该分类所属用户',
  sort_article_name varchar(60) NOT NULL COMMENT '分类名称',
  PRIMARY KEY (sort_article_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;



# ----------------------------
# --article 文章表
# ----------------------------
CREATE TABLE article (
  article_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '日志自增ID号',
  article_name varchar(128) NOT NULL COMMENT '文章名称',
  article_time int(13) NOT NULL COMMENT '发布时间',
  article_ip varchar(15) NOT NULL COMMENT '发布IP',
  article_click int(10) NOT NULL COMMENT '查看人数',
  sort_article_id mediumint(8) NOT NULL COMMENT '所属分类',
  user_id mediumint(8) NOT NULL COMMENT '所属用户ID',
  type_id tinyint(3) NOT NULL DEFAULT 1 COMMENT '栏目ID',
  article_type int(13) NOT NULL DEFAULT 1 COMMENT '文章的模式:0为私有，1为公开，2为仅好友查看',
  article_content text NOT NULL COMMENT '文章内容',
  article_up tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否置顶:0为否，1为是',
  article_support tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否博主推荐:0为否，1为是',
  PRIMARY KEY (article_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


# -------------------------
# --shuoshuo 用户心情说说表
# -------------------------
CREATE TABLE shuoshuo (
  shuo_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '说说记录ID',
  user_id mediumint(8) NOT NULL COMMENT '用户ID',
  shuo_time int(13) NOT NULL DEFAULT 0 COMMENT '发布时间',
  shuo_ip varchar(15) NOT NULL COMMENT '说说发布时的IP地址',
  shuoshuo varchar(255) NOT NULL COMMENT '说说内容',
  type_id tinyint(3) NOT NULL DEFAULT 3 COMMENT '栏目ID,默认为3',
  PRIMARY KEY (shuo_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

#
# -------------------------
# --photos 相片表
# -------------------------
CREATE TABLE photos (
  photo_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '相片ID',
  photo_name varchar(255) NOT NULL COMMENT '相片名称',
  photo_src varchar(255) NOT NULL COMMENT '图片路径',
  photo_description varchar(255) NOT NULL COMMENT '图片描述',
  user_id mediumint(8) NOT NULL COMMENT '所属用户ID',
  sort_id mediumint(8) NOT NULL COMMENT '所属相册ID',
  upload_time int(13) NOT NULL COMMENT '图片上传时间',
  upload_ip varchar(15) NOT NULL COMMENT '图片操作上传IP地址',
  PRIMARY KEY (photo_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;



# ----------------------
# --about_blog 博客信息表
# ----------------------
CREATE TABLE about_blog (
  blog_id mediumint(8) NOT NULL  COMMENT '用户ID',
  blog_keyword varchar(255) NOT NULL COMMENT '博客关键字',
  blog_description varchar(255) NOT NULL COMMENT '博客描述',
  blog_name varchar(36) NOT NULL COMMENT '博客名称',
  blog_title varchar(128) NOT NULL COMMENT '博客标题',
  PRIMARY KEY (blog_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;



# ------------------
# -- power_list 功能权限表
# ------------------
CREATE TABLE power_list (
  p_id int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  power_id int(10) NOT NULL COMMENT '权限ID',
  power_name varchar(36) NOT NULL COMMENT '权限描述',
  PRIMARY KEY (p_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;



# -------------------
# --friend 好友表
# -------------------
CREATE TABLE friend (
  f_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  user_id mediumint(8) NOT NULL COMMENT '用户ID',
  friend_id mediumint(8) NOT NULL COMMENT '好友ID',
  PRIMARY KEY (f_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


# ----------------------
# --user_attention 用户关注表
# ----------------------
CREATE TABLE user_attention (
  a_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  user_id mediumint(8) NOT NULL COMMENT '用户ID',
  attention_id mediumint(8) NOT NULL COMMENT '关注ID',
  PRIMARY KEY (a_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

#
# -----------------------
# --secret_message 用户私信表
# -----------------------
CREATE TABLE secret_message (
  secret_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '自增私信ID',
  send_id mediumint(8) NOT NULL COMMENT '发信者ID',
  receive_id mediumint(8) NOT NULL COMMENT '收信者ID',
  message_topic varchar(64) NOT NULL COMMENT '私信标题',
  message_content varchar(255) NOT NULL COMMENT '私信内容',
  PRIMARY KEY (secret_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;



# ------------------------
# --system_message 系统通知表
# ------------------------
CREATE TABLE system_message (
  system_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '系统通知ID',
  send_id mediumint(8) NOT NULL COMMENT '接受者ID',
  group_id tinyint(3) NOT NULL COMMENT '用户组ID',
  send_default mediumint(8) NOT NULL COMMENT '1时发送所有用户，0时则不采用',
  system_topic varchar(60) NOT NULL COMMENT '通知内容',
  system_content varchar(255) NOT NULL COMMENT '通知内容',
  PRIMARY KEY (system_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


# --------------------------
# --friendly_link 友情链接
# --------------------------
CREATE TABLE friendly_link (
  link_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '友情链接自增ID',
  link_name varchar(60) NOT NULL COMMENT '友情链接名称',
  link_url varchar(255) NOT NULL COMMENT '链接地址',
  link_logo varchar(255) NOT NULL COMMENT 'LOGO图片',
  show_order tinyint(3) NOT NULL COMMENT '在页面显示的顺序',
  PRIMARY KEY (link_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


# --------------------
# --stay_message 用户留言表
# --------------------
CREATE TABLE stay_message (
  stay_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '留言表自增ID',
  user_id mediumint(8) NOT NULL COMMENT '用户ID',
  stay_user_id mediumint(8) NOT NULL COMMENT '留言者ID',
  message_content varchar(255) NOT NULL COMMENT '留言内容',
  stay_user_ip varchar(15) NOT NULL COMMENT '留言用户的IP地址',
  message_stay_time int(13) NOT NULL COMMENT '留言时间',
  place varchar(64) NOT NULL COMMENT '地区',
  PRIMARY KEY (stay_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


# ------------------------
# --visitor 最近访客表
# ------------------------
CREATE TABLE visitor (
  v_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '访客记录ID',
  visitor_id mediumint(8) NOT NULL COMMENT '访客ID',
  visitor_time int(13) NOT NULL COMMENT '来访时间',
  user_id mediumint(8) NOT NULL COMMENT '被访用户ID',
  visitor_ip varchar(15) NOT NULL COMMENT '访客IP地址',
  type_id int(3) NOT NULL COMMENT '访问板块ID',
  where_id mediumint(8) NOT NULL COMMENT '查看某板块的某个子项目，如查看相册板块的第3个相册，该ID对应该相册的ID号',
  PRIMARY KEY (v_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


#
# ----------------------------
# --user_comment 用户评论表
# ----------------------------
CREATE TABLE user_comment (
  c_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '评论自增ID号',
  user_id mediumint(8) NOT NULL COMMENT '收到评论的用户ID',
  type_id tinyint(3) NOT NULL COMMENT '评论栏目ID',
  commit_id mediumint(8) NOT NULL COMMENT '评论内容的ID',
  commit_content varchar(255) NOT NULL COMMENT '评论内容',
  commit_user_id mediumint(8) NOT NULL COMMENT '评论者ID',
  commit_time int(13) NOT NULL COMMENT '评论时间',
  commit_ip varchar(15) NOT NULL COMMENT '评论时的IP地址',
  PRIMARY KEY (c_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;
