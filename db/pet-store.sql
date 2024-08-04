CREATE TABLE `pet` (
	`id` INTEGER NOT NULL UNIQUE,
	`master_id` INTEGER,
	`shop_id` INTEGER,
	`name` VARCHAR(255),
	`type` VARCHAR(255),
	`health` INTEGER,
	`intimacy` INTEGER,
	`birthday` DATETIME,
	PRIMARY KEY(`id`)
);


CREATE TABLE `master` (
	`id` INTEGER NOT NULL UNIQUE,
	`login_name` VARCHAR(255),
	`login_pass` VARCHAR(255),
	`balance` INTEGER,
	PRIMARY KEY(`id`)
);


CREATE TABLE `shop` (
	`id` INTEGER NOT NULL UNIQUE,
	`login_name` VARCHAR(255),
	`login_pass` VARCHAR(255),
	`balance` INTEGER,
	PRIMARY KEY(`id`)
);


CREATE TABLE `bill` (
	`id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
	`shop_id` INTEGER,
	`pet_id` INTEGER,
	`seller_id` INTEGER,
	`buyer_id` INTEGER,
	`transaction_type` VARCHAR(255),
	`transaction_price` INTEGER,
	`transaction_time` DATETIME,
	PRIMARY KEY(`id`)
);


ALTER TABLE `pet`
ADD FOREIGN KEY(`master_id`) REFERENCES `master`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `pet`
ADD FOREIGN KEY(`shop_id`) REFERENCES `shop`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `bill`
ADD FOREIGN KEY(`pet_id`) REFERENCES `pet`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `bill`
ADD FOREIGN KEY(`seller_id`) REFERENCES `master`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `bill`
ADD FOREIGN KEY(`buyer_id`) REFERENCES `master`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `bill`
ADD FOREIGN KEY(`shop_id`) REFERENCES `shop`(`id`)
ON UPDATE NO ACTION ON DELETE NO ACTION;