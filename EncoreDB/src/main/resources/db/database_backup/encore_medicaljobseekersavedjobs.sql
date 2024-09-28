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
-- Table structure for table `medicaljobseekersavedjobs`
--

DROP TABLE IF EXISTS `medicaljobseekersavedjobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicaljobseekersavedjobs` (
  `MedicalJobSeekerSavedJobId` int NOT NULL AUTO_INCREMENT,
  `MedicalJobSeekerUserId` int NOT NULL,
  `MedicalEmployerJobPostingId` int NOT NULL,
  `SavedDate` date NOT NULL,
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`MedicalJobSeekerSavedJobId`),
  UNIQUE KEY `ukMedicalJobSeekerSavedJobs` (`MedicalJobSeekerUserId`,`MedicalEmployerJobPostingId`),
  KEY `fkMedicalJobSeekerSavedJobsMedicalEmployerJobPostingId` (`MedicalEmployerJobPostingId`),
  CONSTRAINT `fkMedicalJobSeekerSavedJobsMedicalEmployerJobPostingId` FOREIGN KEY (`MedicalEmployerJobPostingId`) REFERENCES `medicalemployerjobposting` (`MedicalEmployerJobPostingId`),
  CONSTRAINT `fkMedicalJobSeekerSavedJobsMedicalJobSeekerUserId` FOREIGN KEY (`MedicalJobSeekerUserId`) REFERENCES `users` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicaljobseekersavedjobs`
--

LOCK TABLES `medicaljobseekersavedjobs` WRITE;
/*!40000 ALTER TABLE `medicaljobseekersavedjobs` DISABLE KEYS */;
INSERT INTO `medicaljobseekersavedjobs` VALUES (1,4,1,'2024-09-01','2024-09-01 15:35:36',4);
/*!40000 ALTER TABLE `medicaljobseekersavedjobs` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-01 15:43:30
