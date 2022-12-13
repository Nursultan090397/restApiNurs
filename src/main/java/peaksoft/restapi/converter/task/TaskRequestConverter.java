package peaksoft.restapi.converter.task;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.student.StudentRequest;
import peaksoft.restapi.dto.task.TaskRequest;
import peaksoft.restapi.entities.Student;
import peaksoft.restapi.entities.Task;

@Component
public class TaskRequestConverter {
    public Task createTask(TaskRequest taskRequest) {
        if (taskRequest == null) {
            return null;
        }
        Task  task = new Task ();
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());


        return task;
    }

    public void updateTask(TaskRequest taskRequest,Task task) {
        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadline(taskRequest.getDeadline());
    }
}