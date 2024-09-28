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
-- Table structure for table `enumspecialitytype`
--

DROP TABLE IF EXISTS `enumspecialitytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enumspecialitytype` (
  `SpecialityTypeId` int NOT NULL AUTO_INCREMENT,
  `SpecialityTypeName` varchar(128) NOT NULL,
  `SpecialityTypeDesc` varchar(512) DEFAULT NULL,
  `IsActive` bit(1) NOT NULL DEFAULT b'0',
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`SpecialityTypeId`),
  UNIQUE KEY `ukEnumSpecialityType` (`SpecialityTypeName`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enumspecialitytype`
--

LOCK TABLES `enumspecialitytype` WRITE;
/*!40000 ALTER TABLE `enumspecialitytype` DISABLE KEYS */;
INSERT INTO `enumspecialitytype` VALUES (1,'Cardiology','Cardiology',_binary '',NULL,NULL),(2,'Dermatology','Dermatology',_binary '',NULL,NULL),(3,'Nephrology','Nephrology',_binary '',NULL,NULL),(4,'Neurology','Neurology',_binary '',NULL,NULL),(5,'Pediatrics','Pediatrics',_binary '',NULL,NULL),(6,'Psychiatry','Psychiatry',_binary '',NULL,NULL),(7,'Pulmonology','Pulmonology',_binary '',NULL,NULL),(8,'Anesthesiology','Anesthesiology',_binary '',NULL,NULL),(9,'EmergencyMedicine','Emergency Medicine',_binary '',NULL,NULL),(10,'FamilyPractice','Family Practice',_binary '',NULL,NULL),(11,'GeneralPractice','General Practice',_binary '',NULL,NULL),(12,'Endocrinology','Endocrinology',_binary '',NULL,NULL),(13,'Gastroenterology','Gastroenterology',_binary '',NULL,NULL),(14,'Gynecology','Gynecology',_binary '',NULL,NULL),(15,'InternalMedicine','Internal Medicine',_binary '',NULL,NULL);
/*!40000 ALTER TABLE `enumspecialitytype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-01 15:43:25
