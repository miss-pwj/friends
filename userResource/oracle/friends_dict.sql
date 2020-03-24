create sequence friends_seq;

create table fridends_dict
(
   id                   number  not null  primary key ,	--设置自动自增序列,
   type                 varchar(50),
   value                varchar(50)
);
-- 数据字典表数据
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'education', '高中及以下');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'education', '中专');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'education', '大专');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'education', '大学本科');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'education', '硕士');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'education', '博士');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'marry_status', '未婚');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'marry_status', '离异');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'marry_status', '丧偶');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'live_condition', '和家人同住');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'live_condition', '已购房');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'live_condition', '租房');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'live_condition', '打算婚后购房');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'live_condition', '单位宿舍');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '销售');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '客户服务');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '计算机/互联网');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '通信/电子');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '生产/制造');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '物流/仓储');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '商贸/采购');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '人事/行政');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '高级管理');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '广告/市场');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '传媒/艺术');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '生物/制药');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '医疗/护理');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '金融/保险');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '建筑/房地产');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '咨询/顾问');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '法律');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '财会/审计');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '教育/科研');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '服务业');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '交通运输');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '政府机构');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '军人/警察');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '农林牧渔');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '自由职业');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '在校学生');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '待业');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job', '其他行业');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '鼠');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '牛');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '虎');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '兔');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '龙');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '蛇');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '马');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '羊');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '猴');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '鸡');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '狗');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'animal', '猪');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '白羊座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '金牛座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '双子座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '巨蟹座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '狮子座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '处女座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '天秤座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '天蝎座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '射手座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '摩羯座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '水平座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'zodiac', '双鱼座');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'religion', '不信教');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'religion', '佛教');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'religion', '道教');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'religion', '伊斯兰教');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'religion', '基督教');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'religion', '天主教');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'religion', '儒家门徒');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'religion', '不可知论者');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'religion', '其他宗教');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job_time', '有双休');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job_time', '工作忙碌');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job_time', '工作清闲');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job_time', '自由工作出差');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'job_time', '经常出差');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'love_history', '初恋还在');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'love_history', '谈过3次以内恋爱');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'love_history', '情场高手');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'marry_time', '认同闪婚');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'marry_time', '一年内');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'marry_time', '两年内');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'marry_time', '三年内');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'marry_time', '时机成熟就结婚');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'parent_status', '父母均健在');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'parent_status', '只有母亲健在');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'parent_status', '只有父亲健在');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'parent_status', '父母均已离世');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'bro_and_sis', '独生子女');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'bro_and_sis', '2');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'bro_and_sis', '3');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'bro_and_sis', '4');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'bro_and_sis', '更多');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'com_reason', '违法信息');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'com_reason', '有害信息');
INSERT INTO fridends_dict (id,type, value) VALUES (friends_seq.nextval,'com_reason', '人身攻击我');


select * from fridends_dict;