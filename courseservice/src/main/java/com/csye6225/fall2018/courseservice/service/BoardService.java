package com.csye6225.fall2018.courseservice.service;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.fall2018.courseservice.datamodel.DynamoDBConnector;
import com.csye6225.fall2018.courseservice.datamodel.Board;

import java.util.HashMap;
import java.util.List;

public class BoardService {
    static DynamoDBConnector dynamoDb;
    DynamoDBMapper mapper;

    public BoardService() {
        dynamoDb = new DynamoDBConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public Board add(Board board) {
        mapper.save(board);
        return board;
    }

    public Board delete(String boardId) {
        Board board = get(boardId);
        mapper.delete(board, new DynamoDBDeleteExpression());
        return board;
    }

    public Board update(Board board) {
        delete(board.getBoardId());
        mapper.save(board);
        return board;
    }

    public Board get(String boardId) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1",  new AttributeValue().withS(boardId));

        DynamoDBQueryExpression<Board> queryExpression = new DynamoDBQueryExpression<Board>()
                .withIndexName("boardId-index")
                .withKeyConditionExpression("boardId = :v1")
                .withConsistentRead(false)
                .withExpressionAttributeValues(eav);

        List<Board> list =  mapper.query(Board.class, queryExpression);
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public List<Board> getAll(){
        return mapper.scan(Board.class, new DynamoDBScanExpression());
    }


}