package peaksoft.restapi.converter.lesson;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.instructor.InstructorRequest;
import peaksoft.restapi.dto.lesson.LessonRequest;
import peaksoft.restapi.entities.Instructor;
import peaksoft.restapi.entities.Lesson;

@Component
public class LessonRequestConverter {
    public Lesson createLesson(LessonRequest lessonRequest) {
        if (lessonRequest == null) {
            return null;
        }
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        return lesson;
    }

    public void updateLesson(Lesson lesson, LessonRequest lessonRequest) {
       lesson.setLessonName(lessonRequest.getLessonName());
    }
}