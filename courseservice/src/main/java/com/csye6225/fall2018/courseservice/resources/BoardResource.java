package com.csye6225.fall2018.courseservice.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.csye6225.fall2018.courseservice.datamodel.Board;
import com.csye6225.fall2018.courseservice.service.BoardService;

@Path("board")
public class BoardResource {

    BoardService boardService = new BoardService();

		@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Board add(Board board) {
        return boardService.add(board);
    }

    @DELETE
    @Path("/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Board delete(@PathParam("boardId") String boardId) {
        return boardService.delete(boardId);
    }

    @PUT
    @Path("/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Board update(@PathParam("boardId") String boardId, Board board) {
        return boardService.update(boardId, board);
    }

		@GET
    @Path("/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Board get(@PathParam("boardId") String boardId) {
        return boardService.get(boardId);
    }

		@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Board> getAll() {
        return boardService.getAll();
    }
}
