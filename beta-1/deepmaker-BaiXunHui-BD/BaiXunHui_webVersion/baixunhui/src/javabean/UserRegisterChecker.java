package javabean;
import instance.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.SQLOpenHelper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;


public class UserRegisterChecker {
	
	private static String strUserName, strPassword, strConfirmpassword, 
						  strEmail, strPhone, strQQ;
	
	public UserRegisterChecker(){
	}
	
	public static boolean isRegisterSuccess(HttpServletRequest request,HttpServletResponse response)
	throws Exception{
		
		getInputUserInfo(request);

		if(isInputInfoValid(request)){
			SQLOpenHelper sqlHelper = new SQLOpenHelper();
			sqlHelper.databaseOpen();
			Statement sqlStatement = sqlHelper.getConnection().createStatement();
			
			if(isUserNameNotExist(request, sqlHelper, sqlStatement)) {
				enrollUser(sqlHelper, sqlStatement);
				setCurrentUser(request);
				return true;
			}
			else
				return false;
		}
		return false;
	}

	private static boolean isInputInfoValid(HttpServletRequest request) {
		if (strUserName.equals("") || strPassword.equals("") || strConfirmpassword.equals("")
				|| strEmail.equals("") || strPhone.equals("") || strQQ.equals("")) {
			return false;//û��дĳһ��Ϣ
		}
		
		if (!strPassword.equals(strConfirmpassword)) {
			request.setAttribute("msg", "ע��ʧ�ܣ�������������벻ͬ");
			return false;//������������벻ͬ
		}
		return true;
	}
	
	private static boolean isUserNameNotExist(HttpServletRequest request,
			SQLOpenHelper sqlHelper, Statement sqlStatement)
			throws SQLException {
		
		ResultSet queryResultSet = sqlStatement.executeQuery("select * from user where username=" + "'" + strUserName + "'");
		if (queryResultSet != null && queryResultSet.next()) {//���ݿ�������Ϊ�գ��û����Ѵ���
			request.setAttribute("msg", "ע��ʧ�ܣ��û����Ѿ�����");
			sqlHelper.databaseClose();
			return false;
		}
		return true;
	}
	
	private static void enrollUser(SQLOpenHelper sqlHelper,
			Statement sqlStatement) throws SQLException {
		String sql = "insert into user values('" + strUserName + "'," +
		"'" + strPassword + "'," + "'" + strEmail + "'," + "'" + strPhone + "'," + "'" + strQQ + "')";
		
		sqlStatement.execute(sql);
		sqlHelper.databaseClose();
	}
	
	private static void setCurrentUser(HttpServletRequest request) {
		request.setAttribute("userName", strUserName);
		HttpSession session=request.getSession(true);
		User user = new User();
		user.setUserName(strUserName);
		user.setEmail(strEmail);
		user.setPhone(strPhone);
		user.setUserQQ(strQQ);

		session.setAttribute("curUser", user);
	}

	private static void getInputUserInfo(HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("gbk");
		strUserName = request.getParameter("userName").trim();
		strPassword = request.getParameter("password").trim();
		strConfirmpassword = request.getParameter("confirmpassword").trim();
		strEmail = request.getParameter("email").trim();
		strPhone = request.getParameter("phone").trim();
		strQQ = request.getParameter("qq").trim();
	}
	

}
