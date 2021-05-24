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

insert into cities (name, region, country, create_at, update_at)
values ('Москва', 'Московская область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Санкт-Петербург', 'Ленинградская область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Ростов-на-Дону', 'Ростовская область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Нижний Новгород', 'Нижегородская область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Тольятти', 'Самарская область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Владимир', 'Владимирская область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Екатеринбург', 'Свердловская область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Калининград', 'Калининградcкая область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Воронеж', 'Воронежская область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Владивосток', 'Приморский край', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       ('Волгоград', 'Волгоградская область', 'Россия', DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'));

insert into style_level (style, level, create_at, update_at)
values (1, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (1, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (1, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (1, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (2, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (2, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (2, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (2, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (3, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (3, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (3, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (3, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (4, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (4, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (4, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (4, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (5, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (5, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (5, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (5, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (6, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (6, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (6, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (6, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (7, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (7, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (7, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (7, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (8, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (8, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (8, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (8, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (9, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (9, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (9, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (9, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (10, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (10, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (10, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (10, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (11, 1, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (11, 2, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')),
       (11, 3, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s')), (11, 4, DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'), DATE_FORMAT(NOW(),'%y-%c-%d %H:%i:%s'));