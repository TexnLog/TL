-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 08, 2014 at 12:42 PM
-- Server version: 5.5.35
-- PHP Version: 5.3.10-1ubuntu3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--	
-- Create Database: `pcstorage_db`
CREATE database pcstorage_db;

-- add users storage_mgr to pcstorage_db
CREATE USER storage_mgr@localhost IDENTIFIED BY 'test123';
GRANT ALL PRIVILEGES ON pcstorage_db.* to storage_mgr@localhost;
CREATE USER 'storage_mgr'@'%' IDENTIFIED BY 'test123';
GRANT ALL PRIVILEGES ON pcstorage_db.* to 'storage_mgr'@'%';

-- need to edit 'my.cnf' the 'bind=IP' line if you want to access MySql DB remotely

-- --------------------------------------------------------

--
-- Table structure for table `COMPUTER`
--

CREATE TABLE IF NOT EXISTS `COMPUTER` (
  `serialNumber` varchar(30) NOT NULL,
  `etiketa` varchar(30) NOT NULL,
  `model` varchar(30) NOT NULL,
  `perigrafi` varchar(30) NOT NULL,
  `typos` varchar(20) NOT NULL,
  `cpu` int(11) DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `disk` int(11) DEFAULT NULL,
  PRIMARY KEY (`serialNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `COMPUTER`
--

INSERT INTO `COMPUTER` (`serialNumber`, `etiketa`, `model`, `perigrafi`, `typos`, `cpu`, `ram`, `disk`) VALUES
('A4444', 'Sony', 'Vaio', 'Sony Vaio F132', '2', 2600, 3072, 450),
('A5823', 'Sony', 'Vaio', 'Sony Vaio E318', '2', 2700, 2048, 550),
('B1144', 'Acer', 'Aspire', 'Acer Aspire 7781', '2', 2600, 2048, 750),
('B8844', 'Acer', 'Aspire', 'Acer Aspire  8590', '2', 2800, 4096, 500),
('C2940', 'Toshiba', 'Satellite', 'Toshiba Satellite A8850', '1', 2800, 4096, 750),
('C7881', 'Toshiba', 'Satellite', 'Toshiba Satellite C920', '2', 2800, 2048, 550);

-- --------------------------------------------------------

--
-- Table structure for table `EMPLOYEE`
--

CREATE TABLE IF NOT EXISTS `EMPLOYEE` (
  `phone` varchar(20) NOT NULL,
  `aname` varchar(20) DEFAULT NULL,
  `eponymo` varchar(35) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `XREWSH`
--

CREATE TABLE IF NOT EXISTS `XREWSH` (
  `phone` varchar(20) NOT NULL,
  `serialNumber` varchar(30) NOT NULL,
  PRIMARY KEY (`serialNumber`),
  KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `XREWSH`
--
ALTER TABLE `XREWSH`
  ADD CONSTRAINT `XREWSH_ibfk_1` FOREIGN KEY (`phone`) REFERENCES `EMPLOYEE` (`phone`),
  ADD CONSTRAINT `XREWSH_ibfk_2` FOREIGN KEY (`serialNumber`) REFERENCES `COMPUTER` (`serialNumber`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
