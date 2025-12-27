-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Des 2025 pada 10.01
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_klinikgigi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `dokter`
--

CREATE TABLE `dokter` (
  `id_dokter` int(11) NOT NULL,
  `nama_dokter` varchar(100) NOT NULL,
  `spesialis` varchar(100) DEFAULT NULL,
  `no_telp` varchar(20) DEFAULT NULL,
  `jadwal_praktik` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `dokter`
--

INSERT INTO `dokter` (`id_dokter`, `nama_dokter`, `spesialis`, `no_telp`, `jadwal_praktik`) VALUES
(1, 'Dr. Andi', 'Gigi Umum', '0811111111', 'Senin-Rabu'),
(2, 'Dr. Budi', 'Ortodonti', '0822222222', 'Selasa-Kamis'),
(3, 'Dr. Citra', 'Bedah Mulut', '0833333333', 'Senin-Jumat'),
(4, 'Dr. Dedi', 'Gigi Anak', '0844444444', 'Rabu-Jumat'),
(5, 'Dr. Eka', 'Periodonti', '0855555555', 'Sabtu');

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal_pemeriksaan`
--

CREATE TABLE `jadwal_pemeriksaan` (
  `id_jadwal` int(11) NOT NULL,
  `no_urut` int(11) NOT NULL,
  `id_pasien` int(11) NOT NULL,
  `tanggal` datetime NOT NULL,
  `id_dokter` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jadwal_pemeriksaan`
--

INSERT INTO `jadwal_pemeriksaan` (`id_jadwal`, `no_urut`, `id_pasien`, `tanggal`, `id_dokter`) VALUES
(1, 1, 1, '2025-01-01 09:00:00', 1),
(2, 2, 2, '2025-01-01 10:00:00', 2),
(3, 3, 3, '2025-01-02 09:00:00', 3),
(4, 4, 4, '2025-01-02 10:00:00', 4),
(5, 5, 5, '2025-01-03 09:00:00', 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `login_pengguna`
--

CREATE TABLE `login_pengguna` (
  `id_pengguna` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `level` enum('1','2') NOT NULL,
  `id_dokter` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login_pengguna`
--

INSERT INTO `login_pengguna` (`id_pengguna`, `username`, `password`, `level`, `id_dokter`) VALUES
(1, 'admin', '0192023a7bbd73250516f069df18b500', '1', NULL),
(2, 'Andi', '03339dc0dff443f15c254baccde9bece', '2', 1),
(3, 'Budi', '9c5fa085ce256c7c598f6710584ab25d', '2', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `obat`
--

CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL,
  `nama_obat` varchar(100) NOT NULL,
  `satuan` varchar(50) DEFAULT NULL,
  `harga` decimal(10,2) DEFAULT 0.00,
  `stok` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `obat`
--

INSERT INTO `obat` (`id_obat`, `nama_obat`, `satuan`, `harga`, `stok`) VALUES
(1, 'Amoxicillin', 'Tablet', 5000.00, 100),
(2, 'Paracetamol', 'Tablet', 3000.00, 200),
(3, 'Ibuprofen', 'Tablet', 4000.00, 150),
(4, 'Mouthwash', 'Botol', 15000.00, 50),
(5, 'Vitamin C', 'Tablet', 2000.00, 300);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasien`
--

CREATE TABLE `pasien` (
  `id_pasien` int(11) NOT NULL,
  `nama_pasien` varchar(100) NOT NULL,
  `jenis_kelamin` enum('L','P') DEFAULT NULL,
  `tanggal_lahir` date DEFAULT NULL,
  `alamat` varchar(200) DEFAULT NULL,
  `no_telp` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `jenis_kelamin`, `tanggal_lahir`, `alamat`, `no_telp`) VALUES
(1, 'Siti Aminah', 'P', '2000-01-10', 'Bandung', '0819000001'),
(2, 'Ahmad Fauzi', 'L', '1998-03-12', 'Jakarta', '0819000002'),
(3, 'Dewi Lestari', 'P', '2001-07-21', 'Bekasi', '0819000003'),
(4, 'Rizky Pratama', 'L', '1999-11-30', 'Depok', '0819000004'),
(5, 'Nur Aisyah', 'P', '2002-05-15', 'Bogor', '0819000005');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` int(11) NOT NULL,
  `id_pemeriksaan` int(11) NOT NULL,
  `total_bayar` decimal(10,2) DEFAULT NULL,
  `tgl_pembayaran` date DEFAULT curdate(),
  `status` enum('BELUM LUNAS','LUNAS') DEFAULT 'BELUM LUNAS'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `id_pemeriksaan`, `total_bayar`, `tgl_pembayaran`, `status`) VALUES
(1, 1, 50000.00, '2025-01-01', 'LUNAS'),
(2, 2, 30000.00, '2025-01-01', 'LUNAS'),
(3, 3, 45000.00, '2025-01-02', 'BELUM LUNAS'),
(4, 4, 25000.00, '2025-01-02', 'LUNAS'),
(5, 5, 60000.00, '2025-01-03', 'BELUM LUNAS');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemeriksaan`
--

CREATE TABLE `pemeriksaan` (
  `id_pemeriksaan` int(11) NOT NULL,
  `id_jadwal` int(11) NOT NULL,
  `keluhan` text DEFAULT NULL,
  `diagnosa` text DEFAULT NULL,
  `tindakan` text DEFAULT NULL,
  `tanggal` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pemeriksaan`
--

INSERT INTO `pemeriksaan` (`id_pemeriksaan`, `id_jadwal`, `keluhan`, `diagnosa`, `tindakan`, `tanggal`) VALUES
(1, 1, 'Sakit gigi', 'Gigi berlubang', 'Tambal gigi', '2025-01-01 09:30:00'),
(2, 2, 'Nyeri rahang', 'Maloklusi', 'Konsultasi', '2025-01-01 10:30:00'),
(3, 3, 'Gusi bengkak', 'Infeksi gusi', 'Pembersihan', '2025-01-02 09:30:00'),
(4, 4, 'Gigi sensitif', 'Email menipis', 'Fluoride', '2025-01-02 10:30:00'),
(5, 5, 'Gigi goyang', 'Periodontitis', 'Scaling', '2025-01-03 09:30:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `resep_obat`
--

CREATE TABLE `resep_obat` (
  `id_resep` int(11) NOT NULL,
  `id_pemeriksaan` int(11) NOT NULL,
  `id_obat` int(11) NOT NULL,
  `jumlah` int(11) DEFAULT 1,
  `aturan_pakai` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `resep_obat`
--

INSERT INTO `resep_obat` (`id_resep`, `id_pemeriksaan`, `id_obat`, `jumlah`, `aturan_pakai`) VALUES
(1, 1, 1, 10, '3x sehari'),
(2, 2, 2, 5, '2x sehari'),
(3, 3, 3, 7, '2x sehari'),
(4, 4, 4, 1, 'Setelah makan'),
(5, 5, 5, 10, '1x sehari');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`id_dokter`);

--
-- Indeks untuk tabel `jadwal_pemeriksaan`
--
ALTER TABLE `jadwal_pemeriksaan`
  ADD PRIMARY KEY (`id_jadwal`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `id_dokter` (`id_dokter`);

--
-- Indeks untuk tabel `login_pengguna`
--
ALTER TABLE `login_pengguna`
  ADD PRIMARY KEY (`id_pengguna`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `fk_login_dokter` (`id_dokter`);

--
-- Indeks untuk tabel `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indeks untuk tabel `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_pasien`);

--
-- Indeks untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `id_pemeriksaan` (`id_pemeriksaan`);

--
-- Indeks untuk tabel `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD PRIMARY KEY (`id_pemeriksaan`),
  ADD KEY `id_dokter` (`id_jadwal`);

--
-- Indeks untuk tabel `resep_obat`
--
ALTER TABLE `resep_obat`
  ADD PRIMARY KEY (`id_resep`),
  ADD KEY `id_pemeriksaan` (`id_pemeriksaan`),
  ADD KEY `id_obat` (`id_obat`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `dokter`
--
ALTER TABLE `dokter`
  MODIFY `id_dokter` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `jadwal_pemeriksaan`
--
ALTER TABLE `jadwal_pemeriksaan`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `login_pengguna`
--
ALTER TABLE `login_pengguna`
  MODIFY `id_pengguna` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `obat`
--
ALTER TABLE `obat`
  MODIFY `id_obat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `pasien`
--
ALTER TABLE `pasien`
  MODIFY `id_pasien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  MODIFY `id_pemeriksaan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `resep_obat`
--
ALTER TABLE `resep_obat`
  MODIFY `id_resep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `jadwal_pemeriksaan`
--
ALTER TABLE `jadwal_pemeriksaan`
  ADD CONSTRAINT `jadwal_pemeriksaan_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `jadwal_pemeriksaan_ibfk_2` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`id_dokter`);

--
-- Ketidakleluasaan untuk tabel `login_pengguna`
--
ALTER TABLE `login_pengguna`
  ADD CONSTRAINT `fk_login_dokter` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`id_dokter`);

--
-- Ketidakleluasaan untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`id_pemeriksaan`) REFERENCES `pemeriksaan` (`id_pemeriksaan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD CONSTRAINT `pemeriksaan_ibfk_1` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal_pemeriksaan` (`id_jadwal`);

--
-- Ketidakleluasaan untuk tabel `resep_obat`
--
ALTER TABLE `resep_obat`
  ADD CONSTRAINT `resep_obat_ibfk_1` FOREIGN KEY (`id_pemeriksaan`) REFERENCES `pemeriksaan` (`id_pemeriksaan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `resep_obat_ibfk_2` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
