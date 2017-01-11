/*
Navicat MySQL Data Transfer

Source Server         : mydatabase
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-01-11 04:05:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` varchar(36) NOT NULL COMMENT '角色Id',
  `roleName` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `authoritied` varchar(255) DEFAULT NULL COMMENT '拥有的权限',
  `dateAdded` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加日期',
  `lastModified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
SET FOREIGN_KEY_CHECKS=1;
