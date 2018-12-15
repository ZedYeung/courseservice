package com.csye6225.fall2018.courseservice.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.csye6225.fall2018.courseservice.datamodel.Course;
import com.csye6225.fall2018.courseservice.service.CourseService;

@Path("course")
public class CourseResource {

    CourseService courseService = new CourseService();

		@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course add(Course course) {
        return courseService.add(course);
    }

    @DELETE
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course delete(@PathParam("courseId") String courseId) {
        return courseService.delete(courseId);
    }

    @PUT
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course update(@PathParam("courseId") String courseId, Course course) {
        return courseService.update(course);
    }

		@GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course get(@PathParam("courseId") String courseId) {
        return courseService.get(courseId);
    }

		@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAll() {
        return courseService.getAll();
    }
}

