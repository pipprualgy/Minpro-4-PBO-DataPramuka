-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 13, 2026 at 02:35 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pramuka`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota_pramuka`
--

CREATE TABLE `anggota_pramuka` (
  `id_anggota` int NOT NULL,
  `nama_anggota` varchar(100) DEFAULT NULL,
  `jenis_kelamin` varchar(15) DEFAULT NULL,
  `id_kwarran` int NOT NULL,
  `kode_gudep` int NOT NULL,
  `tingkat_pramuka` varchar(20) DEFAULT NULL,
  `hak_bina` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `anggota_pramuka`
--

INSERT INTO `anggota_pramuka` (`id_anggota`, `nama_anggota`, `jenis_kelamin`, `id_kwarran`, `kode_gudep`, `tingkat_pramuka`, `hak_bina`) VALUES
(1001, 'Muhammad Farel Awaluddin', 'L', 170301, 1122, 'Penegak', NULL),
(2001, 'Pak Kaspul Anwar', 'L', 170301, 1122, NULL, 'KMD');

-- --------------------------------------------------------

--
-- Table structure for table `gugus_depan`
--

CREATE TABLE `gugus_depan` (
  `kode_gudep` int NOT NULL,
  `nama_gudep` varchar(100) DEFAULT NULL,
  `pangkalan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `gugus_depan`
--

INSERT INTO `gugus_depan` (`kode_gudep`, `nama_gudep`, `pangkalan`) VALUES
(1122, 'Ki Hajar Dewantara - Dewi Sartika', 'SMAN 1 Berau');

-- --------------------------------------------------------

--
-- Table structure for table `kwarran`
--

CREATE TABLE `kwarran` (
  `id_kwarran` int NOT NULL,
  `nama_kwarran` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `kwarran`
--

INSERT INTO `kwarran` (`id_kwarran`, `nama_kwarran`) VALUES
(170301, 'Tanjung Redeb'),
(170302, 'Gunung Tabur'),
(170303, 'Sambaliung');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota_pramuka`
--
ALTER TABLE `anggota_pramuka`
  ADD KEY `fk_kwarran_anggota_pramuka` (`id_kwarran`),
  ADD KEY `fk_gugus_depan_anggota_pramuka` (`kode_gudep`);

--
-- Indexes for table `gugus_depan`
--
ALTER TABLE `gugus_depan`
  ADD PRIMARY KEY (`kode_gudep`);

--
-- Indexes for table `kwarran`
--
ALTER TABLE `kwarran`
  ADD PRIMARY KEY (`id_kwarran`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `anggota_pramuka`
--
ALTER TABLE `anggota_pramuka`
  ADD CONSTRAINT `fk_gugus_depan_anggota_pramuka` FOREIGN KEY (`kode_gudep`) REFERENCES `gugus_depan` (`kode_gudep`),
  ADD CONSTRAINT `fk_kwarran_anggota_pramuka` FOREIGN KEY (`id_kwarran`) REFERENCES `kwarran` (`id_kwarran`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
