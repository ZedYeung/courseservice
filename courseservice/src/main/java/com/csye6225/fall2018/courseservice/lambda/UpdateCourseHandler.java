package com.csye6225.fall2018.courseservice.lambda;

import java.util.Map;
import org.json.JSONObject;

import com.amazonaws.regions.Regions;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.stepfunctions.AWSStepFunctions;
import com.amazonaws.services.stepfunctions.AWSStepFunctionsClientBuilder;
import com.amazonaws.services.stepfunctions.model.StartExecutionRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;


public class UpdateCourseHandler implements RequestHandler<DynamodbEvent, String> {
    AWSStepFunctions client = AWSStepFunctionsClientBuilder
          .standard()
          .withRegion(Regions.US_EAST_1)
          .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
          .build();

    String stateMachineArn = "arn:aws:states:us-east-1:755355487827:stateMachine:Choicestate";

    @Override
    public String handleRequest(DynamodbEvent event, Context context) {
        context.getLogger().log("Processing event: " + event);

        for(DynamodbStreamRecord record : event.getRecords()) {
            if (record == null) {
                context.getLogger().log("null record");
                continue;
            }

            String recordEvent = record.getEventName();
            if (!recordEvent.equals("INSERT")) {
                context.getLogger().log("not insert");
                continue;
            }

            Map<String, AttributeValue> map = record.getDynamodb().getNewImage();
            if (map == null) {
                context.getLogger().log("null map");
                continue;
            }

            String courseId = map.get("courseId").getS();
            String department = map.get("department").getS();

            String boardId = "";
            long length = 0;
            String notificationTopic = "";

            if ( map.get("boardId") != null ) {
              boardId = map.get("boardId").getS();
            }

            if ( map.get("roster") != null ) {
              length = map.get("roster").getL().size();
            }

            if ( map.get("notificationTopic") != null ) {
              notificationTopic = map.get("notificationTopic").getS();
            }

            String inputs = new JSONObject()
                .put("courseId", courseId)
                .put("department", department)
                .put("boardId", boardId)
                .put("length", length)
                .put("notificationTopic", notificationTopic)
                .toString();

            StartExecutionRequest request = new StartExecutionRequest();
            request.setInput(inputs);
            request.setStateMachineArn(stateMachineArn);
            client.startExecution(request);
        }
        return "Done";
    }
}