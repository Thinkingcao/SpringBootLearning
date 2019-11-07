/*
Navicat MySQL Data Transfer

Source Server         : 自己的
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : springboot-mybatis-plus

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-08-22 10:22:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '城市名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES ('1035761969176342529', '北京');
INSERT INTO `t_city` VALUES ('1035762001753501698', '成都');
INSERT INTO `t_city` VALUES ('1035765839768121346', '上海');
INSERT INTO `t_city` VALUES ('1035765875767832578', '深圳');
INSERT INTO `t_city` VALUES ('1035788325201117185', '1');

-- ----------------------------
-- Table structure for t_idcard
-- ----------------------------
DROP TABLE IF EXISTS `t_idcard`;
CREATE TABLE `t_idcard` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `code` varchar(20) DEFAULT NULL COMMENT '身份证号码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_idcard
-- ----------------------------
INSERT INTO `t_idcard` VALUES ('1035788325276614657', '1');
INSERT INTO `t_idcard` VALUES ('1035789714388168706', '123456789012345678');
SET FOREIGN_KEY_CHECKS=1;
