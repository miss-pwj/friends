select * from fridends_dict;

update fridends_dict set type='marry_plan' where type='marry_time';


create table perfectInfo(
    username varchar2(20) primary key,      --用户名
    education varchar2(20),                 --学历
    salary number(10),                      --月薪
    height number(10),                      --身高
    weight number(5),                       --体重
    live_condition varchar(20),             --居住环境
            
    job varchar(10),                        --工作
    zodiac varchar(5),                      --生肖
    constellation varchar(5),               --星座
    faith varchar(10),                      --信仰
    job_time varchar(20),                   --休假
    marry_plan varchar(20),                 --结婚打算
    parent_status varchar(20),              --父母情况
    bro_and_sis varchar(10),                  --兄弟姐妹数量
     constraint FK_perfectInfo_userbasic foreign key(username) references user_basic(username)  on delete cascade 
);
alter table perfectInfo modify bro_and_sis varchar(10);
alter table fridends_dict rename to user_dict;

desc user_dict

alter table perfectInfo  modify  salary  default 0  ;
alter table perfectInfo  modify  height  default 0  ;
alter table perfectInfo  modify  weight  default 0  ;
alter table perfectInfo modify  job varchar2(20) ;

desc perfectInfo 
alter table perfectInfo add birthday varchar2(20);
commit;
select  *from perfectInfo;