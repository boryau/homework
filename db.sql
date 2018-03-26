create table if not exists `payment`(
	`id` int(8) unsigned NOT NULL AUTO_INCREMENT,
    `amount` double(100,2) not null,
    `currency` varchar(3) not null,
    `user_id` varchar(36) not null,
	`payee_id` varchar(36) not null,
    `payment_method_id` varchar(36) not null,
    `status` varchar(36)  not null,
    `created` TIMESTAMP default current_timestamp,
    PRIMARY KEY (`id`)
);