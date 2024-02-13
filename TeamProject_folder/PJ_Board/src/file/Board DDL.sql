create database board;
use board;

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
	`u_id`	varchar(13) NOT NULL primary key,
	`u_pw`	varchar(20) not NULL,
	`u_mail`	varchar(30) not null unique,
	`u_phone`	varchar(13) not null unique,
	`u_name`	varchar(10) not NULL,
	`u_admin`	int not null default 0,
	`u_try`	int default 0,
    `u_state` boolean default false
);

DROP TABLE IF EXISTS `Board`;

CREATE TABLE `Board` (
	`b_num`	int auto_increment NOT NULL primary key,
	`b_name`	varchar(20) not NULL,
	`b_c_num`	int NOT NULL
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
	`p_num`	int auto_increment NOT NULL primary key,
	`p_title`	varchar(50) not NULL,
	`p_content`	text not NULL,
	`p_date`	date not NULL,
	`p_view`	int default 0 not NULL,
	`p_b_num`	int NOT NULL,
	`p_u_id`	varchar(13) NOT NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`c_num`	int auto_increment NOT NULL primary key,
	`c_name`	varchar(20) not null unique
);

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
	`r_num`	int auto_increment NOT NULL primary key,
	`r_content`	text not NULL,
	`r_date`	date not NULL,
	`r_u_id`	varchar(13) NOT NULL,
	`r_p_num`	int NOT NULL
);

ALTER TABLE `Board` ADD CONSTRAINT `FK_category_TO_Board_1` FOREIGN KEY (
	`b_c_num`
)
REFERENCES `category` (
	`c_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_Board_TO_post_1` FOREIGN KEY (
	`p_b_num`
)
REFERENCES `Board` (
	`b_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_User_TO_post_1` FOREIGN KEY (
	`p_u_id`
)
REFERENCES `User` (
	`u_id`
);

ALTER TABLE `reply` ADD CONSTRAINT `FK_User_TO_reply_1` FOREIGN KEY (
	`r_u_id`
)
REFERENCES `User` (
	`u_id`
);

ALTER TABLE `reply` ADD CONSTRAINT `FK_post_TO_reply_1` FOREIGN KEY (
	`r_p_num`
)
REFERENCES `post` (
	`p_num`
);
