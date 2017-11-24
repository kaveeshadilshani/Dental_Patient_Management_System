CREATE TABLE `tbl_action_template` (
  `ID` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `NAME` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `DISPLAY_NAME` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `COMMENT` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT '0',
  `INSERT_USER_ID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INSERT_DATETIME` datetime DEFAULT NULL,
  `UPDATE_USER_ID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UPDATE_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
