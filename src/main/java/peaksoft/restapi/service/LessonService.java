package peaksoft.restapi.service;

import peaksoft.restapi.dto.lesson.LessonRequest;
import peaksoft.restapi.dto.lesson.LessonResponse;
import peaksoft.restapi.entities.Lesson;

import java.util.List;

public interface LessonService {
    List<LessonResponse> getAllLessons(Long courseId);

    LessonResponse addLesson(Long id, LessonRequest lessonRequest);

    LessonResponse getLessonById(Long id);

    LessonResponse updateLesson(Long id, LessonRequest lessonRequest);

    LessonResponse deleteLesson(Long id);
}
