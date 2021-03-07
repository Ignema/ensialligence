CREATE TABLE IF NOT EXISTS `jaime` (
  `idjaime` int NOT NULL AUTO_INCREMENT,
  `id` int DEFAULT NULL,
  `idarticle` int DEFAULT NULL,
  PRIMARY KEY (`idjaime`),
  UNIQUE KEY `idjaime_UNIQUE` (`idjaime`),
  KEY `FK_USER_idx` (`id`),
  KEY `FK_ART_JAIME_idx` (`idarticle`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;