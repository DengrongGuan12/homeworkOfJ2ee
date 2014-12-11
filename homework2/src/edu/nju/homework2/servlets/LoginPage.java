package edu.nju.homework2.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginName=null;
		String loginPasswd=null;
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().equals("LoginName")) {
					loginName=cookie.getValue();
					if(loginPasswd!=null){
						break;
					}
				}
				if(cookie.getName().equals("LoginPasswd")){
					loginPasswd=cookie.getValue();
					if(loginName!=null){
						break;
					}
					
				}
			}
		}
		if(loginName==null){
			loginName="";
		}
		if(loginPasswd==null){
			loginPasswd="";
		}
		response.setContentType("text/html; charset=GBK");
		PrintWriter out=response.getWriter();
		out.println("<title>登录</title>"
				+ "</head><body><div align='center'><form method='post' action='/homework2/LoginCheck'>"
				+ "<table><tr><td align='center'>用户名:</td><td align='center'>"
				+ "<input type='text' name='username' value='"+loginName+"'/></td></tr>"
						+ "<tr><td align='center'>密码:</td><td align='center'>"
						+ "<input type='password' name='passwd' value='"+loginPasswd+"'/>"
						+ "</td></tr><tr><td align='center'><input type='checkbox' name='remember' />记住我</td>"
						+ "<td align='center'><input type='submit' value='登录' /></td></tr></table></form></div>"
						+ "</body></html>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
