package edu.nju.homework2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import edu.nju.homework2.Objs.Course;
import edu.nju.homework2.Objs.Courses;
import edu.nju.homework2.Objs.DataBase;
import edu.nju.homework2.Objs.Student;



/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����Ѿ���¼��ʾ�ɼ���δ��¼��ת����¼ҳ��
		HttpSession session=request.getSession(false);
		if(session!=null){
			Student student=(Student)session.getAttribute("student");
			if(null != student){
				this.displayGrades(student, request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/LoginPage");
			}
		}else{
			response.sendRedirect(request.getContextPath()+"/LoginPage");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("username");
		String passwd=request.getParameter("passwd");
		String remember=request.getParameter("remember");
		Cookie cookie=null;
		if(this.checkLogin(name, passwd)){
			Courses.loadCourses();
			Student student=new Student(name, passwd);
			if (remember!=null){
				cookie = new Cookie("LoginName", name);
				cookie.setMaxAge(Integer.MAX_VALUE);
				response.addCookie(cookie);
				cookie=new Cookie("LoginPasswd", passwd);
				cookie.setMaxAge(Integer.MAX_VALUE);
				response.addCookie(cookie);
			}
			HttpSession session=request.getSession(true);
			session.setAttribute("student",student);
			this.displayGrades(student,request,response);
			
		}else {
			this.displayLoginError(request,response);
		}
		
		
		
	}
	private boolean checkLogin(String name,String passwd){
		boolean suc=false;
		ResultSet rs=DataBase.getResultSet("select password from student where name='"+name+"'");
		if(rs==null){
			suc=false;
		}else{
			try {
				while(rs.next()){
					if(rs.getString(1).equals(passwd)){
						suc=true;
						break;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return suc;
	}
	private void displayLoginError(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html; charset=GBK");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>��¼ʧ��</title></head>");
		out.println("<body>");
		out.println("<div align='center'>");
		out.println("<table>"
				+ "<tr>"
				+ "<td align='center'><font color='red' size='4px'>�û�����������������µ�¼��</font></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td align='center'>���<a href='"+request.getContextPath()+"/LoginPage'>�˴�</a>���µ�¼</td>"
				+ "</tr></table>");
		out.println("</div>");
		out.println("</body></html>");
	}
	
	private void displayGrades(Student student,HttpServletRequest request,HttpServletResponse response) throws IOException{
		student.loadMyCourses();
		response.setContentType("text/html; charset=GBK");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title>��ӭ</title></head>");
		out.println("<body>");
		out.println("<h1 align='center'>��ӭ�㣬"+student.getName()+"</h1>");
		out.println("<h2 align='center'>��ĳɼ��б�<h2>");
		out.println("<div align='center'><table border='1'><tr><td>�γ̺�</td><td>�γ�����</td><td>�γ̳ɼ�</td></tr>");
		ArrayList<Course> courses=student.getCourses();
		boolean hasUnpassedCourse=false;
		for (Course course : courses) {
			int id=course.getId();
			String name=course.getName();
			int grade=course.getGrade();
			if(grade<60){
				hasUnpassedCourse=true;
				out.println("<tr bgcolor='red'>");
			}else{
				out.println("<tr>");
			}
			out.println("<td>"+id+"</td>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+grade+"</td>");
			out.println("</tr>");
			
			
		}
		out.println("</table></div>");
		if(hasUnpassedCourse){
			out.println("<h3 align='center'><span style='color:#E53333;'>ע�⣬���в�����Ŀγ̣�</span></h3>");
		}
		out.println("<a href='"+request.getContextPath()+"/Logout'>�˳�</a>");
		out.println("</body></html>");
		
	}
	


}
