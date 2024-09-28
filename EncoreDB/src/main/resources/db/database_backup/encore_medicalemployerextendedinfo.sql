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
-- Table structure for table `medicalemployerextendedinfo`
--

DROP TABLE IF EXISTS `medicalemployerextendedinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicalemployerextendedinfo` (
  `MedicalEmployerExtendedInfoId` int NOT NULL AUTO_INCREMENT,
  `MedicalEmployerUserId` int NOT NULL,
  `OrganizationRole` varchar(512) DEFAULT NULL,
  `Address1` varchar(512) DEFAULT NULL,
  `Address2` varchar(512) DEFAULT NULL,
  `City` varchar(128) NOT NULL,
  `State` varchar(128) NOT NULL,
  `Zip` char(10) DEFAULT NULL,
  `Phone` char(10) DEFAULT NULL,
  `MalpracticeCandidateAcceptable` bit(1) DEFAULT b'0',
  `BoardActionsCandidateAcceptable` bit(1) DEFAULT b'0',
  `DisciplinaryActionCandidateAcceptable` bit(1) DEFAULT b'0',
  `JobPreferenceTypeId` int DEFAULT NULL,
  `GovernmentAssignment` bit(1) DEFAULT b'0',
  `Beds` int DEFAULT NULL,
  `AvgPatientsInMonth` int DEFAULT NULL,
  `Peers` int DEFAULT NULL,
  `Nurses` int DEFAULT NULL,
  `ORs` int DEFAULT NULL,
  `MalpracticeCoverage` bit(1) DEFAULT b'0',
  `CredentialingCoverage` bit(1) DEFAULT b'0',
  `LicenseCoverage` bit(1) DEFAULT b'0',
  `TravelHousingCoverage` bit(1) DEFAULT b'0',
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`MedicalEmployerExtendedInfoId`),
  UNIQUE KEY `ukJobSeekerExtendedInformation` (`MedicalEmployerUserId`),
  KEY `fkMedicalEmployerExtendedInfoJobPreferenceTypeId` (`JobPreferenceTypeId`),
  CONSTRAINT `fkMedicalEmployerExtendedInfoJobPreferenceTypeId` FOREIGN KEY (`JobPreferenceTypeId`) REFERENCES `enumjobtype` (`JobTypeId`),
  CONSTRAINT `fkMedicalEmployerExtendedInfoMedicalEmployerUserId` FOREIGN KEY (`MedicalEmployerUserId`) REFERENCES `users` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalemployerextendedinfo`
--

LOCK TABLES `medicalemployerextendedinfo` WRITE;
/*!40000 ALTER TABLE `medicalemployerextendedinfo` DISABLE KEYS */;
INSERT INTO `medicalemployerextendedinfo` VALUES (1,2,NULL,NULL,NULL,'Columbus','Ohio',NULL,NULL,_binary '\0',_binary '\0',_binary '\0',NULL,_binary '\0',NULL,NULL,NULL,NULL,NULL,_binary '\0',_binary '\0',_binary '\0',_binary '\0',NULL,NULL),(2,3,'MD','Test Address 1','Test Address 2','Alabama','Ohio','12345','9876543210',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL);
/*!40000 ALTER TABLE `medicalemployerextendedinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-01 15:43:27
