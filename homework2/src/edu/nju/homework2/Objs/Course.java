package edu.nju.homework2.Objs;

public class Course {
	private int id;
	private String name;
	private int grade;
	public Course(int id,String name,int grade){
		this.setId(id);
		this.setName(name);
		this.setGrade(grade);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	

}
