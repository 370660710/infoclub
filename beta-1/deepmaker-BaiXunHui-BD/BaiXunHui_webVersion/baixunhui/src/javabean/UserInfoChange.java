package javabean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import instance.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.SQLOpenHelper;

public class UserInfoChange {

	private static String userName;
	
	public static boolean changeEmail(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		
		HttpSession session=request.getSession(true);
		User curUser = (User)session.getAttribute("curUser");
		userName = curUser.getUserName();
		
		SQLOpenHelper sqlHelper = new SQLOpenHelper();
		sqlHelper.databaseOpen();
		Statement sqlStatement = sqlHelper.getConnection().createStatement();
		
		int rst = sqlStatement.executeUpdate("update user set email = '" + 
				request.getParameter("newEmail") + "' where username = " + "'" + userName + "'");
		if (rst == 0)//���ݿ�����Ϊ��
		{
			sqlHelper.databaseClose();
			return false;
		}
		curUser.setEmail(request.getParameter("newEmail"));
		sqlHelper.databaseClose();
		return true;
	}

	public static boolean changePassword(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		HttpSession session=request.getSession(true);
		User curUser = (User)session.getAttribute("curUser");
		userName = curUser.getUserName();
		
		SQLOpenHelper sqlHelper = new SQLOpenHelper();
		sqlHelper.databaseOpen();

		Statement sqlStatement = sqlHelper.getConnection().createStatement();
		
		ResultSet rst = sqlStatement.executeQuery("select * from user where username=" + "'" + userName + "'");
		
		if (rst == null && !rst.next())//���ݿ�����Ϊ��
		{
		System.out.print("asd");
			sqlHelper.databaseClose();
			return false;
		}

		String strName = "", strPwd = "";
		while (rst.next()) {
			System.out.print("asd2");
			strName = rst.getString("userName");
			strPwd = rst.getString("password");
		}
		

		if (!userName.equals(strName) || !request.getParameter("oldPassword").equals(strPwd))//�û��������벻ƥ��
		{
			sqlHelper.databaseClose();
			return false;
		}
		
		int rst2 = sqlStatement.executeUpdate("update user set password = '" + 
				request.getParameter("newPassword") + "' where username = " + "'" + userName + "'");
		if (rst2 == 0)//���ݿ�����Ϊ��
		{
			System.out.print("asd4");
			sqlHelper.databaseClose();
			return false;
		}
		System.out.print("asd5");
		sqlHelper.databaseClose();
		return true;
	}

	public static boolean changePhone(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		
		HttpSession session=request.getSession(true);
		User curUser = (User)session.getAttribute("curUser");
		userName = curUser.getUserName();
		
		SQLOpenHelper sqlHelper = new SQLOpenHelper();
		sqlHelper.databaseOpen();

		Statement sqlStatement = sqlHelper.getConnection().createStatement();
		
		int rst = sqlStatement.executeUpdate("update user set Tel = '" + 
				request.getParameter("newPhone") + "' where username = " + "'" + userName + "'");
		if (rst == 0)//���ݿ�����Ϊ��
		{
			sqlHelper.databaseClose();
			return false;
		}
		curUser.setPhone(request.getParameter("newPhone"));
		sqlHelper.databaseClose();
		return true;
		
	}

	public static boolean changeQQ(HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		HttpSession session=request.getSession(true);
		User curUser = (User)session.getAttribute("curUser");
		userName = curUser.getUserName();
		
		SQLOpenHelper sqlHelper = new SQLOpenHelper();
		sqlHelper.databaseOpen();

		Statement sqlStatement = sqlHelper.getConnection().createStatement();
		
		int rst = sqlStatement.executeUpdate("update user set QQ = '" + 
				request.getParameter("newQQ") + "' where username = " + "'" + userName + "'");
		if (rst == 0)//���ݿ�����Ϊ��
		{
			sqlHelper.databaseClose();
			return false;
		}
		curUser.setUserQQ(request.getParameter("newQQ"));
		sqlHelper.databaseClose();
		return true;
	}

}
