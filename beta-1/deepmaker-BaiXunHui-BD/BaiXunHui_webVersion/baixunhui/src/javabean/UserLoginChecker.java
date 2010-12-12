package javabean;
import instance.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.SQLOpenHelper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;


public class UserLoginChecker {
	
	private static String userName;
	private static String userPassword;
	private static ResultSet sqlResultSet;
	
	public UserLoginChecker(){
	}
	
	public static boolean isLoginSuccess(HttpServletRequest request, 
			HttpServletResponse response) throws UnsupportedEncodingException{
		
			getInputNameAndPassword(request);
			SQLOpenHelper sqlHelper = new SQLOpenHelper();
			try {
				
				if(isUserValid(sqlHelper)) {
					return checkAndLogin(request, sqlHelper);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}  finally {
				if (sqlHelper != null) {
					sqlHelper.databaseClose();
				}
			}
			return false;
	}

	private static  boolean checkAndLogin(HttpServletRequest request,
			SQLOpenHelper sqlHelper)
			throws SQLException {
		if(checkPasswordSuccess(sqlHelper)){
			userLogin(request);			
			sqlHelper.databaseClose();
			return true;
		}
		return false;
	}

	private static void userLogin(HttpServletRequest request)
			throws SQLException {
		sqlResultSet.previous();
		request.setAttribute("userName", userName);
		HttpSession session=request.getSession(true);
		setCurrentUser(session);
	}

	private static void setCurrentUser(HttpSession session) throws SQLException {
		User user = new User();
		user.setUserName(userName);
		user.setEmail(sqlResultSet.getString("email"));
		user.setPhone(sqlResultSet.getString("Tel"));
		user.setUserQQ(sqlResultSet.getString("QQ"));
		session.setAttribute("curUser", user);
	}

	private static boolean checkPasswordSuccess(SQLOpenHelper sqlHelper)
			throws SQLException {
		String strName = "", strPwd = "";
		while (sqlResultSet.next()) {
			strName = sqlResultSet.getString("userName");
			strPwd = sqlResultSet.getString("password");
		}
		if (!userName.equals(strName) || !userPassword.equals(strPwd)){ //用户名与密码不匹配
			sqlHelper.databaseClose();
			return false;
		}
		return true;
	}

	private static boolean isUserValid(SQLOpenHelper sqlHelper)
			throws SQLException {
		
		sqlHelper.databaseOpen();
		
		Statement sqlStatement = sqlHelper.getConnection().createStatement();
		sqlResultSet = sqlStatement.executeQuery("select * from user where username=" + "'" + userName + "'");
		
		if (sqlResultSet == null && !sqlResultSet.next()) {  //数据库结果集为空
			sqlHelper.databaseClose();
			return false;
		}
		return true;
	}

	private static void getInputNameAndPassword(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("gbk");
		userName = request.getParameter("userName").trim();
		userPassword = request.getParameter("password").trim();
	}
	
}
