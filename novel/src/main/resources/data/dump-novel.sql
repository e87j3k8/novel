-- MySQL dump 10.16  Distrib 10.2.34-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: webnovel
-- ------------------------------------------------------
-- Server version	10.2.34-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_genrecode`
--

DROP TABLE IF EXISTS `tb_genrecode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_genrecode` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `genreNm` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_genrecode`
--

LOCK TABLES `tb_genrecode` WRITE;
/*!40000 ALTER TABLE `tb_genrecode` DISABLE KEYS */;
INSERT INTO `tb_genrecode` VALUES (1,'로맨스'),(2,'호러'),(3,'SF'),(4,'판타지');
/*!40000 ALTER TABLE `tb_genrecode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_items`
--

DROP TABLE IF EXISTS `tb_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_items` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `subtitle` varchar(100) NOT NULL DEFAULT '',
  `content` longtext DEFAULT '',
  `regDt` datetime NOT NULL,
  `novelId` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_items_FK` (`novelId`),
  CONSTRAINT `tb_items_FK` FOREIGN KEY (`novelId`) REFERENCES `tb_novel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_items`
--

LOCK TABLES `tb_items` WRITE;
/*!40000 ALTER TABLE `tb_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_novel`
--

DROP TABLE IF EXISTS `tb_novel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_novel` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `author` int(10) NOT NULL,
  `title` varchar(100) NOT NULL,
  `genre1` int(3) NOT NULL,
  `genre2` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_novel_FK` (`author`),
  KEY `tb_novel_FK_1` (`genre1`),
  KEY `tb_novel_FK_2` (`genre2`),
  CONSTRAINT `tb_novel_FK` FOREIGN KEY (`author`) REFERENCES `tb_user` (`id`),
  CONSTRAINT `tb_novel_FK_1` FOREIGN KEY (`genre1`) REFERENCES `tb_genrecode` (`id`),
  CONSTRAINT `tb_novel_FK_2` FOREIGN KEY (`genre2`) REFERENCES `tb_genrecode` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_novel`
--

LOCK TABLES `tb_novel` WRITE;
/*!40000 ALTER TABLE `tb_novel` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_novel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_recommend`
--

DROP TABLE IF EXISTS `tb_recommend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_recommend` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `novelId` int(10) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  `userBy` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_recommend_FK_1` (`userBy`),
  CONSTRAINT `tb_recommend_FK` FOREIGN KEY (`id`) REFERENCES `tb_novel` (`id`),
  CONSTRAINT `tb_recommend_FK_1` FOREIGN KEY (`userBy`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_recommend`
--

LOCK TABLES `tb_recommend` WRITE;
/*!40000 ALTER TABLE `tb_recommend` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_recommend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nick` varchar(100) NOT NULL,
  `regDt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_view`
--

DROP TABLE IF EXISTS `tb_view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_view` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `itemId` int(10) NOT NULL,
  `userBy` int(10) NOT NULL DEFAULT 0,
  `Dt` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tb_view_FK` (`itemId`),
  CONSTRAINT `tb_view_FK` FOREIGN KEY (`itemId`) REFERENCES `tb_items` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_view`
--

LOCK TABLES `tb_view` WRITE;
/*!40000 ALTER TABLE `tb_view` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_view` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'webnovel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-17  0:10:31
