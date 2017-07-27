/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : wefun

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-07-10 17:47:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '首页', '1', '0', '1', '1', '2017-07-03 10:42:24', '2017-07-03 10:42:24');
INSERT INTO `category` VALUES ('2', '文化创意', '1', '0', '6', '2', '2017-07-03 11:00:58', '2017-07-03 11:00:58');
INSERT INTO `category` VALUES ('3', '品牌推广', '1', '0', '6', '3', '2017-07-03 11:01:15', '2017-07-03 11:01:15');
INSERT INTO `category` VALUES ('4', '定制礼典', '1', '0', '6', '3', '2017-07-03 11:01:35', '2017-07-03 11:01:35');
INSERT INTO `category` VALUES ('5', '首页滚动', '2', '1', '2', '1', '2017-07-03 14:30:52', '2017-07-03 14:30:54');

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content
-- ----------------------------

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `wechat` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `qrCodeWechat` varchar(255) DEFAULT NULL,
  `qrCodeQQ` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES ('1', '武成大街2号莱茵春天1709', '3258613042@qq.com', '028-86612315', '国儒雅风(公众号)', '3258613042', '', '', '2017-07-03 13:55:35', '2017-07-04 15:33:42');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `order` varchar(255) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `contentId` int(11) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', 'http://guoruyafeng.oss-cn-shenzhen.aliyuncs.com/image/monCulture.jpg', '1', '1', '5', null, '中国母亲文化暨华服文化国际交流会', '2017-07-06 10:28:39', '2017-07-06 10:28:41');
INSERT INTO `resource` VALUES ('2', 'http://guoruyafeng.oss-cn-shenzhen.aliyuncs.com/image/monCultureCommunicate.jpg', '1', '2', '5', null, null, '2017-07-06 10:28:39', '2017-07-06 10:28:39');
INSERT INTO `resource` VALUES ('3', null, '1', '3', '5', null, null, '2017-07-06 10:28:39', '2017-07-06 10:28:39');
INSERT INTO `resource` VALUES ('4', null, '1', '4', '5', null, null, '2017-07-06 10:28:39', '2017-07-06 10:28:39');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `realName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '123456', '超级管理员');
