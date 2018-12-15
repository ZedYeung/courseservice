package com.csye6225.fall2018.courseservice.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice.datamodel.Student;
import com.csye6225.fall2018.courseservice.datamodel.Course;

import java.util.HashMap;
import java.util.List;

public class StudentService {

    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public StudentService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

		public Student add(Student student) {
        mapper.save(student);
        return student;
    }

    public void register(String studentId, String courseId) {
        CourseService courseService = new CourseService();
        Course course = courseService.get(courseId);
        Student student = get(studentId);

        //create a new SNS client and set endpoint
        // deprecated
        // AmazonSNSClient snsClient = new AmazonSNSClient();
        // snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));
        AmazonSNS sns = AmazonSNSClient.builder()
						.withRegion("us-east-1")
						.build();

        String notificationTopic = course.getNotificationTopic();

        //subscribe to an SNS topic
        SubscribeRequest subRequest = new SubscribeRequest(
                            notificationTopic, "email", student.getEmailId());
        sns.subscribe(subRequest);
    }

		public Student delete(String studentId) {
        Student student = get(studentId);
        mapper.delete(student, new DynamoDBDeleteExpression());
        return student;
    }

    public Student update(Student student) {
        delete(student.getStudentId());
        mapper.save(student);
        return student;
    }

    public Student get(String studentId) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(studentId));

        DynamoDBQueryExpression<Student> queryExpression = new DynamoDBQueryExpression<Student>()
                .withIndexName("studentId-index")
                .withKeyConditionExpression("studentId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<Student> list =  mapper.query(Student.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public List<Student> getAll(){
        return mapper.scan(Student.class, new DynamoDBScanExpression());
    }
}
