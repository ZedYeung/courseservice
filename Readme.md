# CSYE6225 Assignment - Student Management System API

## Overview
  - The system manages Professors, Students and Programs.
  - Every Program has Courses
  - Every Course has Lectures, and each lecture will have notes, and associated material
  - Every Course will have a board
  - Every Course will have a roster
  - Every Course has enrolled Students
  - Every Course has one associated Professor, and a Student TA
  - Every Student has information in the system
       - Name        
       - StudentId
       - image     
       - courses enrolled
       - program name

## API
http://neu-cyse6225-student-management-system.us-east-1.elasticbeanstalk.com/webapi

  Get /programs  
  Get /programs/{programId}  
  Post /programs  
  ```
  {
    "programName": "IS",
    "courses": [0, 1]
  }
  ```
  Put /programs/{programId}  
  Delete /programs/{programId}  
  Get /courses  
  Get /courses/{courseId}  
  Post /courses  
  ```
  {
    "courseName": "Cloud Computing",
    "lectures": [0, 1],
    "board": "board",
    "roster": "roster",
    "enrolledStudents": [0, 1],
    "associatedProf": 0,
    "courseTA": 1  
  }
  ```
  Put /courses/{courseId}  
  Delete /courses/{courseId}  
  Get /lectures  
  Get /lectures/{lectureId}  
  Post /lectures
  ```
  {
    "associatedMaterialURL": "associatedMaterialURL",
    "lectureName": "leture1",
    "notesURL": [
      "12313123",
      "456456"
    ]
  }
  ```  
  Put /lectures/{lectureId}  
  Delete /lectures/{lectureId}  
  Get /professors  
  Get /professors/{professorId}  
  Post /professors  
  ```
  {
    "department": "IS",
    "firstName": "Ab",
    "joiningDate": "2019-10-11T20:20:11.234"
  }
  ```
  Put /professors/{professorId}  
  Delete /professors/{professorId}  
  Get /students  
  Get /students/{studentId}  
  Post /students  
  ```
  {
    "studentName": "KK",
    "imageURL": "imageURL",
    "programName": "IS",
    "enrolledCourses": [0, 1]
  }
  ```
  Put /students/{studentId}  
  Delete /students/{studentId}  
