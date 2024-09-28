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
-- Table structure for table `userauthentication`
--

DROP TABLE IF EXISTS `userauthentication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userauthentication` (
  `UserAuthenticationId` int NOT NULL AUTO_INCREMENT,
  `UserId` int NOT NULL,
  `LastSignInDate` date DEFAULT NULL,
  `MFAPassed` bit(1) NOT NULL DEFAULT b'0',
  `MFATypeId` int NOT NULL,
  `RememberMe` bit(1) DEFAULT NULL,
  `TrustedDeviceId` varchar(1024) DEFAULT NULL,
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`UserAuthenticationId`),
  UNIQUE KEY `ukUserAuthentication` (`UserId`),
  KEY `fkUserAuthenticationMFATypeId` (`MFATypeId`),
  CONSTRAINT `fkUserAuthenticationMFATypeId` FOREIGN KEY (`MFATypeId`) REFERENCES `enummfatype` (`MFATypeId`),
  CONSTRAINT `fkUserAuthenticationUserId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userauthentication`
--

LOCK TABLES `userauthentication` WRITE;
/*!40000 ALTER TABLE `userauthentication` DISABLE KEYS */;
INSERT INTO `userauthentication` VALUES (1,1,'2021-03-30',_binary '',1,NULL,NULL,NULL,NULL),(2,2,'2021-03-30',_binary '',1,NULL,NULL,NULL,NULL),(3,3,'2024-09-01',_binary '',1,NULL,NULL,NULL,NULL),(4,4,'2024-09-01',_binary '',1,NULL,NULL,NULL,NULL),(5,5,'2024-09-01',_binary '',1,NULL,NULL,NULL,NULL),(6,6,'2021-03-30',_binary '',1,NULL,NULL,NULL,NULL),(7,7,'2021-03-30',_binary '',1,NULL,NULL,NULL,NULL),(8,8,'2021-03-30',_binary '',1,NULL,NULL,NULL,NULL),(9,9,'2021-03-30',_binary '',1,NULL,NULL,NULL,NULL),(10,10,'2024-08-30',_binary '',1,NULL,NULL,'2024-08-30 20:36:08',10);
/*!40000 ALTER TABLE `userauthentication` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-01 15:43:29
