/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-11-23 02:00:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_resource
-- ----------------------------
DROP TABLE IF EXISTS `tb_resource`;
CREATE TABLE `tb_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `resourceType` int(10) unsigned DEFAULT '1' COMMENT '资源类型，1：育儿，2：传统，3：艺术',
  `type` int(10) unsigned DEFAULT '1' COMMENT ' 1：视频。2：文章',
  `content` varchar(255) DEFAULT '' COMMENT '内容',
  `title` varchar(255) DEFAULT '' COMMENT '标题',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `statue` int(255) DEFAULT '1' COMMENT '审核状态，1：审核，2：启用，3：禁用',
  `imgUrl` varchar(255) DEFAULT NULL,
  `createTime` bigint(20) DEFAULT NULL,
  `updateTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_resource
-- ----------------------------

-- ----------------------------
-- Table structure for tb_resource_data
-- ----------------------------
DROP TABLE IF EXISTS `tb_resource_data`;
CREATE TABLE `tb_resource_data` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `resourceId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `readSum` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_resource_data
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(255) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL COMMENT '幼童：type = 1，家长：type = 2，老师：type = 3',
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `loginName` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `grade` int(255) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `index` (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
