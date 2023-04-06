# Databases

简介

- 数据库（DataBase，DB）：指长期保存在计算机的存储设备上，按照一定规则组织起来，可以被各种用户或应用共享的数据集合。简单理解数据的仓库。
- 数据库管理系统（DataBase Management System，DBMS）：指一种操作和管理数据库的大型软件，用于建立、使用和维护数据库，对数据库进行统一管理和控制，以保证数据库的安全性和完整性。用户通过数据库管理系统访问数据库中的数据。
- 数据库是通过数据库管理系统创建和操作的。

常见数据库管理系统

- Oracle：Oracle数据库被认为是业界目前比较成功的关系型数据库管理系统。Oracle数据库可以运行在UNIX、Windows等主流操作系统平台，完全支持所有的工业标准，并获得最高级别的ISO标准安全性认证。
- MySQL：MySQL是一个关系型数据库管理系统，由瑞典MySQL AB 公司开发，目前属于 Oracle旗下产品。MySQL 是最流行的关系型数据库管理系统之一，在 WEB 应用方面，MySQL是最好的 RDBMS (Relational Database Management System，关系数据库管理系统) 应用软件。
- DB2：DB2是IBM公司的产品，DB2数据库系统采用多进程多线索体系结构，其功能足以满足大中公司的需要，并可灵活地服务于中小型电子商务解决方案。
- Microsoft SQL Server：SQL Server 是Microsoft 公司推出的关系型数据库管理系统。具有使用方便可伸缩性好与相关软件集成程度高等优点。
- SQLLite:应用在手机端的数据库。

客户端工具

1.3.1 Navicat的安装

1.3.2 Navicat的使用

- 使用自动完成代码，默认选中第1个   使用 TAB键

   > https://blog.csdn.net/lss0217/article/details/102625628

1.3.3 DataGrip的安装

1.3.4 DataGrip的使用

## MySQL

### 概述

- SQL：Structure Query Language（结构化查询语言），SQL被美国国家标准局（ANSI）确定为关系型数据库语言的美国标准，后来被国际化标准组织（ISO）采纳为关系数据库语言的国际标准。
- SQL 是一种标准化的语言，它允许你在数据库上执行操作，如创建数据库、表等等，查询内容，更新内容，并删除条目等操作。
- Create, Read, Update, and Delete 通常称为CRUD操作。
- MySQL注释：（1）#开头 （2）--空格 开头  （3）/* 多行注释 */

```
# 注释
-- 注释
/*注释*/
```

#### 分类

- DDL（Data Definition Language）：数据定义语言，用来定义数据库对象：库、表、列等。
- DML（Data Manipulation Language）：数据操作语言，用来定义数据库记录（数据）。
- DQL（Data Query Language）：数据查询语言，用来查询记录（数据）。
- DCL（Data Control Language）：数据控制语言，用来定义访问权限和安全级别。

#### Windows安装MySQL

#### Linux安装MySQL

### DDL 

#### 操作数据库

##### 系统默认数据库

- information_schema：information_schema数据库是MySQL自带的，它提供了访问数据库元数据的方式。什么是元数据呢？元数据是关于数据的数据，如数据库名或表名，列的数据类型，或访问权限等。 别动！

- mysql:mysql：这个是mysql的核心数据库,主要负责存储数据库的用户、权限设置、关键字等mysql自己需要使用的控制和管理信息，不可以删除。

- performance_schema：性能优化的数据库

- test:这个是安装时候创建的一个测试数据库，和它的名字一样，是一个完全的空数据库，没有任何表，可以删除。

##### 显示所有数据库

```
show databases;   # 显示当前mysql中的数据库
```

##### 创建数据库

```sql
CREATE DATABASE IF NOT EXISTS test DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
```

##### 查看创建数据库的定义信息

```sql
ShOW CREATE DATABASE test;
```

##### 修改数据库字符集;

```sql
ALTER DATABASE mydb2 character SET utf8;
```

##### 删除数据库

```sql
DROP DATABASE IF EXISTS test;
```

##### 当前使用的数据库

```sql
Select database(); #没有选择数据 null
```

##### 切换数据库

```sql
USE test;
```

##### 查看数据库编码的具体信息

```
Show variables like ‘character%’;
```

##### 显示当前时间、用户名、数据库版本

```
SELECT now(), user(), version();
```

#### 操作表

##### 创建表。

```sql
CREATE TABLE  IF NOT EXISTS `student`
(
   `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
   `name` VARCHAR(50) Unique,
   `age` INT Default 0, 
   `address` VARCHAR(100)   # 最后一个字段无序写逗号，否则报错
) CHARSET=utf8; # 不能写成 utf-8

注意：数据库名、表名、字段名可以使用反勾号` 括住，也可以不括。如果SQL关键字一般要括住。
```

##### 删除表

```sql
DROP TABLE student;
```

##### 查询数据库中的所有表

```
SHOW TABLES;
```

##### 添加列

```
ALTER TABLE student ADD image blob;
```

##### 表的第一列添加一个字段

```
　　ALTER TABLE tb_dept1 ADD column2 INT(11) FIRST;
```

##### 在表的指定列之后添加一个字段

```
　　ALTER TABLE tb_dept1 ADD column3 INT(11) AFTER name;
```

##### 修改列

```
ALTER TABLE student MODIFY address varchar(60);
```

##### 删除列

```
ALTER TABLE student DROP image;
```

##### 修改表名

```
RENAME TABLE student TO user;
```

##### 查看表的创建语句

```
SHOW CREATE TABLE user;
```

##### 查看表的字段信息

```
DESC student; 或者 DESCRIBE student;
```

##### 修改表的字符集

```
ALTER TABLE user CHARACTER SET gbk;
```

##### 修改列名

```
ALTER TABLE user CHANGE name username varchar(100);
```

#####  清空表数据

```
TRUNCATE TABLE student;
```

##### 查看所有表

```
 SHOW TABLES
 SHOW TABLES FROM  库名
```

### DML

#### INSERT 

​	语法： INSERT INTO 表名（列名1，列名2 ...）VALUES(列值1，列值2...);

- 列名与列值的类型、个数、顺序要一一对应。
- 可以把列名当做java中的形参，把列值当做实参。
- 参数不要超出列定义的长度。
- 如果插入空值，请使用null
- 插入的日期和字符一样，都使用单引号括起来。

##### 一次添加一条数据

```sql
INSERT INTO student(id,name,age,address) values (1,'zhangsan',20,'北京海淀');
INSERT INTO student(id,name,age,address) values (2,'lisi',22,'上海浦东');
INSERT INTO student(id,name,age,address) values (3,'wangwu',23,'北京昌平');
```

##### 一次添加多条数据

```sql
INSERT INTO student(id,name,age,address) values (4,'曹操',27,'北京海淀'),
											(5,'周瑜',28,'北京朝阳'),
											(6,'赵云',30,'北京大兴');
```

#### UPDATE

​	语法：UPDATE 表名 SET 列名1=列值1,列名2=列值2 ... WHERE 列名=值

##### 一次修改一条数据

```
UPDATE student SET address='河北保定',age=33 WHERE id=1;
```

##### 一次修改多条数据

```
UPDATE student SET age=age+5;
```

#### DELETE

​	语法 ： DELETE FROM 表名 【WHERE 列名=值】

##### 一次删除一条数据

```
DELETE FROM student WHERE name=‘zhangsan’;
```

##### 一次删除所有数据

```
DELETE FROM student;
```

##### 一次删除所有数据

```
TRUNCATE TABLE studnet;
```

- DELETE 删除表中的数据，表结构还在;删除后的数据使用日志可以找回。
- TRUNCATE 删除是把表直接DROP掉，然后再创建一个同样的新表。
- TRUNCATE 删除的数据不能找回。执行速度比DELETE快。


### DQL

语法： SELECT 列名 FROM 表名 【WHERE --> GROUP BY-->HAVING--> ORDER BY-->LIMIT】

```mysql
  SELECT selection_list /*要查询的列名称*/
  FROM table_list /*要查询的表名称*/
  WHERE condition /*行条件*/
  GROUP BY grouping_columns /*对结果分组*/
  HAVING condition /*分组后的行条件*/
  ORDER BY sorting_columns /*对结果排序*/
  LIMIT offset_start, row_count /*结果限定*/
```

**示例操作：**

​	1>创建学生表并添加数据

```sql
# 创建表stu
CREATE TABLE stu (
	sid	CHAR(6),
	sname		VARCHAR(50),
	age		INT,
	gender	VARCHAR(50)
);
#添加数据
INSERT INTO stu VALUES('S_1001', 'liuYi', 35, 'male');
INSERT INTO stu VALUES('S_1002', 'chenEr', 15, 'female');
INSERT INTO stu VALUES('S_1003', 'zhangSan', 95, 'male');
INSERT INTO stu VALUES('S_1004', 'liSi', 65, 'female');
INSERT INTO stu VALUES('S_1005', 'wangWu', 55, 'male');
INSERT INTO stu VALUES('S_1006', 'zhaoLiu', 75, 'female');
INSERT INTO stu VALUES('S_1007', 'sunQi', 25, 'male');
INSERT INTO stu VALUES('S_1008', 'zhouBa', 45, 'female');
INSERT INTO stu VALUES('S_1009', 'wuJiu', 85, 'male');
INSERT INTO stu VALUES('S_1010', 'zhengShi', 5, 'female');
INSERT INTO stu VALUES('S_1011', 'xxx', NULL, NULL);
```

2>创建雇员表并添加数据

```sql
#创建雇员表
CREATE TABLE emp(
	empno		INT,
	ename		VARCHAR(50),
	job		VARCHAR(50),
	mgr		INT,
	hiredate	DATE,
	sal		DECIMAL(7,2),
	comm		decimal(7,2),
	deptno		INT
);
#添加数据
INSERT INTO emp values(7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO emp values(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO emp values(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,500,30);
INSERT INTO emp values(7566,'JONES','MANAGER',7839,'1981-04-02',2975,NULL,20);
INSERT INTO emp values(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
INSERT INTO emp values(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,NULL,30);
INSERT INTO emp values(7782,'CLARK','MANAGER',7839,'1981-06-09',2450,NULL,10);
INSERT INTO emp values(7788,'SCOTT','ANALYST',7566,'1987-04-19',3000,NULL,20);
INSERT INTO emp values(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO emp values(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO emp values(7876,'ADAMS','CLERK',7788,'1987-05-23',1100,NULL,20);
INSERT INTO emp values(7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30);
INSERT INTO emp values(7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20);
INSERT INTO emp values(7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10);
```

3>创建部门表并添加数据

```sql
#创建部门表
CREATE TABLE dept(
	deptno		INT,
	dname		varchar(14),
	loc		varchar(13)
)CHARSET=utf8;
#添加数据
INSERT INTO dept values(10, '财务部', 'beijing');
INSERT INTO dept values(20, 'java开发部', 'tianjin');
INSERT INTO dept values(30, '测试部', 'shanghai');
INSERT INTO dept values(40, '销售部', 'shenzheng');
```

#### 简单查询

查询所有列  *表示所有列

​		`SELECT * FROM stu;`

查询指定列

​		`SELECT sid, sname, age FROM stu;`

#### 条件查询

条件查询就是在查询时给出WHERE子句，在WHERE子句中可以使用如下运算符及关键字：

- 查询性别为女，并且年龄小于50的记录

```sql
SELECT * FROM stu WHERE gender='female' AND age<50;
```

- 查询学号为S_1001，或者姓名为liSi的记录

