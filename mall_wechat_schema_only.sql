-- MySQL dump 10.13  Distrib 8.4.0, for macos14 (arm64)
--
-- Host: 127.0.0.1    Database: mall_wechat
-- ------------------------------------------------------
-- Server version	8.4.5

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `wechat_auto_reply_content`
--

DROP TABLE IF EXISTS `wechat_auto_reply_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_auto_reply_content` (
  `content_id` bigint NOT NULL AUTO_INCREMENT,
  `msg_type` varchar(100) NOT NULL,
  `reply_data` longtext NOT NULL,
  `reply_type` varchar(100) NOT NULL,
  `rule_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`content_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_auto_reply_keyword`
--

DROP TABLE IF EXISTS `wechat_auto_reply_keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_auto_reply_keyword` (
  `keyword_id` bigint NOT NULL AUTO_INCREMENT,
  `full_match` int NOT NULL,
  `keyword_name` varchar(30) NOT NULL,
  `rule_id` int NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`keyword_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_auto_reply_rule`
--

DROP TABLE IF EXISTS `wechat_auto_reply_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_auto_reply_rule` (
  `rule_id` bigint NOT NULL AUTO_INCREMENT,
  `all_keyword` varchar(1000) DEFAULT NULL,
  `reply_all` int NOT NULL,
  `reply_count` int NOT NULL,
  `reply_type_count` varchar(1000) DEFAULT NULL,
  `rule_name` varchar(60) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_masssend`
--

DROP TABLE IF EXISTS `wechat_masssend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_masssend` (
  `send_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `content` varchar(3000) DEFAULT NULL,
  `delete_state` int DEFAULT NULL,
  `error_count` int DEFAULT NULL,
  `error_info` varchar(2000) DEFAULT NULL,
  `material_data` longtext,
  `media_id` varchar(500) DEFAULT NULL,
  `msg_id` varchar(200) DEFAULT NULL,
  `msg_type` varchar(100) NOT NULL,
  `send_state` int DEFAULT NULL,
  `send_type` varchar(100) NOT NULL,
  `sent_count` int DEFAULT NULL,
  `wechat_tag_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`send_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_material_image`
--

DROP TABLE IF EXISTS `wechat_material_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_material_image` (
  `material_id` bigint NOT NULL AUTO_INCREMENT,
  `image_alias` varchar(100) NOT NULL,
  `image_name` varchar(200) NOT NULL,
  `material_image_url` varchar(500) NOT NULL,
  `media_id` varchar(100) NOT NULL,
  `update_time` datetime NOT NULL,
  `usable_state` int NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_material_news`
--

DROP TABLE IF EXISTS `wechat_material_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_material_news` (
  `material_id` bigint NOT NULL AUTO_INCREMENT,
  `media_id` varchar(100) DEFAULT NULL,
  `search_content` longtext,
  `simple_list` longtext,
  `update_time` datetime NOT NULL,
  `usable_state` int NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_material_news_item`
--

DROP TABLE IF EXISTS `wechat_material_news_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_material_news_item` (
  `item_id` bigint NOT NULL AUTO_INCREMENT,
  `Author` varchar(16) DEFAULT NULL,
  `content` longtext,
  `content_source_url` varchar(500) DEFAULT NULL,
  `digest` varchar(120) DEFAULT NULL,
  `parent_id` int NOT NULL,
  `thumb_media_id` varchar(100) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_menu`
--

DROP TABLE IF EXISTS `wechat_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT,
  `click_msg_type` varchar(100) DEFAULT NULL,
  `menu_key` varchar(100) DEFAULT NULL,
  `menu_name` varchar(60) NOT NULL,
  `menu_reply_data` longtext,
  `menu_sort` int NOT NULL,
  `menu_state` int NOT NULL,
  `menu_type` varchar(100) NOT NULL,
  `menu_view_url` varchar(1000) DEFAULT NULL,
  `parent_id` int NOT NULL,
  `parent_name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_mp_tmpl`
--

DROP TABLE IF EXISTS `wechat_mp_tmpl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_mp_tmpl` (
  `tmpl_id` bigint NOT NULL AUTO_INCREMENT,
  `mp_deputy_industry` varchar(200) NOT NULL,
  `mp_primary_industry` varchar(200) NOT NULL,
  `mp_template_content` longtext NOT NULL,
  `mp_template_example` longtext NOT NULL,
  `mp_template_id` varchar(200) NOT NULL,
  `mp_template_title` varchar(500) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`tmpl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_notice_log`
--

DROP TABLE IF EXISTS `wechat_notice_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_notice_log` (
  `log_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `create_time` bigint DEFAULT NULL,
  `event` varchar(100) DEFAULT NULL,
  `event_key` varchar(255) DEFAULT NULL,
  `finish_state` int NOT NULL,
  `from_user_name` varchar(500) DEFAULT NULL,
  `msg_id` bigint DEFAULT NULL,
  `msg_type` varchar(100) DEFAULT NULL,
  `other_params` varchar(2000) DEFAULT NULL,
  `to_user_name` varchar(500) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_qrcode`
--

DROP TABLE IF EXISTS `wechat_qrcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_qrcode` (
  `code_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `code_explain` varchar(100) NOT NULL,
  `code_title` varchar(30) NOT NULL,
  `expire_seconds` int NOT NULL,
  `handle_params` longtext,
  `handle_type` varchar(500) DEFAULT NULL,
  `qrcode_ticket` varchar(500) DEFAULT NULL,
  `qrcode_url` varchar(1000) DEFAULT NULL,
  `scene_id` int NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`code_id`),
  UNIQUE KEY `UK_mkbcbu6kfuc823gjjkwl5l897` (`scene_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_subscribe_qrcode`
--

DROP TABLE IF EXISTS `wechat_subscribe_qrcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_subscribe_qrcode` (
  `data_id` bigint NOT NULL AUTO_INCREMENT,
  `sign` varchar(500) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `wechat_qrcode_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_user`
--

DROP TABLE IF EXISTS `wechat_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  `head_img_url` varchar(1000) DEFAULT NULL,
  `language` varchar(100) DEFAULT NULL,
  `nick_name` varchar(30) NOT NULL,
  `open_id` varchar(200) NOT NULL,
  `province` varchar(100) DEFAULT NULL,
  `remark` varchar(30) DEFAULT NULL,
  `sex` int NOT NULL,
  `subscribe_time` datetime NOT NULL,
  `union_id` varchar(200) DEFAULT NULL,
  `wechat_tag_id` varchar(500) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_user_black`
--

DROP TABLE IF EXISTS `wechat_user_black`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_user_black` (
  `black_id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `head_img_url` varchar(1000) DEFAULT NULL,
  `language` varchar(100) DEFAULT NULL,
  `nick_name` varchar(30) NOT NULL,
  `open_id` varchar(200) NOT NULL,
  `province` varchar(100) DEFAULT NULL,
  `remark` varchar(30) DEFAULT NULL,
  `sex` int NOT NULL,
  `subscribe_time` datetime NOT NULL,
  `union_id` varchar(200) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`black_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wechat_user_tag`
--

DROP TABLE IF EXISTS `wechat_user_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wechat_user_tag` (
  `tag_id` bigint NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(30) NOT NULL,
  `tag_sort` int DEFAULT NULL,
  `user_count` int DEFAULT NULL,
  `wechat_tag_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `UK_1v7jnnny2kv76gd1nhfi0qxdm` (`wechat_tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-07  6:06:32
