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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `UserTypeId` int DEFAULT NULL,
  `Email` char(64) NOT NULL,
  `FirstName` char(32) DEFAULT NULL,
  `LastName` char(32) DEFAULT NULL,
  `Password` char(128) NOT NULL,
  `StatusTypeId` int NOT NULL,
  `FieldTypeId` int DEFAULT NULL,
  `SubDomain` varchar(256) DEFAULT NULL,
  `RegistrationDate` date DEFAULT NULL,
  `RemoveRequestedDate` date DEFAULT NULL,
  `OrganizationId` int DEFAULT NULL,
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `ukUsers` (`Email`),
  KEY `fkUsersUserTypeId` (`UserTypeId`),
  KEY `fkUsersStatusTypeId` (`StatusTypeId`),
  KEY `fkUsersFieldTypeId` (`FieldTypeId`),
  KEY `fkUsersOrganizationId` (`OrganizationId`),
  CONSTRAINT `fkUsersFieldTypeId` FOREIGN KEY (`FieldTypeId`) REFERENCES `enumfieldtype` (`FieldTypeId`),
  CONSTRAINT `fkUsersOrganizationId` FOREIGN KEY (`OrganizationId`) REFERENCES `organization` (`OrganizationId`),
  CONSTRAINT `fkUsersStatusTypeId` FOREIGN KEY (`StatusTypeId`) REFERENCES `enumuserstatustype` (`UserStatusTypeId`),
  CONSTRAINT `fkUsersUserTypeId` FOREIGN KEY (`UserTypeId`) REFERENCES `enumusertype` (`UserTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'sysadmin@healthcare.com','admin',NULL,'$2a$10$Vl7unTXMqkgRnglNeeb8iu2f25vceo0.eNtynSZe8.9XofwtDuIhG',1,1,NULL,NULL,NULL,NULL,NULL,NULL),(2,2,'pyenugu@hotmail.com','Phani','Yenugu','$2a$10$suCl2VnYqH.MgrOejnZQtuEGy1Co9Ax3XK.W68cE.LaKzDy1ns3Re',1,1,NULL,'2021-03-08',NULL,3,NULL,NULL),(3,2,'e2@hotmail.com','Employer2',NULL,'$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e',1,1,NULL,'2021-03-08',NULL,3,NULL,NULL),(4,3,'js1@hotmail.com','JobSeeker1',NULL,'$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e',1,1,NULL,'2021-03-08',NULL,3,NULL,NULL),(5,3,'js2@hotmail.com','JobSeeker2',NULL,'$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e',1,1,NULL,'2021-03-08',NULL,3,NULL,NULL),(6,3,'js3@hotmail.com','JobSeeker3',NULL,'$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e',1,1,NULL,'2021-03-08',NULL,3,NULL,NULL),(7,3,'js4@hotmail.com','JobSeeker4',NULL,'$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e',1,1,NULL,'2021-03-08',NULL,3,NULL,NULL),(8,3,'js5@hotmail.com','JobSeeker5',NULL,'$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e',1,1,NULL,'2021-03-08',NULL,3,NULL,NULL),(9,3,'js6@hotmail.com','JobSeeker6',NULL,'$2a$10$febN8k2o3Xvui3xQo.OjauTFX6fzGxu1xChtvv3TwFM4tVY/wPz3e',1,1,NULL,'2021-03-08',NULL,3,NULL,NULL),(10,3,'mmeena@divinisoft.com','Mohit','Meena','$2a$10$qoOrxa7t0jtOzpdET9vvrO9EmS.kA63pT8fIAJLZlwKFgloqekZYy',1,NULL,NULL,NULL,NULL,NULL,'2024-08-30 20:36:08',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
