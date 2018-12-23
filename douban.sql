/*
 Navicat MySQL Data Transfer

 Source Server         : mysql连接
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : douban

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 23/12/2018 22:22:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for actor
-- ----------------------------
DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor`  (
  `actor_id` int(11) NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `actor_intro` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`actor_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of actor
-- ----------------------------
INSERT INTO `actor` VALUES (1, '日高法子', '日高のり子（旧姓伊东），日本著名');
INSERT INTO `actor` VALUES (2, '杰森·莫玛', '杰森·莫玛（Jason Momoa），美国演员，');
INSERT INTO `actor` VALUES (3, '肖央', '青年导演，很受业内人士肯定');

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `label_id` int(11) NOT NULL AUTO_INCREMENT,
  `label_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `label_num` int(11) NOT NULL,
  PRIMARY KEY (`label_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES (1, '喜剧', 1);
INSERT INTO `label` VALUES (2, '动画', 1);
INSERT INTO `label` VALUES (3, '超级英雄', 3);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_age` int(11) NOT NULL,
  `manager_phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_cardid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_code` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 'jhk', '8756', 45, '15501215488', 'jhk@qq.com', '8745', '5412');
INSERT INTO `manager` VALUES (2, 'kij', '7485', 54, '15501215233', 'kij@qq.com', '7452', '2145');
INSERT INTO `manager` VALUES (3, 'jnm', '7451', 25, '13745856521', 'jnm@qq.com', '7412', '3265');

-- ----------------------------
-- Table structure for movie_actor
-- ----------------------------
DROP TABLE IF EXISTS `movie_actor`;
CREATE TABLE `movie_actor`  (
  `movie_id` int(11) NOT NULL,
  `actor_id` int(11) NOT NULL,
  `actor_pro` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`movie_id`, `actor_id`) USING BTREE,
  INDEX `actor_idx`(`actor_id`) USING BTREE,
  CONSTRAINT `actor` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`actor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `mov_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`mov_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_actor
-- ----------------------------
INSERT INTO `movie_actor` VALUES (1, 2, '主演');
INSERT INTO `movie_actor` VALUES (2, 3, '主演');
INSERT INTO `movie_actor` VALUES (3, 1, '主演');

-- ----------------------------
-- Table structure for movie_label
-- ----------------------------
DROP TABLE IF EXISTS `movie_label`;
CREATE TABLE `movie_label`  (
  `mov_id` int(11) NOT NULL,
  `label_id` int(11) NOT NULL,
  PRIMARY KEY (`mov_id`, `label_id`) USING BTREE,
  INDEX `label_id_idx`(`label_id`) USING BTREE,
  CONSTRAINT `label_id` FOREIGN KEY (`label_id`) REFERENCES `label` (`label_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_label
-- ----------------------------
INSERT INTO `movie_label` VALUES (2, 1);
INSERT INTO `movie_label` VALUES (3, 2);
INSERT INTO `movie_label` VALUES (1, 3);

-- ----------------------------
-- Table structure for movie_star
-- ----------------------------
DROP TABLE IF EXISTS `movie_star`;
CREATE TABLE `movie_star`  (
  `movie_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `star` int(11) NOT NULL,
  PRIMARY KEY (`movie_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_star
-- ----------------------------
INSERT INTO `movie_star` VALUES (1, 1, 4);
INSERT INTO `movie_star` VALUES (2, 1, 5);

-- ----------------------------
-- Table structure for movies
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies`  (
  `mov_id` int(11) NOT NULL AUTO_INCREMENT,
  `mov_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mov_intro` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mov_time` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mov_cou` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mov_la` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mov_rel` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`mov_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movies
-- ----------------------------
INSERT INTO `movies` VALUES (1, '海王', '华纳兄弟影片公司与导演温', '143', '美国', '英语 ', '2018-12-07');
INSERT INTO `movies` VALUES (2, '天气预爆', '号称', '104', '中国', '汉语普通话', '2018-12-21');
INSERT INTO `movies` VALUES (3, '龙猫', '小月的母亲生病住院了', '86', '中国大陆', '日语', '2018-12-14');

-- ----------------------------
-- Table structure for movies_review
-- ----------------------------
DROP TABLE IF EXISTS `movies_review`;
CREATE TABLE `movies_review`  (
  `mov_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `mov_time` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mov_lik` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`mov_id`, `user_id`) USING BTREE,
  INDEX `user_id_idx`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movies_review
-- ----------------------------
INSERT INTO `movies_review` VALUES (1, 1, '2018-12-23', '20');
INSERT INTO `movies_review` VALUES (2, 1, '2018-12-23', '21');
INSERT INTO `movies_review` VALUES (3, 1, '2018-12-23', '41');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_sex` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_age` int(11) NOT NULL,
  `user_email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_cardid` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_code` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'hhh', '8754', '男', 19980415, 'hhh@qq.com', '7854', '5412');
INSERT INTO `users` VALUES (2, 'kkk', '8562', '女', 19970405, 'kkk@qq.com', '8547', '5241');
INSERT INTO `users` VALUES (3, 'lll', '8745', '男', 19970805, 'lll@qq.com', '8521', '3254');

SET FOREIGN_KEY_CHECKS = 1;
