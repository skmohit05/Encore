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
-- Table structure for table `medicalemployerjobposting`
--

DROP TABLE IF EXISTS `medicalemployerjobposting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicalemployerjobposting` (
  `MedicalEmployerJobPostingId` int NOT NULL AUTO_INCREMENT,
  `MedicalEmployerUserId` int NOT NULL,
  `Title` varchar(512) NOT NULL,
  `Speciality` varchar(512) NOT NULL,
  `JobDescription` text,
  `AssignmentTypeId` int DEFAULT NULL,
  `AssignmentShiftTypeId` int DEFAULT NULL,
  `Supervised` bit(1) DEFAULT b'0',
  `PrescriptionAuthorityNeeded` bit(1) DEFAULT b'0',
  `AssignmentFromDate` date DEFAULT NULL,
  `AssignmentToDate` date DEFAULT NULL,
  `CompensationRange` varchar(128) DEFAULT NULL,
  `Compensation` int DEFAULT NULL,
  `CompensationTypeId` int DEFAULT NULL,
  `MalpracticeAccepted` bit(1) DEFAULT b'0',
  `MalpracticeCoverage` bit(1) DEFAULT b'0',
  `CredentialingCoverage` bit(1) DEFAULT b'0',
  `LicenseCoverage` bit(1) DEFAULT b'0',
  `TravelHousingCoverage` bit(1) DEFAULT b'0',
  `YearsExperience` int DEFAULT NULL,
  `Priority1` int DEFAULT NULL,
  `Priority2` int DEFAULT NULL,
  `Priority3` int DEFAULT NULL,
  `Priority4` int DEFAULT NULL,
  `Priority5` int DEFAULT NULL,
  `PostedDate` date DEFAULT NULL,
  `UpdatedDate` date DEFAULT NULL,
  `StatusTypeId` int DEFAULT NULL,
  `ExpiryDate` date DEFAULT NULL,
  `State` varchar(128) DEFAULT NULL,
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`MedicalEmployerJobPostingId`),
  KEY `fkMedicalEmployerJobPostingMedicalEmployerUserId` (`MedicalEmployerUserId`),
  KEY `fkMedicalEmployerJobPostingAssignmentTypeId` (`AssignmentTypeId`),
  KEY `fkMedicalEmployerJobPostingAssignmentShiftTypeId` (`AssignmentShiftTypeId`),
  KEY `fkMedicalEmployerJobPostingPriority1` (`Priority1`),
  KEY `fkMedicalEmployerJobPostingPriority2` (`Priority2`),
  KEY `fkMedicalEmployerJobPostingPriority3` (`Priority3`),
  KEY `fkMedicalEmployerJobPostingPriority4` (`Priority4`),
  KEY `fkMedicalEmployerJobPostingPriority5` (`Priority5`),
  KEY `fkMedicalEmployerJobPostingCompensationTypeId` (`CompensationTypeId`),
  KEY `fkMedicalEmployerJobPostingStatusTypeId` (`StatusTypeId`),
  CONSTRAINT `fkMedicalEmployerJobPostingAssignmentShiftTypeId` FOREIGN KEY (`AssignmentShiftTypeId`) REFERENCES `enumshifttype` (`ShiftTypeId`),
  CONSTRAINT `fkMedicalEmployerJobPostingAssignmentTypeId` FOREIGN KEY (`AssignmentTypeId`) REFERENCES `enumassignmenttype` (`AssignmentTypeId`),
  CONSTRAINT `fkMedicalEmployerJobPostingCompensationTypeId` FOREIGN KEY (`CompensationTypeId`) REFERENCES `enumcompensationtype` (`CompensationTypeId`),
  CONSTRAINT `fkMedicalEmployerJobPostingMedicalEmployerUserId` FOREIGN KEY (`MedicalEmployerUserId`) REFERENCES `users` (`UserId`),
  CONSTRAINT `fkMedicalEmployerJobPostingPriority1` FOREIGN KEY (`Priority1`) REFERENCES `enumpriorityfeaturetype` (`PriorityFeatureTypeId`),
  CONSTRAINT `fkMedicalEmployerJobPostingPriority2` FOREIGN KEY (`Priority2`) REFERENCES `enumpriorityfeaturetype` (`PriorityFeatureTypeId`),
  CONSTRAINT `fkMedicalEmployerJobPostingPriority3` FOREIGN KEY (`Priority3`) REFERENCES `enumpriorityfeaturetype` (`PriorityFeatureTypeId`),
  CONSTRAINT `fkMedicalEmployerJobPostingPriority4` FOREIGN KEY (`Priority4`) REFERENCES `enumpriorityfeaturetype` (`PriorityFeatureTypeId`),
  CONSTRAINT `fkMedicalEmployerJobPostingPriority5` FOREIGN KEY (`Priority5`) REFERENCES `enumpriorityfeaturetype` (`PriorityFeatureTypeId`),
  CONSTRAINT `fkMedicalEmployerJobPostingStatusTypeId` FOREIGN KEY (`StatusTypeId`) REFERENCES `enumjobpostingstatustype` (`JobPostingStatusTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicalemployerjobposting`
--

LOCK TABLES `medicalemployerjobposting` WRITE;
/*!40000 ALTER TABLE `medicalemployerjobposting` DISABLE KEYS */;
INSERT INTO `medicalemployerjobposting` VALUES (1,3,'CRNA','Cardiology',NULL,1,1,_binary '\0',_binary '\0','2024-09-04','2024-09-24',NULL,115,1,_binary '\0',_binary '\0',_binary '\0',_binary '\0',NULL,1,3,4,7,5,6,'2024-09-01','2024-09-01',1,'2024-09-04','Foley','2024-09-01 15:08:55',3);
/*!40000 ALTER TABLE `medicalemployerjobposting` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-01 15:43:28
