package com.csye6225.fall2018.courseservice.datamodel;
import java.util.List;

public class Course {
	private long courseId;
	private String courseName;
	private List<Lecture> lectures;
	private String board;
	private String roster;
	private List<Student> enrolledStudents;
	private Professor associatedProf;
	private Student courseTA;
	
	public Course() {
		
	}
	
	public Course(long courseId, String courseName, List<Lecture> lectures, String board, String roster,
			List<Student> enrolledStudents, Professor associatedProf, Student courseTA) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.lectures = lectures;
		this.board = board;
		this.roster = roster;
		this.enrolledStudents = enrolledStudents;
		this.associatedProf = associatedProf;
		this.courseTA = courseTA;
	}

	public long getCourseId() {
		  return courseId;
		}

	public void setCourseId(long courseId) {
	  this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getRoster() {
		return roster;
	}

	public void setRoster(String roster) {
		this.roster = roster;
	}

	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public Professor getAssociatedProf() {
		return associatedProf;
	}

	public void setAssociatedProf(Professor associatedProf) {
		this.associatedProf = associatedProf;
	}

	public Student getCourseTA() {
		return courseTA;
	}

	public void setCourseTA(Student courseTA) {
		this.courseTA = courseTA;
	}
	
	
}
