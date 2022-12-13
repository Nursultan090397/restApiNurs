package peaksoft.restapi.service;

import peaksoft.restapi.dto.student.StudentRequest;
import peaksoft.restapi.dto.student.StudentResponse;
import peaksoft.restapi.entities.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    List<StudentResponse> getStudentList();

    List<StudentResponse> getAlStudents(Long groupId);

    StudentResponse addStudent(Long id, StudentRequest studentRequest) throws IOException;

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(StudentRequest studentRequest, Long id);

    StudentResponse deleteStudent(Long id);

    void assignStudent(Long groupId,Long studentId) throws IOException;
}
