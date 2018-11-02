package com.csye6225.fall2018.courseservice.datamodel;
import java.util.List;

public class Course {
	private long courseId;
	private String courseName;
	private List<Long> lectures;
	private String board;
	private String roster;
	private List<Long> enrolledStudents;
	private long associatedProf;
	private long courseTA;
	
	public Course() {
		
	}
	
	public Course(long courseId, String courseName, List<Long> lectures, String board, String roster,
			List<Long> enrolledStudents, long associatedProf, long courseTA) {
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

	public List<Long> getLectures() {
		return lectures;
	}

	public void setLectures(List<Long> lectures) {
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

	public List<Long> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<Long> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public long getAssociatedProf() {
		return associatedProf;
	}

	public void setAssociatedProf(long associatedProf) {
		this.associatedProf = associatedProf;
	}

	public long getCourseTA() {
		return courseTA;
	}

	public void setCourseTA(long courseTA) {
		this.courseTA = courseTA;
	}
	
	
}
