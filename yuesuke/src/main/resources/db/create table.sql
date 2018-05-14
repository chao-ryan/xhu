-- -- 删除表
DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS CLASS_INFO;
DROP TABLE IF EXISTS COLLEGE;
DROP TABLE IF EXISTS JOB_TITLE;
DROP TABLE IF EXISTS TEACHERS;
DROP TABLE IF EXISTS STUDENTS;
DROP TABLE IF EXISTS ROOM;
DROP TABLE IF EXISTS CLASS_RELATION;


-- -- 创建学号信息表account:
-- -- 	ID主键,account_number学生学号,password密码,save_time添加时间,update_time修改时间
CREATE TABLE ACCOUNT(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	ACCOUNT_NUMBER VARCHAR(30) NOT NULL COMMENT '学生学号/账户',
	`PASSWORD` VARCHAR(30) NOT NULL COMMENT '密码',
	SAVE_TIME DATETIME NOT NULL COMMENT '保存时间 yyyy-MM-dd HH:mm:ss',
	UPDATE_TIME DATETIME NOT NULL COMMENT '更新时间 yyyy-MM-dd HH:mm:ss'
)ENGINE=INNODB COMMENT '学号信息表';


-- -- 创建教师职称表job_title:
-- -- 	id主键,job_name职称
CREATE TABLE JOB_TITLE(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	JOB_NAME VARCHAR(50) COMMENT '职称'
)ENGINE=INNODB COMMENT '教师职称表';


-- -- 创建学生宿舍信息表room:
-- -- 	id主键,area宿舍区域,loudong楼栋号,floor_number楼层号,room_number房间号,auntie_name宿管阿姨姓名,students_number学生人数,empty_room空房间数,is_full是否已入住满
CREATE TABLE ROOM(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	AREA VARCHAR(30) COMMENT '宿舍区域',
	LOUDONG VARCHAR(8) COMMENT '楼栋号',
	FLOOR_NUMBER VARCHAR(8) COMMENT '楼层号',
	ROOM_NUMBER VARCHAR(8) COMMENT '房间号',
	AUNTIE_NAME VARCHAR(30) COMMENT '宿管阿姨姓名',
	STUDENTS_NUMBER INT COMMENT '学生人数',
	EMPTY_ROOM INT COMMENT '空房间数',
	IS_FULL TINYINT(1) DEFAULT 1 COMMENT '是否已入住满 0-否，1-是（默认）'
)ENGINE=INNODB COMMENT '学生宿舍信息表';


-- -- 创建班级信息表class_info:
-- -- 	ID主键,number班级编号,name班级名称,major班级专业,student_number学生人数,teachers_id辅导员（外键，一对一）,college_id学院（外键，多对一）,
-- -- 	,save_time添加时间,update_time更新时间
CREATE TABLE CLASS_INFO(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	NUMBER VARCHAR(30) NOT NULL COMMENT '班级编号',
	`NAME` VARCHAR(30) NOT NULL COMMENT '班级名称',
	MAJOR VARCHAR(30) COMMENT '班级专业',
	STUDENTS_NUMBER INT COMMENT '学生人数',
	TEACHERS_ID BIGINT COMMENT '辅导员外键（一对一）' REFERENCES TEACHERS(ID),
	SAVE_TIME DATETIME NOT NULL COMMENT '添加时间 yyyy-MM-dd HH:mm:ss',
	UPDATE_TIME DATETIME NOT NULL COMMENT '更新时间 yyyy-MM-dd HH:mm:ss'
)ENGINE=INNODB COMMENT '班级信息表';


-- -- 创建班级关系表class_relation:
CREATE TABLE CLASS_RELATION(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	GRADE VARCHAR(30) COMMENT '年级',
	COLLEGE_ID BIGINT COMMENT '学院信息表外键' REFERENCES COLLEGE(ID),
	CLASS_INFO_ID BIGINT COMMENT '班级信息表外键' REFERENCES CLASS_INFO(ID),
	STUDENTS_ID BIGINT COMMENT '学生信息表外键' REFERENCES STUDENTS(ID)
)ENGINE=INNODB COMMENT '学生班级关系表';


