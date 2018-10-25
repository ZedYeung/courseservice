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
  Put /programs/{programId}  
  Delete /programs/{programId}  
  Get /courses  
  Get /courses/{courseId}  
  Post /courses  
  Put /courses/{courseId}  
  Delete /courses/{courseId}  
  Get /lectures  
  Get /lectures/{lectureId}  
  Post /lectures  
  Put /lectures/{lectureId}  
  Delete /lectures/{lectureId}  
  Get /professors  
  Get /professors/{professorId}  
  Post /professors  
  Put /professors/{professorId}  
  Delete /professors/{professorId}  
  Get /students  
  Get /students/{studentId}  
  Post /students  
  Put /students/{studentId}  
  Delete /students/{studentId}  
