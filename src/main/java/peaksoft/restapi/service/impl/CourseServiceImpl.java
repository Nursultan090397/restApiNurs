package peaksoft.restapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.restapi.converter.course.CourseRequestConverter;
import peaksoft.restapi.converter.course.CourseResponseConverter;
import peaksoft.restapi.dto.course.CourseRequest;
import peaksoft.restapi.dto.course.CourseResponse;
import peaksoft.restapi.entities.Company;
import peaksoft.restapi.entities.Course;
import peaksoft.restapi.repository.CompanyRepository;
import peaksoft.restapi.repository.CourseRepository;
import peaksoft.restapi.service.CourseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final CourseResponseConverter courseResponseConverter;
    private final CourseRequestConverter courseRequestConverter;


    @Override
    public List<CourseResponse> getAllCourses(Long id) {
        return courseResponseConverter.view(courseRepository.getAllCourses(id));
    }

    @Override
    public CourseResponse addCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRequestConverter.createCourse(courseRequest);
        Company company = companyRepository.getById(id);
        company.addCourse(course);
        course.setCompany(company);
        courseRepository.save(course);
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest)  {
        Course course = courseRepository.findById(id).get();
        courseRequestConverter.updateCourse(course, courseRequest);
        courseRepository.save(course);

        return courseResponseConverter.viewCourse(course);
    }

    @Override
    public CourseResponse deleteCourse(Long id) {
        Course course = courseRepository.findById(id).get();
        courseRepository.delete(course);
        return courseResponseConverter.viewCourse(course);
    }

    }