-- -- 创建学院信息表college:
-- -- 	ID主键,name学院名称,students_number学生人数,teachers_number教师人数,save_time创建时间,update_time更新时间
CREATE TABLE COLLEGE(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	`NAME` VARCHAR(50) COMMENT '学院名称',
	STUDENTS_NUMBER INT COMMENT '学生人数',
	TEACHERS_NUMBER INT COMMENT '教师人数',
	SAVE_TIME DATETIME NOT NULL COMMENT '创建时间 yyyy-MM-dd HH:mm:ss',
	UPDATE_TIME DATETIME COMMENT '更新时间 yyyy-MM-dd HH:mm:ss'
)ENGINE=INNODB COMMENT '学院信息表';


-- -- 创建教师信息表teachers:
-- -- 	ID主键,name教师姓名,sex教师性别,age教师年龄,origin籍贯,nation民族,id_number身份证号,phone手机号,salary工资,
-- -- 	college_id学院（外键，多对一）,job_title教师职称（多对一）, save_time入职时间,update_time更新时间
CREATE TABLE TEACHERS(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	`NAME` VARCHAR(30) COMMENT '教师姓名',
	SEX TINYINT(1) COMMENT '教师性别 0-女，1-男',
	AGE INT COMMENT '教师年龄',
	ORIGIN VARCHAR(50) COMMENT '籍贯',
	NATION VARCHAR(30) COMMENT '民族',
	ID_NUMBER VARCHAR(50) COMMENT '身份证号',
	PHONE VARCHAR(30) COMMENT '手机号',
	SALARY DOUBLE COMMENT '工资',
	COLLEGE_ID BIGINT COMMENT '学院外键（多对一）' REFERENCES COLLEGE(ID),
	JOB_TITLE_ID BIGINT COMMENT '教师职称外键（多对一）' REFERENCES JOB_TITLE(ID),
	SAVE_TIME DATETIME COMMENT '录入时间 yyyy-MM-dd HH:mm:ss',
	UPDATE_TIME DATETIME COMMENT '更新时间 yyyy-MM-dd HH:mm:ss'
)ENGINE=INNODB COMMENT '教师信息表';


-- -- 创建学生个人信息表students:
-- -- 	ID主键，name学生姓名,sex学生性别,birthday学生出生年月（yyyy-MM）,origin籍贯,enthnic民族,id_number身份证号,university学校名字,
-- -- 	achievement高考成绩,class_info_id班级（外键，多对一）,college_id学院（外键，多对一）,room_id宿舍（外键，多对一）,
-- -- 	account_id学号（外键，一对一）
-- -- 	phone手机号,father_name父亲姓名,father_phone父亲联系方式,father_adress父亲现居地,mother_name母亲姓名,
-- -- 	mother_phone母亲联系方式,mother_adress母亲现居地,family_population家庭人口,save_time保存时间,update_time更新时间
CREATE TABLE STUDENTS(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	`NAME` VARCHAR(30) NOT NULL COMMENT '学生姓名',
	SEX TINYINT(1) NOT NULL COMMENT '学生性别 0-女，1-男',
	BIRTHDAY DATE COMMENT '出生年月日 yyyy-MM-dd',
	ORIGIN VARCHAR(50) COMMENT '籍贯',
	ENTHNIC VARCHAR(30) COMMENT '民族',
	ID_NUMBER VARCHAR(50) COMMENT '身份证号',
	UNIVERSITY VARCHAR(100) COMMENT '学校名字',
	ACHIEVEMENT DOUBLE COMMENT '高考成绩',
	PHONE VARCHAR(30) COMMENT '手机号',
	FATHER_NAME VARCHAR(30) COMMENT '父亲名字',
	FATHER_PHONE VARCHAR(30) COMMENT '父亲联系方式',
	FATHER_ADDRESS VARCHAR(50) COMMENT '父亲现居地',
	MOTHER_NAME VARCHAR(30) COMMENT '母亲名字',
	MOTHER_PHONE VARCHAR(30) COMMENT '母亲联系方式',
	MOTHER_ADDRESS VARCHAR(50) COMMENT '母亲现居地',
	FAMILY_POPULATION INT COMMENT '家庭人口',
	SAVE_TIME DATETIME NOT NULL COMMENT '保存时间 yyyy-MM-dd HH:mm:ss',
	UPDATE_TIME DATETIME NOT NULL COMMENT '更新时间 yyyy-MM-dd HH:mm:ss',
	ROOM_ID BIGINT COMMENT '宿舍外键（多对一）' REFERENCES ROOM(ID),
	ACCOUNT_ID BIGINT COMMENT '学生学号外键（一对一）' REFERENCES ACCOUNT(ID)
)ENGINE=INNODB COMMENT '学生信息表';






