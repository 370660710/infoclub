1.将提供的源码放置到服务器端:apache-tomcat-6.0.29-windows-x86

2.安装mySQL，在命令行窗口输入指令，在数据库里创建用户表单（创建信息如下）：
   create database baixunhui;
   use baixunhui;
   create table user
  (
	username varchar(12) not null unique,
	password varchar(10) not null,
	email varchar(40) not null,
	Tel varchar(12),
	QQ varchar(12),
  );

(本机sql的jbds密码为2256504，若要成功浏览，请修改util包的SQLOpenHelper连接设置connection的密码）

3.访问index.jsp。

4.由于时间的限制，系统仅仅实现和完善了普遍用户的注册登录以及用户修改、查询用户信息和退出系统功能。

5.程序只在本地架设的服务器上运行成功，若未能在你的机器上运行，可先查看我们的截图，请谅解。