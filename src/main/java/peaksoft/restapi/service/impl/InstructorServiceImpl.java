package peaksoft.restapi.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.restapi.converter.instructor.InstructorRequestConverter;
import peaksoft.restapi.converter.instructor.InstructorResponseConverter;
import peaksoft.restapi.dto.instructor.InstructorRequest;
import peaksoft.restapi.dto.instructor.InstructorResponse;
import peaksoft.restapi.entities.Course;
import peaksoft.restapi.entities.Group;
import peaksoft.restapi.entities.Instructor;
import peaksoft.restapi.repository.CourseRepository;
import peaksoft.restapi.repository.InstructorRepository;
import peaksoft.restapi.service.InstructorService;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;
    private final InstructorRequestConverter instructorRequestConverter;
    private final InstructorResponseConverter instructorResponseConverter;



    @Override
    public List<InstructorResponse> getInstructorList() {
        return instructorResponseConverter.view(instructorRepository.findAll());
    }

    @Override
    public List<InstructorResponse> getAlInstructors(Long courseId) {
        return instructorResponseConverter.view(instructorRepository.getReferenceById(courseId).getCourse().getInstructorList());

    }

    @Override
    public InstructorResponse addInstructor(Long id, InstructorRequest instructorRequest) {
        Course course = courseRepository.getById(id);
        Instructor instructor = instructorRepository.getReferenceById(id);
        course.addInstructor(instructor);
        instructor.setCourse(course);
        instructorRepository.save(instructor);
        return instructorResponseConverter.viewInstructor(instructor);

    }

    @Override
    public InstructorResponse getInstructorById(Long id) {
        Instructor instructor =instructorRepository.getById(id) ;
        return instructorResponseConverter.viewInstructor(instructor);
    }

    @Override
    public InstructorResponse updateInstructor( Long id, InstructorRequest instructorRequest) {
        Instructor instructor = instructorRepository.getById(id);
        instructorRequestConverter.updateInstructor(instructor,instructorRequest);
       instructorRepository.save(instructor);
        return instructorResponseConverter.viewInstructor(instructor);

    }

    @Override
    public InstructorResponse deleteInstructor(Long id) {
        Instructor instructor =  instructorRepository.findById(id).get();
        instructorRepository.deleteById(id);
        return instructorResponseConverter.viewInstructor(instructor);


}

    @Override
    public void assignInstructor(Long courseId, Long instructorId) throws IOException {
        Instructor instructor = instructorRepository.getById(instructorId);
        Course course = courseRepository.getById(courseId);
        if (course.getInstructorList()!=null){
            for (Instructor g : course.getInstructorList()) {
                if (g.getId() == instructorId) {
                    throw new IOException("This instructor already exists!");
                }
            }
        }
        instructor.getCourse().getInstructorList().remove(instructor);
        instructor.setCourse(course);
        course.addInstructor(instructor);
        instructorRepository.save(instructor);
        courseRepository.save(course);
    }
}
