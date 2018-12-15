package com.csye6225.fall2018.courseservice.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import com.csye6225.fall2018.courseservice.datamodel.Student;
import com.csye6225.fall2018.courseservice.service.StudentService;

@Path("student")
public class StudentResource {

    StudentService studentService = new StudentService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student add(Student student) {
        return studentService.add(student);
    }

    @POST
    @Path("/{studentId}/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void register(@PathParam("studentId") String studentId, String courseId) {
        studentService.register(studentId, courseId);
    }

		@DELETE
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student delete(@PathParam("studentId") String studentId) {
        return studentService.delete(studentId);
    }

    @PUT
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student update(@PathParam("studentId") String studentId, Student student) {
        return studentService.update(student);
    }

		@GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student get(@PathParam("studentId") String studentId) {
        return studentService.get(studentId);
    }

		@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAll() {
        return studentService.getAll();
    }
}

