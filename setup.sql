CREATE TABLE `Person` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '',
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
commit;


CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Mobile` varchar(15) NOT NULL,
  `CreationDate` datetime NOT NULL,
  `LastLoginDate` datetime DEFAULT NULL,
  `UserStatus` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `EMAIL_UNIQUE` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE `chantingsessionhistory` (
  `ChantingSessionHistoryId` int(11) NOT NULL AUTO_INCREMENT,
  `ChantingSessionStartTime` datetime NOT NULL,
  `ChantingSessionEndTime` datetime DEFAULT NULL,
  `ChantingSessionDate` date NOT NULL,
  `NumberOfBeads` int(11) DEFAULT NULL,
  `UserId` int(11) NOT NULL,
  PRIMARY KEY (`ChantingSessionHistoryId`),
  KEY `UserId_idx` (`UserId`),
  CONSTRAINT `CHANTINGSESSIONHISTORY_USER_FK` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
