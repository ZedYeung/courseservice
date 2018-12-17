package com.csye6225.fall2018.courseservice.service;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import com.csye6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice.datamodel.Registrar;

import java.util.HashMap;
import java.util.List;

public class RegistrarService {
    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public RegistrarService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public Registrar add(Registrar registrar) {
        mapper.save(registrar);
        return registrar;
    }

    public Registrar delete(String registrarId) {
        Registrar registrar = get(registrarId);
        mapper.delete(registrar, new DynamoDBDeleteExpression());
        return registrar;
    }

    public Registrar update(String registrarId, Registrar registrar) {
        delete(registrarId);
        registrar.setRegistrarId(registrarId);
        mapper.save(registrar);
        return registrar;
    }

    public Registrar get(String registrarId) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(registrarId));

        DynamoDBQueryExpression<Registrar> queryExpression = new DynamoDBQueryExpression<Registrar>()
                .withIndexName("registrarId-index")
                .withKeyConditionExpression("registrarId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<Registrar> list =  mapper.query(Registrar.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public List<Registrar> getAll(){
        return mapper.scan(Registrar.class, new DynamoDBScanExpression());
    }


}