package com.csye6225.fall2018.courseservice.service;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice.datamodel.Professor;

import java.util.HashMap;
import java.util.List;

public class ProfessorService {

    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public ProfessorService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

		public Professor add(Professor prof) {
        mapper.save(prof);
        return prof;
    }

		public Professor delete(String profId) {
        Professor prof = get(profId);
        mapper.delete(prof, new DynamoDBDeleteExpression());
        return prof;
    }

    public Professor update(Professor prof) {
        delete(prof.getProfessorId());
        mapper.save(prof);
        return prof;
    }

		public Professor get(String profId) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(profId));

        DynamoDBQueryExpression<Professor> queryExpression = new DynamoDBQueryExpression<Professor>()
                .withIndexName("professorId-index")
                .withKeyConditionExpression("professorId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<Professor> list =  mapper.query(Professor.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

		public List<Professor> getAll(){
        return mapper.scan(Professor.class, new DynamoDBScanExpression());
    }
}