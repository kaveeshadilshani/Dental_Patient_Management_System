CREATE TABLE `tbl_action_template_value` (
  `ID` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `ACTION_TEMPLATE_ID` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `ACTION_ID` char(32) COLLATE utf8_unicode_ci NOT NULL,
  `STATUS` tinyint(4) DEFAULT '0',
  `INSERT_USER_ID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `INSERT_DATETIME` datetime DEFAULT NULL,
  `UPDATE_USER_ID` char(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `UPDATE_DATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_action_template_id` (`ACTION_TEMPLATE_ID`),
  KEY `ACTION_ID` (`ACTION_ID`),
  CONSTRAINT `fk_action_template_id` FOREIGN KEY (`ACTION_TEMPLATE_ID`) REFERENCES `tbl_action_template` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tbl_action_template_value_ibfk_1` FOREIGN KEY (`ACTION_ID`) REFERENCES `tbl_action` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
