select * from fridends_dict;

update fridends_dict set type='marry_plan' where type='marry_time';


create table perfectInfo(
    username varchar2(20) primary key,      --�û���
    education varchar2(20),                 --ѧ��
    salary number(10),                      --��н
    height number(10),                      --���
    weight number(5),                       --����
    live_condition varchar(20),             --��ס����
            
    job varchar(10),                        --����
    zodiac varchar(5),                      --��Ф
    constellation varchar(5),               --����
    faith varchar(10),                      --����
    job_time varchar(20),                   --�ݼ�
    marry_plan varchar(20),                 --������
    parent_status varchar(20),              --��ĸ���
    bro_and_sis varchar(10),                  --�ֵܽ�������
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