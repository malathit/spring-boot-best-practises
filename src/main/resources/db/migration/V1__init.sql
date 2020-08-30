CREATE TABLE IF NOT EXISTS `customer` (
    `username` varchar(128) NOT NULL,
    `first_name` varchar(128) NOT NULL,
    `last_name` varchar(128) DEFAULT NULL,
    PRIMARY KEY(`username`)
);

INSERT INTO `customer`(`username`, `first_name`, `last_name`) values('abcd', 'abcd', 'efg');