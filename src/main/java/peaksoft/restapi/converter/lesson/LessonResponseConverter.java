package peaksoft.restapi.converter.lesson;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.group.GroupResponse;
import peaksoft.restapi.dto.lesson.LessonResponse;
import peaksoft.restapi.entities.Group;
import peaksoft.restapi.entities.Lesson;

import java.util.ArrayList;
import java.util.List;

@Component
public class LessonResponseConverter {
    public LessonResponse viewLesson(Lesson lesson){
        if (lesson==null){
            return null;
        }

        LessonResponse lessonResponse = new LessonResponse();

        lessonResponse.setId(lesson.getId());
        lessonResponse.setLessonName(lesson.getLessonName());

        return lessonResponse;
    }

    public List<LessonResponse> view(List<Lesson> lessons){
        List<LessonResponse> lessonResponses = new ArrayList<>();

        for (Lesson lesson: lessons) {
            lessonResponses.add(viewLesson(lesson));
        }

        return lessonResponses;
    }
}
