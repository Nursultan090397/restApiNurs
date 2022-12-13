package peaksoft.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.course.CourseRequest;
import peaksoft.restapi.dto.course.CourseResponse;
import peaksoft.restapi.service.CourseService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/getAll/{id}")
    public List<CourseResponse> getAllCourse(@PathVariable Long id){
        return courseService.getAllCourses(id);
    }

    @PostMapping("/save/{id}")
    public CourseResponse saveCourse(@PathVariable Long id, @RequestBody CourseRequest courseRequest)  {
        return courseService.addCourse(id, courseRequest);
    }

    @GetMapping("/findById/{id}")
    public CourseResponse findById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public CourseResponse deleteById(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }

    @PutMapping("/update/{id}")
    public CourseResponse updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable Long id)  {
        return courseService.updateCourse(id, courseRequest);
    }
}