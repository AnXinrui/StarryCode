-- 数据库创建
create database if not exists StarryCode;

use StarryCode;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName  varchar(30)                           not null comment '用户名',
    userPassword varchar(30)                           not null comment '密码',
    nickName     varchar(30)  default '新用户' comment '用户昵称',
    userAvatar   varchar(1024) default 'https://cdn.acwing.com/media/user/profile/photo/384987_lg_df95fc8710.jpg'  comment '用户头像',
    userProfile  varchar(512)  default '该用户很懒，什么也没有写 =-='    null comment '用户简介',
--     userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除'
) comment '用户' collate = utf8mb4_unicode_ci;