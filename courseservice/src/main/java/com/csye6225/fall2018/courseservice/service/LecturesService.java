package com.csye6225.fall2018.courseservice.service;

import com.csye6225.fall2018.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.fall2018.courseservice.datamodel.Lecture;
import java.util.*;

public class LecturesService {
	static HashMap<Long, Lecture> lecturesMap = InMemoryDatabase.getLectureDB();
	
	// Getting a list of all lectures
	// GET "..webapi/lectures"
	public List<Lecture> getAllLectures() {	
		List<Lecture> list = new ArrayList<>();
		for (Lecture lecture : lecturesMap.values()) {
			list.add(lecture);
		}
		return list ;
	}
	
	//GET, get a lecture by its id
	public Lecture getLecture(long lectureId) {
		return lecturesMap.get(lectureId);
	}

	//POST, add a new lecture
	public Lecture addLecture(Lecture lecture) {
		long nextAvailableId = lecturesMap.size() + 1;
		lecture.setLectureId(nextAvailableId);
		lecturesMap.put(nextAvailableId, lecture);
		return lecturesMap.get(nextAvailableId);
	}
	
	//PUT, update information of a lecture
	public Lecture updateLecture(long lectureId, Lecture lecture) {	
//		Lecture oldLecture = lecturesMap.get(lectureId);
//		lectureId = oldLecture.getLectureId();
//		lecture.setLectureId(lectureId);
		lecturesMap.put(lectureId, lecture);
		return lecture;
	}
	
	//DELETE, delete a lecture
	public Lecture deleteLecture(long lectureId) {
		Lecture deletedLectureInfo = lecturesMap.get(lectureId);
		lecturesMap.remove(lectureId);
		return deletedLectureInfo;
	}

}
