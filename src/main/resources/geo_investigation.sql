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

 Date: 19/07/2022 11:22:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_disaster_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_disaster_attribute`;
CREATE TABLE `t_disaster_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `disaster_type_id` bigint(20) NULL DEFAULT NULL,
  `name_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `required` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_disaster_attribute
-- ----------------------------
INSERT INTO `t_disaster_attribute` VALUES (1, 1, '灾害发生地点', 'Disaster Place', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (2, 1, '农场面积', 'farm size', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (3, 1, '灾害发生面积', 'Disaster area', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (4, 1, '正常产量', 'normal volume', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (8, 1, '灾后产量', 'post-disaster', '无', 1, '2022-06-13 22:46:59', '2022-06-13 22:47:00');
INSERT INTO `t_disaster_attribute` VALUES (9, 2, '灾害发生地点', 'Disaster Place', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (10, 2, '农场面积', 'farm size', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (11, 2, '灾害发生面积', 'Disaster area', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (12, 2, '正常产量', 'normal volume', '无', 1, NULL, NULL);
INSERT INTO `t_disaster_attribute` VALUES (13, 2, '灾后产量', 'post-disaster', '无', 1, '2022-06-13 22:46:59', '2022-06-13 22:47:00');

-- ----------------------------
-- Table structure for t_disaster_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `t_disaster_attribute_value`;
CREATE TABLE `t_disaster_attribute_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `disaster_attr_id` bigint(20) NOT NULL,
  `value_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_disaster_attribute_value
-- ----------------------------
INSERT INTO `t_disaster_attribute_value` VALUES (6, 1, '广东深圳', 'shenzhen', NULL, NULL);
INSERT INTO `t_disaster_attribute_value` VALUES (7, 2, '1000', '1000', NULL, NULL);
INSERT INTO `t_disaster_attribute_value` VALUES (8, 4, '500', '500', NULL, NULL);
INSERT INTO `t_disaster_attribute_value` VALUES (9, 8, '200', '200', NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_disaster_type
-- ----------------------------
INSERT INTO `t_disaster_type` VALUES (1, '干旱', 'Droughts', '2022-06-13 15:26:18', NULL);
INSERT INTO `t_disaster_type` VALUES (2, '虫害', 'pestis', NULL, NULL);
INSERT INTO `t_disaster_type` VALUES (3, '洪涝', 'flood', '2022-06-13 18:46:32', '2022-06-13 18:46:32');

-- ----------------------------
-- Table structure for t_disease_data_coll_nav
-- ----------------------------
DROP TABLE IF EXISTS `t_disease_data_coll_nav`;
CREATE TABLE `t_disease_data_coll_nav`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL COMMENT '样地的id',
  `disease_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病害类型',
  `survey_leaves` int(11) NULL DEFAULT NULL COMMENT '调查总叶片数',
  `diseased_leaves` int(11) NULL DEFAULT NULL COMMENT '病害叶片数',
  `site_canopy_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样点冠层图片地址',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disease_data_coll_nav
-- ----------------------------
INSERT INTO `t_disease_data_coll_nav` VALUES (1, 1, '干旱', 500, 40, NULL, '2022-07-18 15:19:30', '2022-07-18 15:20:38');

-- ----------------------------
-- Table structure for t_disease_sample_coll
-- ----------------------------
DROP TABLE IF EXISTS `t_disease_sample_coll`;
CREATE TABLE `t_disease_sample_coll`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL COMMENT '样地的id',
  `disease_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病害类型',
  `survey_leaves` int(11) NULL DEFAULT NULL COMMENT '调查叶片的数量',
  `diseased_leaves` int(11) NULL DEFAULT NULL COMMENT '病叶数量',
  `quadrat_canopy_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样方冠层照片',
  `quadrat_leaves_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样方叶片照片',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disease_sample_coll
-- ----------------------------
INSERT INTO `t_disease_sample_coll` VALUES (1, 1, '干旱', 500, 40, NULL, NULL, '2022-07-18 09:58:59', '2022-07-18 15:14:03');

