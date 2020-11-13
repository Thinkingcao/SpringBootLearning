/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 127.0.0.1:3306
 Source Schema         : test-ordertwo

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 13/11/2020 17:47:20
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
INSERT INTO `t_order` VALUES (1, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');
INSERT INTO `t_order` VALUES (2, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');
INSERT INTO `t_order` VALUES (3, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');
INSERT INTO `t_order` VALUES (4, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');
INSERT INTO `t_order` VALUES (5, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');
INSERT INTO `t_order` VALUES (6, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');
INSERT INTO `t_order` VALUES (7, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');
INSERT INTO `t_order` VALUES (8, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');
INSERT INTO `t_order` VALUES (9, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');
INSERT INTO `t_order` VALUES (10, 200, 105, '卡布奇诺', 38, 11, 'slave测试员');

SET FOREIGN_KEY_CHECKS = 1;
