-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3366
-- Generation Time: May 09, 2022 at 05:26 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vehicle_rent`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer_res`
--

CREATE TABLE `customer_res` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `number` varchar(20) NOT NULL,
  `type` varchar(120) NOT NULL,
  `Address` varchar(500) NOT NULL,
  `sdate` varchar(20) NOT NULL,
  `edate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_res`
--

INSERT INTO `customer_res` (`id`, `name`, `number`, `type`, `Address`, `sdate`, `edate`) VALUES
(10, 'Chamod', 'a', 'lk', 'lkn', 'lkn', 'lk'),
(11, 'wqhio', 'iohew', 'iojwe', 'iojew', 'jeoiw', 'ioj'),
(12, 'ehfuh', 'sn', 'fjd', 'ije', 'ij', 'efj'),
(13, 'hef', 'jreio', 'rij', 'ierj', 'iejrio', 'firjio'),
(15, 'j', 'n', 'lkm', 'lkm', 'klm', 'klm'),
(16, 'j', 'n', 'lkm', 'lkm', 'klm', 'klm');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_res`
--
ALTER TABLE `customer_res`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer_res`
--
ALTER TABLE `customer_res`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
