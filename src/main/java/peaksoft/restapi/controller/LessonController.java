package peaksoft.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.lesson.LessonRequest;
import peaksoft.restapi.dto.lesson.LessonResponse;
import peaksoft.restapi.service.LessonService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;


    @GetMapping("/getAllByCourseId/{courseId}")
    public List<LessonResponse> getAllLesson(@PathVariable Long courseId){
        return lessonService.getAllLessons(courseId);
    }

    @PostMapping("/save/{id}")
    public LessonResponse saveLesson(@PathVariable Long id, @RequestBody LessonRequest lessonRequest) throws IOException {
        return lessonService.addLesson(id, lessonRequest);
    }

    @GetMapping("/findById/{id}")
    public LessonResponse findById(@PathVariable Long id){
        return lessonService.getLessonById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public LessonResponse deleteById(@PathVariable Long id){
         return lessonService.deleteLesson(id);
    }

    @PutMapping("/update/{id}")
    public LessonResponse updateLesson(@RequestBody LessonRequest lessonRequest, @PathVariable Long id) throws IOException {
        return lessonService.updateLesson(id, lessonRequest);
    }
}