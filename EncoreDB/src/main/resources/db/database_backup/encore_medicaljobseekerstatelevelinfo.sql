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
-- Table structure for table `medicaljobseekerstatelevelinfo`
--

DROP TABLE IF EXISTS `medicaljobseekerstatelevelinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicaljobseekerstatelevelinfo` (
  `MedicalJobSeekerStateLevelInfoId` int NOT NULL AUTO_INCREMENT,
  `MedicalJobSeekerExtendedInfoId` int NOT NULL,
  `StateId` int NOT NULL,
  `LicenseExpirationDate` datetime DEFAULT NULL,
  `PrescriptionAuthority` int DEFAULT NULL,
  PRIMARY KEY (`MedicalJobSeekerStateLevelInfoId`),
  UNIQUE KEY `ukMedicalJobSeekerStateLevelInfo` (`MedicalJobSeekerExtendedInfoId`,`StateId`),
  KEY `fkMedicalJobSeekerStateLevelInfoStateId` (`StateId`),
  CONSTRAINT `fkMedicalJobSeekerStateLevelInfoMedicalJobSeekerExtendedInfoId` FOREIGN KEY (`MedicalJobSeekerExtendedInfoId`) REFERENCES `medicaljobseekerextendedinfo` (`MedicalJobSeekerExtendedInfoId`),
  CONSTRAINT `fkMedicalJobSeekerStateLevelInfoStateId` FOREIGN KEY (`StateId`) REFERENCES `enumusstatestype` (`USStatesTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicaljobseekerstatelevelinfo`
--

LOCK TABLES `medicaljobseekerstatelevelinfo` WRITE;
/*!40000 ALTER TABLE `medicaljobseekerstatelevelinfo` DISABLE KEYS */;
INSERT INTO `medicaljobseekerstatelevelinfo` VALUES (2,2,1,NULL,1),(5,1,35,NULL,0);
/*!40000 ALTER TABLE `medicaljobseekerstatelevelinfo` ENABLE KEYS */;
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
