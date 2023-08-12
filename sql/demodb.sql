
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP DATABASE IF EXISTS `bootdb`;
CREATE DATABASE bootdb;
USE bootdb;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` int(10) NOT NULL AUTO_INCREMENT,
    `username` varchar(25) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
    `img` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `create_time` DATETIME NULL 	DEFAULT  CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

INSERT INTO user VALUES(1,'用户1','大家庭','1234','',NOW());

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
    `id` int(10) NOT NULL AUTO_INCREMENT,
    `product_name` varchar(100) character set utf8 COLLATE utf8_bin NOT NULL ,
    `product_id` int(10) NOT NULL,
    `product_banner` varchar(2000) character set utf8 COLLATE utf8_bin NOT NULL ,
    `product_content` varchar(2000) character set utf8 COLLATE utf8_bin NOT NULL ,
    `product_price` decimal(10, 2) NULL DEFAULT NULL,
    `product_sale_price` decimal(10, 2) NOT NULL,
    `product_img` varchar(2000) character set utf8 COLLATE utf8_bin NOT NULL ,
    `create_time` DATETIME NULL 	DEFAULT  CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
    `id` int(5) NOT NULL AUTO_INCREMENT,
    `name` varchar(30) character set utf8 COLLATE utf8_bin NOT NULL,
    `code` varchar(30) character set utf8 COLLATE utf8_bin NOT NULL ,
    `combo` varchar(255) character set utf8 COLLATE utf8_bin NOT NULL ,
    `logo` varchar(255) character set utf8 COLLATE utf8_bin NOT NULL ,
    `create_time` DATETIME NULL 	DEFAULT  CURRENT_TIMESTAMP,
    `update_time` DATETIME NULL 	DEFAULT  CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;
