package com.csye6225.fall2018.courseservice.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.csye6225.fall2018.courseservice.datamodel.Registrar;
import com.csye6225.fall2018.courseservice.service.RegistrarService;

@Path("registrar")
public class RegistrarResource {

    RegistrarService registrarService = new RegistrarService();

		@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Registrar add(Registrar registrar) {
        return registrarService.add(registrar);
    }

    @DELETE
    @Path("/{registrarId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Registrar delete(@PathParam("registrarId") String registrarId) {
        return registrarService.delete(registrarId);
    }

    @PUT
    @Path("/{registrarId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Registrar update(@PathParam("registrarId") String registrarId, Registrar registrar) {
        return registrarService.update(registrarId, registrar);
    }

		@GET
    @Path("/{registrarId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Registrar get(@PathParam("registrarId") String registrarId) {
        return registrarService.get(registrarId);
    }

		@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Registrar> getAll() {
        return registrarService.getAll();
    }
}

