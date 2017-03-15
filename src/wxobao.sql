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
  `product_id` int(11) NOT NULL,
  `add_time` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `show` int(11) DEFAULT '0',
  PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_banner`
--

LOCK TABLES `t_banner` WRITE;
/*!40000 ALTER TABLE `t_banner` DISABLE KEYS */;
INSERT INTO `t_banner` VALUES (1,159,'2017-03-21 13:34:55','1.jpg',1),(2,160,'2017-03-21 13:34:55','2.jpg',1),(3,161,'2017-03-21 13:34:55','3.jpg',1),(4,162,'2017-03-21 13:34:55','4.jpg',1);
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
  `remark` varchar(20) DEFAULT NULL,
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
INSERT INTO `t_business` VALUES (1,'th.jpg',NULL,NULL,'11755555','西安欧亚学院商业街',NULL,'2016-06-06','炒菜','北国之春',1),(2,'6755670_175428297196_2.jpg',NULL,NULL,'15932134','西安欧亚学院商业街',NULL,'2016-06-06','黄焖鸡','黄焖鸡',1),(3,'5601_20130116180659554383_1.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,'豆浆','豆浆坊',2),(4,'th.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,'炒米','四川宜宾小吃',3),(5,'6755670_175428297196_2.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,'大骨汤','大骨汤沙锅宴',3),(6,'6755670_175428297196_2.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,'面面','四川担担面',3),(7,'5601_20130116180659554383_1.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,'刀削面','重庆削面',4),(8,'th.jpg',NULL,NULL,'029-2652342','西安欧亚学院商业街',NULL,NULL,'韩国','韩国料理',4);
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
-- Table structure for table `t_cart`
--

DROP TABLE IF EXISTS `t_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cart` (
  `cart_id` varchar(255) NOT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cart`
--

LOCK TABLES `t_cart` WRITE;
/*!40000 ALTER TABLE `t_cart` DISABLE KEYS */;
INSERT INTO `t_cart` VALUES ('0bcc6a8389b04d4e9ff926b0783eff81'),('0ec99c64a0a449a1a5ef9bd5f47288e5'),('1345209c67b94d0a8823851c07a4749b'),('23d231aa070746f19ad50ab561e48b33'),('370325851ff64ca8951b7018615623b9'),('382245cc4fa1483daf488a5c24e25bb5'),('39b9d34bd80a4529b4a85704d4710d81'),('4294fb2f4e1e48edb8be6ab0423a2ef3'),('49de70bc283e4fef860ead3126a1949e'),('6e2bd5bd2dc844f69f83d94b52bb89bf'),('705a485b7bd8409c815fb9df8175acb2'),('7413a9d5b5ad466a8822f0eef8b30948'),('7fbe6733655b4ffba66a7801b69b8d79'),('81f1c05785b04ae5bab76585a7c27dbd'),('940923b0f5344a37b61a0abc9271feb5'),('97046c8268c045fcba8aab531c17f0c1'),('aa0c407ab7a645fa843e6eb5633832ea'),('b5a9271cc479405bb19afb4e753e1207'),('b6078046a4424c0992dfbe9229dc2850'),('b93626decc4d4b7d8d13e389708f4591'),('bf8f7c3be9b44c9280cd799d35314ed5'),('cec4a8a6312c4d53bdd6559401c3d70f'),('cf80c86995a74e4ea2ca504959c6f988'),('d7fd005491724e61a72accaf536b7eba'),('dead9418d50345e3b4944a2d70e52c12'),('fdc2849954dd4943ad0bde106bceabeb');
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
  `user_id` varchar(255) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`collect_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_collect`
--

