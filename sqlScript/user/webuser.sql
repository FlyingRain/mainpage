/*
Navicat MySQL Data Transfer

Source Server         : mydatabase
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-01-11 05:07:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for webuser
-- ----------------------------
DROP TABLE IF EXISTS `webuser`;
CREATE TABLE `webuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` varchar(36) CHARACTER SET utf8 NOT NULL COMMENT '用户Id',
  `userName` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
  `gender` tinyint(2) NOT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
  `bankAccount` varchar(36) DEFAULT NULL,
  `idCard` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话',
  `img` blob COMMENT '头像',
  `password` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  `extension` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '扩展字段',
  `dateAdded` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加日期',
  `lastModified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
SET FOREIGN_KEY_CHECKS=1;
