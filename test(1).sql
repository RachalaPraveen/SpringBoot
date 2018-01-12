-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 12, 2018 at 02:33 PM
-- Server version: 5.7.20-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `Account`
--

CREATE TABLE `Account` (
  `id` bigint(20) NOT NULL,
  `referenceId` varchar(255) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `credentialsexpired` bit(1) NOT NULL DEFAULT b'0',
  `expired` bit(1) NOT NULL DEFAULT b'0',
  `locked` bit(1) NOT NULL DEFAULT b'0',
  `version` int(11) NOT NULL DEFAULT '0',
  `createdBy` varchar(100) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedBy` varchar(100) DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Account`
--

INSERT INTO `Account` (`id`, `referenceId`, `username`, `password`, `enabled`, `credentialsexpired`, `expired`, `locked`, `version`, `createdBy`, `createdAt`, `updatedBy`, `updatedAt`) VALUES
(1, 'a07bd221-3ecd-4893-a0f0-78d7c0fbf94e', 'user', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', b'1', b'0', b'0', b'0', 0, 'user', '2018-01-09 20:24:53', NULL, NULL),
(2, '7bd137c8-ab64-4a45-bf2d-d9bae3574622', 'operations', '$2a$10$CoMVfutnv1qZ.fNlHY1Na.rteiJhsDF0jB1o.76qXcfdWN6As27Zm', b'1', b'0', b'0', b'0', 0, 'user', '2018-01-09 20:24:53', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `AccountRole`
--

CREATE TABLE `AccountRole` (
  `accountId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `AccountRole`
--

INSERT INTO `AccountRole` (`accountId`, `roleId`) VALUES
(1, 1),
(2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `client_metadata`
--

CREATE TABLE `client_metadata` (
  `id` int(11) NOT NULL,
  `schma_name` varchar(30) NOT NULL DEFAULT '',
  `user_name` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(30) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client_metadata`
--

INSERT INTO `client_metadata` (`id`, `schma_name`, `user_name`, `password`) VALUES
(1, 'secondds', 'praveen', 'praveen'),
(2, 'thirdds', 'praveen', 'praveen');

-- --------------------------------------------------------

--
-- Table structure for table `DATABASECHANGELOG`
--

CREATE TABLE `DATABASECHANGELOG` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DATABASECHANGELOG`
--

INSERT INTO `DATABASECHANGELOG` (`ID`, `AUTHOR`, `FILENAME`, `DATEEXECUTED`, `ORDEREXECUTED`, `EXECTYPE`, `MD5SUM`, `DESCRIPTION`, `COMMENTS`, `TAG`, `LIQUIBASE`, `CONTEXTS`, `LABELS`, `DEPLOYMENT_ID`) VALUES
('1', 'mwarman', 'db.changelog-1.7.0.xml', '2018-01-09 20:24:51', 1, 'EXECUTED', '7:24e906eaf055412a83e13fdcf9b88edc', 'createTable', '', NULL, '3.3.0', NULL, NULL, NULL),
('2', 'mwarman', 'db.changelog-1.7.0.xml', '2018-01-09 20:24:51', 2, 'EXECUTED', '7:6a6edc817e7afe893c341975bc2183cd', 'insert (x2)', '', NULL, '3.3.0', NULL, NULL, NULL),
('3', 'mwarman', 'db.changelog-1.7.0.xml', '2018-01-09 20:24:51', 3, 'EXECUTED', '7:c5fb048782f5a7ac319007ab50a1992a', 'createTable', '', NULL, '3.3.0', NULL, NULL, NULL),
('4', 'mwarman', 'db.changelog-1.7.0.xml', '2018-01-09 20:24:52', 4, 'EXECUTED', '7:7bf0f05663574ccbef4fb3149aff37d0', 'createTable', '', NULL, '3.3.0', NULL, NULL, NULL),
('5', 'mwarman', 'db.changelog-1.7.0.xml', '2018-01-09 20:24:53', 5, 'EXECUTED', '7:696ebfcd9baf239b5f3b926795de5229', 'createTable', '', NULL, '3.3.0', NULL, NULL, NULL),
('6', 'mwarman', 'db.changelog-1.7.0.xml', '2018-01-09 20:24:53', 6, 'EXECUTED', '7:27eef493613d5631a9c8801465d66158', 'insert (x2)', '', NULL, '3.3.0', NULL, NULL, NULL),
('7', 'mwarman', 'db.changelog-1.7.0.xml', '2018-01-09 20:24:53', 7, 'EXECUTED', '7:47e68c314a576689d513f59e005be957', 'insert (x3)', '', NULL, '3.3.0', NULL, NULL, NULL),
('8', 'mwarman', 'db.changelog-1.7.0.xml', '2018-01-09 20:24:53', 8, 'EXECUTED', '7:b0711365570acaae2189e7c178714684', 'sql (x2)', '', NULL, '3.3.0', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `DATABASECHANGELOGLOCK`
--

CREATE TABLE `DATABASECHANGELOGLOCK` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `DATABASECHANGELOGLOCK`
--

INSERT INTO `DATABASECHANGELOGLOCK` (`ID`, `LOCKED`, `LOCKGRANTED`, `LOCKEDBY`) VALUES
(1, b'0', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Greeting`
--

CREATE TABLE `Greeting` (
  `id` bigint(20) NOT NULL,
  `referenceId` varchar(255) NOT NULL,
  `text` varchar(100) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '0',
  `createdBy` varchar(100) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedBy` varchar(100) DEFAULT NULL,
  `updatedAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Greeting`
--

INSERT INTO `Greeting` (`id`, `referenceId`, `text`, `version`, `createdBy`, `createdAt`, `updatedBy`, `updatedAt`) VALUES
(1, '1e0d5287-67fd-4043-9ac4-b8d358d6d7ce', 'Hello World!', 0, 'user', '2018-01-09 20:24:51', NULL, NULL),
(2, '37c3178d-3b49-47b6-99d1-277b1a3e8df8', 'Hola Mundo!', 0, 'user', '2018-01-09 20:24:51', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `people`
--

CREATE TABLE `people` (
  `id` int(11) NOT NULL,
  `first_name` varchar(10) NOT NULL,
  `last_name` varchar(10) NOT NULL,
  `created_at` varchar(122) NOT NULL DEFAULT '',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `people`
--

INSERT INTO `people` (`id`, `first_name`, `last_name`, `created_at`, `updated_at`) VALUES
(1, 'praveen', 'rachala', '2018-01-03 19:55:53', '2018-01-03 14:26:04');

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

CREATE TABLE `Role` (
  `id` bigint(20) NOT NULL,
  `code` varchar(50) NOT NULL,
  `label` varchar(100) NOT NULL,
  `ordinal` int(11) NOT NULL,
  `effectiveAt` datetime NOT NULL,
  `expiresAt` datetime DEFAULT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` (`id`, `code`, `label`, `ordinal`, `effectiveAt`, `expiresAt`, `createdAt`) VALUES
(1, 'ROLE_USER', 'User', 0, '2015-01-01 00:00:00', NULL, '2018-01-09 20:24:53'),
(2, 'ROLE_ADMIN', 'Admin', 1, '2015-01-01 00:00:00', NULL, '2018-01-09 20:24:53'),
(3, 'ROLE_SYSADMIN', 'System Admin', 2, '2015-01-01 00:00:00', NULL, '2018-01-09 20:24:53');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Account`
--
ALTER TABLE `Account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UQ_Account_Username` (`username`),
  ADD UNIQUE KEY `UQ_Account_ReferenceId` (`referenceId`);

--
-- Indexes for table `AccountRole`
--
ALTER TABLE `AccountRole`
  ADD KEY `FK_AccountRole_RoleId` (`roleId`),
  ADD KEY `FK_AccountRole_AccountId` (`accountId`);

--
-- Indexes for table `client_metadata`
--
ALTER TABLE `client_metadata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `DATABASECHANGELOGLOCK`
--
ALTER TABLE `DATABASECHANGELOGLOCK`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Greeting`
--
ALTER TABLE `Greeting`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UQ_Greeting_ReferenceId` (`referenceId`);

--
-- Indexes for table `people`
--
ALTER TABLE `people`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UQ_Role_Code` (`code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Account`
--
ALTER TABLE `Account`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `client_metadata`
--
ALTER TABLE `client_metadata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Greeting`
--
ALTER TABLE `Greeting`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `people`
--
ALTER TABLE `people`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `AccountRole`
--
ALTER TABLE `AccountRole`
  ADD CONSTRAINT `FK_AccountRole_AccountId` FOREIGN KEY (`accountId`) REFERENCES `Account` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_AccountRole_RoleId` FOREIGN KEY (`roleId`) REFERENCES `Role` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
