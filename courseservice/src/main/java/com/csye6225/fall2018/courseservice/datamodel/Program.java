package com.csye6225.fall2018.courseservice.datamodel;
import java.util.List;

public class Program {
	private long programId;
	public String programName;
	public List<Course> courses;
	
	public Program() {
		
	}
	
	public Program(long programId, String programName, List<Course> courses) {
		this.programId = programId;
		this.programName = programName;
		this.courses = courses;
	}
	
	public long getProgramId() {
		return programId;
	}
	
	public void setProgramId(long programId) {
		this.programId = programId;
	}
	
	public String getProgramName() {
		return programName;
	}
	
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
