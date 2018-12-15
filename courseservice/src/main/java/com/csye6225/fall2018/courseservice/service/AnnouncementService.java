package com.csye6225.fall2018.courseservice.service;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice.datamodel.Announcement;

import java.util.HashMap;
import java.util.List;

public class AnnouncementService {
    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public AnnouncementService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public Announcement add(Announcement announcement) {
        mapper.save(announcement);
        return announcement;
    }

    public Announcement delete(String boardId, String announcementId) {
        Announcement announcement = get(boardId, announcementId);
        mapper.delete(announcement, new DynamoDBDeleteExpression());
        return announcement;
    }

    public Announcement update(Announcement announcement) {
        delete(announcement.getBoardId(), announcement.getAnnouncementId());
        mapper.save(announcement);
        return announcement;
    }

    public Announcement get(String boardId, String announcementId) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(boardId));
        eav.put(":v2",  new AttributeValue().withS(announcementId));

        DynamoDBQueryExpression<Announcement> queryExpression = new DynamoDBQueryExpression<Announcement>()
                .withIndexName("boardId-announcementId-index")
                .withConsistentRead(false)
                .withKeyConditionExpression("boardId = :v1 and begins_with(announcementId, :v2)")
                .withExpressionAttributeValues(eav);

        List<Announcement> iList =  mapper.query(Announcement.class, queryExpression);
        if (iList.size() == 0) return null;
        return iList.get(0);
    }

    public List<Announcement> getAll(){
        return mapper.scan(Announcement.class, new DynamoDBScanExpression());
    }
}