```sql
SELECT * FROM stu WHERE sid ='S_1001' OR sname='liSi';
```

- 查询学号为S _ 1001 ，S _ 1002，S _ 1003的记录

```sql
SELECT * FROM stu 
WHERE sid IN ('S_1001','S_1002','S_1003');
等同于
SELECT * FROM stu 
WHERE sid='S_1001' or sid='S_1002' or sid='S_1003';
```

- 查询学号不是S_1001，S_1002，S_1003的记录

```sql
SELECT * FROM tab_student 
WHERE sid NOT IN('S1001','S1002','S_1003');
```

- 查询年龄为null的记录

```sql
SELECT * FROM stu WHERE age IS NULL;
```

- 查询年龄在20到40之间的学生记录

```sql
SELECT * 
FROM stu 
WHERE age BETWEEN 20 AND 40;
```

- 查询性别非男的学生记录

```sql
SELECT * 
FROM stu
WHERE NOT gender='male';
```

- 查询姓名不为null的学生记录

```sql
SELECT * 
FROM stu
WHERE sname IS NOT NULL;
```

#### 模糊查询

关键字LIKE。

通配符: 

​	_ 任意一个字符

​    %：任意0~n个字符

- 查询姓名由5个字符构成，并且第5个字符为“i”的学生记录

```sql
SELECT * 
FROM stu
WHERE sname LIKE '____i';
```

- 查询姓名以“z”开头的学生记录

```sql
SELECT * 
FROM stu
WHERE sname LIKE 'z%';
```

- 查询姓名中包含“a”字符的学生记录

```sql
SELECT * 
FROM stu
WHERE sname LIKE '%a%';
```

#### 字段控制查询

- 去除重复记录

去除重复记录（两行或两行以上记录中列的数据都相同）

```sql
SELECT DISTINCT sal FROM emp;
SELECT DISTINCT sal,comm FROM emp;
```

- 两列之和

　	因为sal和comm两列的类型都是数值类型，所以可以做加运算。如果sal或comm中有一个字段不是数值类型，那么会出错。

```sql
SELECT *,sal+comm FROM emp;
```

**注：任何东西与NULL相加结果还是NULL，使用函数IFNULL把NULL转换成数值0的**

```
SELECT *,sal+IFNULL(comm,0) FROMemp;
```

- 给列名添加别名

在上面查询中出现列名为sal+comm，这很不美观，现在我们给这一列给出一个别名，为total：

```sql
SELECT *, sal+IFNULL(comm,0) AS total FROM emp;
```

**注：给列起别名时，也可以省略AS关键字**

#### 排序

使用 ORDER  BY 

- 升序（ASC 默认）

```sql
SELECT *
FROM stu
ORDER BY age ASC;
```

- 降序（DESC）

```sql
SELECT *
FROM stu
ORDER BY age DESC; 
```

#### 聚合函数   

- COUNT()：统计指定列不为NULL的记录行数；
- MAX()：计算指定列的最大值，如果指定列是字符串类型，那么使用字符串排序运算；
- MIN()：计算指定列的最小值，如果指定列是字符串类型，那么使用字符串排序运算；
- SUM()：计算指定列的数值和，如果指定列类型不是数值类型，那么计算结果为0；
- AVG()：计算指定列的平均值，如果指定列类型不是数值类型，那么计算结果为0；

COUNT

- 查询emp表中记录数：

```sql
SELECT COUNT(*) AS ‘cnt’ FROM emp;
```

- 查询emp表中月薪大于2500的人数：

```sql
SELECT COUNT(*) FROM emp
WHERE sal > 2500;
```

SUM和AVG

- 查询所有雇员月薪+佣金和：

```sql
SELECT SUM(sal+IFNULL(comm,0))FROM emp;
```

- 统计所有员工平均工资：

```sql
SELECT AVG(sal) FROM emp;
```

MAX和MIN

- 查询最高工资和最低工资：

```sql
SELECT MAX(sal), MIN(sal) FROM emp;
```

#### 分组查询

使用GROUP BY子句

**注：凡是和聚合函数同时出现的列名，则一定要写在group by 之后**

分组查询

- 查询每个部门的部门编号和每个部门的工资和：

```sql
SELECT deptno, SUM(sal)
FROM emp
GROUP BY deptno;
```

- 查询每个部门的部门编号以及每个部门的人数：

```sql
SELECT deptno,COUNT(*)
FROM emp
GROUP BY deptno;
```

- 查询每个部门的部门编号以及每个部门工资大于1500的人数：

```sql
SELECT deptno,COUNT(*)
FROM emp
WHERE sal>1500
GROUP BY deptno;
```

HAVING子句

- 查询工资总和大于9000的部门编号以及工资和：

```sql
SELECT deptno, SUM(sal)
FROM emp
GROUP BY deptno
HAVING SUM(sal) > 9000;
```

​      **注：having与where的区别:**

- 1.having是在分组后对数据进行过滤,where是在分组前对数据进行过滤             
- 2.having后面可以使用分组函数(统计函数)
- where后面不可以使用分组函数。
- where是对分组前记录的条件，如果某行记录没有满足WHERE子句的条件，那么这行记录不会参加分组；having是对分组后数据的约束。

#### LIMIT限制

LIMIT用来限定查询结果的起始行，以及总行数。

- 查询10行记录，起始行从3开始

```sql
SELECT* FROM emp LIMIT 3, 10;
```

**总结单表查询**

- 查询语句书写顺序：select  列 from 表 【where- group by- having- order by-limit】
- 查询语句执行顺序：from 表 where -group by -having - select - order by-limit   

#### 多表查询

多个表之间是有关系的，那么关系靠谁来维护?

多表约束：外键约束。

多表的关系

- 一对多关系

   一对多建表原则：在多的一方创建一个字段，字段作为外键指向一方的主键.

- 多对多关系

   多对多关系建表原则：需要创建第三张表,中间表中至少两个字段，这两个字段分别作为外键指向各自一方的主键.

- 一对一关系

   在实际的开发中应用不多.因为一对一可以创建成一张表.

两种建表原则：

唯一外键对应：在多的一方创建一个外键指向一的一方的主键，将外键设置为unique和非空.

主键对应：让一对一的双方的主键进行建立关系. 唯一非空

多表查询

（1）合并结果集：把两个select语句的查询结果合并到一起！

合并结果集有两种方式：

UNION：去除重复记录，例如：SELECT* FROM t1 UNION SELECT * FROM t2；

UNION ALL：不去除重复记录，例如：SELECT * FROM t1 UNION ALL SELECT * FROM t2。

注意：被合并的两个结果：列数必须相同，列类型可以不同。

连接查询

连接查询就是求出多个表的乘积，例如t1连接t2，那么查询出的结果就是t1*t2。

连接查询会产生笛卡尔积，假设集合A={a,b}，集合B={0,1,2}，则两个集合的笛卡尔积为{(a,0),(a,1),(a,2),(b,0),(b,1),(b,2)}。可以扩展到多个集合的情况。

那么多表查询产生这样的结果并不是我们想要的，那么怎么去除重复的，不想要的记录呢，当然是通过条件过滤。通常要查询的多个表之间都存在关联关系，那么就通过关联关系去除笛卡尔积。

emp表

```sql
CREATE TABLE emp(
	empno	int,
	ename	varchar(50),
	job		varchar(50),
	mgr		int,
	hiredate	date,
	sal		decimal(7,2),
	comm	decimal(7,2),
	deptno	int
);
#添加数据SQL语句省略
```

dept表

```sql
CREATE TABLE dept(
	deptno		int,
	dname		varchar(14),
	loc		varchar(13)
);
#添加数据SQL语句省略
```

执行如下SQL语句

```sql
select * from emp,dept;
```

**使用主外键关系做为条件来去除无用信息**

```sql
SELECT * FROM emp,dept WHERE emp.deptno=dept.deptno;
```

上面查询结果会把两张表的所有列都查询出来，也许你不需要那么多列，这时就可以指定要查询的列了。

```sql
SELECT emp.ename,emp.sal,emp.comm,dept.dname 
FROM emp,dept 
WHERE emp.deptno=dept.deptno;
```

（1）内连接

上面的连接语句就是内连接，但它不是SQL标准中的查询方式，可以理解为方言！

SQL标准的内连接为：

```sql
SELECT * 
FROM emp e 
INNER JOIN dept d 
ON e.deptno=d.deptno;
注意：on后面 主外键关系
```

内连接的特点：查询结果必须满足条件。

（2）外连接

包括左外连接和右外连接，外连接的特点：查询出的结果存在不满足条件的可能。

a.左外连接：以左表为主表，右表是从表

```sql
SELECT * FROM emp e 
LEFT OUTER JOIN dept d 
ON e.deptno=d.deptno;
```

左连接是先查询出左表（即以左表为主），然后查询右表，左表中满足条件和不满足条件都显示出来，右边不满足条件的显示NULL。

我们还是用上面的例子来说明。其中emp表中“张三”这条记录中，部门编号为50，而dept表中不存在部门编号为50的记录，所以“张三”这条记录，不能满足e.deptno=d.deptno这条件。但在左连接中，因为emp表是左表，所以左表中的记录都会查询出来，即“张三”这条记录也会查出，但相应的右表部分显示NULL。

b.右外连接

右连接就是先把右表中所有记录都查询出来，然后左表满足条件的显示，不满足显示NULL。例如在dept表中的40部门并不存在员工，但在右连接中，如果dept表为右表，那么还是会查出40部门，但相应的员工信息为NULL。

```sql
SELECT * FROM emp e 
RIGHT OUTER JOIN dept d 
ON e.deptno=d.deptno;
```

**连接查询总结：**

​	连接不限于两张表，连接查询也可以是三张、四张，甚至N张表的连接查询。通常连接查询不可能需要整个笛卡尔积，而只是需要其中一部分，那么这时就需要使用条件来去除不需要的记录。这个条件大多数情况下都是使用主外键关系去除。

子查询（嵌套查询）

子查询出现的位置：

​	a. where后，作为被查询的条件的一部分；

​	b. from后，作临时表；

当子查询出现在where后作为条件时，还可以使用如下关键字：

​	a. any  跟结果集里面的多行单列部分进行比较，满足就返回true

​	b. all  跟结果里面的多行单列所有进行比较,所有都满足了才返回true

子查询结果集的常见形式： 

​	a. 单行单列（用于条件）

​	b. 多行单列（用于条件）

​	c. 多行多列（用于表）

示例：

**1.   工资高于JONES的员工。**

分析：

查询条件：工资>JONES工资，其中JONES工资需要一条子查询。

第一步：查询JONES的工资

```sql
SELECT sal FROM emp WHERE ename='JONES';
```

第二步：查询高于JONES工资的员工

```sql
SELECT * FROM emp WHERE sal > (第一步结果);
```

结果：

```sql
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename='JONES');
```

### DCL

> https://www.cnblogs.com/Rohn/p/11722515.html

#### 创建用户

```
CREATE USER `zhangsan` IDENTIFIED BY '123';
CREATE USER `zhangsan`@`localhost` IDENTIFIED BY '123';
```

#### 授权

```
GRANT ALL ON school.* TO `zhangsan`;
```

#### 撤销权限

```
REVOKE ALL ON school.* FROM `zhangsan`;
```

#### 新建用户

```
create user 'buyi'@localhost identified by 'buyi';
```

#### 删除用户

```
DROP USER `zhangsan`; 
```

见6.2创建用户和授权 

