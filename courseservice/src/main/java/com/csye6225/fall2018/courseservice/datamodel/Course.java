package com.csye6225.fall2018.courseservice.datamodel;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import java.util.List;

/*
Course
     - Id (Dynamo Db generated) and hash key
     - courseId - DynamoDbIndexHashKey, a Global Secondary Index (GSI)
     - professorId
     - taId
     - department
     - boardId
     - listOfRegisteredStudents/roster - has student Id list (this is the roster)
     - notificationTopic // NEW FIELD for storing sns topic.
*/


@DynamoDBTable(tableName = "Course")
public class Course {

    private String id;
    private String courseId;
    private String professorId;
    private String taId;
    private String department;
    private String boardId;
    private List<String> roster;
    private String notificationTopic;

    public Course() {

    }

    public Course(String courseId, String professorId, String taId, String department,
                  String boardId, List<String> roster, String notificationTopic) {
    		this.courseId = courseId;
    		this.professorId = professorId;
    		this.taId = taId;
    		this.department = department;
    		this.boardId = boardId;
    		this.roster = roster;
        this.notificationTopic = notificationTopic;
  	}

    @DynamoDBHashKey(attributeName = "Id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // @DynamoDBAttribute(attributeName = "courseId")
    @DynamoDBIndexHashKey(attributeName = "courseId", globalSecondaryIndexName = "courseId-index")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @DynamoDBAttribute(attributeName = "professorId")
    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    @DynamoDBAttribute(attributeName = "taId")
    public String getTaId() {
        return taId;
    }

    public void setTaId(String taId) {
        this.taId = taId;
    }

    @DynamoDBAttribute(attributeName = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @DynamoDBAttribute(attributeName = "boardId")
    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    @DynamoDBAttribute(attributeName = "roster")
    public List<String> getRoster() {
        return roster;
    }

    public void setRoster(List<String> roster) {
        this.roster = roster;
    }

    @DynamoDBAttribute(attributeName = "notificationTopic")
    public String getNotificationTopic() {
        return notificationTopic;
    }

    public void setNotificationTopic(String notificationTopic) {
        this.notificationTopic = notificationTopic;
    }

    @DynamoDBIgnore
    @Override
    public String toString() {
        return  "id=" + getId() + ", courseId=" + getCourseId() + ", professorId=" + getProfessorId()
                + ", department=" + getDepartment() + ", taId=" + getTaId()
                + ", boardId=" + getBoardId() + ", notificationTopic=" + getNotificationTopic();
    }
}