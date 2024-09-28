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
-- Table structure for table `enumusstatestype`
--

DROP TABLE IF EXISTS `enumusstatestype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enumusstatestype` (
  `USStatesTypeId` int NOT NULL AUTO_INCREMENT,
  `USStatesTypeName` varchar(128) NOT NULL,
  `USStatesTypeDesc` varchar(512) DEFAULT NULL,
  `IsActive` bit(1) NOT NULL DEFAULT b'0',
  `Lud` datetime DEFAULT NULL,
  `Lub` int DEFAULT NULL,
  PRIMARY KEY (`USStatesTypeId`),
  UNIQUE KEY `ukEnumUSStatesType` (`USStatesTypeName`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enumusstatestype`
--

LOCK TABLES `enumusstatestype` WRITE;
/*!40000 ALTER TABLE `enumusstatestype` DISABLE KEYS */;
INSERT INTO `enumusstatestype` VALUES (1,'Alabama','Alabama',_binary '',NULL,NULL),(2,'Alaska','Alaska',_binary '',NULL,NULL),(3,'Arizona','Arizona',_binary '',NULL,NULL),(4,'Arkansas','Arkansas',_binary '',NULL,NULL),(5,'California','California',_binary '',NULL,NULL),(6,'Colorado','Colorado',_binary '',NULL,NULL),(7,'Connecticut','Connecticut',_binary '',NULL,NULL),(8,'Delaware','Delaware',_binary '',NULL,NULL),(9,'Florida','Florida',_binary '',NULL,NULL),(10,'Georgia','Georgia',_binary '',NULL,NULL),(11,'Hawaii','Hawaii',_binary '',NULL,NULL),(12,'Idaho','Idaho',_binary '',NULL,NULL),(13,'Illinois','Illinois',_binary '',NULL,NULL),(14,'Indiana','Indiana',_binary '',NULL,NULL),(15,'Iowa','Iowa',_binary '',NULL,NULL),(16,'Kansas','Kansas',_binary '',NULL,NULL),(17,'Kentucky','Kentucky',_binary '',NULL,NULL),(18,'Louisiana','Louisiana',_binary '',NULL,NULL),(19,'Maine','Maine',_binary '',NULL,NULL),(20,'Maryland','Maryland',_binary '',NULL,NULL),(21,'Massachusetts','Massachusetts',_binary '',NULL,NULL),(22,'Michigan','Michigan',_binary '',NULL,NULL),(23,'Minnesota','Minnesota',_binary '',NULL,NULL),(24,'Mississippi','Mississippi',_binary '',NULL,NULL),(25,'Missouri','Missouri',_binary '',NULL,NULL),(26,'Montana','Montana',_binary '',NULL,NULL),(27,'Nebraska','Nebraska',_binary '',NULL,NULL),(28,'Nevada','Nevada',_binary '',NULL,NULL),(29,'New Hampshire','New Hampshire',_binary '',NULL,NULL),(30,'New Jersey','New Jersey',_binary '',NULL,NULL),(31,'New Mexico','New Mexico',_binary '',NULL,NULL),(32,'New York','New York',_binary '',NULL,NULL),(33,'North Carolina','North Carolina',_binary '',NULL,NULL),(34,'North Dakota','North Dakota',_binary '',NULL,NULL),(35,'Ohio','Ohio',_binary '',NULL,NULL),(36,'Oklahoma','Oklahoma',_binary '',NULL,NULL),(37,'Oregon','Oregon',_binary '',NULL,NULL),(38,'Pennsylvania','Pennsylvania',_binary '',NULL,NULL),(39,'Rhode Island','Rhode Island',_binary '',NULL,NULL),(40,'South Carolina','South Carolina',_binary '',NULL,NULL),(41,'South Dakota','South Dakota',_binary '',NULL,NULL),(42,'Tennessee','Tennessee',_binary '',NULL,NULL),(43,'Texas','Texas',_binary '',NULL,NULL),(44,'Utah','Utah',_binary '',NULL,NULL),(45,'Vermont','Vermont',_binary '',NULL,NULL),(46,'Virginia','Virginia',_binary '',NULL,NULL),(47,'Washington','Washington',_binary '',NULL,NULL),(48,'West Virginia','West Virginia',_binary '',NULL,NULL),(49,'Wisconsin','Wisconsin',_binary '',NULL,NULL),(50,'Wyoming','Wyoming',_binary '',NULL,NULL);
/*!40000 ALTER TABLE `enumusstatestype` ENABLE KEYS */;
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
