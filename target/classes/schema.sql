create database seckill;

use seckill;

CREATE TABLE
    seckill.seckill
    (
        seckill_id BIGINT NOT NULL AUTO_INCREMENT,
        name VARCHAR(120) NOT NULL,
        NUMBER INT NOT NULL,
        start_time TIMESTAMP,
        end_time TIMESTAMP,
        create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (seckill_id),
        INDEX idx_start_time (start_time),
        INDEX idx_end_time (end_time),
        INDEX idx_create_time (create_time)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
insert into seckill(name,number,start_time,end_time)
values ('1000元秒杀phone6',100,'2016-01-31','2016-02-01'),
('500元秒杀ipad2',200,'2016-01-02','2016-02-03'),
('300元秒杀华为note8',300,'2016-01-03','2016-02-02'),
('200元秒杀小米2',400,'2016-01-04','2016-02-04');

create table success_killed(
seckill_id bigint not null,
user_phone bigint not null,
state tinyint not null default -1 comment '状态表示:-1无效,0成功,1已付款',
create_time timestamp not null,
primary key (seckill_id,user_phone),
key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '秒杀成功明细表';

