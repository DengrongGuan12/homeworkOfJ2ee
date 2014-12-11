package edu.nju.homework2.Objs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Student {
	private String name;
	private String passwd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	private ArrayList<Course> courses=new ArrayList<Course>();
	public Student(String name,String passwd){
		this.setName(name);
		this.setPasswd(passwd);
	}
	private void addCourse(int id,String name,int grade){
		Course course=new Course(id,name,grade);
		this.courses.add(course);
	}
	public void loadMyCourses(){
		ResultSet rs=DataBase.getResultSet("select course_id,grade from record where stu_name='"+this.name+"'");
		if(null !=rs){
			try {
				while(rs.next()){
					int id=rs.getInt(1);
					int grade=rs.getInt(2);
					this.addCourse(id, Courses.getNameById(id), grade);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Course> getCourses(){
		return this.courses;
	}
}
