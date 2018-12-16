package com.csye6225.fall2018.courseservice.lambda;

import java.util.Map;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;

import com.csye6225.fall2018.courseservice.datamodel.Course;
import com.csye6225.fall2018.courseservice.service.CourseService;

public class SendNotificationHandler implements RequestHandler<DynamodbEvent, String> {
    AmazonSNS sns = AmazonSNSClient.builder()
        .withRegion("us-east-1")
        .build();

    @Override
    public String handleRequest(DynamodbEvent event, Context context) {
        for(DynamodbStreamRecord record : event.getRecords()) {
            if (record == null) {
                continue;
            }

            String recordEvent = record.getEventName();
            if (!recordEvent.equals("INSERT")) {
                continue;
            }

            Map<String, AttributeValue> map = record.getDynamodb().getNewImage();
            if (map == null) {
                continue;
            }

            String courseId = map.get("courseId").getS();
            String announcementText = map.get("announcementText").getS();

            CourseService courseService = new CourseService();
            Course course = courseService.get(courseId);
            String notificationTopic = course.getNotificationTopic();

            String subject = "New Announcement";

            // send notification
            PublishRequest pubRequest = new PublishRequest(notificationTopic, announcementText, subject);
            sns.publish(pubRequest);
        }
        
        return "Processed event: " + event;
    }
}