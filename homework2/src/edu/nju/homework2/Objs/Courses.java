package edu.nju.homework2.Objs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

public class Courses {
	private static Hashtable<Integer, String> courses=new Hashtable<Integer, String>();
	private static void addCourse(String name,int id){
		courses.put(id, name);
	}
	public static String getNameById(int id){
		return courses.get(id);
	}
	public static void loadCourses(){
		ResultSet rs=DataBase.getResultSet("select * from course");
		if(null != rs){
			try {
				while(rs.next()){
					addCourse(rs.getString(1), rs.getInt(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
