/*
SQLyog Community Edition- MySQL GUI v6.05
Host - 5.6.17 : Database - passagens_aereas
*********************************************************************
Server version : 5.6.17
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `passagens_aereas`;

USE `passagens_aereas`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `aeronave` */

DROP TABLE IF EXISTS `aeronave`;

CREATE TABLE `aeronave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) CHARACTER SET utf8 NOT NULL,
  `nome` varchar(100) CHARACTER SET utf8 NOT NULL,
  `total_assentos` int(11) NOT NULL,
  `qtd_assentos_A` int(11) NOT NULL,
  `qtd_assentos_B` int(11) NOT NULL,
  `qtd_assentos_C` int(11) NOT NULL,
  `qtd_assentos_horizontais` int(11) NOT NULL,
  `qtd_assentos_verticais` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `aeronave` */

insert  into `aeronave`(`id`,`codigo`,`nome`,`total_assentos`,`qtd_assentos_A`,`qtd_assentos_B`,`qtd_assentos_C`,`qtd_assentos_horizontais`,`qtd_assentos_verticais`) values (1,'012RE','Teste R',60,10,20,30,0,0),(2,'012RE','Teste R',60,10,20,30,0,0),(3,'012RE','Rafael P',27,12,12,3,0,0),(4,'012RE','Rafael P',27,12,12,3,0,0),(5,'012RE','Rafael P',27,12,12,3,0,0),(6,'012RE','Rafael P',27,12,12,3,0,0),(7,'012RE','Rafael P',27,12,12,3,0,0);

/*Table structure for table `aeroporto` */

DROP TABLE IF EXISTS `aeroporto`;

CREATE TABLE `aeroporto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) CHARACTER SET utf8 NOT NULL,
  `nome` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `aeroporto` */

/*Table structure for table `bilhete` */

DROP TABLE IF EXISTS `bilhete`;

CREATE TABLE `bilhete` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bilhete` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID do Usuario',
  `usuario` varchar(45) CHARACTER SET utf8 NOT NULL,
  `senha` varchar(100) CHARACTER SET utf8 NOT NULL,
  `perfil` enum('administrador','atendente') CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`usuario`,`senha`,`perfil`) values (1,'atendente','123','atendente'),(2,'administrador','123','administrador');

/*Table structure for table `voo` */

DROP TABLE IF EXISTS `voo`;

CREATE TABLE `voo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) CHARACTER SET utf8 NOT NULL,
  `aeroporto_origem_id` int(11) NOT NULL,
  `aeroporto_destino_id` int(11) NOT NULL,
  `data_voo` datetime NOT NULL,
  `aeronave_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_voo_aeroporto_origem` (`aeroporto_origem_id`),
  KEY `FK_voo_aeroporto_destino` (`aeroporto_destino_id`),
  KEY `FK_voo_aeronave` (`aeronave_id`),
  CONSTRAINT `FK_voo_aeronave` FOREIGN KEY (`aeronave_id`) REFERENCES `aeronave` (`id`),
  CONSTRAINT `FK_voo_aeroporto_destino` FOREIGN KEY (`aeroporto_destino_id`) REFERENCES `aeroporto` (`id`),
  CONSTRAINT `FK_voo_aeroporto_origem` FOREIGN KEY (`aeroporto_origem_id`) REFERENCES `aeroporto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `voo` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
