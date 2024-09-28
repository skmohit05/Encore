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
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organization` (
  `OrganizationId` int NOT NULL AUTO_INCREMENT,
  `OrganizationName` varchar(256) NOT NULL,
  `OrganizationTypeId` int NOT NULL,
  `Speciality` varchar(1024) DEFAULT NULL,
  `FacilityTypeId` int DEFAULT NULL,
  `FacilitySubTypeId` int DEFAULT NULL,
  `Government` bit(1) DEFAULT b'0',
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`OrganizationId`),
  UNIQUE KEY `ukOrganization` (`OrganizationName`),
  KEY `fkOrganizationOrganizationTypeId` (`OrganizationTypeId`),
  KEY `fkOrganizationFacilityTypeId` (`FacilityTypeId`),
  KEY `fkOrganizationFacilitySubTypeId` (`FacilitySubTypeId`),
  CONSTRAINT `fkOrganizationFacilitySubTypeId` FOREIGN KEY (`FacilitySubTypeId`) REFERENCES `enumfacilitysubtype` (`FacilitySubTypeId`),
  CONSTRAINT `fkOrganizationFacilityTypeId` FOREIGN KEY (`FacilityTypeId`) REFERENCES `enumfacilitytype` (`FacilityTypeId`),
  CONSTRAINT `fkOrganizationOrganizationTypeId` FOREIGN KEY (`OrganizationTypeId`) REFERENCES `enumorganizationtype` (`OrganizationTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES (1,'IITM',2,'Product Development, Software Development',1,NULL,_binary '',NULL,NULL),(2,'DiviniSoft',2,'Software Solution Provider',1,NULL,_binary '\0',NULL,NULL),(3,'Encore',3,NULL,1,8,_binary '\0',NULL,NULL);
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
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
