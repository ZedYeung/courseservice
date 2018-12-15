package com.csye6225.fall2018.courseservice.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.csye6225.fall2018.courseservice.datamodel.Professor;
import com.csye6225.fall2018.courseservice.service.ProfessorService;

@Path("professor")
public class ProfessorResource {

    ProfessorService professorService = new ProfessorService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor add(Professor professor) {
        return professorService.add(professor);
    }

		@DELETE
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor delete(@PathParam("professorId") String professorId) {
        return professorService.delete(professorId);
    }

    @PUT
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor update(@PathParam("professorId") String professorId, Professor professor) {
        return professorService.update(professor);
    }

		@GET
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor get(@PathParam("professorId") String professorId) {
        return professorService.get(professorId);
    }

		@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> getAll() {
        return professorService.getAll();
    }
}

