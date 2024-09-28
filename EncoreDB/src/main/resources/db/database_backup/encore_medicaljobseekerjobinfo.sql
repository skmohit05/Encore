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
-- Table structure for table `medicaljobseekerjobinfo`
--

DROP TABLE IF EXISTS `medicaljobseekerjobinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicaljobseekerjobinfo` (
  `MedicalJobSeekerJobInfoId` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(512) NOT NULL,
  `Speciality` varchar(512) NOT NULL,
  `Place` varchar(512) NOT NULL,
  `FacilityName` varchar(512) NOT NULL,
  `FacilityTypeId` int NOT NULL,
  `OrganizationTypeId` int DEFAULT NULL,
  `FacilitySubTypeId` int DEFAULT NULL,
  `AssignmentTypeId` int NOT NULL,
  `AssignmentShiftTypeId` int NOT NULL,
  `City` varchar(128) NOT NULL,
  `State` varchar(128) NOT NULL,
  `Zip` char(10) DEFAULT NULL,
  `AssignmentFromDate` date NOT NULL,
  `AssignmentToDate` date DEFAULT NULL,
  `Beds` int DEFAULT NULL,
  `AvgPatientsInMonth` int DEFAULT NULL,
  `Peers` int DEFAULT NULL,
  `Nurses` int DEFAULT NULL,
  `ORs` int DEFAULT NULL,
  `Supervised` bit(1) DEFAULT NULL,
  `Compensation` int DEFAULT NULL,
  `Travel` bit(1) DEFAULT b'0',
  `TravelHousingCoverage` bit(1) DEFAULT b'0',
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`MedicalJobSeekerJobInfoId`),
  KEY `fkMedicalJobSeekerJobInfoFacilityTypeId` (`FacilityTypeId`),
  KEY `fkMedicalJobSeekerJobInfoAssignmentTypeId` (`AssignmentTypeId`),
  KEY `fkMedicalJobSeekerJobInfoAssignmentShiftTypeId` (`AssignmentShiftTypeId`),
  KEY `fkMedicalJobSeekerJobInfoOrganizationTypeId` (`OrganizationTypeId`),
  KEY `fkMedicalJobSeekerJobInfoFacilitySubTypeId` (`FacilitySubTypeId`),
  CONSTRAINT `fkMedicalJobSeekerJobInfoAssignmentShiftTypeId` FOREIGN KEY (`AssignmentShiftTypeId`) REFERENCES `enumshifttype` (`ShiftTypeId`),
  CONSTRAINT `fkMedicalJobSeekerJobInfoAssignmentTypeId` FOREIGN KEY (`AssignmentTypeId`) REFERENCES `enumassignmenttype` (`AssignmentTypeId`),
  CONSTRAINT `fkMedicalJobSeekerJobInfoFacilitySubTypeId` FOREIGN KEY (`FacilitySubTypeId`) REFERENCES `enumfacilitysubtype` (`FacilitySubTypeId`),
  CONSTRAINT `fkMedicalJobSeekerJobInfoFacilityTypeId` FOREIGN KEY (`FacilityTypeId`) REFERENCES `enumfacilitytype` (`FacilityTypeId`),
  CONSTRAINT `fkMedicalJobSeekerJobInfoOrganizationTypeId` FOREIGN KEY (`OrganizationTypeId`) REFERENCES `enumorganizationtype` (`OrganizationTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicaljobseekerjobinfo`
--

LOCK TABLES `medicaljobseekerjobinfo` WRITE;
/*!40000 ALTER TABLE `medicaljobseekerjobinfo` DISABLE KEYS */;
INSERT INTO `medicaljobseekerjobinfo` VALUES (2,'CRNA','Cardiology','Ohio','Test Facility 1',1,1,8,1,1,'Columbus','Ohio','12345','2024-08-29',NULL,100,80,7,14,3,_binary '',100,_binary '\0',_binary '\0',NULL,NULL),(3,'Test Title 3','Test Speciality 3','Ohio','Test Facility 1',1,NULL,NULL,1,1,'Columbus','Ohio',NULL,'2024-08-29',NULL,NULL,NULL,NULL,NULL,NULL,_binary '',NULL,_binary '\0',_binary '\0',NULL,NULL),(4,'Test Title 4','Test Speciality 4','Ohio','Test Facility 1',1,NULL,NULL,1,1,'Columbus','Ohio',NULL,'2024-08-29',NULL,NULL,NULL,NULL,NULL,NULL,_binary '',NULL,_binary '\0',_binary '\0',NULL,NULL),(5,'Test Title 5','Test Speciality 5','Ohio','Test Facility 1',1,NULL,NULL,1,1,'Columbus','Ohio',NULL,'2024-08-29',NULL,NULL,NULL,NULL,NULL,NULL,_binary '',NULL,_binary '\0',_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `medicaljobseekerjobinfo` ENABLE KEYS */;
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
