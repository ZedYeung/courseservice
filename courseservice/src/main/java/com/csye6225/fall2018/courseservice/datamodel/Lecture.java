package com.csye6225.fall2018.courseservice.datamodel;
import java.util.List;

public class Lecture {
	private long lectureId;
	private String lectureName;
	private List<String> notesURL;
	private String associatedMaterialURL;
	
	public Lecture() {
		
	}
	
	public Lecture(long lectureId, String lectureName,
			List<String> notesURL, String associatedMaterialURL) {
		this.lectureId = lectureId;
		this.lectureName = lectureName;
		this.notesURL = notesURL;
		this.associatedMaterialURL = associatedMaterialURL;
	}

	public long getLecturetId() {
		return lectureId;
	}

	public void setLectureId(long lectureId) {
		this.lectureId = lectureId;
	}
	
	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public List<String> getNotesURL() {
		return notesURL;
	}

	public void setNotesURL(List<String> notesURL) {
		this.notesURL = notesURL;
	}

	public String getAssociatedMaterialURL() {
		return associatedMaterialURL;
	}

	public void setAssociatedMaterialURL(String associatedMaterialURL) {
		this.associatedMaterialURL = associatedMaterialURL;
	}
	
}
