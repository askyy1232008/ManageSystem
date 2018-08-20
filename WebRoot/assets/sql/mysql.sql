
CREATE TABLE `tb_user` (
  `userID` INT(11) AUTO_INCREMENT NOT NULL COMMENT '用户ID',
  `userName` NVARCHAR(128) NOT NULL COMMENT '登录名',
  `password` NVARCHAR(128) NOT NULL COMMENT '登录密码',
  `phoneNumber` NVARCHAR(20) NOT NULL COMMENT '手机号码',
  `organization` NVARCHAR(128) NOT NULL COMMENT '组织',
  `createTime` DATETIME NOT NULL COMMENT '账户创建时间',
  `lastLoginTime` DATETIME DEFAULT NULL COMMENT '上一次登录的时间',
  `status` INT(11) NOT NULL COMMENT '用户状态，1为正常，0为禁用',
  `isOnline` BIT NOT NULL COMMENT '是否在线，1为在线，0为不在线',
  PRIMARY KEY (`UserID`)
)ENGINE=INNODB  DEFAULT CHARSET=utf8;
SELECT * FROM `tb_user`;
INSERT INTO `tb_user`(
  `userName`,
  `password`,
  `phoneNumber`,
  `organization`,
  `createTime`,
  `lastLoginTime`,
  `status`,
  `isOnline`
)VALUES(
  'user',
  '123',
  '18270581222',
  '高安行者',
  '2017-07-20 09:26:00',
  '2017-07-20 09:26:00',
  1,
  0
);
SELECT	* FROM tb_user