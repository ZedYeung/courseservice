# CSYE6225 Assignment - Student Management System API

## Overview
```
Professors
     - Id - Autog-generated and Dynamo db hash key
     - professorId - DynamoDbIndexHashKey, a Global Secondary Index (GSI)
     - firstName
     - lastName
     - joiningDate
     - department
Course
     - Id (Dynamo Db generated) and hash key
     - courseId - DynamoDbIndexHashKey, a Global Secondary Index (GSI)
     - professorId
     - taId
     - department
     - boardId
     - listOfRegisteredStudents/roster - has student Id list (this is the roster)
Board
     - Id (Dynamo Db generated) and hash key
     - boardId - DynamoDbIndexHashKey, a Global Secondary Index (GSI)
     - courseId
Announcements
     - Id (Dynamo Db generated) and hash key
     - announcementId - dynamodb Index range key part of the GSI
     - announcementText - (ensure text size is no more than 160 characters)
     - boardId -DynamoDbIndexHashKey, part of the GSI Global Secondary Index (GSI)

Student
     - Id (Dynamo Db generated) and hash key
     - studentId - DynamoDbIndexHashKey, a Global Secondary Index (GSI)
     - firstName
     - lastName
     - joiningDate
     - department
     - registeredCourses - has list of registered courseIds
```

## API
http://neu-cyse6225-student-management-system.us-east-1.elasticbeanstalk.com/webapi

  ### professor
  GET /professor  
  GET /professor/{professorId}    
  POST /professor  
  PUT /professor/{professorId}  
  DELETE /professor/{professorId}  

  ### course
  GET /course  
  GET /course/{courseId}  
  POST /course  
  PUT /course/{courseId}  
  DELETE /course/{courseId}  

  ### board
  GET /board  
  GET /board/{boardId}  
  POST /board  
  PUT /board/{boardId}  
  DELETE /board/{boardId}  

  ### announcement
  GET /announcement  
  GET /announcement/{announcementId}  
  POST /announcement  
  PUT /announcement/{announcementId}  
  DELETE /announcement/{announcementId}  

  ### student
  GET /student  
  GET /student/{studentId}  
  POST /student  
  PUT /student/{studentId}  
  DELETE /student/{studentId}  
