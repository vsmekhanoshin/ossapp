DROP TABLE IF EXISTS `cities_tbl`;
CREATE TABLE `cities_tbl`
(
    `id`        mediumint unsigned NOT NULL AUTO_INCREMENT,
    `name_fld`  varchar(45)        NOT NULL,
    `create_at` TIMESTAMP          NOT NULL,
    `update_at` TIMESTAMP          NOT NULL,
    `active`    BOOLEAN            NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `styles_tbl`;
CREATE TABLE `styles_tbl`
(
    `id`        smallint unsigned NOT NULL AUTO_INCREMENT,
    `name_fld`  varchar(45)       NOT NULL,
    `create_at` TIMESTAMP         NOT NULL,
    `update_at` TIMESTAMP         NOT NULL,
    `active`    BOOLEAN           NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `level_style_tbl`;
CREATE TABLE `level_style_tbl`
(
    `id`        smallint unsigned NOT NULL AUTO_INCREMENT,
    `value`     tinyint unsigned  NOT NULL,
    `create_at` TIMESTAMP         NOT NULL,
    `update_at` TIMESTAMP         NOT NULL,
    `active`    BOOLEAN           NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `users_tbl`;
CREATE TABLE `users_tbl`
(
    `id`             int unsigned       NOT NULL AUTO_INCREMENT,
    `phone_fld`      varchar(45)        NOT NULL,
    `name_fld`       varchar(45)        NOT NULL,
    `birth_date_fld` date               NOT NULL,
    `weight_fld`     tinyint unsigned   NOT NULL,
    `sex_fld`        tinyint            NOT NULL,
    `city_id`        mediumint unsigned NOT NULL,
    `about_fld`      varchar(16000)     NOT NULL,
    `create_at`      TIMESTAMP          NOT NULL,
    `update_at`      TIMESTAMP          NOT NULL,
    `active`         BOOLEAN            NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`id`),
    UNIQUE KEY `phone_fld_UNIQUE` (`phone_fld`),
    CONSTRAINT `fk_user_city` FOREIGN KEY (`city_id`) REFERENCES `cities_tbl` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `user_styles_tbl`;
CREATE TABLE `user_styles_tbl`
(
    `user_id`   int unsigned      NOT NULL,
    `style_id`  smallint unsigned NOT NULL,
    `level_id`  smallint unsigned NOT NULL,
    `create_at` TIMESTAMP         NOT NULL,
    `update_at` TIMESTAMP         NOT NULL,
    `active`    BOOLEAN           NOT NULL DEFAULT TRUE,
    KEY `user_style_key_idx` (`user_id`),
    KEY `style_user_key_idx` (`style_id`),
    CONSTRAINT `fk_style_user_key` FOREIGN KEY (`style_id`) REFERENCES `styles_tbl` (`id`),
    CONSTRAINT `fk_user_style_key` FOREIGN KEY (`user_id`) REFERENCES `users_tbl` (`id`),
    CONSTRAINT `fk_style_level_key` FOREIGN KEY (`level_id`) REFERENCES `level_style_tbl` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `images_user_tbl`;
CREATE TABLE `images_user_tbl`
(
    `id`        smallint unsigned NOT NULL AUTO_INCREMENT,
    `user_id`   int unsigned      NOT NULL,
    `path_fld`  varchar(255)      NOT NULL,
    `create_at` TIMESTAMP         NOT NULL,
    `update_at` TIMESTAMP         NOT NULL,
    `active`    BOOLEAN           NOT NULL DEFAULT TRUE,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_image_user_key` FOREIGN KEY (`user_id`) REFERENCES `users_tbl` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

