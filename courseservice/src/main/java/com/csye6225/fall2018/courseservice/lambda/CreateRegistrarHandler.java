package com.csye6225.fall2018.courseservice.lambda;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class CreateRegistrarHandler implements RequestHandler<UpdateCourseEvent, UpdateCourseEvent> {
    String registerOfferingUrl = "http://neu-cyse6225-student-management-system.us-east-1.elasticbeanstalk.com/webapi/registerOffering";

    @Override
    public UpdateCourseEvent handleRequest(UpdateCourseEvent event, Context context) {
        context.getLogger().log("Processing event: " + event);

        HttpClient httpClient = HttpClientBuilder.create().build();

        String params = new JSONObject()
          .put("registrarId", "2018" + event.getCourseId())
          .put("offeringId", "206" + event.getCourseId())
          .put("offeringType", "Course")
          .put("department", event.getDepartment())
          .put("PerUnitPrice", 1234)
          .toString();

        try {
            HttpPost request = new HttpPost(registerOfferingUrl);
            request.addHeader("content-type", "application/json");
            request.setEntity(new StringEntity(params));

            HttpResponse response = httpClient.execute(request);
            context.getLogger().log("status code: " + response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
}