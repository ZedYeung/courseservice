package com.csye6225.fall2018.courseservice.service;

import com.csye6225.fall2018.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.fall2018.courseservice.datamodel.Course;
import java.util.*;

public class CoursesService {
	static HashMap<Long, Course> coursesMap = InMemoryDatabase.getCourseDB();
	
	// Getting a list of all courses
	// GET "..webapi/courses"
	public List<Course> getAllCourses() {	
		List<Course> list = new ArrayList<>();
		for (Course course : coursesMap.values()) {
			list.add(course);
		}
		return list ;
	}
	
	//GET, get a course by its id
	public Course getCourse(long courseId) {
		return coursesMap.get(courseId);
	}

	//POST, add a new course
	public Course addCourse(Course course) {
		long nextAvailableId = coursesMap.size() + 1;
		course.setCourseId(nextAvailableId);
		coursesMap.put(nextAvailableId, course);
		return course;
	}
	
	//PUT, update information of a course
	public Course updateCourse(long courseId, Course course) {	
//		Course oldCourse = coursesMap.get(courseId);
//		courseId = oldCourse.getCourseId();
//		course.setCourseId(courseId);
		coursesMap.put(courseId, course);
		return course;
	}
	
	//DELETE, delete a course
	public Course deleteCourse(long courseId) {
		Course deletedCourseInfo = coursesMap.get(courseId);
		coursesMap.remove(courseId);
		return deletedCourseInfo;
	}

}
