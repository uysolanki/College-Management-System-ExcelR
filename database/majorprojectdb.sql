-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 10, 2025 at 02:16 PM
-- Server version: 5.1.53
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `majorprojectdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`) VALUES
(1, 'ADMIN'),
(2, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `rno` int(11) NOT NULL,
  `per` double NOT NULL,
  `sname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`rno`, `per`, `sname`) VALUES
(1, 98.5, 'Rahul'),
(18, 99.9, 'Kohli'),
(34, 87.6, 'Tom'),
(45, 68.9, 'Sharma'),
(76, 87.6, 'Tommy'),
(77, 98.7, 'Shubman'),
(101, 78, 'Tom');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `tno` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `sal` int(11) NOT NULL,
  `tname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`tno`, `age`, `sal`, `tname`) VALUES
(1, 45, 1000, 'Alice'),
(2, 32, 900, 'Ben'),
(5, 25, 600, 'Elcid'),
(6, 49, 1800, 'Frank'),
(13, 37, 1900, 'Virat');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `account_enabled_status` int(11) NOT NULL,
  `account_expiry_date` date DEFAULT NULL,
  `account_locked_status` int(11) NOT NULL,
  `credentials_expiry_date` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`, `user_name`, `account_enabled_status`, `account_expiry_date`, `account_locked_status`, `credentials_expiry_date`) VALUES
(1, '$2a$12$ELixTw75rQdVVA/C0BFyoeH.bwb420lz0ejxBMy8Rr4GCN4qpOEgy', 'alice', 1, '2026-09-10', 1, '2025-09-09'),
(2, '$2a$12$OrsWxWiRw5joC/qsKcymNOyUQ9i1fVu8Mzz0WEuS.0EpcYKhpbiSa', 'ben', 1, '2026-09-10', 1, '2026-01-10');

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE IF NOT EXISTS `users_roles` (
  `fuser_id` int(11) NOT NULL,
  `frole_id` int(11) NOT NULL,
  KEY `FKbu8wj3n4gulvldcfgbuyc64ax` (`frole_id`),
  KEY `FKt6m0dl5eh53oopymarkc4q6gd` (`fuser_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`fuser_id`, `frole_id`) VALUES
(1, 1),
(2, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKt6m0dl5eh53oopymarkc4q6gd` FOREIGN KEY (`fuser_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKbu8wj3n4gulvldcfgbuyc64ax` FOREIGN KEY (`frole_id`) REFERENCES `role` (`role_id`);
