package com.csye6225.fall2018.courseservice.service;

import com.csye6225.fall2018.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.fall2018.courseservice.datamodel.Program;
import java.util.*;

public class ProgramsService {
	static HashMap<Long, Program> programsMap = InMemoryDatabase.getProgramDB();
	
	// Getting a list of all programs
	// GET "..webapi/programs"
	public List<Program> getAllPrograms() {	
		List<Program> list = new ArrayList<>();
		for (Program program : programsMap.values()) {
			list.add(program);
		}
		return list ;
	}
	
	//GET, get a program by its id
	public Program getProgram(long programId) {
		return programsMap.get(programId);
	}

	//POST, add a new program
	public Program addProgram(Program program) {
		long nextAvailableId = programsMap.size() + 1;
		program.setProgramId(nextAvailableId);
		programsMap.put(nextAvailableId, program);
		return program;
	}
	
	//PUT, update information of a program
	public Program updateProgram(long programId, Program program) {	
//		Program oldProgram = programsMap.get(programId);
//		programId = oldProgram.getProgramId();
//		program.setProgramId(programId);
		programsMap.put(programId, program);
		return program;
	}
	
	//DELETE, delete a program
	public Program deleteProgram(long programId) {
		Program deletedProgramInfo = programsMap.get(programId);
		programsMap.remove(programId);
		return deletedProgramInfo;
	}

}
