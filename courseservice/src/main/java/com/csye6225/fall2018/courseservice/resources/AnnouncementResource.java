package com.csye6225.fall2018.courseservice.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.csye6225.fall2018.courseservice.datamodel.Announcement;
import com.csye6225.fall2018.courseservice.service.AnnouncementService;

@Path("announcement")
public class AnnouncementResource {

    AnnouncementService announcementService = new AnnouncementService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Announcement add(Announcement announcement) {
        return announcementService.add(announcement);
    }

		@DELETE
    @Path("/{boardId}_{announcementId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Announcement delete(@PathParam("boardId") String boardId,
		                           @PathParam("announcementId") String announcementId) {
        return announcementService.delete(boardId, announcementId);
    }

    @PUT
    @Path("/{boardId}_{announcementId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Announcement update(@PathParam("boardId") String boardId,
															 @PathParam("announcementId") String announcementId,
                               Announcement announcement) {
        return announcementService.update(announcement);
    }

		@GET
    @Path("/{boardId}_{announcementId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Announcement get(@PathParam("boardId") String boardId,
														@PathParam("announcementId") String announcementId) {
        return announcementService.get(boardId, announcementId);
    }

		@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Announcement> getAll() {
        return announcementService.getAll();
    }
}