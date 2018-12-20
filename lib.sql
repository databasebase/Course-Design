-- MySQL dump 10.13  Distrib 8.0.12, for osx10.13 (x86_64)
--
-- Host: localhost    Database: lib
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `app_student`
--

DROP TABLE IF EXISTS `app_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `app_student` (
  `app_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `app_data` date NOT NULL,
  PRIMARY KEY (`app_student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_student`
--

LOCK TABLES `app_student` WRITE;
/*!40000 ALTER TABLE `app_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `app_teacher`
--

DROP TABLE IF EXISTS `app_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `app_teacher` (
  `app_teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `app_date` date NOT NULL,
  PRIMARY KEY (`app_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `app_teacher`
--

LOCK TABLES `app_teacher` WRITE;
/*!40000 ALTER TABLE `app_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `app_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) NOT NULL,
  `book_intro` varchar(20) NOT NULL,
  `book_addr` varchar(20) NOT NULL,
  `book_ok` varchar(20) NOT NULL,
  `book_health` int(11) NOT NULL,
  `sort_id` int(11) NOT NULL,
  `book_record` date DEFAULT NULL,
  `book_borrow_times` int(11) NOT NULL,
  `book_price` int(11) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_sort`
--

DROP TABLE IF EXISTS `book_sort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book_sort` (
  `sort_id` int(11) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(20) NOT NULL,
  `sort_sit` varchar(20) NOT NULL,
  PRIMARY KEY (`sort_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_sort`
--

LOCK TABLES `book_sort` WRITE;
/*!40000 ALTER TABLE `book_sort` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_sort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_student`
--

DROP TABLE IF EXISTS `borrow_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `borrow_student` (
  `borrow_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `borrow_date` date NOT NULL,
  `exp_return_date` date NOT NULL,
  PRIMARY KEY (`borrow_student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_student`
--

LOCK TABLES `borrow_student` WRITE;
/*!40000 ALTER TABLE `borrow_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_teacher`
--

DROP TABLE IF EXISTS `borrow_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `borrow_teacher` (
  `borrow_teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `borrow_date` date NOT NULL,
  `exp_return_date` date NOT NULL,
  PRIMARY KEY (`borrow_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_teacher`
--

LOCK TABLES `borrow_teacher` WRITE;
/*!40000 ALTER TABLE `borrow_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `col_student`
--

DROP TABLE IF EXISTS `col_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `col_student` (
  `col_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `col_date` date NOT NULL,
  `col_instr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`col_student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `col_student`
--

LOCK TABLES `col_student` WRITE;
/*!40000 ALTER TABLE `col_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `col_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `col_teacher`
--

DROP TABLE IF EXISTS `col_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `col_teacher` (
  `col_teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `col_date` date NOT NULL,
  `col_instr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`col_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `col_teacher`
--

LOCK TABLES `col_teacher` WRITE;
/*!40000 ALTER TABLE `col_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `col_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(20) NOT NULL,
  `manager_age` int(11) NOT NULL,
  `manager_phone` varchar(20) NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_student`
--

DROP TABLE IF EXISTS `return_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `return_student` (
  `return_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `return_date` date NOT NULL,
  `manager_id` int(11) NOT NULL,
  `book_health` int(11) NOT NULL,
  PRIMARY KEY (`return_student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_student`
--

LOCK TABLES `return_student` WRITE;
/*!40000 ALTER TABLE `return_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_teacher`
--

DROP TABLE IF EXISTS `return_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `return_teacher` (
  `return_teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `return_date` date NOT NULL,
  `manager_id` int(11) NOT NULL,
  `book_health` int(11) NOT NULL,
  PRIMARY KEY (`return_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_teacher`
--

LOCK TABLES `return_teacher` WRITE;
/*!40000 ALTER TABLE `return_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `return_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(20) NOT NULL,
  `stu_sex` varchar(5) NOT NULL,
  `stu_age` int(11) NOT NULL,
  `stu_pro` varchar(20) NOT NULL,
  `stu_grade` int(11) NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teacher` (
  `tea_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_name` varchar(20) NOT NULL,
  `tea_sex` varchar(5) NOT NULL,
  `tea_age` int(11) NOT NULL,
  `tea_dep` varchar(20) NOT NULL,
  PRIMARY KEY (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_student`
--

DROP TABLE IF EXISTS `ticket_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket_student` (
  `ticket_student_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `over_date` int(11) NOT NULL,
  `ticket_fee` int(11) NOT NULL,
  PRIMARY KEY (`ticket_student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_student`
--

LOCK TABLES `ticket_student` WRITE;
/*!40000 ALTER TABLE `ticket_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_teacher`
--

DROP TABLE IF EXISTS `ticket_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket_teacher` (
  `ticket_teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `over_date` int(11) NOT NULL,
  `ticket_fee` int(11) NOT NULL,
  PRIMARY KEY (`ticket_teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_teacher`
--

LOCK TABLES `ticket_teacher` WRITE;
/*!40000 ALTER TABLE `ticket_teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket_teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-20 12:44:49