-- ----------------------------
-- Table structure for t_disease_sys_survey
-- ----------------------------
DROP TABLE IF EXISTS `t_disease_sys_survey`;
CREATE TABLE `t_disease_sys_survey`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL,
  `disease_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `survey_leaves` int(11) NULL DEFAULT NULL,
  `diseased_leaves` int(11) NULL DEFAULT NULL,
  `quadrat_canopy_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `quadrat_leaves_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_disease_sys_survey
-- ----------------------------
INSERT INTO `t_disease_sys_survey` VALUES (1, 1, '干旱', 500, 40, NULL, NULL, '2022-07-18 15:15:18', '2022-07-18 15:18:32');

-- ----------------------------
-- Table structure for t_environment_factor
-- ----------------------------
DROP TABLE IF EXISTS `t_environment_factor`;
CREATE TABLE `t_environment_factor`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL,
  `soil_moisture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '土壤湿度',
  `soil_temp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '土壤温度',
  `air_moisture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '空气湿度',
  `air_temp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '空气温度',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_environment_factor
-- ----------------------------
INSERT INTO `t_environment_factor` VALUES (1, 1, '20', '30', '29', '39', '2022-07-19 11:05:02', '2022-07-19 11:05:02');

-- ----------------------------
-- Table structure for t_land_attribute
-- ----------------------------
DROP TABLE IF EXISTS `t_land_attribute`;
CREATE TABLE `t_land_attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `land_type_id` bigint(20) NOT NULL,
  `name_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `required` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_attribute
-- ----------------------------
INSERT INTO `t_land_attribute` VALUES (1, 2, '森林起源类型', 'origin of forest', '无', 0, NULL, NULL);
INSERT INTO `t_land_attribute` VALUES (2, 2, '森林用途', 'Forest use', '无', 1, NULL, NULL);
INSERT INTO `t_land_attribute` VALUES (4, 2, '植被高度', 'vegetation height', '无', 1, '2022-06-13 22:12:48', '2022-06-13 22:12:49');
INSERT INTO `t_land_attribute` VALUES (5, 3, '覆盖度', 'degree of coverage', '无', 1, '2022-06-13 22:22:05', '2022-06-13 22:22:05');
INSERT INTO `t_land_attribute` VALUES (6, 3, '植被层次性', NULL, '无', 1, NULL, NULL);
INSERT INTO `t_land_attribute` VALUES (7, 3, '森林起源类型', 'origin of forest', '无', 0, NULL, NULL);
INSERT INTO `t_land_attribute` VALUES (8, 3, '森林用途', 'Forest use', '无', 1, NULL, NULL);
INSERT INTO `t_land_attribute` VALUES (9, 3, '植被高度', 'vegetation height', '无', 1, '2022-06-13 22:12:48', '2022-06-13 22:12:49');

-- ----------------------------
-- Table structure for t_land_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `t_land_attribute_value`;
CREATE TABLE `t_land_attribute_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `land_attr_id` bigint(20) NOT NULL,
  `value_chs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_attribute_value
-- ----------------------------
INSERT INTO `t_land_attribute_value` VALUES (1, 1, '天然林', 'wildwood', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (2, 1, '次生林', 'secondary forest', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (5, 1, '人工林', 'artificial forest', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (6, 2, '用材林', 'timber forest', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (7, 7, '天然林', 'wildwood', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (8, 7, '次生林', 'secondary forest', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (9, 7, '人工林', 'artificial forest', NULL, NULL);
INSERT INTO `t_land_attribute_value` VALUES (10, 2, '薪炭林', 'tallwood', NULL, NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_land_type
-- ----------------------------
INSERT INTO `t_land_type` VALUES (1, '林地', 'woodlands', NULL, NULL, NULL);
INSERT INTO `t_land_type` VALUES (2, '常绿阔叶林', 'Evergreen Broadleaved Forests', 1, NULL, NULL);
INSERT INTO `t_land_type` VALUES (3, '落叶阔叶林', 'Deciduous Broadleaved Forests', 1, NULL, NULL);
INSERT INTO `t_land_type` VALUES (4, '草地', 'grassland', NULL, NULL, NULL);
INSERT INTO `t_land_type` VALUES (5, '温性草甸草原', 'Warm meadow', 4, NULL, NULL);
INSERT INTO `t_land_type` VALUES (8, '竹林', 'bamboo forest', 1, '2022-07-08 11:46:51', '2022-07-08 11:46:51');
INSERT INTO `t_land_type` VALUES (9, '稀疏林', 'Sparse forest', 1, '2022-07-08 11:51:23', '2022-07-08 11:51:23');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, 'getLandType', '获取土地类型', '', NULL, NULL);
INSERT INTO `t_permission` VALUES (3, 'getLandAttribute', '获取土地属性及属性值', '', NULL, NULL);
INSERT INTO `t_permission` VALUES (4, 'addLandType', '添加土地类型', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (5, 'addLandAttribute', '添加土地属性', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (6, 'addLandAttrValue', '添加土地属性值', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (7, 'getDisasterType', '获取灾害类型', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (8, 'getDisasterAttribute', '获取灾害属性及属性值', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (9, 'addDisasterAttribute', '添加灾害属性', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (10, 'addDisasterAttrValue', '添加灾害属性值', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (11, 'uploadFile', '上传图片', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (12, 'addRecord', '添加记录', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (13, 'getRecords', '查询记录', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (14, 'updateLandType', '修改土地类型', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (15, 'deleteLandType', '删除土地类型', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (16, 'updateLandAttr', '修改土地属性', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (17, 'updateLandAttrValue', '修改土地属性值', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (18, 'deleteLandAttr', '删除土地属性', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (19, 'deleteLandAttrValue', '删除土地属性值', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (20, 'updateDisasterType', '修改灾害类型', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (21, 'updateDisasterAttribute', '修改灾害属性', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (22, 'updateDisasterAttrValue', '修改灾害属性值', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (23, 'deleteDisasterType', '删除灾害类型', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (24, 'deleteDisasterAttribute', '删除灾害属性', NULL, NULL, NULL);
INSERT INTO `t_permission` VALUES (25, 'deleteDisasterAttrValue', '删除灾害属性值', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_pest_collection
-- ----------------------------
DROP TABLE IF EXISTS `t_pest_collection`;
CREATE TABLE `t_pest_collection`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL,
  `pest_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '虫害类型',
  `quadrat_canopy_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样方冠层图片地址',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_pest_collection
-- ----------------------------
INSERT INTO `t_pest_collection` VALUES (1, 1, '蚜虫', NULL, '2022-07-18 15:21:43', '2022-07-18 15:23:10');

-- ----------------------------
-- Table structure for t_pest_img
-- ----------------------------
DROP TABLE IF EXISTS `t_pest_img`;
CREATE TABLE `t_pest_img`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pest_coll_record_id` bigint(20) NOT NULL COMMENT '虫害采集表记录的id',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样方叶片的图片地址',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_pest_img
-- ----------------------------
INSERT INTO `t_pest_img` VALUES (1, 1, 'tupiandizhi', '2022-07-18 15:25:35', '2022-07-18 15:25:35');

