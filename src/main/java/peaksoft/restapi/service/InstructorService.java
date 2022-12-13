package peaksoft.restapi.service;

import peaksoft.restapi.dto.instructor.InstructorRequest;
import peaksoft.restapi.dto.instructor.InstructorResponse;
import peaksoft.restapi.entities.Instructor;

import java.io.IOException;
import java.util.List;

public interface InstructorService {
    List<InstructorResponse> getInstructorList();
    List<InstructorResponse> getAlInstructors(Long courseId);

    InstructorResponse addInstructor(Long id, InstructorRequest instructorRequest);

    InstructorResponse getInstructorById(Long id);

    InstructorResponse updateInstructor(Long id, InstructorRequest instructorRequest);

    InstructorResponse deleteInstructor(Long id);

    void assignInstructor(Long courseId,Long instructorId) throws IOException;
}
