package com.csye6225.fall2018.courseservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.fall2018.courseservice.datamodel.Lecture;
import com.csye6225.fall2018.courseservice.service.LecturesService;

@Path("lectures")
public class LecturesResource {

	LecturesService lectureService = new LecturesService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lecture> getAllLectures() {
		return lectureService.getAllLectures();
	}
	 
	@GET
	@Path("/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture getLectureById(@PathParam("lectureId") long lectureId) {
		return lectureService.getLecture(lectureId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addLecture(Lecture lecture) {
		lectureService.addLecture(lecture);
	}
	
	@PUT
	@Path("/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Lecture updateProfessor(@PathParam("lectureId") long lectureId, Lecture newLecture) {
		return lectureService.updateLecture(lectureId, newLecture);
	}
	
	@DELETE
	@Path("/{lectureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Lecture deleteLecture(@PathParam("lectureId") long lectureId) {
		return lectureService.deleteLecture(lectureId);
	}
 }
