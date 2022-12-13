package peaksoft.restapi.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.restapi.converter.lesson.LessonRequestConverter;
import peaksoft.restapi.converter.lesson.LessonResponseConverter;
import peaksoft.restapi.dto.lesson.LessonRequest;
import peaksoft.restapi.dto.lesson.LessonResponse;
import peaksoft.restapi.entities.Course;
import peaksoft.restapi.entities.Lesson;
import peaksoft.restapi.repository.CourseRepository;
import peaksoft.restapi.repository.LessonRepository;
import peaksoft.restapi.service.LessonService;

import java.util.List;

@Service
@RequiredArgsConstructor

public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;
    private final LessonRequestConverter lessonRequestConverter;
    private final LessonResponseConverter lessonResponseConverter;


    @Override
    public List<LessonResponse> getAllLessons(Long id) {
        return lessonResponseConverter.view( lessonRepository.findAllLessonByCourseId(id));
    }

    @Override
    public LessonResponse addLesson(Long id, LessonRequest lessonRequest) {
        Course course = courseRepository.getById(id);
        Lesson lesson = lessonRequestConverter.createLesson(lessonRequest);
        course.addLesson(lesson);
        lesson.setCourse(course);
        lessonRepository.save(lesson);
        return lessonResponseConverter.viewLesson(lesson);
    }

    @Override
    public LessonResponse getLessonById(Long id) {
        return lessonResponseConverter.viewLesson(lessonRepository.getById(id));
    }

    @Override
    public LessonResponse updateLesson(Long id,LessonRequest lessonRequest) {
        Lesson lesson1 = lessonRepository.findById(id).get();
        lessonRequestConverter.updateLesson(lesson1,lessonRequest);
        lessonRepository.save(lesson1);
        return lessonResponseConverter.viewLesson(lesson1);
    }

    @Override
    public LessonResponse deleteLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id).get();
        lessonRepository.delete(lesson);
        return lessonResponseConverter.viewLesson(lesson);
    }
}
