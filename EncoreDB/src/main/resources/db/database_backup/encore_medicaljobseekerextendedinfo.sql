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
-- Table structure for table `medicaljobseekerextendedinfo`
--

DROP TABLE IF EXISTS `medicaljobseekerextendedinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicaljobseekerextendedinfo` (
  `MedicalJobSeekerExtendedInfoId` int NOT NULL AUTO_INCREMENT,
  `MedicalJobSeekerUserId` int NOT NULL,
  `Address1` varchar(512) NOT NULL,
  `Address2` varchar(512) DEFAULT NULL,
  `City` varchar(128) NOT NULL,
  `State` char(30) NOT NULL,
  `Zip` char(10) NOT NULL,
  `Title` char(7) NOT NULL,
  `SpecialityTypeId` int NOT NULL,
  `Malpractice` bit(1) DEFAULT NULL,
  `BoardActions` bit(1) DEFAULT NULL,
  `DisciplinaryActions` bit(1) DEFAULT NULL,
  `LossOfPrivileges` bit(1) DEFAULT NULL,
  `NPDB` bit(1) DEFAULT NULL,
  `EpicExperience` bit(1) DEFAULT NULL,
  `MalpracticeInfo` varchar(1024) DEFAULT NULL,
  `BoardActionsInfo` varchar(1024) DEFAULT NULL,
  `DisciplinaryActionsInfo` varchar(1024) DEFAULT NULL,
  `LossOfPrivilegesInfo` varchar(1024) DEFAULT NULL,
  `NPDBInfo` varchar(1024) DEFAULT NULL,
  `EpicExperienceYears` int DEFAULT NULL,
  `JobPreferenceTypeId` int NOT NULL,
  `Travel` bit(1) DEFAULT b'0',
  `TravelStatePreferenceId` int DEFAULT NULL,
  `ShiftPreferenceTypeId` int NOT NULL,
  `CallPreference` bit(1) DEFAULT b'0',
  `GovernmentAssignment` bit(1) DEFAULT b'0',
  `Compensation` int DEFAULT NULL,
  `CompensationTypeId` int DEFAULT NULL,
  `YearsExperience` int DEFAULT NULL,
  `AdditionalInformation1` varchar(1024) DEFAULT NULL,
  `AdditionalInformation2` varchar(1024) DEFAULT NULL,
  `AdditionalInformation3` varchar(1024) DEFAULT NULL,
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`MedicalJobSeekerExtendedInfoId`),
  UNIQUE KEY `ukMedicalJobSeekerExtendedInfo` (`MedicalJobSeekerUserId`),
  KEY `fkMedicalJobSeekerExtendedInfoSpecialityTypeId` (`SpecialityTypeId`),
  KEY `fkMedicalJobSeekerExtendedInfoJobPreferenceTypeId` (`JobPreferenceTypeId`),
  KEY `fkMedicalJobSeekerExtendedInfoTravelStatePreferenceId` (`TravelStatePreferenceId`),
  KEY `fkMedicalJobSeekerExtendedInfoShiftPreferenceTypeId` (`ShiftPreferenceTypeId`),
  KEY `fkMedicalJobSeekerExtendedInfoCompensationTypeId` (`CompensationTypeId`),
  CONSTRAINT `fkMedicalJobSeekerExtendedInfoCompensationTypeId` FOREIGN KEY (`CompensationTypeId`) REFERENCES `enumcompensationtype` (`CompensationTypeId`),
  CONSTRAINT `fkMedicalJobSeekerExtendedInfoJobPreferenceTypeId` FOREIGN KEY (`JobPreferenceTypeId`) REFERENCES `enumjobtype` (`JobTypeId`),
  CONSTRAINT `fkMedicalJobSeekerExtendedInfoMedicalJobSeekerUserId` FOREIGN KEY (`MedicalJobSeekerUserId`) REFERENCES `users` (`UserId`),
  CONSTRAINT `fkMedicalJobSeekerExtendedInfoShiftPreferenceTypeId` FOREIGN KEY (`ShiftPreferenceTypeId`) REFERENCES `enumshifttype` (`ShiftTypeId`),
  CONSTRAINT `fkMedicalJobSeekerExtendedInfoSpecialityTypeId` FOREIGN KEY (`SpecialityTypeId`) REFERENCES `enumspecialitytype` (`SpecialityTypeId`),
  CONSTRAINT `fkMedicalJobSeekerExtendedInfoTravelStatePreferenceId` FOREIGN KEY (`TravelStatePreferenceId`) REFERENCES `enumusstatestype` (`USStatesTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicaljobseekerextendedinfo`
--

LOCK TABLES `medicaljobseekerextendedinfo` WRITE;
/*!40000 ALTER TABLE `medicaljobseekerextendedinfo` DISABLE KEYS */;
INSERT INTO `medicaljobseekerextendedinfo` VALUES (1,4,'Addr',NULL,'Columbus','Ohio','12345','CRNA',1,_binary '\0',NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,1,_binary '\0',NULL,1,_binary '\0',_binary '\0',100,NULL,2,NULL,NULL,NULL,NULL,NULL),(2,5,'Addr',NULL,'Columbus','Ohio','123456','ABC',1,_binary '',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,_binary '\0',NULL,1,_binary '\0',_binary '\0',100,1,2,NULL,NULL,NULL,NULL,NULL),(3,6,'Addr',NULL,'Columbus','Ohio','123456','ABC',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,_binary '\0',NULL,1,_binary '\0',_binary '\0',100,1,2,NULL,NULL,NULL,NULL,NULL),(4,7,'Addr',NULL,'Columbus','Ohio','123456','ABC',1,_binary '',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,_binary '\0',NULL,1,_binary '\0',_binary '\0',100,1,2,NULL,NULL,NULL,NULL,NULL),(5,8,'Addr',NULL,'Columbus','Ohio','123456','ABC',1,_binary '',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,_binary '\0',NULL,1,_binary '\0',_binary '\0',100,1,2,NULL,NULL,NULL,NULL,NULL),(6,9,'Addr',NULL,'Columbus','Ohio','123456','ABC',1,_binary '',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,_binary '\0',NULL,1,_binary '\0',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `medicaljobseekerextendedinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-01 15:43:26
