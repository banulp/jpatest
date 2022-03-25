
https://spring.io/guides/gs/accessing-data-mysql/
https://heesutory.tistory.com/34

https://jdm.kr/blog/141

CREATE TABLE `member` (
`seq` INT(10) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NULL DEFAULT NULL,
PRIMARY KEY (`seq`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;
CREATE TABLE `phone` (
`seq` INT(10) NOT NULL AUTO_INCREMENT,
`member_id` INT(10) NULL DEFAULT NULL,
`no` VARCHAR(50) NULL DEFAULT NULL,
PRIMARY KEY (`seq`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

http://localhost:8080/demo/init
http://localhost:8080/demo/mlist/Dong
http://localhost:8080/demo/mlist