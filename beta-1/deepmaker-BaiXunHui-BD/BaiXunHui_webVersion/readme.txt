1.���ṩ��Դ����õ���������:apache-tomcat-6.0.29-windows-x86

2.��װmySQL���������д�������ָ������ݿ��ﴴ���û�����������Ϣ���£���
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

(����sql��jbds����Ϊ2256504����Ҫ�ɹ���������޸�util����SQLOpenHelper��������connection�����룩

3.����index.jsp��

4.����ʱ������ƣ�ϵͳ����ʵ�ֺ��������ձ��û���ע���¼�Լ��û��޸ġ���ѯ�û���Ϣ���˳�ϵͳ���ܡ�

5.����ֻ�ڱ��ؼ���ķ����������гɹ�����δ������Ļ��������У����Ȳ鿴���ǵĽ�ͼ�����½⡣