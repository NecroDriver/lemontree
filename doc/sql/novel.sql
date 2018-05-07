/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : lemontree

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 07/05/2018 09:39:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for novel
-- ----------------------------
DROP TABLE IF EXISTS `novel`;
CREATE TABLE `novel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `novelCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `novelName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `coverImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `flagDelete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除，0：否 1：是',
  `flagUpdate` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否更新,0:否 1:是',
  `flagEnd` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否完结,0:否 1:是',
  `createTime` datetime(0) NOT NULL,
  `creator` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creatorIP` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modifyTime` datetime(0) NOT NULL,
  `modifier` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modifierIP` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
