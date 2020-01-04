-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 16 Ara 2019, 21:01:35
-- Sunucu sürümü: 10.1.39-MariaDB
-- PHP Sürümü: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `gym`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `antrenortip`
--

CREATE TABLE `antrenortip` (
  `tipID` int(11) NOT NULL,
  `tipAd` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `bransID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `antrenortip`
--

INSERT INTO `antrenortip` (`tipID`, `tipAd`, `bransID`) VALUES
(1, 'Crunch', 1),
(2, 'Zumba', 1),
(3, 'Kardiyo', 1),
(4, 'Crossfit', 1),
(5, 'Koşu', 2),
(6, 'Cimnastik', 2),
(7, 'Pilates', 2),
(8, 'Boks', 3),
(9, 'MuayThai', 3),
(10, 'Bisiklet', 4);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `antrenörler`
--

CREATE TABLE `antrenörler` (
  `antrenorID` int(11) NOT NULL,
  `TCNO` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Ad` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Soyad` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `TelefonNo` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `DogumTarihi` date DEFAULT NULL,
  `Password` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `tipID` int(11) DEFAULT NULL,
  `subeID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `antrenörler`
--

INSERT INTO `antrenörler` (`antrenorID`, `TCNO`, `Ad`, `Soyad`, `TelefonNo`, `DogumTarihi`, `Password`, `tipID`, `subeID`) VALUES
(4, '11111111', 'Fatih', 'Karaman', '05313030640', '1998-01-13', '12345', 4, 14),
(5, '2222222', 'Abdullah', 'Karaman', '05311233321', '1999-01-20', '31231', 3, 8);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `branslar`
--

CREATE TABLE `branslar` (
  `bransID` int(11) NOT NULL,
  `bransAd` varchar(20) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `branslar`
--

INSERT INTO `branslar` (`bransID`, `bransAd`) VALUES
(1, 'Fitness'),
(2, 'Atletizm'),
(3, 'Dövüş'),
(4, 'Yarış');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ekipman`
--

CREATE TABLE `ekipman` (
  `ekipmanID` int(11) NOT NULL,
  `ekipmanAd` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `miktar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `ekipman`
--

INSERT INTO `ekipman` (`ekipmanID`, `ekipmanAd`, `miktar`) VALUES
(1, 'Dumbell', 30),
(2, 'Barbells', 5),
(3, 'Z-Bar', 4),
(4, 'Bench', 10);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `fatura`
--

CREATE TABLE `fatura` (
  `faturaID` int(11) NOT NULL,
  `uyeID` int(11) NOT NULL,
  `odemeID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `fatura`
--

INSERT INTO `fatura` (`faturaID`, `uyeID`, `odemeID`) VALUES
(1, 6, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `indeks`
--

CREATE TABLE `indeks` (
  `indeksID` int(11) NOT NULL,
  `boy` float DEFAULT NULL,
  `kilo` int(11) DEFAULT NULL,
  `indeks` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `indeks`
--

INSERT INTO `indeks` (`indeksID`, `boy`, `kilo`, `indeks`) VALUES
(1, 2, 80, 20),
(2, 1.8, 70, 22);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `odeme`
--

CREATE TABLE `odeme` (
  `odemeID` int(11) NOT NULL,
  `odemeAd` varchar(20) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `odeme`
--

INSERT INTO `odeme` (`odemeID`, `odemeAd`) VALUES
(1, 'Nakit'),
(2, 'Kredi Kartı');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sehir`
--

CREATE TABLE `sehir` (
  `sehirID` int(11) NOT NULL,
  `sehirAd` varchar(20) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `sehir`
--

INSERT INTO `sehir` (`sehirID`, `sehirAd`) VALUES
(54, 'istanbul'),
(55, 'izmir'),
(56, 'ankara'),
(57, 'bursa'),
(58, 'balıkesir'),
(59, 'adana');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sube`
--

CREATE TABLE `sube` (
  `subeID` int(11) NOT NULL,
  `subeAd` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `sehirID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `sube`
--

INSERT INTO `sube` (`subeID`, `subeAd`, `sehirID`) VALUES
(8, 'Yeşilpınar', 54),
(9, 'Bornova', 55),
(10, 'Keçiören', 56),
(11, 'Yıldırım', 57),
(12, 'Edremit', 58),
(13, 'Ceyhan', 59),
(14, 'Eyüp', 54);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `tarih`
--

CREATE TABLE `tarih` (
  `tarihID` int(11) NOT NULL,
  `yil` int(11) DEFAULT NULL,
  `ay` int(11) DEFAULT NULL,
  `gun` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `tarih`
--

INSERT INTO `tarih` (`tarihID`, `yil`, `ay`, `gun`) VALUES
(1, 2019, 1, 1),
(2, 2019, 4, 1),
(3, 2019, 7, 1),
(4, 2020, 1, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urun`
--

CREATE TABLE `urun` (
  `urunID` int(11) NOT NULL,
  `urunAd` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `miktar` int(11) NOT NULL,
  `faturaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `urun`
--

INSERT INTO `urun` (`urunID`, `urunAd`, `miktar`, `faturaID`) VALUES
(1, 'Gainer', 3, 1),
(2, 'Protein', 5, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uyeler`
--

CREATE TABLE `uyeler` (
  `uyeID` int(11) NOT NULL,
  `TCNO` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `uyeAd` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Soyad` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `TelefonNo` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Adres` varchar(50) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Email` varchar(30) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Cinsiyet` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Dogumtarihi` date DEFAULT NULL,
  `indeksID` int(11) DEFAULT NULL,
  `tipID` int(11) DEFAULT NULL,
  `uyelikID` int(11) DEFAULT NULL,
  `antrenorID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `uyeler`
--

INSERT INTO `uyeler` (`uyeID`, `TCNO`, `uyeAd`, `Soyad`, `TelefonNo`, `Adres`, `Email`, `Cinsiyet`, `Dogumtarihi`, `indeksID`, `tipID`, `uyelikID`, `antrenorID`) VALUES
(6, '321312', 'Ahmet', 'Aydin', '05447654433', 'ev adresi', 'ahmet.aydin', 'erkek', '2000-04-15', 1, 2, 2, 4);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uyeliktarihi`
--

CREATE TABLE `uyeliktarihi` (
  `uyelikID` int(11) NOT NULL,
  `baslama` date DEFAULT NULL,
  `bitis` date DEFAULT NULL,
  `sure` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `uyeliktarihi`
--

INSERT INTO `uyeliktarihi` (`uyelikID`, `baslama`, `bitis`, `sure`) VALUES
(1, '2019-01-01', '2019-02-01', 30),
(2, '2019-01-01', '2019-04-01', 90),
(3, '2019-01-01', '2019-07-01', 180),
(4, '2019-01-01', '2020-01-01', 365);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uyetip`
--

CREATE TABLE `uyetip` (
  `tipID` int(11) NOT NULL,
  `tipAd` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `bransID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `uyetip`
--

INSERT INTO `uyetip` (`tipID`, `tipAd`, `bransID`) VALUES
(1, 'Sporcu', 1),
(2, 'Atlet', 2),
(3, 'Dövüşçü', 3),
(4, 'Bisikletçi', 4);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yönetici`
--

CREATE TABLE `yönetici` (
  `ID` int(11) NOT NULL,
  `Password` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Ad` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL,
  `Soyad` varchar(11) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `yönetici`
--

INSERT INTO `yönetici` (`ID`, `Password`, `Ad`, `Soyad`) VALUES
(1, '12345', 'fatih', 'karaman'),
(2, '12345', 'admin', 'admin');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `antrenortip`
--
ALTER TABLE `antrenortip`
  ADD PRIMARY KEY (`tipID`),
  ADD KEY `bransID` (`bransID`);

--
-- Tablo için indeksler `antrenörler`
--
ALTER TABLE `antrenörler`
  ADD PRIMARY KEY (`antrenorID`),
  ADD KEY `antrenörler_ibfk_1` (`tipID`),
  ADD KEY `antrenörler_ibfk_2` (`subeID`);

--
-- Tablo için indeksler `branslar`
--
ALTER TABLE `branslar`
  ADD PRIMARY KEY (`bransID`);

--
-- Tablo için indeksler `ekipman`
--
ALTER TABLE `ekipman`
  ADD PRIMARY KEY (`ekipmanID`);

--
-- Tablo için indeksler `fatura`
--
ALTER TABLE `fatura`
  ADD PRIMARY KEY (`faturaID`),
  ADD KEY `odemeID` (`odemeID`),
  ADD KEY `uyeID` (`uyeID`);

--
-- Tablo için indeksler `indeks`
--
ALTER TABLE `indeks`
  ADD PRIMARY KEY (`indeksID`);

--
-- Tablo için indeksler `odeme`
--
ALTER TABLE `odeme`
  ADD PRIMARY KEY (`odemeID`);

--
-- Tablo için indeksler `sehir`
--
ALTER TABLE `sehir`
  ADD PRIMARY KEY (`sehirID`);

--
-- Tablo için indeksler `sube`
--
ALTER TABLE `sube`
  ADD PRIMARY KEY (`subeID`),
  ADD KEY `sube_ibfk_1` (`sehirID`);

--
-- Tablo için indeksler `tarih`
--
ALTER TABLE `tarih`
  ADD PRIMARY KEY (`tarihID`);

--
-- Tablo için indeksler `urun`
--
ALTER TABLE `urun`
  ADD PRIMARY KEY (`urunID`),
  ADD KEY `faturaID` (`faturaID`);

--
-- Tablo için indeksler `uyeler`
--
ALTER TABLE `uyeler`
  ADD PRIMARY KEY (`uyeID`),
  ADD KEY `tipID` (`tipID`),
  ADD KEY `uyelikID` (`uyelikID`),
  ADD KEY `antrenorID` (`antrenorID`),
  ADD KEY `indeksID` (`indeksID`);

--
-- Tablo için indeksler `uyeliktarihi`
--
ALTER TABLE `uyeliktarihi`
  ADD PRIMARY KEY (`uyelikID`);

--
-- Tablo için indeksler `uyetip`
--
ALTER TABLE `uyetip`
  ADD PRIMARY KEY (`tipID`),
  ADD KEY `bransID` (`bransID`);

--
-- Tablo için indeksler `yönetici`
--
ALTER TABLE `yönetici`
  ADD PRIMARY KEY (`ID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `antrenortip`
--
ALTER TABLE `antrenortip`
  MODIFY `tipID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Tablo için AUTO_INCREMENT değeri `antrenörler`
--
ALTER TABLE `antrenörler`
  MODIFY `antrenorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `branslar`
--
ALTER TABLE `branslar`
  MODIFY `bransID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `ekipman`
--
ALTER TABLE `ekipman`
  MODIFY `ekipmanID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `fatura`
--
ALTER TABLE `fatura`
  MODIFY `faturaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `indeks`
--
ALTER TABLE `indeks`
  MODIFY `indeksID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `odeme`
--
ALTER TABLE `odeme`
  MODIFY `odemeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `sehir`
--
ALTER TABLE `sehir`
  MODIFY `sehirID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- Tablo için AUTO_INCREMENT değeri `sube`
--
ALTER TABLE `sube`
  MODIFY `subeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `urun`
--
ALTER TABLE `urun`
  MODIFY `urunID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `uyeler`
--
ALTER TABLE `uyeler`
  MODIFY `uyeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `uyetip`
--
ALTER TABLE `uyetip`
  MODIFY `tipID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `yönetici`
--
ALTER TABLE `yönetici`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `antrenortip`
--
ALTER TABLE `antrenortip`
  ADD CONSTRAINT `antrenortip_ibfk_1` FOREIGN KEY (`bransID`) REFERENCES `branslar` (`bransID`);

--
-- Tablo kısıtlamaları `antrenörler`
--
ALTER TABLE `antrenörler`
  ADD CONSTRAINT `antrenörler_ibfk_1` FOREIGN KEY (`tipID`) REFERENCES `antrenortip` (`tipID`) ON UPDATE CASCADE,
  ADD CONSTRAINT `antrenörler_ibfk_2` FOREIGN KEY (`subeID`) REFERENCES `sube` (`subeID`) ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `fatura`
--
ALTER TABLE `fatura`
  ADD CONSTRAINT `fatura_ibfk_1` FOREIGN KEY (`odemeID`) REFERENCES `odeme` (`odemeID`),
  ADD CONSTRAINT `fatura_ibfk_2` FOREIGN KEY (`uyeID`) REFERENCES `uyeler` (`uyeID`);

--
-- Tablo kısıtlamaları `sube`
--
ALTER TABLE `sube`
  ADD CONSTRAINT `sube_ibfk_1` FOREIGN KEY (`sehirID`) REFERENCES `sehir` (`sehirID`) ON UPDATE CASCADE;

--
-- Tablo kısıtlamaları `urun`
--
ALTER TABLE `urun`
  ADD CONSTRAINT `urun_ibfk_1` FOREIGN KEY (`faturaID`) REFERENCES `fatura` (`faturaID`);

--
-- Tablo kısıtlamaları `uyeler`
--
ALTER TABLE `uyeler`
  ADD CONSTRAINT `uyeler_ibfk_2` FOREIGN KEY (`tipID`) REFERENCES `uyetip` (`tipID`),
  ADD CONSTRAINT `uyeler_ibfk_3` FOREIGN KEY (`uyelikID`) REFERENCES `uyeliktarihi` (`uyelikID`),
  ADD CONSTRAINT `uyeler_ibfk_4` FOREIGN KEY (`antrenorID`) REFERENCES `antrenörler` (`antrenorID`),
  ADD CONSTRAINT `uyeler_ibfk_5` FOREIGN KEY (`indeksID`) REFERENCES `indeks` (`indeksID`);

--
-- Tablo kısıtlamaları `uyetip`
--
ALTER TABLE `uyetip`
  ADD CONSTRAINT `uyetip_ibfk_1` FOREIGN KEY (`bransID`) REFERENCES `branslar` (`bransID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
