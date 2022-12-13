package peaksoft.restapi.converter.student;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.instructor.InstructorRequest;
import peaksoft.restapi.dto.student.StudentRequest;
import peaksoft.restapi.entities.Instructor;
import peaksoft.restapi.entities.Student;

@Component
public class StudentRequestConverter {
    public Student createStudent(StudentRequest studentRequest) {
        if (studentRequest == null) {
            return null;
        }
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        return student;
    }

    public void updateStudent(StudentRequest studentRequest,Student student) {
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
    }
}
