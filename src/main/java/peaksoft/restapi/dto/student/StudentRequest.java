package peaksoft.restapi.dto.student;

import lombok.Getter;
import lombok.Setter;
import peaksoft.restapi.entities.StudyFormat;

@Getter
@Setter
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private StudyFormat studyFormat;
}
