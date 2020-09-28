create table `item`(
    `id` int(11) not null auto_increment,
    `code` varchar(255) default null comment '商品编号',
    `name` varchar(255) character set utf8mb4 default null comment '商品名称',
    `create_time` datetime default null,
    primary key (`id`)
)ENGINE = Innodb default character set =utf8 comment = '商品信息表';