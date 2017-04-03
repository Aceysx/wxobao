-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: wxobao
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.10.1

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
-- Table structure for table `t_banner`
--

DROP TABLE IF EXISTS `t_banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_banner` (
  `banner_id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `show` int(11) DEFAULT '0',
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`banner_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_banner`
--

LOCK TABLES `t_banner` WRITE;
/*!40000 ALTER TABLE `t_banner` DISABLE KEYS */;
INSERT INTO `t_banner` VALUES (1,'1.jpg',NULL,1,NULL),(2,'2.jpg',NULL,1,NULL),(3,'3.jpg',NULL,1,NULL),(4,'4.jpg',NULL,1,NULL),(5,'5.jpg',NULL,0,NULL),(6,'6.jpg',NULL,0,NULL);
/*!40000 ALTER TABLE `t_banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_business`
--

DROP TABLE IF EXISTS `t_business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_business` (
  `business_id` int(11) NOT NULL AUTO_INCREMENT,
  `photo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `register_time` date DEFAULT NULL,
  `remark` date DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `domain_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`business_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_business`
--

LOCK TABLES `t_business` WRITE;
/*!40000 ALTER TABLE `t_business` DISABLE KEYS */;
INSERT INTO `t_business` VALUES (1,'th.jpg',NULL,NULL,'11755555','西安欧亚学院商业街',NULL,'2016-06-06',NULL,'北国之春',1),(2,'6755670_175428297196_2.jpg',NULL,NULL,'15932134','西安欧亚学院商业街',NULL,'2016-06-06',NULL,'黄焖鸡',1),(3,'5601_20130116180659554383_1.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,NULL,'豆浆坊',2),(4,'th.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,NULL,'四川宜宾小吃',3),(5,'6755670_175428297196_2.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,NULL,'大骨汤沙锅宴',3),(6,'6755670_175428297196_2.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,NULL,'四川担担面',3),(7,'5601_20130116180659554383_1.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,NULL,'重庆削面',4),(8,'th.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,NULL,'韩国料理',4);
/*!40000 ALTER TABLE `t_business` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_business_domain`
--

DROP TABLE IF EXISTS `t_business_domain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_business_domain` (
  `domain_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `remark` varchar(20) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`domain_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_business_domain`
--

LOCK TABLES `t_business_domain` WRITE;
/*!40000 ALTER TABLE `t_business_domain` DISABLE KEYS */;
INSERT INTO `t_business_domain` VALUES (1,'金桥餐厅',NULL,'thum2b.jpg'),(2,'餐饮大厦',NULL,'142997732509878352.jpg'),(3,'商业一街',NULL,'FonQGcLnWQhK11VqC-QOMIkXMElF.jpg'),(4,'商业二街',NULL,'thumb.jpg');
/*!40000 ALTER TABLE `t_business_domain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_business_item`
--

DROP TABLE IF EXISTS `t_business_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_business_item` (
  `business_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_id` int(11) DEFAULT NULL,
  `business_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`business_item_id`),
  KEY `FKAE4343A784C527C2` (`cart_id`),
  CONSTRAINT `FKAE4343A784C527C2` FOREIGN KEY (`cart_id`) REFERENCES `t_cart` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_business_item`
--

LOCK TABLES `t_business_item` WRITE;
/*!40000 ALTER TABLE `t_business_item` DISABLE KEYS */;
INSERT INTO `t_business_item` VALUES (38,1,3),(39,2,3),(40,2,2),(41,2,1);
/*!40000 ALTER TABLE `t_business_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_cart`
--

DROP TABLE IF EXISTS `t_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cart` (
  `cart_id` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cart`
--

LOCK TABLES `t_cart` WRITE;
/*!40000 ALTER TABLE `t_cart` DISABLE KEYS */;
INSERT INTO `t_cart` VALUES (1),(2);
/*!40000 ALTER TABLE `t_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_collect`
--

DROP TABLE IF EXISTS `t_collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_collect` (
  `collect_id` int(11) NOT NULL,
  `add_date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`collect_id`),
  KEY `FKF429545F995F43BD` (`product_id`),
  CONSTRAINT `FKF429545F995F43BD` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_collect`
--

LOCK TABLES `t_collect` WRITE;
/*!40000 ALTER TABLE `t_collect` DISABLE KEYS */;
INSERT INTO `t_collect` VALUES (80,'2017-02-01',1,169),(86,'2017-02-01',2,161);
/*!40000 ALTER TABLE `t_collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_flavor_and_product`
--

DROP TABLE IF EXISTS `t_flavor_and_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_flavor_and_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `flavor_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_flavor_and_product`
--

LOCK TABLES `t_flavor_and_product` WRITE;
/*!40000 ALTER TABLE `t_flavor_and_product` DISABLE KEYS */;
INSERT INTO `t_flavor_and_product` VALUES (1,151,'1'),(2,151,'2'),(3,160,'1'),(4,160,'2'),(5,151,'3');
/*!40000 ALTER TABLE `t_flavor_and_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_footprint`
--

DROP TABLE IF EXISTS `t_footprint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_footprint` (
  `foot_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  PRIMARY KEY (`foot_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_footprint`
--

LOCK TABLES `t_footprint` WRITE;
/*!40000 ALTER TABLE `t_footprint` DISABLE KEYS */;
INSERT INTO `t_footprint` VALUES (1,2,151,'2017-01-08 18:11:56'),(2,2,155,'2017-01-16 15:54:35'),(3,2,161,'2017-01-08 16:28:40'),(4,2,153,'2016-12-18 22:29:08'),(5,2,152,'2017-01-08 16:45:22'),(6,2,157,'2016-12-08 17:04:27'),(7,2,158,'2016-12-18 22:27:52'),(8,2,159,'2016-12-08 17:04:32'),(9,2,160,'2016-12-08 17:04:46'),(10,2,165,'2017-01-08 16:29:05'),(11,2,169,'2017-01-08 18:01:17'),(12,2,171,'2016-12-18 15:30:53'),(13,2,163,'2017-01-08 16:29:38'),(14,2,183,'2017-01-08 09:03:36'),(15,2,167,'2016-12-18 17:19:39'),(16,2,166,'2016-12-18 18:10:21'),(17,2,181,'2017-01-08 09:03:39'),(18,2,173,'2017-01-08 18:11:49'),(19,2,164,'2017-01-08 16:45:10'),(20,2,178,'2017-01-14 09:22:15');
/*!40000 ALTER TABLE `t_footprint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `order_number` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `deal_time` datetime DEFAULT NULL,
  `finish_time` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  `flavor` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (9,151,2,'c4aede5ad86e4bd7ae03a1c55c88dbd2','5206',1,NULL,NULL,'2005-10-22 12:20:00',0,'','中碗','微辣'),(8,151,2,'3f6fee8936334162a768d58f1904be85','0354',1,NULL,NULL,'2005-10-22 12:20:00',0,'haha','中碗','微辣'),(7,151,2,'ffddca6518dd4a5da4eb7ae054f8323f','0610',1,NULL,NULL,'2005-10-22 12:20:00',NULL,'哈哈','中碗','微辣'),(6,151,2,'8f0e7eb0b9c543ec8fdec4385242672a','8078',1,NULL,NULL,'2005-10-22 12:20:00',NULL,'哈哈','中碗','微辣'),(10,151,2,'f0fc16cb6b3a46a68329355c031011e3','5561',1,NULL,NULL,'2005-10-22 12:20:00',0,'','中碗','微辣'),(11,151,2,'d3cbda2544814c8498bb91352cf311fd','8116',1,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','微辣'),(12,151,2,'08cf90cb94db4a9ebed591bc708130e1','3124',1,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','微辣'),(13,151,2,'18308eb37293440a98628b7c0eb0cbd0','6932',1,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','微辣'),(14,151,2,'e36c1b2af0f44eb3b19402d57914cb03','0941',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(15,151,2,'55b725c6a0b04b7fb63ddf398ea8d35f','8430',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(16,151,2,'64bae0a6163e4a18b45251e95a17d295','6763',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(17,151,2,'1c9a9657fce849e59ab7b79a2e84d7d1','7645',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(18,151,2,'a2015fc2566f4e2e8d7177da1b879b33','6859',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(19,151,2,'2ceb54874fec47aba3ca228a28ca558f','7751',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(20,151,2,'1a55189af19d46198a3730327d07af24','5037',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(21,151,2,'8285f29309294fce8fd602af08e47b6f','5649',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(22,151,2,'930eb4c6c186454193de7ee6ff3cc847','2913',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(23,151,2,'fa2c1f5d670f4becb26c1d7fd9eb780d','4455',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(24,151,2,'9478c9d01c7b4794873150e7cf549ede','7885',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(25,151,2,'e1981fb7a535454a894278700ef780dd','0122',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(26,151,2,'ca79253b8b9f4276bfbf1814fe6bd72e','3925',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(27,151,2,'297eabd741da4ebea208b8ca01d8dd81','3383',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(28,151,2,'2e4a51c4ffc340cbb3e66b603a2e906d','8637',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(29,151,2,'2d34a5aea34b4519b7b8329c959e5760','6692',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(30,151,2,'b900c1894249412a8fc3ac3e106a7d9f','0678',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(31,151,2,'3e46ed50a7514dc8bf1f6527ac3baed8','1621',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(32,151,2,'e013809640c9463e8d4e9ad1756e17a1','5395',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(33,151,2,'ffd6345f6a5e4a64827226ae843a9d80','6926',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(34,151,2,'cbe104501e7e42208ec121cafe3dbb2b','5930',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(35,151,2,'dfc743ba85804aff8c8564a76008d670','1807',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(36,0,2,'4102d5a247c04769be4dfee6530214d2','3584',1,NULL,NULL,'2005-10-22 12:20:00',NULL,'','',''),(37,169,2,'38e4969681714d0583b6c6011cda7422','5015',4,NULL,NULL,'2005-10-22 12:20:00',NULL,'','',''),(38,169,2,'700ad67fa3c5464bbd920fb7a5a38b80','2710',4,NULL,NULL,'2005-10-22 12:20:00',NULL,'','',''),(39,169,2,'af3e0bc32d4042f9bcd33dbca372ab44','7104',4,NULL,NULL,'2005-10-22 12:20:00',NULL,'','',''),(40,169,2,'1b58c80b9bf4468797d0714b40cc75a4','4418',4,NULL,NULL,'2005-10-22 12:20:00',NULL,'','',''),(41,169,2,'280de947c80e47aa94a7287542dd535d','7285',4,NULL,NULL,'2005-10-22 12:20:00',NULL,'','',''),(42,169,2,'3d5d4188e6384bef9c1d7241082b0155','8746',4,NULL,NULL,'2005-10-22 12:20:00',NULL,'','',''),(43,169,2,'c99d05c635e8480e817ded0b907401b2','7802',4,NULL,NULL,'2005-10-22 12:20:00',NULL,'','',''),(44,169,2,'42846390167e4d958640f6254bf281bc','3037',4,NULL,NULL,'2005-10-22 12:20:00',NULL,'','',''),(45,151,2,'c881fb1b4a46494f829bc6ffd9575a99','7712',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(46,151,2,'48d715726d8c40a3b425ebc6dffdefbd','2815',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(47,151,2,'855b5d0b5e55490f939d0cde12c8af1f','5449',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(48,151,2,'a447bb551db844029ed4d41370f902ca','3649',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(49,151,2,'9e322c16826043e1bdac77ccb4743a22','1269',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(50,151,2,'d6353608391f4e0b8e43b9a9f2a5c192','1806',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(51,151,2,'6f9eb8309f784ea5b3609aed16fa0a5b','0086',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(52,151,2,'0af297a1d45e4fbea658f5fdee5db8a6','4495',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(53,151,2,'2b83318cd78140459a18309fa1b70202','8503',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜'),(54,151,2,'842d7baec12244e08c60cef39eef98f1','0804',5,NULL,NULL,'2005-10-22 12:20:00',NULL,'','中碗','三鲜');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(20) NOT NULL,
  `product_img` varchar(255) DEFAULT NULL,
  `product_details` longtext,
  `old_price` double DEFAULT NULL,
  `new_price` double DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `promotion` int(11) DEFAULT '0',
  `sales` int(11) DEFAULT '0',
  `business_id` int(11) DEFAULT NULL,
  `sort_id` int(11) DEFAULT NULL,
  `delivery_method` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (151,'烤肉饭','bc85939c-1fa4-4040-8454-08757e460a60.jpeg','培根咖喱饭是一道菜品，主料是培根、土豆（小个的）、红萝卜、紫洋葱、青豆、玉米粒，辅料是欧芹、牛头牌咖喱、牛奶、橄榄油。1、将土豆，烤肉切丁，如果是冻的青豆和玉米要提前解冻；\r\n2、炒锅内加橄榄油，放入葱花爆香，加入菜翻炒至6成熟；\r\n3、将菜盛入电饭锅内铺开；\r\n4、加入淘洗好的大米和水；\r\n5、按平时煮饭的程序开始煮饭；\r\n6、等电饭锅跳转至保温状态时，打开锅盖，翻拌一下米饭，再盖上锅盖继续保温状态5分钟左右即可。',20,12,'2016-05-06 12:00:20',0,'免配送费',1,200,1,1,NULL),(152,'牛版烤肉饭','0b4426a7-ba0e-48d7-b947-9e0095a54b16.jpeg','只有当你接触到床的那一刻，才会被前所未有的柔软打动。天丝般的爽滑质感，完美的设计，漂亮的色彩搭配。',20,13,'2016-05-06 12:00:20',0,'hehe',1,10,1,1,NULL),(153,'炒粉丝','6c339fea-56bb-41b2-a4ff-b7e667b33cbb.jpeg','只有当你接触到床的那一刻，才会被前所未有的柔软打动。天丝般的爽滑质感，完美的设计，漂亮的色彩搭配。',20,13,'2016-05-06 12:00:20',0,'hehe',1,50,1,1,NULL),(154,'蛋炒面','8cda1b28-5632-46c3-8487-c64a7f510adb.jpeg','\'151\', \'烤肉饭\', \'bc85939c-1fa4-4040-8454-08757e460a60.jpeg\', \'培根咖喱饭是一道菜品，主料是培根、土豆（小个的）、红萝卜、紫洋葱、青豆、玉米粒，辅料是欧芹、牛头牌咖喱、牛奶、橄榄油。1、将土豆，烤肉切丁，如果是冻的青豆和玉米要提前解冻；\\r\\n2、炒锅内加橄榄油，放入葱花爆香，加入菜翻炒至6成熟；\\r\\n3、将菜盛入电饭锅内铺开；\\r\\n4、加入淘洗好的大米和水；\\r\\n5、按平时煮饭的程序开始煮饭；\\r\\n6、等电饭锅跳转至保温状态时，打开锅盖，翻拌一下米饭，再盖上锅盖继续保温状态5分钟左右即可。\', \'20\', \'12\', \'2016-05-06 12:00:20\', \'0\', \'免配送费\', \'1\', \'200\', \'1\', \'1\', NULL\n',20,14,'2016-05-06 12:00:20',0,'hehe',0,21,2,1,NULL),(155,'金典快餐','55f5f89d-3e7f-4449-9cad-ebeea35b6cb7.jpeg','0',20,15,'2016-05-06 12:00:20',0,'hehe',1,122,2,1,NULL),(156,'牛肉汤面','80b4169f-82be-4d5a-b6e8-8d63bef88659.jpeg','0',20,3,'2016-05-06 12:00:20',0,'hehe',0,10,2,1,NULL),(157,'红烧快餐','4785a3c6-190a-4864-a7a8-e875039186a7.jpeg','0',20,8.6,'2016-05-06 12:00:20',0,'hehe',0,5,2,1,NULL),(158,'三鲜汤','8162d1a6-aef4-46a2-9798-d3ea6c549d11.jpeg','0',20,17,'2016-05-06 12:00:20',0,'hehe',1,1,3,1,NULL),(159,'老王烤肉饭','a7c0604c-26f0-45d4-8e7d-23f0608e64f3.jpeg','0',20,19,'2016-05-06 12:00:20',0,'hehe',0,55,3,1,NULL),(160,'沙拉烤肉饭','39089192-2f17-43fa-8b6d-86455e552c98.jpeg','0',20,12,'2016-05-06 12:00:20',0,'hehe',0,4,3,1,NULL),(161,'一口香快餐','335127ad-d4e4-4236-993d-47ea04869a7c.jpeg','0',20,9,'2016-05-06 12:00:20',0,'hehe',1,0,3,1,NULL),(162,'串串','bba9fc60-cecc-45b3-afda-9af61c408ecf.png','0',20,10,'2016-05-06 12:00:20',0,'hehe',0,9,3,1,NULL),(163,'三鲜快餐','c19417fa-094a-4656-8e4a-37a55591f3cd.jpeg','0',20,7,'2016-05-06 12:00:20',0,'hehe',0,89,4,1,NULL),(164,'丸子汤面','c5ed846a-a7d8-4b2a-9a38-6a9b1a4e0815.jpeg','0',20,12,'2016-05-06 12:00:20',0,'hehe',0,76,4,1,NULL),(165,'脆骨套餐','c3b09ac5-16fe-454f-bfcf-7902eb1c07e3.png','0',20,7,'2016-05-06 12:00:20',0,'hehe',0,34,4,1,NULL),(166,'烤肉番茄','ddf446e2-a0b6-454a-aead-ac79d8ec1641.jpeg','0',20,7.5,'2016-05-06 12:00:20',0,'hehe',0,22,4,1,NULL),(167,'烤肉米线','f3b6ca11-e077-4f5c-ae95-feb616ad409a.jpeg','0',20,6,'2016-05-06 12:00:20',0,'hehe',0,21,4,1,NULL),(168,'素汤快餐','f6cf07e1-06bc-4c48-a613-d667db3e6fe2.jpeg','0',20,6.5,'2016-05-06 12:00:20',0,'hehe',0,23,5,1,NULL),(169,'担担面','fd0f4622-6277-41ae-b519-e474e1c55e0a.jpeg','0',20,9,'2016-05-06 12:00:20',0,'hehe',0,87,5,1,NULL),(170,'岐山哨子面','c19417fa-094a-4656-8e4a-37a55591f3cd.jpeg',NULL,20,10,'2015-02-02 12:00:00',0,'00',0,54,5,1,NULL),(171,'山西面屋','dd86c2b6-7896-4c5d-8026-e28dd8ddbf87.jpeg',NULL,20,12,'2015-02-02 12:00:00',0,'00',0,59,5,1,NULL),(172,'山西担担面','bba9fc60-cecc-45b3-afda-9af61c408ecf.jpeg',NULL,22,13,'2016-01-01 12:00:00',11,'11',0,58,5,1,NULL),(173,'手工面','5bcca1a0-bfb6-40f9-8ed1-42730062a930.jpeg',NULL,22,14,'2016-01-01 12:00:00',0,'11',0,31,6,1,NULL),(174,'东北饺子','c5ed846a-a7d8-4b2a-9a38-6a9b1a4e0815.jpeg',NULL,13,22,'2016-01-01 12:00:00',1,'11',0,20,6,1,NULL),(175,'大盘鸡拌面','bf84cb5d-6323-4bea-9464-cd57d7798dba.jpeg',NULL,12,11,'2016-01-01 12:00:00',1,'11',0,2,6,1,NULL),(176,'烩麻什','7182d8a9-b4a3-4dbe-b0fa-8eefc5e0cfd6.jpeg',NULL,14,11,'2016-01-01 12:00:00',1,'11',0,0,6,1,NULL),(177,'油泼面','c5734a2a-e4f4-47c6-8a9c-9d26ec296886.jpeg',NULL,11,11,'2016-01-01 12:00:00',1,'11',0,11,8,1,NULL),(178,'汤圆醪糟','c5ed846a-a7d8-4b2a-9a38-6a9b1a4e0815.jpeg',NULL,4,11,'2016-01-01 12:00:00',1,'11',0,55,8,1,NULL),(179,'烤肉串','f43f99d9-c321-4b5a-8e9a-e1efdd65caeb.jpeg',NULL,7,11,'2016-01-01 12:00:00',1,'11',0,11,8,1,NULL),(180,'北国之春','f3b6ca11-e077-4f5c-ae95-feb616ad409a.jpeg',NULL,9,11,'2016-01-01 12:00:00',1,'11',0,26,8,1,NULL),(181,'鸡排','b298dddb-bdee-4726-9314-ebc622e4e465.jpeg',NULL,8,11,'2016-01-01 12:00:00',2,'11',0,16,7,1,NULL),(183,'鸡排套餐','26b5b13d-8d43-48e0-8be3-db5ae1dc41d7.jpeg',NULL,8,11,'2016-01-01 12:00:00',1,'1',0,11,7,1,NULL);
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_flavor`
--

DROP TABLE IF EXISTS `t_product_flavor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_flavor` (
  `flavor_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`flavor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_flavor`
--

LOCK TABLES `t_product_flavor` WRITE;
/*!40000 ALTER TABLE `t_product_flavor` DISABLE KEYS */;
INSERT INTO `t_product_flavor` VALUES (1,'特辣',''),(2,'微辣',NULL),(3,'不辣',NULL);
/*!40000 ALTER TABLE `t_product_flavor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_item`
--

DROP TABLE IF EXISTS `t_product_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_item` (
  `product_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_number` int(11) DEFAULT '1',
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `business_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `flavor_and_product` varchar(255) DEFAULT NULL,
  `size_and_product` varchar(255) DEFAULT NULL,
  `business_item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_item_id`),
  KEY `FK1792EA4EF361B143` (`business_item_id`),
  CONSTRAINT `FK1792EA4EF361B143` FOREIGN KEY (`business_item_id`) REFERENCES `t_business_item` (`business_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_item`
--

LOCK TABLES `t_product_item` WRITE;
/*!40000 ALTER TABLE `t_product_item` DISABLE KEYS */;
INSERT INTO `t_product_item` VALUES (5,NULL,NULL,NULL,NULL,0,NULL,NULL,NULL),(6,5,178,2,8,11,'','',NULL);
/*!40000 ALTER TABLE `t_product_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_size`
--

DROP TABLE IF EXISTS `t_product_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_size` (
  `size_id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_size`
--

LOCK TABLES `t_product_size` WRITE;
/*!40000 ALTER TABLE `t_product_size` DISABLE KEYS */;
INSERT INTO `t_product_size` VALUES (1,'big',''),(2,'middle',''),(3,'small',NULL);
/*!40000 ALTER TABLE `t_product_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_size2`
--

DROP TABLE IF EXISTS `t_product_size2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_size2` (
  `size_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_size2`
--

LOCK TABLES `t_product_size2` WRITE;
/*!40000 ALTER TABLE `t_product_size2` DISABLE KEYS */;
INSERT INTO `t_product_size2` VALUES (1,151,'大碗',10,NULL),(2,151,'小碗',9,NULL),(3,151,'中碗',8,NULL);
/*!40000 ALTER TABLE `t_product_size2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_sort`
--

DROP TABLE IF EXISTS `t_product_sort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_sort` (
  `sort_id` int(11) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sort_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_sort`
--

LOCK TABLES `t_product_sort` WRITE;
/*!40000 ALTER TABLE `t_product_sort` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product_sort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_size_and_product`
--

DROP TABLE IF EXISTS `t_size_and_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_size_and_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `size_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_size_and_product`
--

LOCK TABLES `t_size_and_product` WRITE;
/*!40000 ALTER TABLE `t_size_and_product` DISABLE KEYS */;
INSERT INTO `t_size_and_product` VALUES (1,151,1,10),(2,151,2,8),(3,151,3,6),(4,161,1,5),(5,161,2,4);
/*!40000 ALTER TABLE `t_size_and_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'Acey','okKFnwgrhDM5FcZrXZGBOswyjEug',1,'湖北','http://wx.qlogo.cn/mmopen/VEy0J95tVsica6fic74EMMiaxQDfN9zNdib14kLG6aYrQTJBuSkMQud84VqxRSic5Ir5ac3oPvibqKK0ViczqbRIousSiaTkn5dnmZM8/0',NULL,NULL),(2,'依旧如初','okKFnwhz4nU90g3bUtGJHQnstWJ8',1,'陕西','http://wx.qlogo.cn/mmopen/3Xf0qNWCOt4rSTXxsPbkvibSseib6x7eicrO3nOzJEdIMnpKBG9hyAR21ypuI8SermHnhsGib3aY3zNu59V8gGwHF3YaxIuNtjbv/0',NULL,NULL),(3,'conntion','okKFnwlWEsINBAhGu6j_tN38cVe8',1,'陕西','http://wx.qlogo.cn/mmopen/3Xf0qNWCOt4rSTXxsPbkv8RHHISmYYZGrjk9ibWlEXOajphsAHWoPMOSibyg9tzVZgLYueYY6k0mDmw5szEPPwt4O50dqRAWab/0',NULL,NULL),(4,'(x-a)²+(y-b)²=r²','okKFnwhdTiYd2vIAkHfmcCBqGfOg',1,'陕西','http://wx.qlogo.cn/mmopen/PiajxSqBRaEJgjeThuYY0TTcUEJnyIMd4mNzI4hhselSw59oraeibVDgtkyFicE72uOxsLTRt6Jsy0kicGoTvxjcicA/0',NULL,NULL),(5,'Freewind','okKFnwhkmEnwRXNNmW2Vs33_FNkw',1,'湖北','http://wx.qlogo.cn/mmopen/CTb9ibcW3a8UXTGEiapW93BskTvxI8tRnjSOIm3ibaOhJLu7SM3PCWcRgSmXNRpiaoFsE4k5mRCheGaLOReKOibq6rBYF2iaSVRnwL/0',NULL,NULL),(6,'Seaborn Lee','okKFnwseLK2PlGZMQesUiCtFhMeI',1,'四川','http://wx.qlogo.cn/mmopen/1W6qZTicicdwVPl8QA1R2Zh9FEkRDAscba8YJKkibXLpxndqVG4HZeQicuKmPpgxdHKDTzDOzSfUZrvkInVY7qPD7d82IwnE7zsH/0',NULL,NULL),(7,'仝键','okKFnwgeUx-xKqWTlk6JUcKsiNcY',1,'北京','http://wx.qlogo.cn/mmopen/VEy0J95tVsica6fic74EMMia5n1OQ8zrIF9XX00Czm8B3N5OexGuPGjTxw9rnsIBNicSnPDXBN28xSvpWeWZIvTARLPibvmWiaPUVQ/0',NULL,NULL),(8,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-07 16:41:54
