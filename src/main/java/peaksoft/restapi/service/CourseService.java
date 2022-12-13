package peaksoft.restapi.service;

import peaksoft.restapi.dto.course.CourseRequest;
import peaksoft.restapi.dto.course.CourseResponse;
import peaksoft.restapi.entities.Course;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses(Long id);

    CourseResponse addCourse(Long id,CourseRequest courseRequest);

    CourseResponse getCourseById(Long id);

    CourseResponse updateCourse(Long courseId, CourseRequest courseRequest);

    CourseResponse deleteCourse(Long id);
}
