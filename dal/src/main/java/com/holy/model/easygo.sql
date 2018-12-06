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

-- ---------------------------------------------------------------------------------------
/*Table structure for table `user_login` */

DROP TABLE IF EXISTS `user_login`;

CREATE TABLE `user_login` (
  `ulid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户登录ID',
  `login_name` VARCHAR(20) NOT NULL COMMENT '用户登录名',
  `password` CHAR(32) NOT NULL COMMENT 'md5加密的密码',
  `login_state` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `head_image_url` VARCHAR(100) NOT NULL DEFAULT '' COMMENT '头像',
  `token` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '会话状态id（口令）',
  `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`ulid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户登录表';

/*Data for the table `user_login` */
-- ---------------------------------------------------------------------------------------
/*Table structure for table `user_infor` */

DROP TABLE IF EXISTS `user_infor`;

CREATE TABLE `user_infor` (
  `uiid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `ulid` INT(10) UNSIGNED NOT NULL COMMENT '用户登录id',
  `username` VARCHAR(20) NOT NULL COMMENT '用户真实姓名',
  `gender` CHAR(1) DEFAULT NULL COMMENT '性别',
  `birthday` DATETIME DEFAULT NULL COMMENT '会员生日',
  `phone` INT(10) UNSIGNED DEFAULT NULL COMMENT '手机号',
  `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  `id_type` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '证件类型：1 身份证，2 军官证，3 护照',
  `id_num` VARCHAR(20) DEFAULT NULL COMMENT '证件号码',
  `balance` DECIMAL(8,2) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
  `user_gain_point` INT(11) NOT NULL DEFAULT '0' COMMENT '用户积分',
  `user_rank` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石',
  `register_state` TINYINT(4) NOT NULL DEFAULT '1' COMMENT '注册状态',
  `register_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注册时间',
  ` writeoff_time` TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '注销时间',
  `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`uiid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `user_infor` */
-- ---------------------------------------------------------------------------------------
/*Table structure for table `user_addr` */

DROP TABLE IF EXISTS `user_addr`;

CREATE TABLE `user_addr` (
  `uaid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键ID',
  `ulid` INT(10) UNSIGNED NOT NULL COMMENT '用户登录id',
  `zip` SMALLINT(6) NOT NULL COMMENT '邮编',
  `province` SMALLINT(6) NOT NULL COMMENT '地区表中省份的ID',
  `city` SMALLINT(6) NOT NULL COMMENT '地区表中城市的ID',
  `district` SMALLINT(6) NOT NULL COMMENT '地区表中的区ID',
  `address` VARCHAR(200) NOT NULL COMMENT '具体的地址门牌号',
  `state` TINYINT(4) NOT NULL COMMENT '状态 1-已删除 2-变更...',
  `consignee` VARCHAR(20) NOT NULL COMMENT '收货人',
  `telephone` INT(10) UNSIGNED DEFAULT NULL COMMENT '手机号',
  `modify_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`uaid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='用户地址表';

/*Data for the table `user_addr` */
-- ---------------------------------------------------------------------------------------
CREATE TABLE user_account_log(
  ualid INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '账户日志ID',
  ulid INT UNSIGNED NOT NULL COMMENT '用户登录ID',
  source TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '记录来源：1订单，2退货单',
  source_sn INT UNSIGNED NOT NULL COMMENT '相关单据ID',
  trigger_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录生成时间',
  balance DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '变动后余额',
  amount DECIMAL(8,2) NOT NULL DEFAULT 0.00 COMMENT '变动金额',
  PRIMARY KEY (ualid)
) ENGINE = INNODB COMMENT '用户余额变动表';
-- ---------------------------------------------------------------------------------------
CREATE TABLE user_login_log(
  ullid INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '登陆日志ID',
  ulid INT UNSIGNED NOT NULL COMMENT '用户登录ID',
  login_way TINYINT(4) NOT NULL DEFAULT '0' COMMENT '登录方式',
  login_terminal VARCHAR(20) NOT NULL COMMENT '登录终端',
  login_ip VARCHAR(15) UNSIGNED NOT NULL COMMENT '登陆IP',
  login_time TIMESTAMP NOT NULL COMMENT '用户登陆时间',
  login_result TINYINT(4) NOT NULL DEFAULT '0' COMMENT '登录结果',
  login_addr VARCHAR(100) DEFAULT NULL COMMENT '登录具体地址',
  logout_reason TINYINT(4) NOT NULL DEFAULT '0' COMMENT '登出原因',
  logout_time TIMESTAMP NOT NULL COMMENT '登出时间',
  logout_ip VARCHAR(15) UNSIGNED NOT NULL COMMENT '登出IP',
  PRIMARY KEY (ullid)
) ENGINE = INNODB COMMENT '用户登陆日志表';
-- ---------------------------------------------------------------------------------------
-- ---------------------------------------------------------------------------------------
CREATE TABLE goods_brand(
  gbid SMALLINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '品牌ID',
  kindid INT UNSIGNED NOT NULL COMMENT '品牌种类id',
  brand_name VARCHAR(50) NOT NULL COMMENT '品牌名称',
  brand_logo VARCHAR(100) COMMENT '品牌logo URL',
  brand_desc VARCHAR(150) COMMENT '品牌描述',
  brand_state TINYINT NOT NULL DEFAULT 0 COMMENT '品牌状态,0禁用,1启用',
  brand_order TINYINT NOT NULL DEFAULT 0 COMMENT '排序',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  telephone VARCHAR(50) NOT NULL COMMENT '联系电话',
  brand_web VARCHAR(100) COMMENT '品牌网络',
  PRIMARY KEY pk_brandid (brand_id)
)ENGINE=INNODB COMMENT '品牌信息表';
-- ---------------------------------------------------------------------------------------
CREATE TABLE goods_type(
  gtid SMALLINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '分类ID',
  type_name VARCHAR(10) NOT NULL COMMENT '分类名称',
  root TINYINT NOT NULL DEFAULT 1 COMMENT '是否是根类型',
  last TINYINT NOT NULL DEFAULT 1 COMMENT '是否是最终类型',
  father_id SMALLINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '父分类ID',
  rank TINYINT NOT NULL DEFAULT 1 COMMENT '分类层级',
  type_code VARCHAR(10) NOT NULL COMMENT '分类编码',
  type_state TINYINT NOT NULL DEFAULT 1 COMMENT '分类状态',
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '最后修改时间',
  PRIMARY KEY pk_categoryid(category_id)
)ENGINE=INNODB COMMENT '商品分类表'
-- ---------------------------------------------------------------------------------------
CREATE TABLE supplier(
  sid INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '供应商ID',
  name CHAR(50) NOT NULL COMMENT '供应商名称',
  scale TINYINT NOT NULL COMMENT '供应商类型：1.自营，2.平台',
  code CHAR(8) NOT NULL COMMENT '供应商编码',
  corporation VARCHAR(10) NOT NULL COMMENT '供应商法人',
  telephone VARCHAR(50) NOT NULL COMMENT '联系电话',
  bank_name VARCHAR(50) NOT NULL COMMENT '供应商开户银行名称',
  bank_account VARCHAR(50) NOT NULL COMMENT '银行账号',
  address VARCHAR(200) NOT NULL COMMENT '供应商地址',
  corporate_state TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0禁止，1启用',
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '最后修改时间',
  PRIMARY KEY pk_supplierid(supplier_id)
) ENGINE = innodb COMMENT '供应商信息表';
-- ---------------------------------------------------------------------------------------
CREATE TABLE product_info(
  product_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '商品ID',
  product_core CHAR(16) NOT NULL COMMENT '商品编码',
  product_name VARCHAR(20) NOT NULL COMMENT '商品名称',
  bar_code VARCHAR(50) NOT NULL COMMENT '国条码',
  brand_id INT UNSIGNED NOT NULL COMMENT '品牌表的ID',
  one_category_id SMALLINT UNSIGNED NOT NULL COMMENT '一级分类ID',
  two_category_id SMALLINT UNSIGNED NOT NULL COMMENT '二级分类ID',
  three_category_id SMALLINT UNSIGNED NOT NULL COMMENT '三级分类ID',
  supplier_id INT UNSIGNED NOT NULL COMMENT '商品的供应商ID',
  price DECIMAL(8,2) NOT NULL COMMENT '商品销售价格',
  average_cost DECIMAL(18,2) NOT NULL COMMENT '商品加权平均成本',
  publish_status TINYINT NOT NULL DEFAULT 0 COMMENT '上下架状态：0下架1上架',
  audit_status TINYINT NOT NULL DEFAULT 0 COMMENT '审核状态：0未审核，1已审核',
  weight FLOAT COMMENT '商品重量',
  length FLOAT COMMENT '商品长度',
  height FLOAT COMMENT '商品高度',
  width FLOAT COMMENT '商品宽度',
  color_type ENUM('红','黄','蓝','黑'),
  production_date DATETIME NOT NULL COMMENT '生产日期',
  shelf_life INT NOT NULL COMMENT '商品有效期',
  descript TEXT NOT NULL COMMENT '商品描述',
  indate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品录入时间',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY pk_productid(product_id)
) ENGINE = innodb COMMENT '商品信息表';
-- ---------------------------------------------------------------------------------------
-- ---------------------------------------------------------------------------------------
-- ---------------------------------------------------------------------------------------

