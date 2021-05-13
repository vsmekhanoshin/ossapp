-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ossapp_chema
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cities_tbl`
--

DROP TABLE IF EXISTS `cities_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities_tbl`
(
    `city_id`  mediumint unsigned NOT NULL AUTO_INCREMENT,
    `name_fld` varchar(45) NOT NULL,
    PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities_tbl`
--

LOCK
TABLES `cities_tbl` WRITE;
/*!40000 ALTER TABLE `cities_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `cities_tbl` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `styles_tbl`
--

DROP TABLE IF EXISTS `styles_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `styles_tbl`
(
    `style_id` smallint unsigned NOT NULL AUTO_INCREMENT,
    `name_fld` varchar(45) NOT NULL,
    PRIMARY KEY (`style_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `styles_tbl`
--

LOCK
TABLES `styles_tbl` WRITE;
/*!40000 ALTER TABLE `styles_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `styles_tbl` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `user_styles_tbl`
--

DROP TABLE IF EXISTS `user_styles_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_styles_tbl`
(
    `user_id`  int unsigned NOT NULL,
    `style_id` smallint unsigned NOT NULL,
    KEY        `user_style_key_idx` (`user_id`),
    KEY        `style_user_key_idx` (`style_id`),
    CONSTRAINT `style_user_key` FOREIGN KEY (`style_id`) REFERENCES `styles_tbl` (`style_id`),
    CONSTRAINT `user_style_key` FOREIGN KEY (`user_id`) REFERENCES `users_tbl` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_styles_tbl`
--

LOCK
TABLES `user_styles_tbl` WRITE;
/*!40000 ALTER TABLE `user_styles_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_styles_tbl` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `users_tbl`
--

DROP TABLE IF EXISTS `users_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_tbl`
(
    `user_id`        int unsigned NOT NULL AUTO_INCREMENT,
    `phone_fld`      varchar(45)    NOT NULL,
    `name_fld`       varchar(45)    NOT NULL,
    `birth_date_fld` date           NOT NULL,
    `weight_fld`     tinyint unsigned NOT NULL,
    `sex_fld`        tinyint        NOT NULL,
    `city_id`        mediumint unsigned NOT NULL,
    `about_fld`      varchar(16000) NOT NULL,
    `photo_fld`      varchar(45) DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `phone_fld_UNIQUE` (`phone_fld`),
    KEY              `city_idx` (`city_id`),
    CONSTRAINT `city` FOREIGN KEY (`city_id`) REFERENCES `cities_tbl` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_tbl`
--

LOCK
TABLES `users_tbl` WRITE;
/*!40000 ALTER TABLE `users_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_tbl` ENABLE KEYS */;
UNLOCK
TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-10  0:13:13
