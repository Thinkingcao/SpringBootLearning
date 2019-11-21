/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : 127.0.0.1:3306
Source Database       : mybatis-xml

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-11-20 13:44:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT '主键Id',
  `name` varchar(200) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(200) DEFAULT NULL COMMENT '性别',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `qq` varchar(100) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '曹某人', '男', '22', '上海', '617271939', '617271839@qq.com');
INSERT INTO `user` VALUES ('2', '曹文哒哒哒哒哒', '女', '100', '上海', '129900555', '129900555@qq.com');
INSERT INTO `user` VALUES ('3', '曹曹', '男', '24', '上海', '289087899', '289087899@qq.com');
INSERT INTO `user` VALUES ('6', '李四', 'option1', '27', '上海市徐汇区徐家汇街道', '78945248', '78945248@qq.com');
INSERT INTO `user` VALUES ('8', '张三', 'option2', '25', '上海市徐汇区徐家汇', '137982901', '137982901@qq.com');
SET FOREIGN_KEY_CHECKS=1;