-- ----------------------------
-- Table structure for t_pest_survey_uav
-- ----------------------------
DROP TABLE IF EXISTS `t_pest_survey_uav`;
CREATE TABLE `t_pest_survey_uav`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL,
  `pest_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '虫害类型',
  `quadrat_canopy_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样方冠层图片地址',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_pest_survey_uav
-- ----------------------------
INSERT INTO `t_pest_survey_uav` VALUES (1, 1, '蚜虫', NULL, '2022-07-18 15:26:57', '2022-07-18 15:30:01');

-- ----------------------------
-- Table structure for t_pest_uav_img
-- ----------------------------
DROP TABLE IF EXISTS `t_pest_uav_img`;
CREATE TABLE `t_pest_uav_img`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pest_survey_uav_record_id` bigint(20) NOT NULL COMMENT '虫害采集表记录的id',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样方叶片的图片地址',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_pest_uav_img
-- ----------------------------

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `latitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '纬度',
  `longitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '经度',
  `survey_time` datetime NULL DEFAULT NULL COMMENT '调查时间',
  `land_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '土地类型信息',
  `crop_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作物类型',
  `crop_variety` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作物品种',
  `sp_canopy_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样地冠层图片地址',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_record
-- ----------------------------
INSERT INTO `t_record` VALUES (1, 3, 30.000000, 42.500000, NULL, NULL, '小麦', NULL, NULL, NULL, '2022-07-18 09:44:23', '2022-07-18 09:55:20');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'administrator', '管理员', NULL, NULL);
INSERT INTO `t_role` VALUES (2, 'user', '普通用户', NULL, NULL);

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (1, 1, 1, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (3, 1, 3, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (4, 1, 4, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (5, 1, 5, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (6, 1, 6, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (7, 1, 7, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (8, 1, 8, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (9, 1, 9, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (10, 1, 10, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (11, 1, 11, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (12, 1, 12, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (13, 1, 13, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (14, 1, 14, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (15, 1, 15, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (16, 1, 16, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (17, 1, 17, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (18, 1, 18, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (19, 1, 19, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (20, 1, 20, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (21, 1, 21, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (22, 1, 22, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (23, 1, 23, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (24, 1, 24, NULL, NULL);
INSERT INTO `t_role_permission` VALUES (25, 1, 25, NULL, NULL);

-- ----------------------------
-- Table structure for t_soil_moisture_coll
-- ----------------------------
DROP TABLE IF EXISTS `t_soil_moisture_coll`;
CREATE TABLE `t_soil_moisture_coll`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL COMMENT '样地的id',
  `site_id` bigint(20) NOT NULL COMMENT '样点的id',
  `soil_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '土壤的类型',
  `depth_10` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '10cm的土壤深度',
  `depth_20` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '20cm的土壤深度',
  `depth_30` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '30cm的土壤深度',
  `air_temp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '空气温度',
  `air_moisture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '空气湿度',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_soil_moisture_coll
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (3, 'chenhongrong', '18144636372', 'chenhongrong@163.com', '$2a$10$6p6B3YUM3/t7JWdS3dRBSuLd3TkBVXxfaIN/xbPJK/BEXMHn0zeWG', '2022-06-30 16:26:01', '2022-06-30 16:26:01');
INSERT INTO `t_user` VALUES (4, 'hongrong', '18144636372', 'chenhongrong@163.com', '$2a$10$ZpJStVV/Uy8MLFwRYXXu7eFi5ctMuwDxz7QvjCSG5KpLyyhJprVWO', '2022-07-06 10:12:20', '2022-07-06 10:12:20');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 3, 1, NULL, NULL);
INSERT INTO `t_user_role` VALUES (2, 4, 1, NULL, NULL);

-- ----------------------------
-- Table structure for t_wheat_yield_coll
-- ----------------------------
DROP TABLE IF EXISTS `t_wheat_yield_coll`;
CREATE TABLE `t_wheat_yield_coll`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `record_id` bigint(20) NOT NULL COMMENT '样地的id',
  `site_id` bigint(20) NOT NULL COMMENT '样点的id',
  `wheat_seed_weight` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '麦籽的重量',
  `disaster_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '灾害类型',
  `solution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '防治措施',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_wheat_yield_coll
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
