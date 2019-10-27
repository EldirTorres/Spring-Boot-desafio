CREATE TABLE `USERS` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) DEFAULT NULL,
`email` varchar(255) DEFAULT NULL,
`password` varchar(255) DEFAULT NULL,
`created` date DEFAULT NULL,
`modified` date DEFAULT NULL,
`last_login` date DEFAULT NULL,
`token` varchar(255) DEFAULT NULL,
`isactive` char(1) DEFAULT '1'
PRIMARY KEY (`id`)
)