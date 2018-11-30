/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.5.61 : Database - easygo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`easygo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `easygo`;

/*Table structure for table `user_addr` */

DROP TABLE IF EXISTS `user_addr`;

CREATE TABLE `user_addr` (
  `uaid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `ulid` int(10) unsigned NOT NULL COMMENT '用户登录id',
  `zip` smallint(6) NOT NULL COMMENT '邮编',
  `province` smallint(6) NOT NULL COMMENT '地区表中省份的ID',
  `city` smallint(6) NOT NULL COMMENT '地区表中城市的ID',
  `district` smallint(6) NOT NULL COMMENT '地区表中的区ID',
  `address` varchar(200) NOT NULL COMMENT '具体的地址门牌号',
  `dafault` tinyint(4) NOT NULL COMMENT '是否默认',
  `state` tinyint(4) NOT NULL COMMENT '状态 1-已删除 2-变更...',
  `consignee` varchar(20) NOT NULL COMMENT '收货人',
  `telephone` int(10) unsigned DEFAULT NULL COMMENT '手机号',
  `modified_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`uaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表';

/*Data for the table `user_addr` */

/*Table structure for table `user_infor` */

DROP TABLE IF EXISTS `user_infor`;

CREATE TABLE `user_infor` (
  `uiid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `ulid` int(10) unsigned NOT NULL COMMENT '用户登录id',
  `username` varchar(20) NOT NULL COMMENT '用户真实姓名',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '会员生日',
  `phone` int(10) unsigned DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `id_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '证件类型：1 身份证，2 军官证，3 护照',
  `id_num` varchar(20) DEFAULT NULL COMMENT '证件号码',
  `account` decimal(8,2) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
  `user_gain_point` int(11) NOT NULL DEFAULT '0' COMMENT '用户积分',
  `user_rank` tinyint(4) NOT NULL DEFAULT '1' COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
  `register_state` tinyint(4) NOT NULL DEFAULT '1' COMMENT '注册状态',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `register_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注册时间',
  ` writeoff_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注销时间',
  PRIMARY KEY (`uiid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `user_infor` */

/*Table structure for table `user_login` */

DROP TABLE IF EXISTS `user_login`;

CREATE TABLE `user_login` (
  `ulid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户登录ID',
  `login_name` varchar(20) NOT NULL COMMENT '用户登录名',
  `password` char(32) NOT NULL COMMENT 'md5加密的密码',
  `login_state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `head_image_url` varchar(100) NOT NULL DEFAULT '' COMMENT '头像',
  `token` varchar(32) NOT NULL DEFAULT '' COMMENT '会话状态id（口令）',
  `modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`ulid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录表';

/*Data for the table `user_login` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