```
/* 用户和权限管理 */ ------------------
-- root密码重置
1. 停止MySQL服务
2.  [Linux] /usr/local/mysql/bin/safe_mysqld --skip-grant-tables &
    [Windows] mysqld --skip-grant-tables
3. use mysql;
4. UPDATE `user` SET PASSWORD=PASSWORD("密码") WHERE `user` = "root";
5. FLUSH PRIVILEGES;
用户信息表：mysql.user
-- 刷新权限
FLUSH PRIVILEGES;
-- 增加用户
CREATE USER 用户名 IDENTIFIED BY [PASSWORD] 密码(字符串)
    - 必须拥有mysql数据库的全局CREATE USER权限，或拥有INSERT权限。
    - 只能创建用户，不能赋予权限。
    - 用户名，注意引号：如 'user_name'@'192.168.1.1'
    - 密码也需引号，纯数字密码也要加引号
    - 要在纯文本中指定密码，需忽略PASSWORD关键词。要把密码指定为由PASSWORD()函数返回的混编值，需包含关键字PASSWORD
-- 重命名用户
RENAME USER old_user TO new_user
-- 设置密码
SET PASSWORD = PASSWORD('密码')  -- 为当前用户设置密码
SET PASSWORD FOR 用户名 = PASSWORD('密码') -- 为指定用户设置密码
-- 删除用户
DROP USER 用户名
-- 分配权限/添加用户
GRANT 权限列表 ON 表名 TO 用户名 [IDENTIFIED BY [PASSWORD] 'password']
    - all privileges 表示所有权限
    - *.* 表示所有库的所有表
    - 库名.表名 表示某库下面的某表
    GRANT ALL PRIVILEGES ON `pms`.* TO 'pms'@'%' IDENTIFIED BY 'pms0817';
-- 查看权限
SHOW GRANTS FOR 用户名
    -- 查看当前用户权限
    SHOW GRANTS; 或 SHOW GRANTS FOR CURRENT_USER; 或 SHOW GRANTS FOR CURRENT_USER();
-- 撤消权限
REVOKE 权限列表 ON 表名 FROM 用户名
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 用户名   -- 撤销所有权限
-- 权限层级
-- 要使用GRANT或REVOKE，您必须拥有GRANT OPTION权限，并且您必须用于您正在授予或撤销的权限。
全局层级：全局权限适用于一个给定服务器中的所有数据库，mysql.user
    GRANT ALL ON *.*和 REVOKE ALL ON *.*只授予和撤销全局权限。
数据库层级：数据库权限适用于一个给定数据库中的所有目标，mysql.db, mysql.host
    GRANT ALL ON db_name.*和REVOKE ALL ON db_name.*只授予和撤销数据库权限。
表层级：表权限适用于一个给定表中的所有列，mysql.talbes_priv
    GRANT ALL ON db_name.tbl_name和REVOKE ALL ON db_name.tbl_name只授予和撤销表权限。
列层级：列权限适用于一个给定表中的单一列，mysql.columns_priv
    当使用REVOKE时，您必须指定与被授权列相同的列。
-- 权限列表
ALL [PRIVILEGES]    -- 设置除GRANT OPTION之外的所有简单权限
ALTER   -- 允许使用ALTER TABLE
ALTER ROUTINE   -- 更改或取消已存储的子程序
CREATE  -- 允许使用CREATE TABLE
CREATE ROUTINE  -- 创建已存储的子程序
CREATE TEMPORARY TABLES     -- 允许使用CREATE TEMPORARY TABLE
CREATE USER     -- 允许使用CREATE USER, DROP USER, RENAME USER和REVOKE ALL PRIVILEGES。
CREATE VIEW     -- 允许使用CREATE VIEW
DELETE  -- 允许使用DELETE
DROP    -- 允许使用DROP TABLE
EXECUTE     -- 允许用户运行已存储的子程序
FILE    -- 允许使用SELECT...INTO OUTFILE和LOAD DATA INFILE
INDEX   -- 允许使用CREATE INDEX和DROP INDEX
INSERT  -- 允许使用INSERT
LOCK TABLES     -- 允许对您拥有SELECT权限的表使用LOCK TABLES
PROCESS     -- 允许使用SHOW FULL PROCESSLIST
REFERENCES  -- 未被实施
RELOAD  -- 允许使用FLUSH
REPLICATION CLIENT  -- 允许用户询问从属服务器或主服务器的地址
REPLICATION SLAVE   -- 用于复制型从属服务器（从主服务器中读取二进制日志事件）
SELECT  -- 允许使用SELECT
SHOW DATABASES  -- 显示所有数据库
SHOW VIEW   -- 允许使用SHOW CREATE VIEW
SHUTDOWN    -- 允许使用mysqladmin shutdown
SUPER   -- 允许使用CHANGE MASTER, KILL, PURGE MASTER LOGS和SET GLOBAL语句，mysqladmin debug命令；允许您连接（一次），即使已达到max_connections。
UPDATE  -- 允许使用UPDATE
USAGE   -- “无权限”的同义词
GRANT OPTION    -- 允许授予权限
```

### 数据完整性

作用：保证用户输入的数据保存到数据库中是正确的。

确保数据的完整性 = 在创建表时给表中添加约束

完整性的分类：

- 实体完整性: 行
- 域完整性: 列
- 引用完整性:  学生表(学号 ,姓名)   成绩表( 学号,科目,成绩)   科目表（科目编号，科目名称）

#### 实体完整性约束

实体：即表中的一行(一条记录)代表一个实体（entity）

实体完整性的作用：标识每一行数据不重复。   实体唯一

约束类型：

**主键约束（primary key）** 

 **唯一约束(unique)**  

**自动增长列(auto_increment)**

#### 主键约束（primary key）

​	注：每个表中要有一个主键。

​	特点：数据唯一，且不能为null

第一种添加方式：

```sql
CREATE TABLE student(
	id int primary key,
	name varchar(50)
);
```

第二种添加方式：此种方式优势在于，可以创建联合主键

```sql
CREATE TABLE student(
	classid int,
	stuid int,
	name varchar(50),
	primary key(classid，stuid)
);
```

#### 唯一约束(unique)      

特点：数据不能重复。可以为null

```sql
CREATE TABLE student(
	Id int primary key,
	Name varchar(50) unique
);
```

#### 自动增长列(auto_increment)  

```sql
CREATE TABLE student(
	Id int primary key auto_increment,
	Name varchar(50)
) auto_increment=100;
INSERT INTO student(name) values(‘tom’);
```

#### 域完整性约束

域完整性约束的作用：限制此单元格的数据正确，不对其它单元格起作用，域代表当前单元格

域完整性约束：数据类型、非空约束（not null）、默认值约束(default)  

check约束（mysql不支持）check(sex='男'or  sex='女')

#### 数据类型

```
/* 数据类型（列类型） */ ------------------
1. 数值类型
-- a. 整型 ----------
    类型         字节     范围（有符号位）
    tinyint     1字节    -128 ~ 127      无符号位：0 ~ 255
    smallint    2字节    -32768 ~ 32767
    mediumint   3字节    -8388608 ~ 8388607
    int         4字节
    bigint      8字节
    int(M)  M表示总位数
    - 默认存在符号位，unsigned 属性修改
    - 显示宽度，如果某个数不够定义字段时设置的位数，则前面以0补填，zerofill 属性修改
        例：int(5)   插入一个数'123'，补填后为'00123'
    - 在满足要求的情况下，越小越好。
    - 1表示bool值真，0表示bool值假。MySQL没有布尔类型，通过整型0和1表示。常用tinyint(1)表示布尔型。
-- b. 浮点型 ----------
    类型             字节     范围
    float(单精度)     4字节
    double(双精度)    8字节
    浮点型既支持符号位 unsigned 属性，也支持显示宽度 zerofill 属性。
        不同于整型，前后均会补填0.
    定义浮点型时，需指定总位数和小数位数。
        float(M, D)     double(M, D)
        M表示总位数，D表示小数位数。
        M和D的大小会决定浮点数的范围。不同于整型的固定范围。
        M既表示总位数（不包括小数点和正负号），也表示显示宽度（所有显示符号均包括）。
        支持科学计数法表示。
        浮点数表示近似值。
-- c. 定点数 ----------
    decimal -- 可变长度
    decimal(M, D)   M也表示总位数，D表示小数位数。
    保存一个精确的数值，不会发生数据的改变，不同于浮点数的四舍五入。
    将浮点数转换为字符串来保存，每9位数字保存为4个字节。
2. 字符串类型
-- a. char, varchar ----------
    char    定长字符串，速度快，但浪费空间
    varchar 变长字符串，速度慢，但节省空间
    M表示能存储的最大长度，此长度是字符数，非字节数。
    不同的编码，所占用的空间不同。
    char,最多255个字符，与编码无关。
    varchar,最多65535字符，与编码有关。
    一条有效记录最大不能超过65535个字节。
        utf8 最大为21844个字符，gbk 最大为32766个字符，latin1 最大为65532个字符
    varchar 是变长的，需要利用存储空间保存 varchar 的长度，如果数据小于255个字节，则采用一个字节来保存长度，反之需要两个字节来保存。
    varchar 的最大有效长度由最大行大小和使用的字符集确定。
    最大有效长度是65532字节，因为在varchar存字符串时，第一个字节是空的，不存在任何数据，然后还需两个字节来存放字符串的长度，所以有效长度是65535-1-2=65532字节。
    例：若一个表定义为 CREATE TABLE tb(c1 int, c2 char(30), c3 varchar(N)) charset=utf8; 问N的最大值是多少？ 答：(65535-1-2-4-30*3)/3
-- b. blob, text ----------
    blob 二进制字符串（字节字符串）
        tinyblob, blob, mediumblob, longblob
    text 非二进制字符串（字符字符串）
        tinytext, text, mediumtext, longtext
    text 在定义时，不需要定义长度，也不会计算总长度。
    text 类型在定义时，不可给default值
-- c. binary, varbinary ----------
    类似于char和varchar，用于保存二进制字符串，也就是保存字节字符串而非字符字符串。
    char, varchar, text 对应 binary, varbinary, blob.
3. 日期时间类型
    一般用整型保存时间戳，因为PHP可以很方便的将时间戳进行格式化。
    datetime    8字节    日期及时间     1000-01-01 00:00:00 到 9999-12-31 23:59:59
    date        3字节    日期         1000-01-01 到 9999-12-31
    timestamp   4字节    时间戳        19700101000000 到 2038-01-19 03:14:07
    time        3字节    时间         -838:59:59 到 838:59:59
    year        1字节    年份         1901 - 2155
datetime    YYYY-MM-DD hh:mm:ss
timestamp   YY-MM-DD hh:mm:ss
            YYYYMMDDhhmmss
            YYMMDDhhmmss
            YYYYMMDDhhmmss
            YYMMDDhhmmss
date        YYYY-MM-DD
            YY-MM-DD
            YYYYMMDD
            YYMMDD
            YYYYMMDD
            YYMMDD
time        hh:mm:ss
            hhmmss
            hhmmss
year        YYYY
            YY
            YYYY
            YY
4. 枚举和集合
-- 枚举(enum) ----------
enum(val1, val2, val3...)
    在已知的值中进行单选。最大数量为65535.
    枚举值在保存时，以2个字节的整型(smallint)保存。每个枚举值，按保存的位置顺序，从1开始逐一递增。
    表现为字符串类型，存储却是整型。
    NULL值的索引是NULL。
    空字符串错误值的索引值是0。
-- 集合（set） ----------
set(val1, val2, val3...)
    create table tab ( gender set('男', '女', '无') );
    insert into tab values ('男, 女');
    最多可以有64个不同的成员。以bigint存储，共8个字节。采取位运算的形式。
    当创建表时，SET成员值的尾部空格将自动被删除。
```

