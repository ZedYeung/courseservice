package com.csye6225.fall2018.courseservice.datamodel;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import java.util.List;

/*
Student
     - Id (Dynamo Db generated) and hash key
     - studentId - DynamoDbIndexHashKey, a Global Secondary Index (GSI)
     - firstName
     - lastName
     - joiningDate
     - department
     - registeredCourses - has list of registered courseIds
     - emailId
*/

@DynamoDBTable(tableName = "Student")
public class Student {

    private String id;
    private String studentId;
    private String firstName;
    private String lastName;
    private String joiningDate;
    private String department;
    private List<String> registeredCourses;
    private String emailId;

    public Student() {}


    @DynamoDBAutoGeneratedKey
    @DynamoDBHashKey(attributeName = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "studentId")
    @DynamoDBIndexHashKey(attributeName = "studentId", globalSecondaryIndexName = "studentId-index")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @DynamoDBAttribute(attributeName = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDBAttribute(attributeName = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DynamoDBAttribute(attributeName = "joiningDate")
    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    @DynamoDBAttribute(attributeName = "registeredCourses")
    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<String> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    @DynamoDBAttribute(attributeName = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @DynamoDBAttribute(attributeName = "emailId")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}

