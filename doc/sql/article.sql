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

 Date: 07/05/2018 09:39:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文章名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'url地址',
  `stage` int(11) NOT NULL COMMENT '属于哪一期',
  `collections` int(11) NOT NULL DEFAULT 0 COMMENT '收藏数',
  `views` int(11) NOT NULL DEFAULT 0 COMMENT '浏览量',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属知识库类别',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别图片地址',
  `createTime` datetime(0) NOT NULL,
  `creator` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creatorIP` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modifyTime` datetime(0) NOT NULL,
  `modifier` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `modifierIP` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 111 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
