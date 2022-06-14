/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : geo_investigation

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 14/06/2022 22:31:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_authority
-- ----------------------------

-- ----------------------------
-- Table structure for t_disaster_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_disaster_attribute`;
CREATE TABLE `t_disaster_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `required` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disaster_attribute
-- ----------------------------
INSERT INTO `t_disaster_attribute` VALUES (1, '灾害发生地点', 'Disaster Place', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (2, '农场面积', 'farm size', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (3, '灾害发生面积', 'Disaster area', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (4, '正常产量', 'normal volume', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (8, '灾后产量', 'post-disaster', '无', 1, '2022-06-13 22:46:59', '2022-06-13 22:47:00');

-- ----------------------------
-- Table structure for t_disaster_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `t_disaster_attribute_value`;
CREATE TABLE `t_disaster_attribute_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_attr_id` bigint(20) NOT NULL,
  `value_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disaster_attribute_value
-- ----------------------------
INSERT INTO `t_disaster_attribute_value` VALUES (1, 8, '广东省', 'Guangdong Province', NULL, NULL);
INSERT INTO `t_disaster_attribute_value` VALUES (2, 9, '100', '100', NULL, NULL);
INSERT INTO `t_disaster_attribute_value` VALUES (3, 10, '40', '40', NULL, NULL);
INSERT INTO `t_disaster_attribute_value` VALUES (4, 8, '山东省', 'Shandong Province', NULL, NULL);
INSERT INTO `t_disaster_attribute_value` VALUES (5, 8, '福建省', 'FuJian Province', '2022-06-14 20:33:50', '2022-06-14 20:33:50');

-- ----------------------------
-- Table structure for t_disaster_type
-- ----------------------------
DROP TABLE IF EXISTS `t_disaster_type`;
CREATE TABLE `t_disaster_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disaster_type
-- ----------------------------
INSERT INTO `t_disaster_type` VALUES (1, '干旱', 'Droughts', '2022-06-13 15:26:18', NULL);
INSERT INTO `t_disaster_type` VALUES (2, '虫害', 'pestis', NULL, NULL);
INSERT INTO `t_disaster_type` VALUES (3, '洪涝', 'flood', '2022-06-13 18:46:32', '2022-06-13 18:46:32');

-- ----------------------------
-- Table structure for t_disaster_type_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_disaster_type_attribute`;
CREATE TABLE `t_disaster_type_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `disaster_id` bigint(20) NOT NULL,
  `disaster_attribute_id` bigint(20) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disaster_type_attribute
-- ----------------------------
INSERT INTO `t_disaster_type_attribute` VALUES (8, 1, 1, NULL, NULL);
INSERT INTO `t_disaster_type_attribute` VALUES (9, 1, 2, NULL, NULL);
INSERT INTO `t_disaster_type_attribute` VALUES (10, 1, 3, NULL, NULL);
INSERT INTO `t_disaster_type_attribute` VALUES (12, 1, 8, '2022-06-13 22:46:59', '2022-06-13 22:47:00');

-- ----------------------------
-- Table structure for t_land_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_land_attribute`;
CREATE TABLE `t_land_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `required` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_attribute
-- ----------------------------
INSERT INTO `t_land_attribute` VALUES (1, '森林起源类型', 'origin of forest', '无', 0, NULL, NULL);
INSERT INTO `t_land_attribute` VALUES (2, '森林用途', 'Forest use', '无', 1, NULL, NULL);
INSERT INTO `t_land_attribute` VALUES (4, '植被高度', 'vegetation height', '无', 1, '2022-06-13 22:12:48', '2022-06-13 22:12:49');
INSERT INTO `t_land_attribute` VALUES (5, '覆盖度', 'degree of coverage', '无', 1, '2022-06-13 22:22:05', '2022-06-13 22:22:05');

-- ----------------------------
-- Table structure for t_land_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `t_land_attribute_value`;
CREATE TABLE `t_land_attribute_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_attr_id` bigint(20) NOT NULL,
  `value_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_attribute_value
-- ----------------------------
INSERT INTO `t_land_attribute_value` VALUES (1, 6, '天然林', 'wildwood', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (2, 6, '次生林', 'secondary forest', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (5, 6, '人工林', 'artificial forest', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (6, 7, '用材林', 'timber forest', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (7, 8, '天然林', 'wildwood', '2022-06-13 17:23:50', '2022-06-13 17:23:50');

-- ----------------------------
-- Table structure for t_land_type
-- ----------------------------
DROP TABLE IF EXISTS `t_land_type`;
CREATE TABLE `t_land_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '简体中文名称',
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英文名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父类型id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_type
-- ----------------------------
INSERT INTO `t_land_type` VALUES (1, '林地', 'woodlands', NULL, NULL, NULL);
INSERT INTO `t_land_type` VALUES (2, '常绿阔叶林', 'Evergreen Broadleaved Forests', 1, NULL, NULL);
INSERT INTO `t_land_type` VALUES (3, '落叶阔叶林', 'Deciduous Broadleaved Forests', 1, NULL, NULL);
INSERT INTO `t_land_type` VALUES (4, '草地', 'grassland', NULL, NULL, NULL);
INSERT INTO `t_land_type` VALUES (5, '温性草甸草原', 'Warm meadow', 4, NULL, NULL);
INSERT INTO `t_land_type` VALUES (6, '常绿针叶林', 'evergreen needle-leaved forest', NULL, '2022-06-13 10:54:48', '2022-06-13 10:54:48');

-- ----------------------------
-- Table structure for t_land_type_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_land_type_attribute`;
CREATE TABLE `t_land_type_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `land_type_id` bigint(20) NOT NULL,
  `land_attribute_id` bigint(20) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_type_attribute
-- ----------------------------
INSERT INTO `t_land_type_attribute` VALUES (6, 2, 1, NULL, NULL);
INSERT INTO `t_land_type_attribute` VALUES (7, 2, 2, NULL, NULL);
INSERT INTO `t_land_type_attribute` VALUES (9, 2, 4, NULL, NULL);
INSERT INTO `t_land_type_attribute` VALUES (10, 2, 5, '2022-06-13 22:22:05', '2022-06-13 22:22:05');

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `land_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `disaster_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` datetime NULL DEFAULT NULL,
  `end_time` datetime NULL DEFAULT NULL,
  `latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员', 'administrator', NULL, NULL);

-- ----------------------------
-- Table structure for t_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_role_authority`;
CREATE TABLE `t_role_authority`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) NOT NULL,
  `authorityId` bigint(20) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_authority
-- ----------------------------
INSERT INTO `t_role_authority` VALUES (1, 1, 1, NULL, NULL);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
