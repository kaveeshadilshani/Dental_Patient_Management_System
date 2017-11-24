CREATE TABLE `tbl_district` (
  `ID` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `NAME` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PROVINCE_ID` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `COMMENT` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT '1',
  `SORT_ORDER` int(4) DEFAULT '1',
  `INSERT_USER_ID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UPDATE_USER_ID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INSERT_DATETIME` datetime DEFAULT NULL,
  `UPDATE_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `PROVINCE_ID` (`PROVINCE_ID`),
  CONSTRAINT `tbl_district_ibfk_1` FOREIGN KEY (`PROVINCE_ID`) REFERENCES `tbl_province` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;