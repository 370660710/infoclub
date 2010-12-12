package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javabean.UserInfoChange;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserAccountManager extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserAccountManager() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
    	response.setCharacterEncoding("GBK");
    	//从请求中获取session对象
    	HttpSession session=request.getSession();
    	//如果session对象为空则返回
    	if(session.getAttribute("curUser") == null) {
    		return;
    	}
   
    	String action = request.getParameter("action");
    	
    	//处理请求
    	if(action.equals("modifyEmail")) {
    		modifyEmail(request, response);
    	} 
    	
    	if(action.equals("modifyPassword")) {
    		try {
				if(UserInfoChange.changePassword(request, response))
					request.getRequestDispatcher("accountMenu.jsp").forward(request, response);
				else
				{
					request.setAttribute("msg", "修改失败，请尝试再次登录");
					
					request.getRequestDispatcher("modifyPassword.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	if(action.equals("modifyPhone")) {
    		try {
				if(UserInfoChange.changePhone(request, response))
					request.getRequestDispatcher("accountMenu.jsp").forward(request, response);
				else
				{
					request.setAttribute("msg", "修改失败，请尝试再次登录");
					
					request.getRequestDispatcher("modifyPhone.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	if(action.equals("modifyQQ")) {
    		try {
				if(UserInfoChange.changeQQ(request, response))
					request.getRequestDispatcher("accountMenu.jsp").forward(request, response);
				else
				{
					request.setAttribute("msg", "修改失败，");
					
					request.getRequestDispatcher("modifyQQ.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	if(action.equals("logout")) {
    		session.removeAttribute("userName");
			session.removeAttribute("curUser");
			request.getRequestDispatcher("index.jsp").forward(request, response);
    	}
		
	}

	private void modifyEmail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			if(UserInfoChange.changeEmail(request, response))
				request.getRequestDispatcher("accountMenu.jsp").forward(request, response);
			else
			{
				request.setAttribute("msg", "修改失败，请尝试再次登录");
				
				request.getRequestDispatcher("modifyEmail.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