LOCK TABLES `t_collect` WRITE;
/*!40000 ALTER TABLE `t_collect` DISABLE KEYS */;
INSERT INTO `t_collect` VALUES (5,'2017-03-05','b6078046a4424c0992dfbe9229dc2850',161),(7,'2017-03-06','b6078046a4424c0992dfbe9229dc2850',151),(10,'2017-03-07','bf8f7c3be9b44c9280cd799d35314ed5',164),(12,'2017-03-07','0bcc6a8389b04d4e9ff926b0783eff81',151),(13,'2017-03-07','370325851ff64ca8951b7018615623b9',161),(22,'2017-03-07','0bcc6a8389b04d4e9ff926b0783eff81',165),(23,'2017-03-07','0bcc6a8389b04d4e9ff926b0783eff81',166),(24,'2017-03-07','0bcc6a8389b04d4e9ff926b0783eff81',175),(26,'2017-03-07','6e2bd5bd2dc844f69f83d94b52bb89bf',151),(27,'2017-03-07','0bcc6a8389b04d4e9ff926b0783eff81',169),(35,'2017-03-07','\'',151),(36,'2017-03-07','\'',170),(37,'2017-03-07','7413a9d5b5ad466a8822f0eef8b30948',153),(38,'2017-03-07','7413a9d5b5ad466a8822f0eef8b30948',164),(39,'2017-03-07','dead9418d50345e3b4944a2d70e52c12',172),(41,'2017-03-07','7413a9d5b5ad466a8822f0eef8b30948',161),(42,'2017-03-07','\'',179),(43,'2017-03-07','dead9418d50345e3b4944a2d70e52c12',159),(48,'2017-03-07','705a485b7bd8409c815fb9df8175acb2',151),(50,'2017-03-07','b93626decc4d4b7d8d13e389708f4591',151),(51,'2017-03-07','6e2bd5bd2dc844f69f83d94b52bb89bf',166),(53,'2017-03-07','0bcc6a8389b04d4e9ff926b0783eff81',164),(61,'2017-03-07','7413a9d5b5ad466a8822f0eef8b30948',155);
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
  `classifys` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
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
INSERT INTO `t_product` VALUES (151,'烤肉饭','bc85939c-1fa4-4040-8454-08757e460a60.jpeg','',20,12,'2016-05-06 12:00:20',0,'培根咖喱饭是一道菜品，主料是培根、土豆（小个的）、红萝卜、紫洋葱、青豆、玉米粒，辅料是欧芹、牛头牌咖喱、牛奶、橄榄油。1、将土豆，烤肉切丁，如果是冻的青豆和玉米要提前解冻；\r\n2、炒锅内加橄榄油，放入葱花爆香，加入菜翻炒至6成熟；\r\n3、将菜盛入电饭锅内铺开；\r\n4、加入淘洗好的大米和水；\r\n5、按平时煮饭的程序开始煮饭；\r\n6、等电饭锅跳转至保温状态时，打开锅盖，翻拌一下米饭，再盖上锅盖继续保温状态5分钟左右即可。',1,200,1,1,NULL),(152,'牛版烤肉饭','0b4426a7-ba0e-48d7-b947-9e0095a54b16.jpeg','',20,13,'2016-05-06 12:00:20',0,'只有当你接触到床的那一刻，才会被前所未有的柔软打动。天丝般的爽滑质感，完美的设计，漂亮的色彩搭配。',1,10,1,1,NULL),(153,'炒粉丝','6c339fea-56bb-41b2-a4ff-b7e667b33cbb.jpeg','',20,13,'2016-05-06 12:00:20',0,'只有当你接触到床的那一刻，才会被前所未有的柔软打动。天丝般的爽滑质感，完美的设计，漂亮的色彩搭配。',1,50,1,1,NULL),(154,'蛋炒面','8cda1b28-5632-46c3-8487-c64a7f510adb.jpeg','\'151\', \'烤肉饭\', \'bc85939c-1fa4-4040-8454-08757e460a60.jpeg\', \'培根咖喱饭是一道菜品，主料是培根、土豆（小个的）、红萝卜、紫洋葱、青豆、玉米粒，辅料是欧芹、牛头牌咖喱、牛奶、橄榄油。1、将土豆，烤肉切丁，如果是冻的青豆和玉米要提前解冻；\\r\\n2、炒锅内加橄榄油，放入葱花爆香，加入菜翻炒至6成熟；\\r\\n3、将菜盛入电饭锅内铺开；\\r\\n4、加入淘洗好的大米和水；\\r\\n5、按平时煮饭的程序开始煮饭；\\r\\n6、等电饭锅跳转至保温状态时，打开锅盖，翻拌一下米饭，再盖上锅盖继续保温状态5分钟左右即可。\', \'20\', \'12\', \'2016-05-06 12:00:20\', \'0\', \'免配送费\', \'1\', \'200\', \'1\', \'1\', NULL\n',20,14,'2016-05-06 12:00:20',0,'hehe',0,21,2,1,NULL),(155,'金典快餐','55f5f89d-3e7f-4449-9cad-ebeea35b6cb7.jpeg','0',20,15,'2016-05-06 12:00:20',0,'hehe',1,122,2,1,NULL),(156,'牛肉汤面','80b4169f-82be-4d5a-b6e8-8d63bef88659.jpeg','0',20,3,'2016-05-06 12:00:20',0,'hehe',0,10,2,1,NULL),(157,'红烧快餐','4785a3c6-190a-4864-a7a8-e875039186a7.jpeg','0',20,8.6,'2016-05-06 12:00:20',0,'hehe',0,5,2,1,NULL),(158,'三鲜汤','8162d1a6-aef4-46a2-9798-d3ea6c549d11.jpeg','0',20,17,'2016-05-06 12:00:20',0,'hehe',1,1,3,1,NULL),(159,'老王烤肉饭','a7c0604c-26f0-45d4-8e7d-23f0608e64f3.jpeg','0',20,19,'2016-05-06 12:00:20',0,'hehe',0,55,3,1,NULL),(160,'沙拉烤肉饭','39089192-2f17-43fa-8b6d-86455e552c98.jpeg','0',20,12,'2016-05-06 12:00:20',0,'hehe',0,4,3,1,NULL),(161,'一口香快餐','335127ad-d4e4-4236-993d-47ea04869a7c.jpeg','0',20,9,'2016-05-06 12:00:20',0,'hehe',1,0,3,1,NULL),(162,'串串','bba9fc60-cecc-45b3-afda-9af61c408ecf.png','0',20,10,'2016-05-06 12:00:20',0,'hehe',0,9,3,1,NULL),(163,'三鲜快餐','c19417fa-094a-4656-8e4a-37a55591f3cd.jpeg','0',20,7,'2016-05-06 12:00:20',0,'hehe',0,89,4,1,NULL),(164,'丸子汤面','c5ed846a-a7d8-4b2a-9a38-6a9b1a4e0815.jpeg','0',20,12,'2016-05-06 12:00:20',0,'hehe',0,76,4,1,NULL),(165,'脆骨套餐','c3b09ac5-16fe-454f-bfcf-7902eb1c07e3.png','0',20,7,'2016-05-06 12:00:20',0,'hehe',0,34,4,1,NULL),(166,'烤肉番茄','ddf446e2-a0b6-454a-aead-ac79d8ec1641.jpeg','0',20,7.5,'2016-05-06 12:00:20',0,'hehe',0,22,4,1,NULL),(167,'烤肉米线','f3b6ca11-e077-4f5c-ae95-feb616ad409a.jpeg','0',20,6,'2016-05-06 12:00:20',0,'hehe',0,21,4,1,NULL),(168,'素汤快餐','f6cf07e1-06bc-4c48-a613-d667db3e6fe2.jpeg','0',20,6.5,'2016-05-06 12:00:20',0,'hehe',0,23,5,1,NULL),(169,'担担面','fd0f4622-6277-41ae-b519-e474e1c55e0a.jpeg','0',20,9,'2016-05-06 12:00:20',0,'hehe',0,87,5,1,NULL),(170,'岐山哨子面','c19417fa-094a-4656-8e4a-37a55591f3cd.jpeg',NULL,20,10,'2015-02-02 12:00:00',0,'00',0,54,5,1,NULL),(171,'山西面屋','dd86c2b6-7896-4c5d-8026-e28dd8ddbf87.jpeg',NULL,20,12,'2015-02-02 12:00:00',0,'00',0,59,5,1,NULL),(172,'山西担担面','bba9fc60-cecc-45b3-afda-9af61c408ecf.jpeg',NULL,22,13,'2016-01-01 12:00:00',11,'11',0,58,5,1,NULL),(173,'手工面','5bcca1a0-bfb6-40f9-8ed1-42730062a930.jpeg',NULL,22,14,'2016-01-01 12:00:00',0,'11',0,31,6,1,NULL),(174,'东北饺子','c5ed846a-a7d8-4b2a-9a38-6a9b1a4e0815.jpeg',NULL,13,22,'2016-01-01 12:00:00',1,'11',0,20,6,1,NULL),(175,'大盘鸡拌面','bf84cb5d-6323-4bea-9464-cd57d7798dba.jpeg',NULL,12,11,'2016-01-01 12:00:00',1,'11',0,2,6,1,NULL),(176,'烩麻什','7182d8a9-b4a3-4dbe-b0fa-8eefc5e0cfd6.jpeg',NULL,14,11,'2016-01-01 12:00:00',1,'11',0,0,6,1,NULL),(177,'油泼面','c5734a2a-e4f4-47c6-8a9c-9d26ec296886.jpeg',NULL,11,11,'2016-01-01 12:00:00',1,'11',0,11,8,1,NULL),(178,'汤圆醪糟','c5ed846a-a7d8-4b2a-9a38-6a9b1a4e0815.jpeg',NULL,4,11,'2016-01-01 12:00:00',1,'11',0,55,8,1,NULL),(179,'烤肉串','f43f99d9-c321-4b5a-8e9a-e1efdd65caeb.jpeg',NULL,7,11,'2016-01-01 12:00:00',1,'11',0,11,8,1,NULL),(180,'北国之春','f3b6ca11-e077-4f5c-ae95-feb616ad409a.jpeg',NULL,9,11,'2016-01-01 12:00:00',1,'11',0,26,8,1,NULL),(181,'鸡排','b298dddb-bdee-4726-9314-ebc622e4e465.jpeg',NULL,8,11,'2016-01-01 12:00:00',2,'11',0,16,7,1,NULL),(183,'鸡排套餐','26b5b13d-8d43-48e0-8be3-db5ae1dc41d7.jpeg',NULL,8,11,'2016-01-01 12:00:00',1,'1',0,11,7,1,NULL);
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
-- Table structure for table `t_product_imgs`
--

