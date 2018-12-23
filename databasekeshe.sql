/*
 Navicat MySQL Data Transfer

 Source Server         : mysql连接
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : databasekeshe

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 23/12/2018 14:25:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_student
-- ----------------------------
DROP TABLE IF EXISTS `app_student`;
CREATE TABLE `app_student`  (
  `app_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `app_date` date NOT NULL,
  PRIMARY KEY (`app_student_id`) USING BTREE,
  INDEX `FK_app_stu_id`(`stu_id`) USING BTREE,
  INDEX `FK_app_book_id`(`book_id`) USING BTREE,
  CONSTRAINT `FK_app_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_app_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_student
-- ----------------------------
INSERT INTO `app_student` VALUES (1, 1, 1, '2018-12-24');
INSERT INTO `app_student` VALUES (2, 2, 2, '2018-12-24');
INSERT INTO `app_student` VALUES (3, 3, 3, '2017-05-06');

-- ----------------------------
-- Table structure for app_teacher
-- ----------------------------
DROP TABLE IF EXISTS `app_teacher`;
CREATE TABLE `app_teacher`  (
  `app_teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `app_date` date NOT NULL,
  PRIMARY KEY (`app_teacher_id`) USING BTREE,
  INDEX `FK_app_tea_id`(`tea_id`) USING BTREE,
  INDEX `FK_app_tbook_id`(`book_id`) USING BTREE,
  CONSTRAINT `FK_app_tbook_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_app_tea_id` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app_teacher
-- ----------------------------
INSERT INTO `app_teacher` VALUES (1, 2, 3, '2018-12-24');
INSERT INTO `app_teacher` VALUES (2, 1, 2, '2018-12-24');
INSERT INTO `app_teacher` VALUES (3, 3, 1, '2017-06-04');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `book_addr` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_ok` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_health` int(11) NOT NULL,
  `book_record` date NULL DEFAULT NULL,
  `book_borrow_times` int(11) NOT NULL,
  `book_price` double NULL DEFAULT NULL,
  `book_sort` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_aut` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `book_state` int(11) NOT NULL,
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '代码大全第二版', '第2版的《代码大全》是著名IT畅销书作者史蒂夫·迈克康奈尔11年前的经典著作的全新演绎：第2版不是第一版的简单修订增补，而是完全进行了重写；增加了很多与时俱进的内容。这也是一本完整的软件构建手册，涵盖了软件构建过程中的所有细节。它从软件质量和编程思想等方面论述了软件构建的各个问题，并详细论述了紧跟潮流的新技术、高屋建瓴的观点、通用的概念，还含有丰富而典型的程序示例。这本书中所论述的技术不仅填补了初级与高级编程技术之间的空白，而且也为程序员们提供了一个有关编程技巧的信息来源。这本书对经验丰富的程序员、技术带头人、自学的程序员及几乎不懂太多编程技巧的学生们都是大有裨益的。可以说，无论是什么背景的读者，阅读这本书都有助于在更短的时间内、更容易地写出更好的程序。', 'ROOM 101', '电子工业出版社', 1, '2000-12-21', 3, 29, '编程', 'Jon Bentley', 2);
INSERT INTO `book` VALUES (2, '黑客与画家', '本书是硅谷创业之父Paul Graham 的文集，主要介绍黑客即优秀程序员的爱好和动机，讨论黑客成长、黑客对世界的贡献以及编程语言和黑客工作方法等所有对计算机时代感兴趣的人的一些话题。书中的内容不但有助于了解计算机编程的本质、互联网行业的规则，还会帮助读者了解我们这个时代，迫使读者独立思考。\r\n\r\n本书适合所有程序员和互联网创业者，也适合一切对计算机行业感兴趣的读者。', 'ROOM 102', '人民邮电出版社', 1, '2000-08-03', 4, 85, '编程', '无名氏', 1);
INSERT INTO `book` VALUES (3, '编程珠玑 : 第2版', '本书是计算机科学方面的经典名著。书的内容围绕程序设计人员面对的一系列实际问题展开。作者Jon Bentley 以其独有的洞察力和创造力，引导读者理解这些问题并学会解决方法，而这些正是程序员实际编程生涯中至关重要的。本书的特色是通过一些精心设计的有趣而又颇具指导意义的程序，对实用程序设计技巧及基本设计原则进行了透彻而睿智的描述，为复杂的编程问题提供了清晰而完备的解决思路。本书对各个层次的程序员都具有很高的阅读价值。.\r\n\r\n多年以来，当程序员们推选出最心爱的计算机图书时，《编程珠玑》总是位列前列。正如自然界里珍珠出自细沙对牡蛎的磨砺，计算机科学大师Jon Bentley以其独有的洞察力和创造力，从磨砺程序员的实际问题中凝结出一篇篇不朽的编程“珠玑”，成为世界计算机界名刊《ACM通讯》历史上最受欢迎的专栏，最终结集为两部不朽的计算机科学经典名著，影响和激励着一代又一代程序员和计算机科学工作者。本书为第一卷，主要讨论计算机科学中最本质的问题：如何正确选择和高效地实现算法。', 'ROOM 103', '人民邮电出版社', 1, '2000-08-07', 5, 75, '编程', 'Jon Bentley', 2);

-- ----------------------------
-- Table structure for borrow_student
-- ----------------------------
DROP TABLE IF EXISTS `borrow_student`;
CREATE TABLE `borrow_student`  (
  `borrow_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `borrow_date` date NOT NULL,
  `exp_return_date` date NOT NULL,
  PRIMARY KEY (`borrow_student_id`) USING BTREE,
  INDEX `FK_bor_stu_id`(`stu_id`) USING BTREE,
  INDEX `FK_bor_book_id`(`book_id`) USING BTREE,
  CONSTRAINT `FK_bor_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_bor_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow_student
-- ----------------------------
INSERT INTO `borrow_student` VALUES (1, 1, 1, '2017-12-04', '2017-12-24');
INSERT INTO `borrow_student` VALUES (2, 2, 2, '2017-12-04', '2017-12-24');
INSERT INTO `borrow_student` VALUES (3, 3, 3, '2017-12-04', '2017-12-24');

-- ----------------------------
-- Table structure for borrow_teacher
-- ----------------------------
DROP TABLE IF EXISTS `borrow_teacher`;
CREATE TABLE `borrow_teacher`  (
  `borrow_teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `borrow_date` date NOT NULL,
  `exp_return_date` date NOT NULL,
  PRIMARY KEY (`borrow_teacher_id`) USING BTREE,
  INDEX `FK_bor_tea_id`(`tea_id`) USING BTREE,
  INDEX `FK_bor_tbook_id`(`book_id`) USING BTREE,
  CONSTRAINT `FK_bor_tbook_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_bor_tea_id` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow_teacher
-- ----------------------------
INSERT INTO `borrow_teacher` VALUES (1, 1, 1, '2017-01-04', '2017-01-24');
INSERT INTO `borrow_teacher` VALUES (2, 2, 2, '2017-01-04', '2017-01-24');
INSERT INTO `borrow_teacher` VALUES (3, 3, 3, '2017-01-04', '2017-12-24');

-- ----------------------------
-- Table structure for col_student
-- ----------------------------
DROP TABLE IF EXISTS `col_student`;
CREATE TABLE `col_student`  (
  `col_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `col_date` date NOT NULL,
  `col_instr` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`col_student_id`) USING BTREE,
  INDEX `FK_col_stu_id`(`stu_id`) USING BTREE,
  INDEX `FK_col_book_id`(`book_id`) USING BTREE,
  CONSTRAINT `FK_col_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_col_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of col_student
-- ----------------------------
INSERT INTO `col_student` VALUES (1, 1, 2, '2016-12-04', '很好');
INSERT INTO `col_student` VALUES (2, 2, 1, '2016-12-04', '不错');
INSERT INTO `col_student` VALUES (3, 3, 3, '2016-12-04', '我想要');

-- ----------------------------
-- Table structure for col_teacher
-- ----------------------------
DROP TABLE IF EXISTS `col_teacher`;
CREATE TABLE `col_teacher`  (
  `col_teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `col_date` date NOT NULL,
  `col_instr` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`col_teacher_id`) USING BTREE,
  INDEX `FK_col_tea_id`(`tea_id`) USING BTREE,
  INDEX `FK_col_tbook_id`(`book_id`) USING BTREE,
  CONSTRAINT `FK_col_tbook_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_col_tea_id` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of col_teacher
-- ----------------------------
INSERT INTO `col_teacher` VALUES (1, 1, 2, '2016-12-04', '很好');
INSERT INTO `col_teacher` VALUES (2, 2, 1, '2016-12-04', '不错');
INSERT INTO `col_teacher` VALUES (3, 3, 3, '2016-12-04', '我想要');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_age` int(11) NOT NULL,
  `manager_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_cardid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `manager_passwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`manager_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, '张好好', 35, '15501215698', 'ssss@126.com', '10014', '121002507', '哈哈', '5478');
INSERT INTO `manager` VALUES (2, '张好', 45, '15501215697', 'sss@126.com', '10013', '121002506', '哈哈哈', '5477');
INSERT INTO `manager` VALUES (3, '张', 35, '15501215696', 'sssss@126.com', '10012', '121002508', '哈哈哈h', '5476');

-- ----------------------------
-- Table structure for return_student
-- ----------------------------
DROP TABLE IF EXISTS `return_student`;
CREATE TABLE `return_student`  (
  `return_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `return_date` date NOT NULL,
  `manager_id` int(11) NOT NULL,
  `book_health` int(11) NOT NULL,
  PRIMARY KEY (`return_student_id`) USING BTREE,
  INDEX `FK_ret_stu_id`(`stu_id`) USING BTREE,
  INDEX `FK_ret_book_id`(`book_id`) USING BTREE,
  INDEX `FK_ret_man_id`(`manager_id`) USING BTREE,
  CONSTRAINT `FK_ret_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ret_man_id` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ret_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of return_student
-- ----------------------------
INSERT INTO `return_student` VALUES (1, 1, 1, '2017-12-05', 1, 1);
INSERT INTO `return_student` VALUES (2, 2, 2, '2017-12-05', 2, 1);
INSERT INTO `return_student` VALUES (3, 3, 3, '2017-12-05', 3, 2);

-- ----------------------------
-- Table structure for return_teacher
-- ----------------------------
DROP TABLE IF EXISTS `return_teacher`;
CREATE TABLE `return_teacher`  (
  `return_teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `return_date` date NOT NULL,
  `manager_id` int(11) NOT NULL,
  `book_health` int(11) NOT NULL,
  PRIMARY KEY (`return_teacher_id`) USING BTREE,
  INDEX `FK_ret_tea_id`(`tea_id`) USING BTREE,
  INDEX `FK_ret_tbook_id`(`book_id`) USING BTREE,
  INDEX `FK_ret_tman_id`(`manager_id`) USING BTREE,
  CONSTRAINT `FK_ret_tbook_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ret_tea_id` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`tea_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ret_tman_id` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stu_sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stu_age` int(11) NOT NULL,
  `stu_pro` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stu_grade` int(11) NOT NULL,
  `stu_username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stu_passwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stu_email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stu_cardid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `stu_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', '男', 19980901, '信息', 3, 'ssfldsh', '3458', 'ssfldsh@126.com', '161002308', '429006');
INSERT INTO `student` VALUES (2, '李四', '女', 19970803, '经管', 4, 'hhhh', '2545', 'hhhh@126.com', '151002306', '429005');
INSERT INTO `student` VALUES (3, '王五', '男', 19960604, '数学', 3, 'kkkk', '5247', 'kkkk@126.com', '181002405', '429003');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tea_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tea_sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tea_age` int(11) NOT NULL,
  `tea_dep` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tea_username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tea_passwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tea_email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tea_cardid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tea_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`tea_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张放', '男', 42, '信息', 'ffff', '5784', 'ffff@126.com', '121002506', '89754');
INSERT INTO `teacher` VALUES (2, '赵伟', '女', 37, '经管', 'kkkk', '8745', 'kkkk@126.com', '131002506', '98754');
INSERT INTO `teacher` VALUES (3, '王东', '男', 39, '数学', 'gggg', '8546', 'gggg@126.com', '141002506', '98753');

SET FOREIGN_KEY_CHECKS = 1;
