CREATE DATABASE  IF NOT EXISTS `encore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `encore`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: encore
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `enumshifttype`
--

DROP TABLE IF EXISTS `enumshifttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enumshifttype` (
  `ShiftTypeId` int NOT NULL AUTO_INCREMENT,
  `ShiftTypeName` varchar(128) NOT NULL,
  `ShiftTypeDesc` varchar(512) DEFAULT NULL,
  `IsActive` bit(1) NOT NULL DEFAULT b'0',
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`ShiftTypeId`),
  UNIQUE KEY `ukEnumShiftType` (`ShiftTypeName`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enumshifttype`
--

LOCK TABLES `enumshifttype` WRITE;
/*!40000 ALTER TABLE `enumshifttype` DISABLE KEYS */;
INSERT INTO `enumshifttype` VALUES (1,'Day','Day',_binary '',NULL,NULL),(2,'Night','Night',_binary '',NULL,NULL),(3,'Weekend','Weekend',_binary '',NULL,NULL),(4,'AllDay','All Day',_binary '',NULL,NULL),(5,'NoPreference','No Preference',_binary '',NULL,NULL),(6,'All','All',_binary '',NULL,NULL),(7,'Variable','Variable',_binary '',NULL,NULL);
/*!40000 ALTER TABLE `enumshifttype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-01 15:43:24
