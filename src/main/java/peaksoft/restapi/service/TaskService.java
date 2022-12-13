package peaksoft.restapi.service;

import peaksoft.restapi.dto.task.TaskRequest;
import peaksoft.restapi.dto.task.TaskResponse;
import peaksoft.restapi.entities.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAlTasks(Long lessonId);

    TaskResponse addTask(Long id, TaskRequest taskrequest);

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(TaskRequest taskRequest, Long id);

    TaskResponse deleteTask(Long id);
}