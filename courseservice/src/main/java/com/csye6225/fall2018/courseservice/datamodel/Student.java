package com.csye6225.fall2018.courseservice.datamodel;
import java.util.List;
import java.util.ArrayList;

public class Student {
	private String studentName;
	private long studentID;
	private String imageURL;
	private List<Long> enrolledCourses;
	private String programName;
	
	public Student() {
		
	}
	
	public Student(String studentName, long studentID, String imageURL,
			String programName, List<Long> enrolledCourses) {
		this.studentName = studentName;
		this.studentID = studentID;
		this.imageURL = imageURL;
		this.programName = programName;
		this.enrolledCourses = new ArrayList<Long>();
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getStudentId() {
		return studentID;
	}

	public void setStudentId(long studentID) {
		this.studentID = studentID;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public List<Long> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(List<Long> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	
}
