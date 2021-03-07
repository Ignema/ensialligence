CREATE TABLE IF NOT EXISTS `friend` (
  `idfriend` int NOT NULL AUTO_INCREMENT,
  `user_1` int DEFAULT NULL,
  `user_2` int DEFAULT NULL,
  PRIMARY KEY (`idfriend`),
  KEY `friend_i1` (`user_1`),
  KEY `friend_i2` (`user_2`),
  CONSTRAINT `FK_USER1` FOREIGN KEY (`user_1`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `FK_USER2` FOREIGN KEY (`user_2`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
