package peaksoft.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.course.CourseRequest;
import peaksoft.restapi.dto.course.CourseResponse;
import peaksoft.restapi.dto.instructor.InstructorRequest;
import peaksoft.restapi.dto.instructor.InstructorResponse;
import peaksoft.restapi.service.CourseService;
import peaksoft.restapi.service.InstructorService;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping("/getAll")
    public List<InstructorResponse> getAllInstructor(){
        return instructorService.getInstructorList();
    }

    @GetMapping("/getAllByCourseId/{courseId}")
    public List<InstructorResponse> getAllInstructor(@PathVariable Long courseId){
        return instructorService.getAlInstructors(courseId);
    }

    @PostMapping("/save/{id}")
    public InstructorResponse saveInstructor(@PathVariable Long id, @RequestBody InstructorRequest instructorRequest) throws IOException {
        return instructorService.addInstructor(id, instructorRequest);
    }

    @GetMapping("/findById/{id}")
    public InstructorResponse findById(@PathVariable Long id){
        return instructorService.getInstructorById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public InstructorResponse deleteById(@PathVariable Long id){
        return instructorService.deleteInstructor(id);
    }

    @PutMapping("/update/{id}")
    public InstructorResponse updateInstructor(@RequestBody InstructorRequest instructorRequest, @PathVariable Long id) throws IOException {
        return instructorService.updateInstructor(id, instructorRequest);
    }

    @PostMapping("/assignInstructor/{instructorId}/{courseId}")
    public void assignInstructor(@PathVariable("instructorId")Long instructorId, @PathVariable("courseId") Long courseId) throws IOException {
        instructorService.assignInstructor(courseId, instructorId);
    }
}