- 数值类型

| 类型             | 大小                                     | 范围（有符号）                                          | 范围（无符号）                  | 用途           |
| ---------------- | ---------------------------------------- | ------------------------------------------------------- | ------------------------------- | -------------- |
| TINYINT          | 1 字节                                   | (-128，127)                                             | (0，255)                        | 小整数值       |
| SMALLINT         | 2 字节                                   | (-32 768，32 767)                                       | (0，65 535)                     | 大整数值       |
| MEDIUMINT        | 3 字节                                   | (-8 388 608，8 388 607)                                 | (0，16 777 215)                 | 大整数值       |
| **INT或INTEGER** | 4 字节                                   | (-2 147 483 648，2 147 483 647)                         | (0，4 294 967 295)              | 大整数值       |
| BIGINT           | 8 字节                                   | (-9 233 372 036 854 775 808，9 223 372 036 854 775 807) | (0，18 446 744 073 709 551 615) | 极大整数值     |
| FLOAT            | 4 字节                                   | 查看帮助文档                                            | 查看帮助文档                    | 单精度浮点数值 |
| DOUBLE           | 8 字节                                   | 查看帮助文档                                            | 查看帮助文档                    | 双精度浮点数值 |
| **DOUBLE(M,D)**  | 8个字节，M表示长度，D表示小数位数        | 同上，受M和D的约束   DUBLE(5,2) -999.99-999.99          | 同上，受M和D的约束              | 双精度浮点数值 |
| **DECIMAL(M,D)** | 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2 | 依赖于M和D的值，M最大值为65                             | 依赖于M和D的值，M最大值为65     | 小数值         |

- 日期类型:

表示时间值的日期和时间类型为DATETIME、DATE、TIMESTAMP、TIME和YEAR。

每个时间类型有一个有效值范围和一个"零"值，当指定不合法的MySQL不能表示的值时使用"零"值。

TIMESTAMP类型有专有的自动更新特性

| 类型         | 大小(字节) | 范围                                                         | 格式                | 用途                     |
| ------------ | ---------- | ------------------------------------------------------------ | ------------------- | ------------------------ |
| **DATE**     | 3          | 1000-01-01/9999-12-31                                        | YYYY-MM-DD          | 日期值                   |
| TIME         | 3          | '-838:59:59'/'838:59:59'                                     | HH:MM:SS            | 时间值或持续时间         |
| YEAR         | 1          | 1901/2155                                                    | YYYY                | 年份值                   |
| **DATETIME** | 8          | 1000-01-01 00:00:00/9999-12-31 23:59:59                      | YYYY-MM-DD HH:MM:SS | 混合日期和时间值         |
| TIMESTAMP    | 4          | 1970-01-01 00:00:00/2038 结束时间是第 **2147483647** 秒，北京时间 **2038-1-19 11:14:07**，格林尼治时间 2038年1月19日 凌晨 03:14:07 | YYYYMMDD HHMMSS     | 混合日期和时间值，时间戳 |

- 字符串类型:

字符串类型指CHAR、VARCHAR、BINARY、VARBINARY、BLOB、TEXT、ENUM和SET

| 类型                            | 大小                | 用途                              |
| ------------------------------- | ------------------- | --------------------------------- |
| **CHAR**                        | 0-255字符           | 定长字符串  char(10) 10个字符     |
| **VARCHAR**                     | 0-65535 字节        | 变长字符串  varchar(10)  10个字符 |
| TINYBLOB                        | 0-255字节           | 不超过 255 个字符的二进制字符串   |
| TINYTEXT                        | 0-255字节           | 短文本字符串                      |
| **BLOB**（binary large object） | 0-65 535字节        | 二进制形式的长文本数据            |
| **TEXT**                        | 0-65 535字节        | 长文本数据                        |
| MEDIUMBLOB                      | 0-16 777 215字节    | 二进制形式的中等长度文本数据      |
| MEDIUMTEXT                      | 0-16 777 215字节    | 中等长度文本数据                  |
| LONGBLOB                        | 0-4 294 967 295字节 | 二进制形式的极大文本数据          |
| LONGTEXT                        | 0-4 294 967 295字节 | 极大文本数据                      |

CHAR和VARCHAR类型类似，但它们保存和检索的方式不同。它们的最大长度和是否尾部空格被保留等方面也不同。在存储或检索过程中不进行大小写转换。

BINARY和VARBINARY类类似于CHAR和VARCHAR，不同的是它们包含二进制字符串而不要非二进制字符串。也就是说，它们包含字节字符串而不是字符字符串。这说明它们没有字符集，并且排序和比较基于列值字节的数值值。

BLOB是一个二进制大对象，可以容纳可变数量的数据。有4种BLOB类型：TINYBLOB、BLOB、MEDIUMBLOB和LONGBLOB。它们只是可容纳值的最大长度不同。

有4种TEXT类型：TINYTEXT、TEXT、MEDIUMTEXT和LONGTEXT。

#### 非空约束

not null

```sql
CREATE TABLE student(
	Id int primary key,
	Name varchar(50) not null,
	Sex varchar(10)
);
INSERT INTO student values(1,’tom’,null);
```

#### 默认值约束 

default

```sql
CREATE TABLE student(
	Id int primary key,
	Name varchar(50) not null,
	Sex varchar(10) default '男'
);
insert intostudent1 values(1,'tom','女');
insert intostudent1 values(2,'jerry',default);
```

#### 引用完整性约束（参照完整性约束）

#### 外键约束：FOREIGN KEY 

第一种添加外键方式。推荐

```sql
#学生表(主表)
CREATE TABLE student(
	sid int primary key,
	name varchar(50) not null,
	sex varchar(10) default '男'
);
```

```sql
#成绩表（从表）
create table score(
        id int,
        score int,
        sid int , 
        CONSTRAINT fk_score_sid foreign key(sid) references student(sid)
);
-- 外键列的数据类型一定要与主键的类型一致
```

第二种添加外键方式。 不推荐

```sql
ALTER TABLE score ADD CONSTRAINT fk_stu_score FOREIGN KEY(sid) REFERENCES student(sid);
```

### MySQL函数

#### 数学

- 绝对值函数ABS(x)

```
mysql> select abs(-23);
+----------+
| abs(-23) |
+----------+
|       23 |
+----------+
```

- 圆周率函数PI()

```
mysql> select pi();
+----------+
| pi()     |
+----------+
| 3.141593 |
+----------+
```

- 平方根函数SQRT(x)

```
mysql> select sqrt(9),sqrt(40),sqrt(-49);
+---------+-------------------+-----------+
| sqrt(9) | sqrt(40)          | sqrt(-49) |
+---------+-------------------+-----------+
|       3 | 6.324555320336759 |      NULL |
+---------+-------------------+-----------+
```

- 求余函数MOD(x,y)

```
mysql> select mod(31,8),mod(234,10),mod(45.5,6);
+-----------+-------------+-------------+
| mod(31,8) | mod(234,10) | mod(45.5,6) |
+-----------+-------------+-------------+
|         7 |           4 |         3.5 |
+-----------+-------------+-------------+
```

- 获取整数的函数CEIL(x)、CEILING(x)和FLOOR(x)

CEIL(x)和CEILING(x)的意义相同，向右取整

FLOOR(x)，向左取整

```
mysql> select ceil(-3.35),ceiling(3.35);
+-------------+---------------+
| ceil(-3.35) | ceiling(3.35) |
+-------------+---------------+
|          -3 |             4 |
+-------------+---------------+

mysql> select floor(-3.35),floor(3.35);
+--------------+-------------+
| floor(-3.35) | floor(3.35) |
+--------------+-------------+
|           -4 |           3 |
+--------------+-------------+
```

- 获取随机数的函数RAND()和RAND(x)

```
mysql> select rand(),rand(10);
+---------------------+--------------------+
| rand()              | rand(10)           |
+---------------------+--------------------+
| 0.21602383369209602 | 0.6570515219653505 |
+---------------------+--------------------+
```

- 函数ROUND(x)、ROUND(x,y)和TRUNCATE(x,y)

四舍五入：ROUND(x)

ROUND(x,y)函数对操作数进行四舍五入操作，结果保留小数点后面指定y位

TRUNCATE(x,y)返回被舍去至小数点后y位的数字x。若y的值为0，则结果不带有小数点或不带有小数部分。若y设为负数，则截去（归零）x小数点左起第y位开始后面所有低位的值。

```
mysql> select round(-1.11),round(-1.77),round(1,11),round(1.77);
+--------------+--------------+-------------+-------------+
| round(-1.11) | round(-1.77) | round(1,11) | round(1.77) |
+--------------+--------------+-------------+-------------+
|           -1 |           -2 |           1 |           2 |
+--------------+--------------+-------------+-------------+

mysql> select round(-1.11,1),round(-1.7777,2),round(13232.333,3),round(1222.33,-1);
+----------------+------------------+--------------------+-------------------+
| round(-1.11,1) | round(-1.7777,2) | round(13232.333,3) | round(1222.33,-1) |
+----------------+------------------+--------------------+-------------------+
|           -1.1 |            -1.78 |          13232.333 |              1220 |
+----------------+------------------+--------------------+-------------------+
```

- 符号函数SIGN(x)

SIGN(x)返回参数的符号，x的值为负、零或正时返回结果依次为-1、0或1。

```
mysql> select sign(-21),sign(0),sign(21);
+-----------+---------+----------+
| sign(-21) | sign(0) | sign(21) |
+-----------+---------+----------+
|        -1 |       0 |        1 |
+-----------+---------+----------+
```

- 幂运算函数POW(x,y)、POWER(x,y)和EXP(x)

POW(x,y)或者POWER(x,y)函数返回x的y次乘方的结果值。

EXP(x)返回e的x乘方后的值。

```
mysql> select pow(2,2),power(2,2),pow(2,-2),power(2,-2);
+----------+------------+-----------+-------------+
| pow(2,2) | power(2,2) | pow(2,-2) | power(2,-2) |
+----------+------------+-----------+-------------+
|        4 |          4 |      0.25 |        0.25 |
+----------+------------+-----------+-------------+

mysql> select exp(3),exp(3),exp(0);
+--------------------+--------------------+--------+
| exp(3)             | exp(3)             | exp(0) |
+--------------------+--------------------+--------+
| 20.085536923187668 | 20.085536923187668 |      1 |
+--------------------+--------------------+--------+
```

- 对数运算函数LOG(x)和LOG10(x)

LOG(x)返回x的自然对数，x相对于基数e的对数。

LOG10(x)返回x的基数为10的对数。

```
mysql> select log(3),log(-3);
+--------------------+---------+
| log(3)             | log(-3) |
+--------------------+---------+
| 1.0986122886681098 |    NULL |
+--------------------+---------+

mysql> select log10(3),log10(100),log10(-100);
+---------------------+------------+-------------+
| log10(3)            | log10(100) | log10(-100) |
+---------------------+------------+-------------+
| 0.47712125471966244 |          2 |        NULL |
+---------------------+------------+-------------+
```

- 正弦函数SIN(x)和反正弦函数ASIN(x)
- 余弦函数COS(x)和反余弦函数ACOS(x)
- 正切函数、反正切函数和余切函数

#### 字符串

