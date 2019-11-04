/*
Navicat MySQL Data Transfer

Source Server         : 本地开发
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : springboot-mapstruct

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-11-05 00:07:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for t_good
-- ----------------------------
DROP TABLE IF EXISTS `t_good`;
CREATE TABLE `t_good` (
  `good_id` int(100) NOT NULL COMMENT '商品编号id',
  `good_name` varchar(100) DEFAULT NULL COMMENT '商品名称',
  `good_num` int(100) DEFAULT NULL COMMENT '商品数量',
  `good_price` int(100) DEFAULT NULL COMMENT '商品价格',
  `good_type` varchar(100) DEFAULT NULL COMMENT '商品类别',
  PRIMARY KEY (`good_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_good
-- ----------------------------
INSERT INTO `t_good` VALUES ('111111', '面包', '100', '5', '零食');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` int(100) NOT NULL COMMENT '订单编号id',
  `good_id` int(100) DEFAULT NULL COMMENT '商品编号id',
  `order_money` int(100) DEFAULT NULL COMMENT '订单金额',
  `pay_state` int(100) DEFAULT NULL COMMENT '支付状态',
  `receiver_address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `receiver_name` varchar(100) DEFAULT NULL COMMENT '收货姓名',
  `receiver_phone` varchar(100) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '111111', '10', '1', '上海市徐汇区腾讯大厦', '曹', '13028193378');
