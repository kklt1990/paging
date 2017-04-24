# 创建学生数据表
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生的id',
  `name` varchar(16) NOT NULL COMMENT '学生的姓名',
  `sex` int(11) DEFAULT NULL COMMENT '学生的性别',
  `age` int(11) DEFAULT NULL COMMENT '学生的年龄',
  `address` varchar(128) DEFAULT NULL COMMENT '学生的地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

INSERT INTO `student` VALUES ('1', '王小军', '1', '17', '北京市东城区');
INSERT INTO `student` VALUES ('2', '李雷雷', '1', '16', '北京市朝阳区');
INSERT INTO `student` VALUES ('3', '张静', '2', '16', '北京市昌平区');
INSERT INTO `student` VALUES ('4', '王晓萌', '2', '17', '北京市顺义区');
INSERT INTO `student` VALUES ('5', '韩梅梅', '2', '16', '北京市朝阳区');
INSERT INTO `student` VALUES ('6', '李小军', '1', '17', '北京市海淀区');
INSERT INTO `student` VALUES ('7', '成龙', '1', '16', '北京市石景山区');
INSERT INTO `student` VALUES ('8', '李海飞', '2', '16', '北京市海淀区');
INSERT INTO `student` VALUES ('9', '罗红', '2', '16', '北京市朝阳区');
INSERT INTO `student` VALUES ('10', '孙海杰', '1', '16', '北京市石景山区');
INSERT INTO `student` VALUES ('11', '王海龙', '1', '16', '北京市东城区');
