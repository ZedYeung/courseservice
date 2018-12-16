package com.csye6225.fall2018.courseservice.datamodel;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

/*
Professors
     - Id - Autog-generated and Dynamo db hash key
     - professorId - DynamoDbIndexHashKey, a Global Secondary Index (GSI)
     - firstName
     - lastName
     - joiningDate
     - department
*/


@DynamoDBTable(tableName = "Professor")
public class Professor {

    private String id;
    private String professorId;
    private String firstName;
    private String lastName;
    private String joiningDate;
    private String department;

    public Professor() {

    }

    public Professor(String professorId, String firstName, String lastName,
                      String joiningDate, String department) {
    		this.professorId = professorId;
    		this.firstName = firstName;
    		this.lastName = lastName;
    		this.joiningDate = joiningDate;
    		this.department = department;
  	}

    @DynamoDBAutoGeneratedKey
    @DynamoDBHashKey(attributeName = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @DynamoDBAttribute(attributeName="professorId")
    @DynamoDBIndexHashKey(attributeName="professorId", globalSecondaryIndexName = "professorId-index")
    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
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

    @DynamoDBAttribute(attributeName = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @DynamoDBIgnore
    @Override
    public String toString() {
        return "ProfId=" + getProfessorId() + ", firstName=" + getFirstName()
                + ", department=" + getDepartment() + ", joiningDate=" + getJoiningDate();
    }
}
