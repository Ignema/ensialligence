CREATE TABLE IF NOT EXISTS `article` (
  `idarticle` int NOT NULL AUTO_INCREMENT,
  `id` int DEFAULT NULL,
  `titre` varchar(300) DEFAULT NULL,
  `categorie` varchar(300) DEFAULT NULL,
  `image` longblob,
  `video` longblob,
  `nbjaimeart` int DEFAULT NULL,
  PRIMARY KEY (`idarticle`),
  KEY `article_i1` (`id`),
  CONSTRAINT `FK_ART` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

