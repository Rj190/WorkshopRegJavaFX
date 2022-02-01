-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2022 at 01:28 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rj`
--

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `pid` varchar(10) NOT NULL,
  `pname` varchar(10) NOT NULL,
  `cname` varchar(10) NOT NULL,
  `dept` varchar(10) NOT NULL,
  `et` varchar(10) NOT NULL,
  `wid` varchar(10) NOT NULL,
  `date` date NOT NULL,
  `ay` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`pid`, `pname`, `cname`, `dept`, `et`, `wid`, `date`, `ay`) VALUES
('1001', 'King', 'SDMCET', 'Mech Engg', 'Technical', 'E300', '2022-02-03', '2021-22'),
('123ww', 'naveen', 'SDM', 'CSE', 'Technical', '2q22', '2022-02-04', '2021-22'),
('rr', 'fff', 'ee', 'CSE', 'Technical', 'ee', '2022-01-05', '2021-22');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `id` varchar(10) NOT NULL,
  `pass` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`id`, `pass`) VALUES
('rj', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `s1`
--

CREATE TABLE `s1` (
  `StudentName` varchar(10) NOT NULL,
  `USN` varchar(19) NOT NULL,
  `Academic Year` int(19) NOT NULL,
  `Company Name` varchar(18) NOT NULL,
  `Internship_Duration` int(10) NOT NULL,
  `PayPackage` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