| **数** **名**                  | **作**  **用**               | **举**  **例**                                               |
| ------------------------------ | ---------------------------- | ------------------------------------------------------------ |
| **CONCAT(str1,    str1...strn) | **字符串连接**               | **SELECT**    CONCAT('My','S','QL');返回：MySQL              |
| INSERT(str,  pos,len, newstr)  | **字符串替换**               | **SELECT** **INSERT(**    '这是SQL Server数据库', **3,10,'MySQL');**  返回：这是MySQL数据库 |
| **LOWER(str)**                 | **将字符串转为小写**         | **SELECT LOWER('MySQL');** 返回：mysql                       |
| **UPPER(str)**                 | **将****字符串****转为大写** | **SELECT UPPER('MySQL');**返回：MYSQL                        |
| **SUBSTRING** (str,num,len)    | **字符串截取**               | **SELECT**  **SUBSTRING(**    **'JavaMySQLOracle',5,5);**返回：MySQL |

- 计算字符串字符数CHAR_LENGTH(str)和长度函数LENGTH(str)

```
mysql> select char_length("xiaoxiao"),length("xiaoxiao");
+-------------------------+--------------------+
| char_length("xiaoxiao") | length("xiaoxiao") |
+-------------------------+--------------------+
|                       8 |                  8 |
+-------------------------+--------------------+
```

- 合并字符串函数CONCAT(s1,s2,…)、CONCAT_WS(x,s1,s2,…)

```
mysql> select concat("xiao",null,"ku");
+--------------------------+
| concat("xiao",null,"ku") |
+--------------------------+
| NULL                     |
+--------------------------+

mysql> select concat("xiao","ku");
+---------------------+
| concat("xiao","ku") |
+---------------------+
| xiaoku              |
+---------------------+

mysql> select concat_ws("---","xiao","ku"),concat_ws("---","xiao",null,"ku");
+------------------------------+-----------------------------------+
| concat_ws("---","xiao","ku") | concat_ws("---","xiao",null,"ku") |
+------------------------------+-----------------------------------+
| xiao---ku                    | xiao---ku                         |
+------------------------------+-----------------------------------+
```

- 替换字符串的函数INSERT(s1,x,len,s2)

```
mysql> select insert("xiao",2,3,"ku");
+-------------------------+
| insert("xiao",2,3,"ku") |
+-------------------------+
| xku                     |
+-------------------------+

mysql> select insert("xiao",2,2,"ku");
+-------------------------+
| insert("xiao",2,2,"ku") |
+-------------------------+
| xkuo                    |
+-------------------------+
```

- 字母大小写转换函数

LOWER (str)或者LCASE (str)

UPPER(str)或者UCASE(str)

```
mysql> select lower('XIAO'),lcase('Ku'),upper('mao'),ucase('dong');
+---------------+-------------+--------------+---------------+
| lower('XIAO') | lcase('Ku') | upper('mao') | ucase('dong') |
+---------------+-------------+--------------+---------------+
| xiao          | ku          | MAO          | DONG          |
+---------------+-------------+--------------+---------------+
```

- 获取指定长度的字符串的函数LEFT(s,n)和RIGHT(s,n)

LEFT(s,n)返回字符串s开始的最左边n个字符

IGHT(s,n)返回字符串str最右边的n个字符。

```
mysql> select left('woshiyigemeiyouganqingdeshashou',6),right('woshiyigemeiouganqigndesha',7);
+-------------------------------------------+---------------------------------------+
| left('woshiyigemeiyouganqingdeshashou',6) | right('woshiyigemeiouganqigndesha',7) |
+-------------------------------------------+---------------------------------------+
| woshiy                                    | gndesha                               |
+-------------------------------------------+---------------------------------------+
```

- 删除空格的函数LTRIM(s)、RTRIM(s)和TRIM(s)

LTRIM(s)返回字符串s，字符串左侧空格字符被删除。

RTRIM(s)返回字符串s，字符串右侧空格字符被删除。

TRIM(s)删除字符串s两侧的空格。

```
mysql> select ltrim("  xiao "),rtrim("  xiao  "),trim("  xiao ");
+------------------+-------------------+-----------------+
| ltrim("  xiao ") | rtrim("  xiao  ") | trim("  xiao ") |
+------------------+-------------------+-----------------+
| xiao             |   xiao            | xiao            |
+------------------+-------------------+-----------------+
```

- 替换函数REPLACE(s,s1,s2)

```
mysql> select replace('xiaoxiao','xiao','ku');
+---------------------------------+
| replace('xiaoxiao','xiao','ku') |
+---------------------------------+
| kuku                            |
+---------------------------------+
```

- 比较字符串大小的函数STRCMP(s1,s2)

```
mysql> select strcmp("xiao","ku"),strcmp("xiao","xiao"),strcmp("ku","xiao");
+---------------------+-----------------------+---------------------+
| strcmp("xiao","ku") | strcmp("xiao","xiao") | strcmp("ku","xiao") |
+---------------------+-----------------------+---------------------+
|                   1 |                     0 |                  -1 |
+---------------------+-----------------------+---------------------+	
```

- 字符串逆序的函数REVERSE(s)

```
mysql> select reverse("xiao");
+-----------------+
| reverse("xiao") |
+-----------------+
| oaix            |
+-----------------+
```

#### 日期和时间

| **函数名**                  | **作用**                                                   | **举例****（结果与当前时间有关）**                           |
| --------------------------- | ---------------------------------------------------------- | :----------------------------------------------------------- |
| **CURDATE()**               | **获取当前日期**                                           | **SELECT  CURDATE();返回：2016-08-08                         |
| **CURTIME()**               | **获取当前时间**                                           | **SELECT  CURTIME****();**  **返回****：****19:19:26**       |
| **NOW()**                   | **获取当前日期和时间**                                     | **SELECT  NOW****();**  **返回****：****2016-08-08  19:19:26** |
| **WEEK(date)**              | **返回日期****date****为一年中的第几周**                   | **SELECT  WEEK(NOW****())****;**  **返回****：****26**       |
| **YEAR(date****)**          | **返回日期****date****的年份**                             | **SELECT  YEAR(NOW****());**  **返回****：****2016**         |
| **HOUR(time)**              | **返回时间****time****的小时值**                           | **SELECT  HOUR(NOW****());**  **返回****：****9**            |
| **MINUTE(time)**            | **返回时间****time****的分钟值**                           | **SELECT  MINUTE(NOW****());**  **返回****：****43**         |
| **DATEDIFF(date1,date2)**   | **返回日期参数****date1****和****date2****之间相隔的天数** | **SELECT  DATEDIFF(NOW****(),**     **'2008-8-8');**  **返回****：****2881** |
| **ADDDATE(****date,n****)** | **计算日期参数****date****加上****n****天后的日期**        | **SELECT  ADDDATE(NOW(),5****);**  **返回****：****2016-09-02 09:37:07** |

- 获取当前日期的函数

```
mysql> select curdate(),current_date(),curdate()+0;
+------------+----------------+-------------+
| curdate()  | current_date() | curdate()+0 |
+------------+----------------+-------------+
| 2023-03-11 | 2023-03-11     |    20230311 |
+------------+----------------+-------------+
```

- 获取当前时间的函数

```
mysql> select curtime(),current_time(),curtime()+0;
+-----------+----------------+-------------+
| curtime() | current_time() | curtime()+0 |
+-----------+----------------+-------------+
| 17:39:16  | 17:39:16       |      173916 |
+-----------+----------------+-------------+
```

- 获取当前日期和时间的函数

```
mysql> select current_timestamp(),localtime(),now(),sysdate();
+---------------------+---------------------+---------------------+---------------------+
| current_timestamp() | localtime()         | now()               | sysdate()           |
+---------------------+---------------------+---------------------+---------------------+
| 2023-03-11 17:40:43 | 2023-03-11 17:40:43 | 2023-03-11 17:40:43 | 2023-03-11 17:40:43 |
+---------------------+---------------------+---------------------+---------------------+
```

- UNIX时间戳函数

```
mysql> select unix_timestamp(),unix_timestamp(now()),now();
+------------------+-----------------------+---------------------+
| unix_timestamp() | unix_timestamp(now()) | now()               |
+------------------+-----------------------+---------------------+
|       1678527769 |            1678527769 | 2023-03-11 17:42:49 |
+------------------+-----------------------+---------------------+
```

- 获取月份的函数MONTH(date)和MONTHNAME(date)

```
mysql> select month('2023-03-11');
+---------------------+
| month('2023-03-11') |
+---------------------+
|                   3 |
+---------------------+

mysql> select monthname('2023-03-11');
+-------------------------+
| monthname('2023-03-11') |
+-------------------------+
| March                   |
+-------------------------+
```

- 获取星期的函数DAYNAME(d)

```
mysql> select dayname('2023-03-11');
+-----------------------+
| dayname('2023-03-11') |
+-----------------------+
| Saturday              |
+-----------------------+
```

- 将日期和时间格式化的函数

#### 条件判断

- if
- ifnull
- case

#### 系统信息

- 获取MySQL版本号

```
mysql> select version();
+-----------+
| version() |
+-----------+
| 8.0.28    |
+-----------+
```

- 连接数

```
mysql> select connection_id();
+-----------------+
| connection_id() |
+-----------------+
|               8 |
+-----------------+
```

- 查看当前使用的数据库

```
mysql> select database(),schema();
+------------+----------+
| database() | schema() |
+------------+----------+
| xiao       | xiao     |
+------------+----------+
```

- 获取用户名的函数

```
mysql> select user(),current_user(),system_user();
+----------------+----------------+----------------+
| user()         | current_user() | system_user()  |
+----------------+----------------+----------------+
| root@localhost | root@localhost | root@localhost |
+----------------+----------------+----------------+
```

#### 其他

- 格式化函数FORMAT(x,n)

```
mysql> select format(233.232,2),format(232.333555,4),format(342.43,0);
+-------------------+----------------------+------------------+
| format(233.232,2) | format(232.333555,4) | format(342.43,0) |
+-------------------+----------------------+------------------+
| 233.23            | 232.3336             | 342              |
+-------------------+----------------------+------------------+
```

- 不同进制的数字进行转换的函数

CONV(N, from_base, to_base)

```
mysql> select conv(15,16,2),conv(15,10,8),conv(15,10,16);
+---------------+---------------+----------------+
| conv(15,16,2) | conv(15,10,8) | conv(15,10,16) |
+---------------+---------------+----------------+
| 10101         | 17            | F              |
+---------------+---------------+----------------+
```

- IP地址与数字相互转换的函数

```
mysql> select inet_aton('172.0.0.1');
+------------------------+
| inet_aton('172.0.0.1') |
+------------------------+
|             2885681153 |
+------------------------+

mysql> select inet_ntoa('2885681153');
+-------------------------+
| inet_ntoa('2885681153') |
+-------------------------+
| 172.0.0.1               |
+-------------------------+
```





### MySQL 8.0的新特性

> https://blog.csdn.net/gh_xiaohe/article/details/124602038

#### 存储引擎

从MySQL 8.0开始，系统表全部换成事务型的InnoDB表

```
select distinct(engine) from information_schema.tables;
```

