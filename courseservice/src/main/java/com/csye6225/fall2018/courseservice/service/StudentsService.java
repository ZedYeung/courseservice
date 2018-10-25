package com.csye6225.fall2018.courseservice.service;

import com.csye6225.fall2018.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.fall2018.courseservice.datamodel.Student;
import java.util.*;

public class StudentsService {
	static HashMap<Long, Student> studentsMap = InMemoryDatabase.getStudentDB();
	
	// Getting a list of all students
	// GET "..webapi/students"
	public List<Student> getAllStudents() {	
		List<Student> list = new ArrayList<>();
		for (Student student : studentsMap.values()) {
			list.add(student);
		}
		return list ;
	}
	
	//GET, get a student by its id
	public Student getStudent(long studentId) {
		return studentsMap.get(studentId);
	}

	//POST, add a new student
	public Student addStudent(Student student) {
		long nextAvailableId = studentsMap.size() + 1;
		student.setStudentId(nextAvailableId);
		studentsMap.put(nextAvailableId, student);
		return student;
	}
	
	//PUT, update information of a student
	public Student updateStudent(long studentId, Student student) {	
//		Student oldStudent = studentsMap.get(studentId);
//		studentId = oldStudent.getStudentId();
//		student.setStudentId(studentId);
		studentsMap.put(studentId, student);
		return student;
	}
	
	//DELETE, delete a student
	public Student deleteStudent(long studentId) {
		Student deletedStudentInfo = studentsMap.get(studentId);
		studentsMap.remove(studentId);
		return deletedStudentInfo;
	}

}
