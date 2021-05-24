DROP TABLE IF EXISTS `cities`;
CREATE TABLE `cities`
(
    `id`        mediumint unsigned NOT NULL AUTO_INCREMENT,
    `name`      varchar(45) NOT NULL,
    `region`    varchar(45) NOT NULL,
    `country`   varchar(45) NOT NULL,
    `create_at` TIMESTAMP   NOT NULL,
    `update_at` TIMESTAMP   NOT NULL,
    `active`    BOOLEAN     NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- DROP TABLE IF EXISTS `styles`;
-- CREATE TABLE `styles`
-- (
--     `id`        smallint unsigned NOT NULL AUTO_INCREMENT,
--     `value`     tinyint unsigned NOT NULL,
--     `create_at` TIMESTAMP NOT NULL,
--     `update_at` TIMESTAMP NOT NULL,
--     `active`    BOOLEAN   NOT NULL DEFAULT TRUE,
--     PRIMARY KEY (`id`)
-- ) ENGINE = InnoDB
--   DEFAULT CHARSET = utf8mb4
--   COLLATE = utf8mb4_0900_ai_ci;

-- DROP TABLE IF EXISTS `level`;
-- CREATE TABLE `level`
-- (
--     `id`        smallint unsigned NOT NULL AUTO_INCREMENT,
--     `value`     tinyint unsigned NOT NULL,
--     `create_at` TIMESTAMP NOT NULL,
--     `update_at` TIMESTAMP NOT NULL,
--     `active`    BOOLEAN   NOT NULL DEFAULT TRUE,
--     PRIMARY KEY (`id`)
-- ) ENGINE = InnoDB
--   DEFAULT CHARSET = utf8mb4
--   COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `style_level`;
CREATE TABLE `style_level`
(
    `id`        smallint unsigned NOT NULL AUTO_INCREMENT,
    `style`  smallint unsigned NOT NULL,
    `level`  smallint unsigned NOT NULL,
    `create_at` TIMESTAMP NOT NULL,
    `update_at` TIMESTAMP NOT NULL,
    `active`    BOOLEAN   NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`id`)
--     KEY         `us_style_fk_idx` (`style_id`),
--     KEY         `us_skill_fk_idx` (`level_id`),
--     CONSTRAINT `us_level_fk` FOREIGN KEY (`level_id`) REFERENCES `level` (`id`),
--     CONSTRAINT `us_style_fk` FOREIGN KEY (`style_id`) REFERENCES `styles` (`id`)
) ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`            int unsigned NOT NULL AUTO_INCREMENT,
    `email`         varchar(90),
    `password`      varchar(21),
    `phone`         varchar(45),
    `name`          varchar(45) NOT NULL,
    `nick_telegram` varchar(33),
    `birth_date`    date,
    `weight`        tinyint unsigned NOT NULL,
    `sex`           tinyint     NOT NULL,
    `city_id`       mediumint unsigned NOT NULL,
    `about`         varchar(16000),
    `create_at`     TIMESTAMP   NOT NULL,
    `update_at`     TIMESTAMP   NOT NULL,
    `active`        BOOLEAN     NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`id`),
    UNIQUE KEY `phone_fld_UNIQUE` (`phone`),
    CONSTRAINT `fk_user_city` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `user_styles`;
CREATE TABLE `user_styles`
(
    `user_id`        int unsigned NOT NULL,
    `style_level_id` smallint unsigned NOT NULL,
    `create_at`      TIMESTAMP NOT NULL,
    `update_at`      TIMESTAMP NOT NULL,
    `active`         BOOLEAN   NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`user_id`, `style_level_id`),
    KEY              `user_style_key_idx` (`user_id`),
    KEY              `style_user_key_idx` (`style_level_id`),
    CONSTRAINT `fk_user_key` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    CONSTRAINT `fk_style_level_key` FOREIGN KEY (`style_level_id`) REFERENCES `style_level` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `images_user`;
CREATE TABLE `images_user`
(
    `id`        smallint unsigned NOT NULL AUTO_INCREMENT,
    `user_id`   int unsigned NOT NULL,
    `path`      varchar(255) NOT NULL,
    `create_at` TIMESTAMP    NOT NULL,
    `update_at` TIMESTAMP    NOT NULL,
    `active`    BOOLEAN      NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_image_user_key` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;