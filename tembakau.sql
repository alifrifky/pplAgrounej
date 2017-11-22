-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2017 at 04:00 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tembakau`
--

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `id_pesanan` bigint(20) UNSIGNED NOT NULL,
  `jumlah_pesanan` int(64) NOT NULL,
  `tanggal_pesanan` date NOT NULL,
  `id_status` varchar(4) NOT NULL,
  `id_user` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`id_pesanan`, `jumlah_pesanan`, `tanggal_pesanan`, `id_status`, `id_user`) VALUES
(1, 0, '2017-11-06', '3', 1),
(2, 1000, '2017-11-07', '2', 1),
(3, 100, '2017-11-13', '1', 1),
(4, 1000, '2017-11-06', '2', 1),
(5, 100, '2017-11-13', '1', 1),
(6, 1000, '2017-11-06', '3', 1),
(7, 166, '1111-11-11', '1', 4);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id_status` varchar(10) NOT NULL,
  `status` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id_status`, `status`) VALUES
('1', 'belum konfirmasi'),
('2', 'sudah konfirmasi'),
('3', 'tidak di terima');

-- --------------------------------------------------------

--
-- Table structure for table `stok`
--

CREATE TABLE `stok` (
  `id_stok` int(8) NOT NULL,
  `jumlah_stok` int(168) NOT NULL,
  `tanggal` date NOT NULL,
  `id_user` int(64) NOT NULL,
  `periode` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stok`
--

INSERT INTO `stok` (`id_stok`, `jumlah_stok`, `tanggal`, `id_user`, `periode`) VALUES
(29, 1111, '0111-11-11', 1, '1'),
(30, 1111, '1111-11-11', 1, '1'),
(31, 1111, '1111-11-11', 1, '1'),
(32, 100, '1111-11-11', 1, '1'),
(33, 100, '1111-11-11', 1, '1'),
(34, 100, '1111-11-11', 1, '1'),
(35, 100, '1111-11-11', 1, '1'),
(36, 100, '1111-11-11', 1, '2'),
(37, 100, '1111-11-11', 1, '3'),
(38, 100, '1111-11-11', 1, '2'),
(39, 100, '1111-11-11', 1, '1');

-- --------------------------------------------------------

--
-- Table structure for table `updatestok`
--

CREATE TABLE `updatestok` (
  `id_stoku` int(11) NOT NULL,
  `stok` int(128) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `updatestok`
--

INSERT INTO `updatestok` (`id_stoku`, `stok`, `status`) VALUES
(1, 14652, '');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(64) NOT NULL,
  `user_name` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `nama_user` varchar(128) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `id_level` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `user_name`, `password`, `nama_user`, `alamat`, `id_level`) VALUES
(1, '1', '1', 'tukinem', '', 1),
(3, '3', '3', 'tok dalang', '', 2),
(4, '4', '4', 'bawon', '', 2),
(6, 'a', 'a', 'a', '', 3),
(7, 'alifri', 'alifrifk', 'alifrifky', 'ali', 2),
(11, 'perusahaan', 'perusahaan', 'perusahaan', 'perusahaan', 2),
(12, 'admin', 'admin', 'admin', 'admin', 3),
(13, 'petani', 'petani', 'petani', 'petani', 1),
(14, '120', '120', '120', 'aalal', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_level`
--

CREATE TABLE `user_level` (
  `id_level` int(16) NOT NULL,
  `nama_level` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_level`
--

INSERT INTO `user_level` (`id_level`, `nama_level`) VALUES
(1, 'petani'),
(2, 'perusahaan'),
(3, 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id_pesanan`),
  ADD UNIQUE KEY `id_pesanan` (`id_pesanan`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `status` (`id_status`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD UNIQUE KEY `id_status` (`id_status`);

--
-- Indexes for table `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`id_stok`),
  ADD KEY `id_petani` (`id_user`),
  ADD KEY `id_petani_2` (`id_user`),
  ADD KEY `id_petani_3` (`id_user`);

--
-- Indexes for table `updatestok`
--
ALTER TABLE `updatestok`
  ADD PRIMARY KEY (`id_stoku`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `id_petani` (`id_user`),
  ADD KEY `id_level` (`id_level`);

--
-- Indexes for table `user_level`
--
ALTER TABLE `user_level`
  ADD PRIMARY KEY (`id_level`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `id_pesanan` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `stok`
--
ALTER TABLE `stok`
  MODIFY `id_stok` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `updatestok`
--
ALTER TABLE `updatestok`
  MODIFY `id_stoku` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(64) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD CONSTRAINT `pesanan_ibfk_2` FOREIGN KEY (`id_status`) REFERENCES `status` (`id_status`),
  ADD CONSTRAINT `pesanan_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `stok`
--
ALTER TABLE `stok`
  ADD CONSTRAINT `stok_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_level`) REFERENCES `user_level` (`id_level`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
