/*
SQLyog Community v13.1.2 (64 bit)
MySQL - 10.1.38-MariaDB : Database - projekat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`projekat` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `projekat`;

/*Table structure for table `bolnica` */

DROP TABLE IF EXISTS `bolnica`;

CREATE TABLE `bolnica` (
  `bolnica_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT 'null',
  `maticni_broj` varchar(20) DEFAULT 'null',
  `poreski_broj` varchar(20) DEFAULT 'null',
  `opis` varchar(200) DEFAULT 'null',
  `vrsta_bolnice_fk` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`bolnica_id`),
  UNIQUE KEY `naziv_unique` (`naziv`),
  UNIQUE KEY `maticniBrojUnique` (`maticni_broj`),
  UNIQUE KEY `poreskiBrojUnique` (`poreski_broj`),
  KEY `bolnica_fk1` (`vrsta_bolnice_fk`),
  CONSTRAINT `bolnica_fk1` FOREIGN KEY (`vrsta_bolnice_fk`) REFERENCES `vrsta_bolnice` (`vrsta_bolnice_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `bolnica` */

insert  into `bolnica`(`bolnica_id`,`naziv`,`maticni_broj`,`poreski_broj`,`opis`,`vrsta_bolnice_fk`) values 
(1,'Urgentni centar Kragujevac','2603996914961','22388525','UC',2),
(2,'Urgentni centar Beograd','22533696632','22514522','UCB',2),
(3,'Urgentni centar Nis','3366778899112','11223344556','UCN',2),
(6,'Opsta bolnica Kragujevac','1111111111111','223355667','OBK',2),
(7,'Euromedik Nis','6699789789789','15189795423','EN',1),
(8,'Biohemija Beograd','4978711239632','15495465456','BB',1),
(12,'Maurelius','12345678999','12345678','dva dva ses osam osam tri',1),
(13,'SPBM','2214599712','1231132132123','dsajkldsajkldjaslkdjasljdla',2),
(15,'Bolnica','223223223223','22322323','Bolnica',2);

/*Table structure for table `doktor` */

DROP TABLE IF EXISTS `doktor`;

CREATE TABLE `doktor` (
  `doktor_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `bolnica_fk` int(10) unsigned DEFAULT NULL,
  `tip_doktora_fk` int(10) unsigned DEFAULT NULL,
  `zvanje_fk` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`doktor_id`),
  KEY `doktor_fk1` (`bolnica_fk`),
  KEY `doktor_fk2` (`tip_doktora_fk`),
  KEY `doktor_fk3` (`zvanje_fk`),
  CONSTRAINT `doktor_fk1` FOREIGN KEY (`bolnica_fk`) REFERENCES `bolnica` (`bolnica_id`) ON UPDATE CASCADE,
  CONSTRAINT `doktor_fk2` FOREIGN KEY (`tip_doktora_fk`) REFERENCES `tip_doktora` (`tip_doktora_id`) ON UPDATE CASCADE,
  CONSTRAINT `doktor_fk3` FOREIGN KEY (`zvanje_fk`) REFERENCES `zvanje` (`zvanje_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

/*Data for the table `doktor` */

insert  into `doktor`(`doktor_id`,`ime`,`prezime`,`bolnica_fk`,`tip_doktora_fk`,`zvanje_fk`) values 
(34,'Ivan','Ivanovic',1,6,16),
(35,'Dusan','Dusanovic',2,9,24),
(36,'Milos','Milosevic',3,7,21),
(37,'Filip','Filipovic',6,2,27),
(38,'Sima','Simic',8,9,20),
(39,'Stefan','Stefanovic',7,5,20),
(40,'Nemanja','Nemanjic',2,8,27),
(42,'Marko','Markovic',7,9,20),
(43,'Sima','Simic',1,9,27),
(44,'igor','igorovic',15,9,16),
(45,'doktor','doktor1',12,9,16),
(46,'doktor2','dokto2',2,9,16),
(47,'marko213123','markovic',15,9,16),
(48,'djsajdsaldasjl','dlajdkljasljdasl',2,9,16),
(49,'ivanovic','van',15,9,16),
(50,'Milanovic','Milan',15,9,16),
(51,'dok3','dok3',15,9,16),
(52,'dok4','dok4',15,9,16),
(53,'dok5','dok5',15,9,16),
(54,'kkkkk','jklk',1,9,16);

/*Table structure for table `tip_doktora` */

DROP TABLE IF EXISTS `tip_doktora`;

CREATE TABLE `tip_doktora` (
  `tip_doktora_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tip_doktora_id`),
  KEY `naziv_unique` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `tip_doktora` */

insert  into `tip_doktora`(`tip_doktora_id`,`naziv`) values 
(9,'Doktor'),
(6,'Epidemiolog'),
(7,'Kardiohirug'),
(2,'Neurohirurg'),
(5,'Psihijatar'),
(4,'Radiolog'),
(8,'Urolog');

/*Table structure for table `vrsta_bolnice` */

DROP TABLE IF EXISTS `vrsta_bolnice`;

CREATE TABLE `vrsta_bolnice` (
  `vrsta_bolnice_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`vrsta_bolnice_id`),
  KEY `naziv_unique` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `vrsta_bolnice` */

insert  into `vrsta_bolnice`(`vrsta_bolnice_id`,`naziv`) values 
(2,'drzavna'),
(1,'privatna');

/*Table structure for table `zvanje` */

DROP TABLE IF EXISTS `zvanje`;

CREATE TABLE `zvanje` (
  `zvanje_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`zvanje_id`),
  UNIQUE KEY `naziv_unique` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

/*Data for the table `zvanje` */

insert  into `zvanje`(`zvanje_id`,`naziv`) values 
(16,'Dipl. farm'),
(24,'Dr sci med.'),
(21,'Dr sci. med'),
(47,'Dr. stom.'),
(20,'Dr.med'),
(27,'Oral hig.'),
(25,'Spec. dr. med');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
