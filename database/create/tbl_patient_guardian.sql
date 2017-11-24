CREATE TABLE `tbl_patient_guardian` (
  `ID` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `PATIENT_ID` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `RELATIONSHIP` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ADDRESS` text COLLATE utf8_unicode_ci,
  `TELEPHONE_HOME` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TELEPHONE_MOBILE` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `NIC` char(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `OCUPATION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MONTHLY_INCOME` decimal(10,2) DEFAULT NULL,
  `COMMENT` text COLLATE utf8_unicode_ci,
  `STATUS` tinyint(4) DEFAULT '1',
  `SORT_ORDER` int(4) DEFAULT '1',
  `INSERT_USER_ID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UPDATE_USER_ID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INSERT_DATETIME` datetime DEFAULT NULL,
  `UPDATE_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `tbl_patient_guardian_ibfk_1` (`PATIENT_ID`),
  CONSTRAINT `tbl_patient_guardian_ibfk_1` FOREIGN KEY (`PATIENT_ID`) REFERENCES `tbl_patient` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8
COLLATE=utf8_unicode_ci;