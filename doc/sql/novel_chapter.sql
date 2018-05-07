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

 Date: 07/05/2018 09:39:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for novel_chapter
-- ----------------------------
DROP TABLE IF EXISTS `novel_chapter`;
CREATE TABLE `novel_chapter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `novelCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `chapterName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `dispOrder` int(11) NULL DEFAULT NULL,
  `createTime` datetime(0) NOT NULL,
  `creator` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creatorIP` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modifyTime` datetime(0) NOT NULL,
  `modifier` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modifierIP` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `novelCode`(`novelCode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11437 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
