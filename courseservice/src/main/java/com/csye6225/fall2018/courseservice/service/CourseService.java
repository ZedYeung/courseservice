package com.csye6225.fall2018.courseservice.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice.datamodel.Course;

import java.util.HashMap;
import java.util.List;

public class CourseService {

    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public CourseService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

		public Course add(Course course) {
        //create a new SNS client and set endpoint
        // deprecated
        // AmazonSNSClient snsClient = new AmazonSNSClient();
        // snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));
        AmazonSNS sns = AmazonSNSClient.builder()
            .withRegion("us-east-1")
            .build();

        //create a new SNS topic
        CreateTopicRequest createTopicRequest = new CreateTopicRequest(course.getCourseId());
        CreateTopicResult createTopicResult = sns.createTopic(createTopicRequest);

        course.setNotificationTopic(createTopicResult.getTopicArn());

        mapper.save(course);
        return course;
    }

    public Course delete(String courseId) {
        Course course = get(courseId);
        mapper.delete(course, new DynamoDBDeleteExpression());
        return course;
    }

		public Course update(Course course) {
        delete(course.getCourseId());
        mapper.save(course);
        return course;
    }

    public Course get(String courseId) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(courseId));

        DynamoDBQueryExpression<Course> queryExpression = new DynamoDBQueryExpression<Course>()
                .withIndexName("courseId-index")
                .withKeyConditionExpression("courseId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<Course> list =  mapper.query(Course.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public List<Course> getAll(){
        return mapper.scan(Course.class, new DynamoDBScanExpression());
    }
}
