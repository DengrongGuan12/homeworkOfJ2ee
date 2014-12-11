/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50157
Source Host           : localhost:3306
Source Database       : javaee

Target Server Type    : MYSQL
Target Server Version : 50157
File Encoding         : 65001

Date: 2014-12-11 22:39:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `name` varchar(128) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('course1', '1');
INSERT INTO `course` VALUES ('course2', '2');
INSERT INTO `course` VALUES ('course3', '3');
INSERT INTO `course` VALUES ('course4', '4');
INSERT INTO `course` VALUES ('course5', '5');
INSERT INTO `course` VALUES ('course6', '6');
INSERT INTO `course` VALUES ('course7', '7');

-- ----------------------------
-- Table structure for `news_inf`
-- ----------------------------
DROP TABLE IF EXISTS `news_inf`;
CREATE TABLE `news_inf` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news_inf
-- ----------------------------
INSERT INTO `news_inf` VALUES ('1', '疯狂Java联盟');
INSERT INTO `news_inf` VALUES ('2', 'crazyit.org');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `course_id` int(11) NOT NULL,
  `stu_name` varchar(128) NOT NULL,
  `grade` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', 'gdr', '49');
INSERT INTO `record` VALUES ('2', 'gdr', '59');
INSERT INTO `record` VALUES ('3', 'gdr', '69');
INSERT INTO `record` VALUES ('4', 'gdr', '79');
INSERT INTO `record` VALUES ('5', 'gdr', '89');
INSERT INTO `record` VALUES ('6', 'gbc', '79');
INSERT INTO `record` VALUES ('7', 'gbc', '79');
INSERT INTO `record` VALUES ('1', 'gbc', '78');
INSERT INTO `record` VALUES ('2', 'gbc', '88');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `name` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('gbc', '123456');
INSERT INTO `student` VALUES ('gdr', '123456');
