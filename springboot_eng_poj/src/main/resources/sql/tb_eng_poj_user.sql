create table tb_eng_poj_user(
    id int unsigned primary key auto_increment comment"用户ID",
    username varchar(20) comment"用户姓名",
    nickname varchar(20) default '' comment"用户昵称",
    password varchar(50) comment"用户密码",
    emily varchar(128) default '' comment"用户邮箱",
    number varchar(30) comment"用户手机号码",
    user_pic varchar(128) default '' comment"头像",
    create_time datetime not null comment"创建时间",
    update_time datetime not null comment"修改时间"
)comment"tb_eng_poj_user表，学英语项目用户表";