![](https://kegui.oss-cn-hangzhou.aliyuncs.com/xiao/xiao_20230310_112725.jpg)

#### 默认字符集

从MySQL 8.0开始，数据库的默认编码改为utf8mb4

查看数据库字符集

```
show variables like 'character_set_database';

+------------------------+---------+
| Variable_name          | Value   |
+------------------------+---------+
| character_set_database | utf8mb4 |
+------------------------+---------+
```

查看表字符集

```
show create table [表名];
```

#### 自增变量的持久化

在MySQL 8.0之前，自增主键AUTO_INCREMENT的值如果大于max(primary key)+1，在MySQL重启后，会重置AUTO_INCREMENT=max(primary key)+1

8.0之前，自增主键不会记录，4个时删除一个再新增一个，主键依旧是4，8.0之后4个时删除一个再新增一个，主键是5

#### 加密函数

- MD5(str)

```
mysql> select md5('xiao');
+----------------------------------+
| md5('xiao')                      |
+----------------------------------+
| d2bf7126723ea8f6005ba141ea3c3e2c |
+----------------------------------+
```

- SHA(str)

```
mysql> select sha('xiao');
+------------------------------------------+
| sha('xiao')                              |
+------------------------------------------+
| 3ba7f577961a2cfa2a042a55bca9a0f94b4f564e |
+------------------------------------------+
```

- SHA2(str, hash_length)

hash_length支持的值为224、256、384、512和0。其中，0等同于256。

```
mysql> select sha2('xiao',256);
+------------------------------------------------------------------+
| sha2('xiao',256)                                                 |
+------------------------------------------------------------------+
| 6941ce7bf0dc5b77b3c8876e8018830b67c60474f9ee3de608e27b390873fe31 |
+------------------------------------------------------------------+
```

#### 窗口函数

> https://blog.csdn.net/Annabel_CM/article/details/125840831
>
> https://www.cnblogs.com/cjsblog/p/16743807.html
>
> https://www.jb51.net/article/229253.htm





#### 通用表表达式



#### DDL的原子化

InnoDB表的DDL支持事务完整性，即DDL操作要么成功要么回滚。

#### 支持不可见索引

索引可以被“隐藏”和“显示”。当一个索引被隐藏时，它不会被查询优化器所使用。

隐藏一个索引，然后观察对数据库的影响。如果数据库性能有所下降，就说明这个索引是有用的，于是将其“恢复显示”即可；如果数据库性能看不出变化，说明这个索引是多余的，可以删掉了。

```
# 设置索引隐藏
alter table [表名]  alter index [索引名] visible;
```

#### 支持JSON类型

在Server层提供一些便于操作JSON的函数，简单地将JSON编码成BLOB，然后交由存储引擎层进行处理。















### 索引



#### 特点

优

- 通过创建唯一索引，可以保证数据库表中每一行数据的唯一性。
- 可以大大加快数据的查询速度，这也是创建索引的主要原因。
- 在实现数据的参考完整性方面，可以加速表和表之间的连接。
- 在使用分组和排序子句进行数据查询时，也可以显著减少查询中分组和排序的时间。

缺

- 创建索引和维护索引要耗费时间，并且随着数据量的增加所耗费的时间也会增加。
- 索引需要占磁盘空间，除了数据表占数据空间之外，每一个索引还要占一定的物理空间，如果有大量的索引，索引文件可能比数据文件更快达到最大文件尺寸。
- 当对表中的数据进行增加、删除和修改的时候，索引也要动态地维护，这样就降低了数据的维护速度。

#### 分类

- 普通索引
- 唯一索引
- 单列索引
- 组合索引
- 全文索引
- 空间索引

#### 创建索引准则

应该创建索引的列

在经常需要搜索的列上，可以加快搜索的速度
在作为主键的列上，强制该列的唯一性和组织表中数据的排列结构
在经常用在连接（JOIN）的列上，这些列主要是一外键，可以加快连接的速度
在经常需要根据范围（<，<=，=，>，>=，BETWEEN，IN）进行搜索的列上创建索引，因为索引已经排序，其指定的范围是连续的
在经常需要排序（order by）的列上创建索引，因为索引已经排序，这样查询可以利用索引的排序，加快排序查询时间；
在经常使用在WHERE子句中的列上面创建索引，加快条件的判断速度。

不该创建索引的列

对于那些在查询中很少使用或者参考的列不应该创建索引。
若列很少使用到，因此有索引或者无索引，并不能提高查询速度。相反，由于增加了索引，反而降低了系统的维护速度和增大了空间需求。
对于那些只有很少数据值或者重复值多的列也不应该增加索引。
这些列的取值很少，例如人事表的性别列，在查询的结果中，结果集的数据行占了表中数据行的很大比例，即需要在表中搜索的数据行的比例很大。增加索引，并不能明显加快检索速度。
对于那些定义为text, image和bit数据类型的列不应该增加索引。
这些列的数据量要么相当大，要么取值很少。
当该列修改性能要求远远高于检索性能时，不应该创建索引。（修改性能和检索性能是互相矛盾的）

#### 索引数据结构

- 二叉树
- 红黑树
- Hash表
- B+Tree

#### 索引操作

##### 创建索引

```
# 普通索引
create index [索引名] on [表名](字段名)

# 普通唯一索引
create unique index [索引名] on [表名](字段名)

# 普通组合索引
create index [索引名] on [表名](字段名，字段名)

# 普通全文索引
create fulltext index [索引名] on [表名](字段名)

# 普通空间索引
create spatial index [索引名] on [表名](字段名)
```

##### 查看索引

```
show index from [表名] 
```

##### 删除索引

```
alter table [表名] drop index [索引名];

drop index [索引名] on [表名];
```

##### 修改索引

```
ALTER TABLE [表名] ADD INDEX [索引名](字段名);
```

#### 回表

- 先通过普通索引扫描出数据所在的行，获取主键id
- 再通过行主键ID取出索引中未包含的数据。



### 存储过程和函数

一条或者多条SQL语句的集合

#### 创建存储过程和函数

```
create procedure [存储过程名]([出入参类型 参数名 参数类型]) 
begin
	SQL语句;
end;

出入参类型[in | out | inout ]

create function [存储函数名]([出入参类型 参数名 参数类型]) 
returns type
return	SQL语句

出入参类型[in | out | inout ]
```

#### 调用存储过程

```
call 存储过程名([参数列表])

select 存储函数名([参数列表])
```

#### 查看存储过程

```
show [procedure | function] status like '%'

show create [procedure | function] [存储过程名 | 存储函数名]
```

#### 修改存储过程

```
alter [procedure | function] [存储过程名 | 存储函数名] 修改内容
```

#### 删除存储过程

```
drop [procedure | function] if exists [存储过程名 | 存储函数名] 
```



### 视图

#### 简介

视图是一个虚拟表，其内容由查询定义。同真实的表一样，视图包含一系列带有名称的列和行数据。但是，视图并不在数据库中以存储的数据值集形式存在。行和列数据来自由定义视图的查询所引用的表，并且在引用视图时动态生成。
视图具有表结构文件，但不存在数据文件。
对其中所引用的基础表来说，视图的作用类似于筛选。定义视图的筛选可以来自当前或其它数据库的一个或多个表，或者其它视图。通过视图进行查询没有任何限制，通过它们进行数据修改时的限制也很少。
视图是存储在数据库中的查询的sql语句，它主要出于两种原因：安全原因，视图可以隐藏一些数据，如：社会保险基金表，可以用视图只显示姓名，地址，而不显示社会保险号和工资数等，另一原因是可使复杂的查询易于理解和使用。

视图的优点和缺点

**优点**

- 简单化，数据所见即所得
- 安全性，用户只能查询或修改他们所能见到得到的数据
- 逻辑独立性，可以屏蔽真实表结构变化带来的影响

**缺点**

- 性能相对较差，简单的查询也会变得稍显复杂

- 修改不方便，特变是复杂的聚合视图基本无法修改

#### 创建视图

```
CREATE VIEW 视图名 AS SELECT 列名1，列名2,.... FROM 原表名;
```

#### 使用视图

```
select * from 视图名 where 条件;
```

#### 查看视图

```mysql
describe 视图名;

show table status like '视图名';

show create view 视图名;

select * from information_schema.views;
```

#### 修改视图

```
方式一：
/*
create or replace view 视图名
as
查询语句;
*/
SELECT * FROM myv3

CREATE OR REPLACE VIEW myv3
AS
SELECT AVG(salary),job_id
FROM employees
GROUP BY job_id;

方式二：
/*
语法：
alter view 视图名
as
查询语句;

*/
ALTER VIEW myv3
AS
SELECT * FROM employees;
```

#### 更新视图

```
update 视图名 set 条件;
insert into 视图名 values ();
delete from 视图名 where 条件;
```

注意：

如果视图包含以下结构中的任何一种，则该视图不可更新：

聚合函数

DISTINCT

GROUP BY

HAVING

UNION、 UNION ALL

FROM子句中的不可更新的多个表

WHERE子句中的子查询，引用FROM子句中的表

#### 删除视图

```mysql
/*

语法：drop view 视图名,视图名,...;
*/

DROP VIEW emp_v1,emp_v2,myv3;

DROP VIEW IF EXISTS v_students_info; --删除视图

SHOW CREATE VIEW v_students_info;--已不存在
```



### 事务

#### 事务概述

​	一组要么同时执行成功，要么同时失败的SQL语句。是数据库操作的一个不能分割执行单元。

​	数据库事务(Database Transaction) ，是指作为单个逻辑工作单元执行的一系列操作，要么完全地执行，要么完全地不执行。 事务处理可以确保除非事务性单元内的所有操作都成功完成，否则不会永久更新面向数据的资源。通过将一组相关操作组合为一个要么全部成功要么全部失败的单元，可以简化错误恢复并使应用程序更加可靠。一个逻辑工作单元要成为事务，必须满足所谓的ACID（原子性、一致性、隔离性和持久性）属性。事务是数据库运行中的逻辑工作单位，由DBMS中的事务管理子系统负责事务的处理。

**事务开始于**

- 连接到数据库上，并执行一条DML语句insert、update或delete
- 前一个事务结束后，又输入了另一条DML语句

**事务结束于**

- 执行commit或rollback语句。
- 执行一条DDL语句，例如create table语句，在这种情况下，会自动执行commit语句。
- 执行一条DDL语句，例如grant语句，在这种情况下，会自动执行commit。
- 断开与数据库的连接
- 执行了一条DML语句，该语句却失败了，在这种情况中，会为这个无效的DML语句执行rollback语句。

#### 事务的四大特点

（ACID）

- **Atomicity(原子性)**

事务内的所有操作是一个整体，要么全部成功，要么全部失败

- **Consistency(一致性)**

事务内有一个操作失败时，所有的更改过的数据都必须回滚到修改前状态

- **Isolation(隔离性)**

事务所做的修改在最终提交以前，对其它事务是不可见的。

- **Durability(持久性)**

事务一旦提交，则其所做的修改就会永久的保存在数据库中

#### 事务隔离级别

##### 查看事务隔离级别

```
mysql> select @@transaction_isolation;
+-------------------------+
| @@transaction_isolation |
+-------------------------+
| REPEATABLE-READ         |
+-------------------------+
```

##### 设置事务隔离级别

```
SET [ SESSION | GLOBAL ] TRANSACTION ISOLATION LEVEL { READ UNCOMMITTED |READ COMMITTED | REPEATABLE READ | SERIALIZABLE }

事务隔离级别越高，数据越安全，但是性能越低
```



1）未提交读：事务A对数据进行修改，但未提交。此时开启事务B，在事务B中能读到事务A中对数据库进行的未提交数据的修改。

2）提交读：事务A对数据进行修改，但未提交。此时开启事务B，在事务B中不能读到事务A中对数据库的修改。在事务B还没有关闭时，事务A提交对数据库的修改，这时，我们在事务B中可以查到事务A对数据库的修改。不过这种提交读存在一个问题，即在同一个事务中对数据库查询两次，两次的结果不一样。

3）可重复读：在同一个事务内对于同一条SQL语句在不同时刻查询返回的结果一致，这被称为可重复读，可重复读是InnoDB的默认级别。在SQL标准中，该隔离级别消除了不可重复读，但是还存在幻读。

4）串行化：在开启事务A时会产生表级锁，此时别的事务会等待事务A结束后才会开启。一般数据库都不会采用串行化，因为无论进行什么操作都不会加锁，所以不具备可用性。



脏读：是指一个事务正在访问数据，并且对数据进行了修改，而这种修改还没有提交到数据库中，这时另一个事务也访问这个数据，然后使用了这个数据。

不可重复读（主要针对修改）：在一个事务内多次读取同一数据，当这个事务还没有结束时，另一个事务也访问该数据，那么在第一个事务中的两次读数据之间，由于第二个事务的修改可能导致第一个事务两次读到的数据是不一样的，因此称为不可重复读。例如，一个编辑人员两次读取同一文档，但在两次读取之间，作者重写了该文档。当编辑人员第二次读取文档时，该文档已更改，原始读取不可重复。如果只有在作者全部完成编写后，编辑人员才可以读取文档，则可以避免该问题。

幻读（主要针对新增和删除）：是指当事务不是独立执行时发生的一种现象。第一个事务对一张数据表中的数据进行了修改，这种修改涉及表中的全部数据行。同时，第二个事务也修改这张表中的数据，这种修改是向表中插入了一行新数据。第一个事务的用户会发现表中还有未修改的数据行，就好像产生了幻觉一样。例如，一个编辑人员更改作者提交的文档，当生产部门将其更改内容合并到该文档的主副本时，发现作者已将未编辑的新材料添加到该文档中。如果在编辑人员和生产部门完成对原始文档的处理之前，任何人都不能将新材料添加到文档中，则可以避免该问题。





```mysql
#开启事务
START TRANSACTION;     
#事务内数据操作语句
UPDATE account SET money=money-1000 WHERE id=1;
UPDATE account SET money=money+1000 WHERE id=2;
#提交事务
COMMIT;
#回滚
ROLLBACK; 
```





### 数据备份与恢复

#### MySQLdump备份

备份单个数据库中的所有表

```
mysqldump -u root -p [数据库名] > d:/xiao.sql
mysqldump -u root -p xiao > d:/xiao.sql
```

备份单个数据库中的某个表

```
mysqldump -u root -p [数据库名] [表名] > d:/addresses.sql
mysqldump -u root -p xiao addresses > d:/addresses.sql
```

#### mysql恢复

```
mysql -u root -p [数据库名] < d:/xiao.sql
```





### MySQL日志

#### 简介

- 错误日志

记录MySQL服务的启动、运行或停止MySQL服务时出现的问题。

- 查询日志

记录建立的客户端连接和执行的语句。

- 二进制日志

记录所有更改数据的语句，可以用于数据复制。

- 慢查询日志

记录所有执行时间超过long_query_time的所有查询或不使用索引的查询。



#### 二进制日志

默认开启，启动和设置二进制日志主要记录MySQL数据库的变化。二进制日志以一种有效的格式并且是事务安全的方式包含更新日志中可用的所有信息。

##### 启动和设置

```
my.ini中[MySQLd]


[MySQLd]
log-bin
expire_logs_days = 2     # MySQL清除过期日志的时间,默认值为0，表示“没有自动删除”
man_binlog_size = 100M   # 单个文件的大小限制,默认值是1GB,超过给定值，关闭当前文件，重新打开一个新的日志文件
```

##### 查看二进制日志

- SHOW BINARY LOGS查看二进制日志文件个数及文件名

```
mysql> show binary logs;
+---------------+-----------+-----------+
| Log_name      | File_size | Encrypted |
+---------------+-----------+-----------+
| binlog.000070 |      5641 | No        |
| binlog.000071 |      7766 | No        |
| binlog.000072 |       180 | No        |
| binlog.000073 |       180 | No        |
| binlog.000074 |       540 | No        |
| binlog.000075 |       180 | No        |
| binlog.000076 |       665 | No        |
+---------------+-----------+-----------+
```

- 使用MySQLbinlog查看二进制日志

```
mysqlbinlog D:\anzhuang\mysql-8.0.28-winx64\data\binlog.000070
```

##### 删除二进制日志

- 使用RESET MASTER语句删除所有二进制日志文件

```
　　RESET MASTER;
```

- 使用PURGE MASTER LOGS语句删除指定日志文件

```
　　PURGE {MASTER | BINARY} LOGS TO 'log_name'
　　PURGE {MASTER | BINARY} LOGS BEFORE 'date'
```

##### 使用二进制日志恢复数据库

```
　　mysqlbinlog [option] filename |mysql –uuser -ppass
　　
　　option是一些可选的选项，filename是日志文件名。比较重要的两对option参数是--start-date、--stop-date和--start-position、--stop-position。--start-date、--stop-date可以指定恢复数据库的起始时间点和结束时间点。--start-position、--stop-position可以指定恢复数据的开始位置和结束位置。
```

#### 错误日志

##### 启动和设置

```
　　[mysqld]
　　log-error=[path / [file_name] ]
```

##### 查看错误日志

```
SHOW VARIABLES LIKE 'log_error';
　　
mysql> show variables like 'log_error';
+---------------+-----------------------------------------------+
| Variable_name | Value                                         |
+---------------+-----------------------------------------------+
| log_error     | D:\anzhuang\mysql-8.0.28-winx64\data\xiao.err |
+---------------+-----------------------------------------------+
```

##### 删除错误日志

```
mysql> flush logs;
Query OK, 0 rows affected (0.29 sec)
```

#### 通用查询日志

##### 启动通用查询日志

查看通用查询日志状态，默认不开启

```
mysql> show variables like '%general%';
+------------------+-----------------------------------------------+
| Variable_name    | Value                                         |
+------------------+-----------------------------------------------+
| general_log      | OFF                                           |
| general_log_file | D:\anzhuang\mysql-8.0.28-winx64\data\xiao.log |
+------------------+-----------------------------------------------+
```

开启/关闭通用查询日志

```
mysql> set @@global.general_log=1;
Query OK, 0 rows affected (0.28 sec)

mysql> set @@global.general_log=0;
Query OK, 0 rows affected (0.06 sec)
```

##### 查看通用查询日志

找到目录直接打开

##### 删除通用查询日志

```
mysqladmin –u root –p flush-logs
```

#### 慢查询日志

默认关闭

##### 启动和设置

```
my.ini或者my.cnf配置文件

[mysqld]
log-slow-queries[=path / [filename] ]
long_query_time=10  # 单位：秒，默认10秒
```

##### 查看慢查询日志

找到目录直接打开

##### 删除慢查询日志

```
mysqladmin -u root -p flush-logs
```

### 性能优化

#### 简介

查询MySQL数据库的性能参数

```
SHOW STATUS LIKE '参数';

Connections：连接MySQL服务器的次数。
Uptime：MySQL服务器的上线时间。
Slow_queries：慢查询的次数。
Com_select：查询操作的次数。
Com_insert：插入操作的次数。
Com_update：更新操作的次数。
Com_delete：删除操作的次数。
```

#### explain关键字

```
mysql> explain select * from addresses;
+----+-------------+-----------+------------+------+---------------+------+---------+------+------+----------+-------+
| id | select_type | table     | partitions | type | possible_keys | key  | key_len | ref  | rows | filtered | Extra |
+----+-------------+-----------+------------+------+---------------+------+---------+------+------+----------+-------+
|  1 | SIMPLE      | addresses | NULL       | ALL  | NULL          | NULL | NULL    | NULL |    6 |   100.00 | NULL  |
+----+-------------+-----------+------------+------+---------------+------+---------+------+------+----------+-------+
```

```
id:选择标识符

	
table:输出结果集的表
partitions:匹配的分区
type:表示表的连接类型
possible_keys:表示查询时，可能使用的索引
key:表示实际使用的索引
key_len:索引字段的长度
ref:列与索引的比较
rows:扫描出的行数(估算的行数)
filtered:按表条件过滤的行百分比
Extra:执行情况的描述和说明
```

- select_type:表示查询的类型。
   - SIMPLE ： 表示查询语句不包含子查询或union
   - PRIMARY：表示此查询是最外层的查询
   - UNION：表示此查询是UNION的第二个或后续的查询
   - DEPENDENT UNION：UNION中的第二个或后续的查询语句，使用了外面查询结果
   - UNION RESULT：UNION的结果
   - SUBQUERY：SELECT子查询语句
   - DEPENDENT SUBQUERY：SELECT子查询语句依赖外层查询的结果。
- **type** 表示存储引擎查询数据时采用的方式。比较重要的一个属性，通过它可以判断出查询是全表扫描还是基于索引的部分扫描。常用属性值如下，从上至下效率依次增强。
   - ALL：表示全表扫描，性能最差。
   - index：表示基于索引的全表扫描，先扫描索引再扫描全表数据。
   - range：表示使用索引范围查询。使用>、>=、<、<=、in等等。
   - ref：表示使用非唯一索引进行单值查询。
   - eq_ref：一般情况下出现在多表join查询，表示前面表的每一个记录，都只能匹配后面表的一行结果。
   - const：表示使用主键或唯一索引做等值查询，常量查询。
   - NULL：表示不用访问表，速度最快。
- possible_keys 表示查询时能够使用到的索引。注意并不一定会真正使用，显示的是索引名称。
- key 表示查询时真正使用到的索引，显示的是索引名称。
- rows MySQL查询优化器会根据统计信息，估算SQL要查询到结果需要扫描多少行记录。原则上rows是越少效率越高，可以直观的了解到SQL效率高低。
- key_len 表示查询使用了索引的字节数量。可以判断是否全部使用了组合索引。 key_len的计算规则如下：
   - 字符串类型 字符串长度跟字符集有关：latin1=1、gbk=2、utf8=3、utf8mb4=4 char(n)：n*字符集长度 varchar(n)：n * 字符集长度 + 2字节
   - 数值类型 TINYINT：1个字节 SMALLINT：2个字节 MEDIUMINT：3个字节 INT、FLOAT：4个字节 BIGINT、DOUBLE：8个字节
   - 时间类型 DATE：3个字节 TIMESTAMP：4个字节 DATETIME：8个字节
   - 字段属性 NULL属性占用1个字节，如果一个字段设置了NOT NULL，则没有此项
- Extra Extra表示很多额外的信息，各种操作会在Extra提示相关信息，常见几种如下：
   - Using where 表示查询需要通过索引回表查询数据。
   - Using index 表示查询需要通过索引，索引就可以满足所需数据。
   - Using filesort 表示查询出来的结果需要额外排序，数据量小在内存，大的话在磁盘，因此有Using filesort建议优化。
   - Using temprorary 查询使用到了临时表，一般出现于去重、分组等操作。



#### 数据库结构优化

- 将字段很多的表分解成多个表
- 增加中间表
- 增加冗余字段（慎用——一个表修改，另一个也需要修改，浪费空间；提高查询性能）

#### MySQL服务器优化

- 硬件优化

加内存、加服务器

- 参数优化

合理配置MySQL参数







### 存储引擎-InnoDB

####  查询当前数据库支持的存储引擎

```
show engines;
```

#### 逻辑存储结构

- 表空间 : InnoDB存储引擎逻辑结构的最高层，ibd文件其实就是表空间文件，在表空间中可以 包含多个Segment段。
-  段 : 表空间是由各个段组成的， 常见的段有数据段、索引段、回滚段等。InnoDB中对于段的管 理，都是引擎自身完成，不需要人为对其控制，一个段中包含多个区。 
- 区 : 区是表空间的单元结构，每个区的大小为1M。 默认情况下， InnoDB存储引擎页大小为 16K， 即一个区中一共有64个连续的页。 
- 页 : 页是组成区的最小单元，页也是InnoDB 存储引擎磁盘管理的最小单元，每个页的大小默 认为 16KB。为了保证页的连续性，InnoDB 存储引擎每次从磁盘申请 4-5 个区。
-  行 : InnoDB 存储引擎是面向行的，也就是说数据是按行进行存放的，在每一行中除了定义表时 所指定的字段以外，还包含两个隐藏字段



#### InnoDB MVCC





#### 缓冲池

##### 查看缓冲池大小

```
mysql> select @@innodb_buffer_pool_size;
+---------------------------+
| @@innodb_buffer_pool_size |
+---------------------------+
|                 134217728 |
+---------------------------+
```

##### 查看缓冲池数量

```
mysql> select @@innodb_buffer_pool_instances;
+--------------------------------+
| @@innodb_buffer_pool_instances |
+--------------------------------+
|                              1 |
+--------------------------------+
```

##### 设置缓冲池大小

```
shell> mysqld --innodb-buffer-pool-chunk-size=134217728

# 修改配置文件my.cnf
[mysqld]
innodb_buffer_pool_chunk_size=134217728

# 在无须重新启动服务器的情况下调整缓冲池
mysql> set GLOBAL innodb_buffer_pool_size=402653184;
```

##### 配置多个缓冲池

```
shell> mysqld  --innodb-buffer-pool-instances=16
```





### MySQL锁

> https://blog.csdn.net/weixin_40471676/article/details/119759425

#### 锁定机制

##### 行级锁定

优

- 锁定对象颗粒度小
- 并发处理能力大

缺

- 获取、释放锁消耗大
- 加锁慢
- 容易死锁

行级锁分类

●　共享锁（S）：允许一个事务读一行数据时阻止其他的事务读取相同数据的排他锁。

●　排他锁（X）：允许获得排他锁的事务更新数据，阻止其他事务取得相同数据的共享锁和排他锁。

●　意向共享锁（IS）：事务打算给数据行加行共享锁。事务在给一个数据行加共享锁前必须先取得该表的IS锁。

●　意向排他锁（IX）：事务打算给数据行加行排他锁。事务在给一个数据行加排他锁前必须先取得该表的IX锁。

##### 表级锁定

- 

##### 页级锁定

颗粒度介于行级锁定与表级锁定之间，所以获取锁定所需要的资源开销以及锁提供的并发处理的能力也介于表级锁定和行级锁定之间。

#### InnoDB的锁定机制

共享锁(S)

排他锁（X）

意向共享锁（IS）

意向排他锁（IX）



#### 各种锁

##### 全局锁

```
# 加全局锁
flush tables with read lock ;

# 数据备份
mysqldump -u root –p 1234 itcast > itcast.sql

# 释放锁
unlock tables ;
```



##### 表级锁

优

- 颗粒度大，开销小，避免死锁

缺

- 锁冲突改了高，并发度低

##### 行级锁

##### 共享锁

- 若事务A对数据对象o加上S锁，则事务A可以读数据对象o，但不能修改
- 其他事务只能再对数据对象o加S锁，而不能加X锁，直到事务A释放数据对象o上的S锁。
- 这样保证了其他事务可以读数据对象o，但在事务A释放数据对象o上的S锁之前，不能对数据对象o进行任何修改。

语法

```
# 加共享锁
lock table tablename read;
# 释放锁
unlock table;
```



```
# 在session1上执行，给数据表创建读锁（创建一个连接就是一个会话）
mysql> lock table userinfo read;
Query OK, 0 rows affected (0.01 sec)
# 可以读取当前表的数据
mysql> select * from userinfo ;
+----+----------+------+
| id | name     | age  |
+----+----------+------+
|  1 | zhangsan |   27 |
|  2 | lisi     |   27 |
|  3 | dd       | NULL |
|  4 | dd       |    2 |
+----+----------+------+
4 rows in set (0.00 sec)
# 在session1上执行，因为给userinfo表加了读锁，所以不能读取其他表数据[ZJ8]
mysql> select * from student_score;
ERROR 1100 (HY000): Table 'student_score' was not locked with LOCK TABLES
# 在session1上执行，因为给表加的读锁，所以当前会话不能对表执行其他操作
mysql> update userinfo set age=age+1;
ERROR 1099 (HY000): Table 'userinfo' was locked with a READ lock and can't be updated
# 在session2上执行，在session1没有释放锁之前，session2可以进行读取userinfo表
mysql> select * from userinfo;
+----+----------+-------+
| id | name     | age   |
+----+----------+-------+
|  1 | zhangsan |   27  |
|  2 | lisi     |   27  |
|  3 | dd       | null  |
|  4 | dd       |    2  |
+----+----------+-------+
4 rows in set (0.00 sec)
# 在session2上执行，在session1 没有释放锁之前，session2修改或删除表userinfo的任何数据都会被阻塞
mysql> update  userinfo set age=1 where name='dd';
# 一直等待，直到seesion1释放锁
# 在session1上执行，释放锁，session1在执行下面释放锁语句后，session2才会提交上面的修改语句
mysql> unlock tables;
```



##### 排他锁

- 若事务A对数据对象o加上X锁，事务A可以读数据对象o，也可以修改数据对象o
- 其他事务则不能再对数据对象o加任何锁，直到事务A释放数据对象o上的锁。
- 这样保证了其他事务在事务A释放数据对象o上的锁之前不能再读取和修改数据对象o。

语法

```
# 给表加排他锁
Lock table tablename write;
# 给行加排他锁
select ... for update;
# 释放表锁
unlock table;
```

 给表加排他锁

```
# 在session1上执行，当前会话session1给表加写锁
mysql> lock table userinfo write;
Query OK, 0 rows affected (0.00 sec)
# 在session1上执行，当前会话可以修改此表数据
mysql> update userinfo set age=9;
Query OK, 4 rows affected (0.01 sec)
Rows matched: 4  Changed: 4  Warnings: 0
# 在session1上执行，当前会话可以查询此表
mysql> select * from userinfo;
+----+----------+------+
| id | name     | age  |
+----+----------+------+
|  1 | zhangsan |    9 |
|  2 | lisi     |    9 |
|  3 | dd       |    9 |
|  4 | dd       |    9 |
+----+----------+------+
4 rows in set (0.00 sec)
# 在session1上执行，在session1没有释放锁之前，session2对userinfo表的任何数据进行操作（增、删、改、查）都将被阻塞
mysql> update  userinfo set age=1 where name='dd';
# 一直等待，直到seesion1释放锁
```

给行加排他锁

```
# 修改提交模式，改为手动提交
mysql> set autocommit=0;
Query OK, 0 rows affected (0.00 sec)
# session1，当前会话给id=1的行加写锁
mysql>  select * from userinfo where id=1 for update;
+----+----------+------+
| id | name     | age  |
+----+----------+------+
|  1 | zhangsan |  10  |
+----+----------+------+
1 row in set (0.00 sec)
# session2，当前会话2可以查询当前表的数据
mysql> select * from userinfo;
+----+----------+------+
| id | name     | age  |
+----+----------+------+
|  1 | zhangsan |   11 |
|  2 | lisi     |   12 |
|  3 | dd       |   12 |
|  4 | dd       |   11 |
+----+----------+------+
4 rows in set (0.00 sec)
# session2，当前会话2可以操作其他行数据
mysql> update userinfo set age=12 where id=2;
Query OK, 0 rows affected (0.01 sec)
Rows matched: 1  Changed: 0  Warnings: 0
# session2，当前会话2修改数据涉及id=1的行，所以一直被阻塞
mysql> update userinfo set age=12 ;

# session1，当前会话1提交数据，也就是释放锁
mysql> commit;
Query OK, 0 rows affected (0.00 sec)
```



##### 意向锁

意向锁的出现是为了使InnoDB支持多粒度锁

- 意向共享锁：事务想要获得表中某些记录的共享锁（读锁），需要在表上先加意向共享锁。
- 意向排他锁：事务想要获得表中某些记录的排他锁（写锁），需要在表上先加意向排他锁。

##### 乐观锁

操作数据库时（更新操作）想法很乐观，认为这次的操作不会导致冲突，在操作数据时不进行任何其他的特殊处理（也就是不加锁），而在进行数据更新后再去判断是否发生了冲突。

##### 悲观锁

作数据库时（更新操作）想法很悲观，认为这次的操作会导致冲突，在操作数据时进行加锁

##### 间隙锁

InnoDB在提交时为了解决幻读问题而引入的锁机制



##### 记录锁

记录锁强制锁定索引记录（作用于唯一索引），当一个会话执行这条语句之后，其他会话执行下面这几种语句都会处于阻塞状态

```
select * from userinfo where id=1 for update;
delete from userinfo where id=4;
insert into userinfo values(4,'hh',18);
```



##### 临键锁

记录锁与间隙锁的组合

##### 死锁

两个或两个以上的事务在执行过程中因争抢锁资源而造成的互相等待的现象。

避免死锁

- 第一种是等待事务超时主动回滚；
- 第二种是进行死锁检查，主动回滚某条事务，让别的事务能继续走下去。



### 其他

#### MySQL的SQL语句执行过程

> https://blog.csdn.net/weixin_40471676/article/details/119759425
>
> https://www.cnblogs.com/mengxinJ/p/14045520.html#_label1_0

- 1、客户端发送语句到MySQL数据库，将根据MySQL的执行计划来查询数据：先从缓冲池中查询数据，如果没有，就会去数据库中查询，如果查询到了，就将其放到缓冲池中
- 2、数据被缓存到缓冲池的同时，会写入回滚日志文件
- 3、更新操作会在缓冲池中完成，将更新后的数据添加到重做日志缓冲区中以后就可以提交事务了
   - 将重做日志缓冲区中的数据刷入重做日志文件中
   - 将本次操作记录写入二进制日志文件中
   - 将二进制日志文件名和更新内容在二进制日志文件中所在的位置都记录到重做日志文件中，同时在重做日志最后添加commit标记。如果在my.cnf中没有开启二进制日志，则直接对重做日志添加commit标记



### 主从复制

主数据库的 DDL 和 DML 操作通过二进制日志传到从库服务器中，然后在从库上对这 些日志重新执行（也叫重做），从而使得从库和主库的数据保持同步。







### 读写分离

把对数据库的读和写操作分开,以对应不同的数据库服务器。主数据库提供写操 作，从数据库提供读操作，这样能有效地减轻单台数据库的压力。



### 分库分表

#### 为什么要分库分表

减少数据库的负担，提升数据库响应速度，缩短查询时间

#### 垂直（纵向）切分

###### 垂直分库

按照业务分类进行划分，每个业务有独立数据库

##### 垂直分表

基于数据表的列为依据切分的，是一种**大表拆小表**的模式

#### 水平（横向）切分

##### 库内分表

库内分表虽然将表拆分，但`子表都还是在同一个数据库`实例中，只是`解决了单一表数据量过大的问题`，并没有将拆分后的表分布到不同机器的库上，还在`竞争同一个物理机的CPU、内存、网络IO。`

##### 分库分表

分库分表则是将切分出来的子表，分散到不同的数据库中，从而使得单个表的数据量变小，达到分布式的效果。





## Redis





## Mybatis



