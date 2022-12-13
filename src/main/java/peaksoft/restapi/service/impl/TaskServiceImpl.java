package peaksoft.restapi.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.restapi.converter.task.TaskRequestConverter;
import peaksoft.restapi.converter.task.TaskResponseConverter;
import peaksoft.restapi.dto.task.TaskRequest;
import peaksoft.restapi.dto.task.TaskResponse;
import peaksoft.restapi.entities.Lesson;
import peaksoft.restapi.entities.Task;
import peaksoft.restapi.repository.LessonRepository;
import peaksoft.restapi.repository.TaskRepository;
import peaksoft.restapi.service.TaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final LessonRepository lessonRepository;
    private final TaskRequestConverter taskRequestConverter;
    private final TaskResponseConverter taskResponseConverter;

    @Override
    public List<TaskResponse> getAlTasks(Long id) {
        return taskResponseConverter.view(taskRepository.findAllTaskByLessonId(id));
    }

    @Override
    public TaskResponse addTask(Long id, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(id).get();
        Task task = taskRequestConverter.createTask(taskRequest);
        lesson.addTask(task);
        task.setLesson(lesson);
        taskRepository.save(task);
        return taskResponseConverter.viewTask(task);
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return taskResponseConverter.viewTask(taskRepository.getById(id));
    }

    @Override
    public TaskResponse updateTask(TaskRequest taskRequest, Long id) {
        Task task1 = taskRepository.findById(id).get();
       taskRequestConverter.updateTask(taskRequest,task1);
        taskRepository.save(task1);
        return taskResponseConverter.viewTask(task1);
    }

    @Override
    public TaskResponse deleteTask(Long id) {
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
        return taskResponseConverter.viewTask(task);
    }
}