DROP TABLE IF EXISTS `t_product_imgs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_imgs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_imgs`
--

LOCK TABLES `t_product_imgs` WRITE;
/*!40000 ALTER TABLE `t_product_imgs` DISABLE KEYS */;
INSERT INTO `t_product_imgs` VALUES (1,151,'__41690758__6455042.jpg'),(2,151,'__41690831__9070955.jpg'),(3,151,'__41690725__4401885.jpg'),(4,152,'T2zfdmXe0bXXXXXXXX_!!918858019.jpg'),(5,152,'TB1cutrKpXXXXX4XXXXXXXXXXXX_!!0-item_pic.jpg'),(6,152,'TB1gwoHNpXXXXasXXXXXXXXXXXX_!!0-item_pic.jpg'),(7,153,'TB1i6OrKXXXXXbZXVXXXXXXXXXX_!!0-item_pic.jpg'),(8,153,'TB1iewFOpXXXXcoXpXXXXXXXXXX_!!0-item_pic.jpg'),(9,153,'TB1mMobLFXXXXXRXVXXXXXXXXXX_!!0-item_pic.jpg'),(10,154,'TB1puFBJVXXXXXUXFXXXXXXXXXX_!!0-item_pic.jpg'),(11,154,'TB1zhwtIVXXXXcLXFXXXXXXXXXX_!!0-item_pic.jpg'),(12,154,'TB2.JE9chBmpuFjSZFsXXcXpFXa_!!489839052.jpg'),(13,155,'TB2_7N9bSiJ.eBjSspfXXbBKFXa_!!555064954.jpg'),(14,155,'TB2_ru7dFOP.eBjSZFHXXXQnpXa_!!17064307.jpg'),(15,155,'TB2A_68d80lpuFjSszdXXcdxFXa_!!489839052.jpg'),(16,156,'TB2a0fOaCzC11BjSszhXXbGVFXa_!!2688686419.jpg'),(17,156,'TB2aRY3XyYC11Bjy1zbXXbYLFXa_!!2645296951.jpg'),(18,156,'TB2b_d7tXXXXXbgXpXXXXXXXXXX_!!825119671.jpg'),(19,157,'TB2b8JDnFXXXXbFXpXXXXXXXXXX_!!1021513046.jpg'),(20,157,'TB2BRNMa90jpuFjy0FlXXc0bpXa_!!2761753104.jpg'),(21,157,'TB2bU3rfmtkpuFjy0FhXXXQzFXa_!!95211642.jpg'),(22,158,'TB2BuRsflNkpuFjy0FaXXbRCVXa_!!918858019.jpg'),(23,158,'TB2C5QWtVXXXXaBXpXXXXXXXXXX_!!90913538.jpg'),(24,158,'TB2CeJDbF5N.eBjSZFmXXboSXXa_!!918858019.jpg'),(25,159,'TB2cyvcbB8lpuFjy0FnXXcZyXXa_!!183260906.jpg'),(26,159,'TB2DLKhefSM.eBjSZFNXXbgYpXa_!!2645296951.jpg'),(27,159,'TB2ef7VaK2yQeBjSszhXXcgeVXa_!!183260906.jpg'),(28,160,'TB2EgqkXbMc61BjSZPiXXavgXXa_!!378880731.jpg'),(29,160,'TB2evACfbXlpuFjy1zbXXb_qpXa_!!95211642 (1).jpg'),(30,160,'TB2evACfbXlpuFjy1zbXXb_qpXa_!!95211642.jpg'),(31,161,'TB2f4fnoFXXXXcPXpXXXXXXXXXX_!!42976212 (1).jpg'),(32,161,'TB2f4fnoFXXXXcPXpXXXXXXXXXX_!!42976212.jpg'),(33,161,'TB2fas0XCwp41Bjy1zbXXbyppXa_!!2688686419.jpg'),(34,162,'TB2FN7mdxeK.eBjSZFlXXaywXXa_!!828401607.jpg'),(35,162,'TB2frcnX3xlpuFjy0FoXXa.lXXa_!!89511120.jpg'),(36,162,'TB2gesZgHJmpuFjSZFwXXaE4VXa_!!17064307.jpg'),(37,163,'TB2Gjb4hVXXXXcNXXXXXXXXXXXX_!!204553836.jpg'),(38,163,'TB2gnTquXXXXXahXpXXXXXXXXXX_!!2761753104.jpg'),(39,163,'TB2H3X7bNeI.eBjSsplXXX6GFXa_!!555064954.jpg'),(40,164,'TB2H4ApspXXXXbGXpXXXXXXXXXX_!!644216784.jpg'),(41,164,'TB2HHLhgVXXXXcCXXXXXXXXXXXX_!!86813790.jpg'),(42,164,'TB2IVy2aH4npuFjSZFmXXXl4FXa_!!86813790.jpg'),(43,165,'TB2JS3QaNjxQeBjSspcXXcQlXXa_!!183260906.jpg'),(44,165,'TB2KEhNalNkpuFjy0FaXXbRCVXa_!!544346393.jpg'),(45,165,'TB2kHnfXtfB11BjSspmXXctQVXa_!!1040553166.jpg'),(46,166,'TB2kjW_cCiJ.eBjSspiXXbqAFXa_!!86813790.jpg'),(47,166,'TB2KtFVbrJmpuFjSZFBXXXaZXXa_!!2705663075.jpg'),(48,166,'TB2kUe5XEhnpuFjSZFEXXX0PFXa_!!89511120.jpg'),(49,167,'TB2l.oWXnPC11Bjy1zcXXbTrVXa_!!89511120.jpg'),(50,167,'TB2LF.lppXXXXarXXXXXXXXXXXX_!!378880731.jpg'),(51,167,'TB2lgAStVXXXXa0XpXXXXXXXXXX_!!90913538.jpg'),(52,168,'TB2LkFQamxjpuFjSszeXXaeMVXa_!!544346393.jpg'),(53,168,'TB2LX6KqVXXXXb4XpXXXXXXXXXX_!!90958157.jpg'),(54,168,'TB2mlDfXuvB11BjSspnXXbE.pXa_!!1040553166.jpg'),(55,169,'TB2n7mXnFXXXXXSXXXXXXXXXXXX_!!1021513046.jpg'),(56,169,'TB2NAIdcFXXXXXOXpXXXXXXXXXX_!!95211642.jpg'),(57,169,'TB2NfRdg5pnpuFjSZFIXXXh2VXa_!!17064307.jpg'),(58,170,'TB2NJnksVXXXXXFXXXXXXXXXXXX_!!378880731.jpg'),(59,170,'TB2No1SabVkpuFjSspcXXbSMVXa_!!828401607.jpg'),(60,170,'TB2nPDxbSqJ.eBjy1zbXXbx8FXa_!!86813790.jpg'),(61,171,'TB2Npz5cCiJ.eBjSspoXXcpMFXa_!!544346393.jpg'),(62,171,'TB2NWLiXZgd61BjSZFpXXcaSVXa_!!2688686419.jpg'),(63,171,'TB2O5vQqVXXXXbcXpXXXXXXXXXX_!!90958157.jpg'),(64,172,'TB2Oe19epXXXXXfXXXXXXXXXXXX_!!42976212.jpg'),(65,172,'TB2OeIufl0kpuFjy1zdXXXuUVXa_!!95211642 (1).jpg'),(66,172,'TB2OeIufl0kpuFjy1zdXXXuUVXa_!!95211642.jpg'),(67,173,'TB2OgCVcq9I.eBjy0FeXXXqwFXa_!!86813790.jpg'),(68,173,'TB2Ot4LXWbyQeBjy1XbXXa9yXXa_!!825119671.jpg'),(69,173,'TB2Q6tIhFXXXXcwXXXXXXXXXXXX_!!114595520.jpg'),(70,174,'TB2qhWnaSCI.eBjy1XbXXbUBFXa_!!2361057734.jpg'),(71,174,'TB2QTe.dMCN.eBjSZFoXXXj0FXa_!!17064307.jpg'),(72,174,'TB2R7pccmFmpuFjSZFrXXayOXXa_!!489839052.jpg'),(73,175,'TB2SClWbrBmpuFjSZFuXXaG_XXa_!!2705663075.jpg'),(74,175,'TB2SFt.a8aM.eBjSZFMXXcypVXa_!!2361057734.jpg'),(75,176,'TB2SlXYnFXXXXb3XXXXXXXXXXXX_!!1021513046.jpg'),(76,176,'TB2T3iRtXXXXXXEXXXXXXXXXXXX_!!825119671.jpg'),(77,176,'TB2u94lbSFjpuFjSspbXXXagVXa_!!1646916039 (1).jpg'),(78,177,'TB2u94lbSFjpuFjSspbXXXagVXa_!!1646916039.jpg'),(79,177,'TB2UoWlkFXXXXXlXXXXXXXXXXXX_!!2622548699.jpg'),(80,177,'TB2uTImbtAvbeFjSspbXXbcOFXa_!!114595520.jpg'),(81,178,'TB2voDfdRaM.eBjSZFMXXcypVXa_!!17064307.jpg'),(82,178,'TB2vZlicrBmpuFjSZFAXXaQ0pXa_!!489839052.jpg'),(83,178,'TB2w..mb0BopuFjSZPcXXc9EpXa_!!1646916039.jpg'),(84,179,'TB2W_KGepXXXXbpXpXXXXXXXXXX_!!42976212.jpg'),(85,179,'TB2wk6rXCtkpuFjy0FhXXXQzFXa_!!89511120.jpg'),(86,179,'TB2wzH8hVXXXXb.XXXXXXXXXXXX_!!204553836.jpg'),(87,180,'TB2YDZnqXXXXXafXFXXXXXXXXXX_!!2761753104.jpg'),(88,180,'TB2ypd7XIwX61BjSspaXXXLrpXa_!!114595520.jpg'),(89,180,'TB2Yqeca9mK.eBjSZPfXXce2pXa_!!2361057734.jpg'),(90,181,'TB2YVQndpOP.eBjSZFHXXXQnpXa_!!828401607.jpg'),(91,181,'TB2YZRLkFXXXXa5XpXXXXXXXXXX_!!2622548699.jpg'),(92,181,'TB2ZfSbaH1J.eBjSszcXXbFzVXa_!!2361057734.jpg'),(93,182,'TB2zFSvsVXXXXclXpXXXXXXXXXX_!!378880731.jpg'),(94,182,'TB2zG5RepXXXXXeXpXXXXXXXXXX_!!42976212.jpg'),(95,182,'TB2zHqhcXOP.eBjSZFHXXXQnpXa_!!86813790.jpg'),(96,183,'TB2zUMBpXXXXXavXXXXXXXXXXXX_!!86813790.jpg'),(97,183,'TB2ZxyYcr5K.eBjy0FfXXbApVXa_!!86813790.jpg'),(98,183,'TB10X0rHVXXXXcvXXXXXXXXXXXX_!!0-item_pic (1).jpg'),(99,175,'TB10X0rHVXXXXcvXXXXXXXXXXXX_!!0-item_pic.jpg');
/*!40000 ALTER TABLE `t_product_imgs` ENABLE KEYS */;
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
  `user_id` varchar(255) DEFAULT NULL,
  `business_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `flavor_and_product` varchar(255) DEFAULT NULL,
  `size_and_product` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`product_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_item`
--

LOCK TABLES `t_product_item` WRITE;
/*!40000 ALTER TABLE `t_product_item` DISABLE KEYS */;
INSERT INTO `t_product_item` VALUES (4,5,155,'',2,15,'',''),(12,1,155,'d7fd005491724e61a72accaf536b7eba',2,15,'',''),(15,1,153,'370325851ff64ca8951b7018615623b9',1,13,'',''),(17,3,151,'dead9418d50345e3b4944a2d70e52c12',1,6,'不辣','small'),(21,3,151,'b93626decc4d4b7d8d13e389708f4591',1,10,'特辣','big'),(22,2,151,'0bcc6a8389b04d4e9ff926b0783eff81',1,10,'特辣','big'),(23,1,165,'1345209c67b94d0a8823851c07a4749b',4,7,'',''),(26,1,155,'0bcc6a8389b04d4e9ff926b0783eff81',2,15,'',''),(27,1,161,'fdc2849954dd4943ad0bde106bceabeb',3,4,'','middle'),(28,1,172,'370325851ff64ca8951b7018615623b9',5,13,'',''),(31,3,158,'bf8f7c3be9b44c9280cd799d35314ed5',3,17,'',''),(32,1,151,'6e2bd5bd2dc844f69f83d94b52bb89bf',1,10,'特辣','big'),(33,4,161,'dead9418d50345e3b4944a2d70e52c12',3,5,'','big'),(34,1,170,'0bcc6a8389b04d4e9ff926b0783eff81',5,10,'',''),(36,2,171,'fdc2849954dd4943ad0bde106bceabeb',5,12,'',''),(37,1,159,'7413a9d5b5ad466a8822f0eef8b30948',3,19,'',''),(38,1,159,'dead9418d50345e3b4944a2d70e52c12',3,19,'',''),(43,1,164,'1345209c67b94d0a8823851c07a4749b',4,12,'',''),(45,2,170,'7413a9d5b5ad466a8822f0eef8b30948',5,10,'',''),(48,1,151,'370325851ff64ca8951b7018615623b9',1,10,'特辣','big'),(49,1,152,'370325851ff64ca8951b7018615623b9',1,13,'',''),(50,1,155,'370325851ff64ca8951b7018615623b9',2,15,'',''),(51,2,151,'dead9418d50345e3b4944a2d70e52c12',1,10,'微辣','big'),(53,1,163,'705a485b7bd8409c815fb9df8175acb2',4,7,'',''),(54,2,162,'cec4a8a6312c4d53bdd6559401c3d70f',3,10,'',''),(55,1,152,'dead9418d50345e3b4944a2d70e52c12',1,13,'','');
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
  `user_id` varchar(255) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES ('0bcc6a8389b04d4e9ff926b0783eff81','.','okKFnwhz4nU90g3bUtGJHQnstWJ8',1,'陕西','http://wx.qlogo.cn/mmopen/3Xf0qNWCOt4rSTXxsPbkvibSseib6x7eicrO3nOzJEdIMnpKBG9hyAR29xZYFwymdbH6zDDPkRx5WIV9rofc9z3f99tPkwdjjPB/0'),('0ec99c64a0a449a1a5ef9bd5f47288e5','张乐芳','okKFnwhjCFCTn8NnMItDvCF-_9f8',2,'陕西','http://wx.qlogo.cn/mmopen/3Xf0qNWCOt4sricoxaHBXtFu4aVaH5nAkOjukkib88M8AvPGQKJTxKCcySWXRVfnK3BHzZC64aza3qiapC5ibJjcg8LriamcCF8Rh/0'),('1345209c67b94d0a8823851c07a4749b','不要和我名字一样。','okKFnwhdTiYd2vIAkHfmcCBqGfOg',1,'','http://wx.qlogo.cn/mmopen/xPKCxELaaj57FJtWJ73WLuEtLT770m1REHu3DkAhuiaEEicTibU1fKdV7PtBEPTtuqKLxh33Ob6MlapOtVr27PdZg/0'),('23d231aa070746f19ad50ab561e48b33','温凉','okKFnwlj6dUeEM6aIrUgel6NfUv4',2,'四川','http://wx.qlogo.cn/mmopen/1W6qZTicicdwVBiaoQuVjy1icnHRdYOl4fH8UxrzcuibIERy85k3eH3Z5SNXuHDgPrUTI53oVpDqROoRkicxfaibZcBRD1E0Pp0j0d9/0'),('370325851ff64ca8951b7018615623b9','鸿声','okKFnwjZexWmtSGvo0phRYsV9EvQ',1,'陕西','http://wx.qlogo.cn/mmopen/xPKCxELaaj7cPd3IyUKe1Hk2BiciaZMxIJcWZrYS3h4XBWZ48z7iaMWqgHECMSuO8XWiaQPDYPFgeFiaCtbycShibV8YUnLibiaJHicPx/0'),('39b9d34bd80a4529b4a85704d4710d81','任我行','okKFnwpu1E-bWp68hnW3VPAsFClM',1,'陕西','http://wx.qlogo.cn/mmopen/xPKCxELaaj7cPd3IyUKe1D476POwWBD7CvibicicvZfQIyUOPUGboQqINvkwfWxJKBvp5NNd1JFR33qcSUqnQ72MbFn0Cq2LVzI/0'),('4294fb2f4e1e48edb8be6ab0423a2ef3','过_','okKFnwr2uSdp6EzfPgDyd9fgJ-IA',1,'陕西','http://wx.qlogo.cn/mmopen/CTb9ibcW3a8UXTGEiapW93BqYn3y4DFuyCaiby51nHhAMhhEUGvenl24PernQtETgpLBkIf8Hiabjciaiby7Ivq22IXZqgSEYvWJkQ/0'),('49de70bc283e4fef860ead3126a1949e','任武杰','okKFnwkcD8w5pYw9Ds2pAcyqGzw4',1,'陕西','http://wx.qlogo.cn/mmopen/VEy0J95tVsicN2EEdey4AjsVPGVmMcchYMxdRgRnnxNk7Na4PJGvWrP8AFPSPQMq03QQmT2DIMPg9rZXGPGD9rRxaf69BgFUf/0'),('6e2bd5bd2dc844f69f83d94b52bb89bf','Freewind','okKFnwhkmEnwRXNNmW2Vs33_FNkw',1,'湖北','http://wx.qlogo.cn/mmopen/CTb9ibcW3a8UXTGEiapW93BskTvxI8tRnjSOIm3ibaOhJLu7SM3PCWcRgSmXNRpiaoFsE4k5mRCheGaLOReKOibq6rBYF2iaSVRnwL/0'),('705a485b7bd8409c815fb9df8175acb2','.','okKFnwlMWBGGICoSYI0sSn5Tb_us',1,'陕西','http://wx.qlogo.cn/mmopen/xPKCxELaaj7cPd3IyUKe1L6YK9bLsZHVNBFUPD6BAT3oWEYRqgCCH5nNXmL0Xkh4eLWPAQhvnaic52jG2Bpp3MTwhb6iawT9Zia/0'),('7413a9d5b5ad466a8822f0eef8b30948','jia','okKFnwjdUk7k0DMa_BqyUIG-haWg',1,'','http://wx.qlogo.cn/mmopen/VEy0J95tVsica6fic74EMMiazfxVFTKwEP97mXTHf8YJsicW4aKYzWaT89yOygsIHbJibuRAECbzic6quAIlHDRXZsgHq2CTHXTeGf/0'),('7fbe6733655b4ffba66a7801b69b8d79','臭狗屎','okKFnwnwqhrWMAeOiKv9UIYUc7qo',2,'','http://wx.qlogo.cn/mmopen/3Xf0qNWCOt4rSTXxsPbkv25MJawaQwv7Tsld473B3Hxa5rhtGU1EW2sGBFTLX0ImBcP6rIErBPcZRHtChtwWepA1GT6W1ad8/0'),('81f1c05785b04ae5bab76585a7c27dbd','凉爽的风','okKFnwktG8wC5jxPbt-R3de77L8U',2,'','http://wx.qlogo.cn/mmopen/xPKCxELaaj7vHbic2aFQqF1njuSZ3DpwwqeZF4yknZ6zK6v2x9DXLoHcCDALkicyibsQ6fI4zYsd1g8ldmq9HZ1ibjtykzsiaa9j9/0'),('940923b0f5344a37b61a0abc9271feb5','书玮','okKFnwhNEi5QsPpF4t4Xk6fbOMtY',2,'陕西','http://wx.qlogo.cn/mmopen/xPKCxELaaj7TzG7MZjy5kIibLhRTeoVo2gfeD5e20LiahRvIDiaRmQF069b0UibobW6AsJticdr2ZqryYTe1JK6KDZO9y6zFLEqUY/0'),('aa0c407ab7a645fa843e6eb5633832ea','Wayne','okKFnwh-6xQvVE8BMo1khR6iEUoo',1,'','http://wx.qlogo.cn/mmopen/3Xf0qNWCOt6ZoJ6wloLHE940JkhWpKryYzEvzBsh2sDzibx7aRtNeuwfs29uQVlq5DCleY9lOHl6SYUtq5ic0o3Y2R6bphCWlI/0'),('b5a9271cc479405bb19afb4e753e1207','123','okKFnwrInR_wUsaQfAK9-XY44GPU',1,'福建','http://wx.qlogo.cn/mmopen/EWFfCIFZR09HQktJqibice4HribHLOtK5axvLVia4ahAcajUx79ZEacLd9WV3xWqicv3VEmXZMGCT4T6lk7QLVpCxccHfiaUrKWyAz/0'),('b93626decc4d4b7d8d13e389708f4591','many','okKFnwrC3PwtB4Ptsd9cXxU3mE20',1,'新疆','http://wx.qlogo.cn/mmopen/xPKCxELaaj7icWA1Z1d6lEcQwTLnGthOiaBZk6X0g7WSA9DxP6Y5gOVEIGlCib0ibceyzicrSvcHuibq0UiaNFdib7icsYA/0'),('bf8f7c3be9b44c9280cd799d35314ed5','Acey','okKFnwgrhDM5FcZrXZGBOswyjEug',1,'湖北','http://wx.qlogo.cn/mmopen/VEy0J95tVsica6fic74EMMiaxQDfN9zNdib14kLG6aYrQTJBuSkMQud84VqxRSic5Ir5ac3oPvibqKK0ViczqbRIousSiaTkn5dnmZM8/0'),('cec4a8a6312c4d53bdd6559401c3d70f','null','okKFnwlWEsINBAhGu6j_tN38cVe8',1,'陕西','http://wx.qlogo.cn/mmopen/3Xf0qNWCOt4rSTXxsPbkv8RHHISmYYZGrjk9ibWlEXOajphsAHWoPMOSibyg9tzVZgLYueYY6k0mDmw5szEPPwt4O50dqRAWab/0'),('cf80c86995a74e4ea2ca504959c6f988','    As;','okKFnwpC_4LNxsKzgpsYrgoV4flY',2,'云南','http://wx.qlogo.cn/mmopen/ajNVdqHZLLBz99DbCXELkpLP8VjYs6wlcplbPkewZZpHqFHf4KoZJJt4KgRicJ2gy9s6icS5nuPiaZeuZBpvLbbWVoBlj5Kvyo2sUkXWx9iao6w/0'),('d7fd005491724e61a72accaf536b7eba','Xt...简单一点','okKFnwvAdjFf8JdbMM6iOnjhqn5E',1,'陕西','http://wx.qlogo.cn/mmopen/1W6qZTicicdwVPl8QA1R2Zh6gvP9vrnBCb5Gs9O5QUZtJibweFFV2xUeQj7A7utjYoFlKePgpqnDmdCluicnJEmVVqTjiamicGBK16/0'),('dead9418d50345e3b4944a2d70e52c12','那些年、','okKFnwotdYJVFUi6KiUXMTjLJ7aY',1,'陕西','http://wx.qlogo.cn/mmopen/1W6qZTicicdwVPl8QA1R2Zh5CwPwZNjOKLG2jFfkcMNuq55ll6moVDoYdMx60ba2bic5Bm9gQIQs47ciajKmKoIdBia3yvfdu9fwP/0'),('fdc2849954dd4943ad0bde106bceabeb','Temperance','okKFnwnQTo0mldys5GYH-gMOOPQw',1,'陕西','http://wx.qlogo.cn/mmopen/1W6qZTicicdwXGoMfeSDC810DqBVp0fla3tG4gXibKmpfU3SZ8MwDGIsYicaSqGYQosaficAYibpxKmAhbYuibIHKG6yTFgAnjOKkq7/0');
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

-- Dump completed on 2017-03-15 20:30:36
