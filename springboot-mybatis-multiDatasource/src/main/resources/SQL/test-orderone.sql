/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 127.0.0.1:3306
 Source Schema         : test-orderone

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 13/11/2020 17:47:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `oid` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pprice` double DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (1, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');
INSERT INTO `t_order` VALUES (2, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');
INSERT INTO `t_order` VALUES (3, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');
INSERT INTO `t_order` VALUES (4, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');
INSERT INTO `t_order` VALUES (5, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');
INSERT INTO `t_order` VALUES (6, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');
INSERT INTO `t_order` VALUES (7, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');
INSERT INTO `t_order` VALUES (8, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');
INSERT INTO `t_order` VALUES (9, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');
INSERT INTO `t_order` VALUES (10, 499, 105, '杨枝甘露', 8.8, 11, 'master管理员');

SET FOREIGN_KEY_CHECKS = 1;
