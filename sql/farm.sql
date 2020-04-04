/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : farm

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 24/03/2020 17:15:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply_record
-- ----------------------------
DROP TABLE IF EXISTS `apply_record`;
CREATE TABLE `apply_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '申请人ID',
  `user_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人姓名',
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人电话',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人地址',
  `amount` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请亩数',
  `apply_reason` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '申请理由',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '照片内容等，存json',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '申请状态  1审核中，2退回，3审核通过',
  `auth_id` int(11) NULL DEFAULT NULL COMMENT '审核人ID',
  `refuse_desc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '驳回理由',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '申请时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '申请记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `author_id` int(11) DEFAULT NULL COMMENT '作者ID',
  `type` tinyint(4) DEFAULT NULL COMMENT '文章类别 1、公告 2、栽培方法 3、病虫防治',
  `title` varchar(64) DEFAULT NULL COMMENT '文章标题',
  `cover_img` varchar(255) DEFAULT NULL COMMENT '封面缩略图',
  `content` text COMMENT '文章内容',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章、公告表';

-- ----------------------------
-- Table structure for business_sumup
-- ----------------------------
DROP TABLE IF EXISTS `business_sumup`;
CREATE TABLE `business_sumup`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author_id` int(11) NULL DEFAULT NULL COMMENT '作者id',
  `time` timestamp(0) NULL DEFAULT NULL COMMENT '下乡时间',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 1、发布，0、撤回',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '下乡总计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '评论人',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 1、有效，0、无效',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '评论时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for operation_record
-- ----------------------------
DROP TABLE IF EXISTS `operation_record`;
CREATE TABLE `operation_record`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '操作人',
  `describe` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '操作类型 1、施肥 2、打药 ',
  `used_aomut` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用量',
  `operation_time` timestamp(0) NULL DEFAULT NULL COMMENT '操作时间',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `describe` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户描述',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', '2020-03-23 18:11:08', '2020-03-23 18:11:08');
INSERT INTO `role` VALUES (2, '技术人员', '2020-03-23 18:11:15', '2020-03-23 18:11:15');
INSERT INTO `role` VALUES (3, '普通用户', '2020-03-23 18:11:22', '2020-03-23 18:11:22');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `phone` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `card_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证（忘记密码时使用）',
  `type` tinyint(4) NOT NULL DEFAULT 3 COMMENT '用户类型',
  `token` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会话信息',
  `token_expire_time` timestamp(0) NULL DEFAULT NULL COMMENT '会话过期时间',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '用户创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '超级管理员', '13786272773', 'e10adc3949ba59abbe56e057f20f883e', '12345678', 1, '186f9b23-7ba5-4a9e-b6e8-7fdbffe373a1', '2020-03-24 17:22:37', '2020-03-23 18:12:35', '2020-03-24 16:55:30');

-- ----------------------------
-- Table structure for user_collect
-- ----------------------------
DROP TABLE IF EXISTS `user_collect`;
CREATE TABLE `user_collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `article_id` int(11) NULL DEFAULT NULL COMMENT '文章ID',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 1、收藏  0、取消',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '收藏时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户收藏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_plant
-- ----------------------------
DROP TABLE IF EXISTS `user_plant`;
CREATE TABLE `user_plant`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `plant_time` datetime(0) NULL DEFAULT NULL COMMENT '种植时间',
  `plant_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '种植方式',
  `yield` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产量',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户种植记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `module_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块URL',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
