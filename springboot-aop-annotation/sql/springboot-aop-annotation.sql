/*
Navicat MySQL Data Transfer

Source Server         : 本地开发
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : springboot-aop-annotation

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-12-19 23:51:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` varchar(255) DEFAULT NULL COMMENT '订单id',
  `order_money` double(255,0) DEFAULT NULL COMMENT '订单金额',
  `receiver_address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `receiver_name` varchar(255) DEFAULT NULL COMMENT '收货姓名',
  `receiver_phone` varchar(255) DEFAULT NULL COMMENT '手机号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
