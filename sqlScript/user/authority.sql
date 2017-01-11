/*
Navicat MySQL Data Transfer

Source Server         : mydatabase
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-01-11 04:05:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `authorityId` varchar(36) NOT NULL COMMENT '权限Id',
  `authorityName` varchar(125) DEFAULT NULL COMMENT '权限名称',
  `authorityCode` varchar(36) DEFAULT NULL COMMENT '权限码',
  `effective` tinyint(2) DEFAULT NULL COMMENT '是否生效',
  `dateAdded` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '添加日期',
  `lastModified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
