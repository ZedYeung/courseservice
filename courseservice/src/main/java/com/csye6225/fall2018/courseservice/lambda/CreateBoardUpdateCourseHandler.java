package com.csye6225.fall2018.courseservice.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.csye6225.fall2018.courseservice.datamodel.Board;
import com.csye6225.fall2018.courseservice.datamodel.Course;
import com.csye6225.fall2018.courseservice.service.BoardService;
import com.csye6225.fall2018.courseservice.service.CourseService;


public class CreateBoardUpdateCourseHandler implements RequestHandler<UpdateCourseEvent, String> {
    //create a new SNS client and set endpoint
    // deprecated
    // AmazonSNSClient snsClient = new AmazonSNSClient();
    // snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));
    AmazonSNS sns = AmazonSNSClient.builder()
        .withRegion("us-east-1")
        .build();

    @Override
    public String handleRequest(UpdateCourseEvent event, Context context) {
        context.getLogger().log("Processing event: " + event);

        String courseId = event.getCourseId();
        String boardId = "012" + courseId;

        CourseService courseService = new CourseService();
        Course course = courseService.get(courseId);

        //create a new SNS topic
        CreateTopicRequest createTopicRequest = new CreateTopicRequest(courseId);
        CreateTopicResult createTopicResult = sns.createTopic(createTopicRequest);

        course.setBoardId(boardId);
        course.setNotificationTopic(createTopicResult.getTopicArn());
        courseService.update(courseId, course);

        BoardService boardService = new BoardService();
        Board board = new Board(boardId, courseId);
        boardService.add(board);

        return "Done";
    }
}