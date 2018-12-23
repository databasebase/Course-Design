-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: experiment
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actor`
--

DROP TABLE IF EXISTS `actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `actor` (
  `actor_id` int(11) NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(45) NOT NULL,
  `actor_intro` varchar(45) NOT NULL,
  PRIMARY KEY (`actor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actor`
--

LOCK TABLES `actor` WRITE;
/*!40000 ALTER TABLE `actor` DISABLE KEYS */;
/*!40000 ALTER TABLE `actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `label`
--

DROP TABLE IF EXISTS `label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `label` (
  `label_id` int(11) NOT NULL AUTO_INCREMENT,
  `label_name` varchar(45) NOT NULL,
  `label_num` int(11) NOT NULL,
  PRIMARY KEY (`label_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `label`
--

LOCK TABLES `label` WRITE;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
/*!40000 ALTER TABLE `label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(45) NOT NULL,
  `manager_password` varchar(45) NOT NULL,
  `manager_age` int(11) NOT NULL,
  `manager_phone` varchar(45) NOT NULL,
  `manager_email` varchar(45) NOT NULL,
  `manager_cardid` varchar(45) NOT NULL,
  `manager_code` varchar(45) NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'1','1',1,'1','1','1','1');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_actor`
--

DROP TABLE IF EXISTS `movie_actor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movie_actor` (
  `movie_id` int(11) NOT NULL,
  `actor_id` int(11) NOT NULL,
  `actor_pro` varchar(45) NOT NULL,
  PRIMARY KEY (`movie_id`,`actor_id`),
  KEY `actor_idx` (`actor_id`),
  CONSTRAINT `actor` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`actor_id`),
  CONSTRAINT `mov_id` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`mov_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_actor`
--

LOCK TABLES `movie_actor` WRITE;
/*!40000 ALTER TABLE `movie_actor` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_actor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_label`
--

DROP TABLE IF EXISTS `movie_label`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movie_label` (
  `mov_id` int(11) NOT NULL,
  `label_id` int(11) NOT NULL,
  PRIMARY KEY (`mov_id`,`label_id`),
  KEY `label_id_idx` (`label_id`),
  CONSTRAINT `label_id` FOREIGN KEY (`label_id`) REFERENCES `label` (`label_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_label`
--

LOCK TABLES `movie_label` WRITE;
/*!40000 ALTER TABLE `movie_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_label` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_star`
--

DROP TABLE IF EXISTS `movie_star`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movie_star` (
  `movie_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `star` int(11) NOT NULL,
  PRIMARY KEY (`movie_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_star`
--

LOCK TABLES `movie_star` WRITE;
/*!40000 ALTER TABLE `movie_star` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_star` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movies` (
  `mov_id` int(11) NOT NULL AUTO_INCREMENT,
  `mov_name` varchar(45) NOT NULL,
  `mov_intro` varchar(45) NOT NULL,
  `mov_time` varchar(45) NOT NULL,
  `mov_cou` varchar(45) NOT NULL,
  `mov_la` varchar(45) NOT NULL,
  `mov_rel` varchar(45) NOT NULL,
  PRIMARY KEY (`mov_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies_review`
--

DROP TABLE IF EXISTS `movies_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movies_review` (
  `mov_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `mov_time` varchar(45) NOT NULL,
  `mov_lik` varchar(45) NOT NULL,
  PRIMARY KEY (`mov_id`,`user_id`),
  KEY `user_id_idx` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies_review`
--

LOCK TABLES `movies_review` WRITE;
/*!40000 ALTER TABLE `movies_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `movies_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_sex` varchar(45) NOT NULL,
  `user_age` int(11) NOT NULL,
  `user_email` varchar(45) NOT NULL,
  `user_cardid` varchar(45) NOT NULL,
  `user_code` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-23 17:07:03
