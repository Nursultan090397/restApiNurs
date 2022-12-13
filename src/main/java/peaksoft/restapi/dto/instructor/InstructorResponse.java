package peaksoft.restapi.dto.instructor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstructorResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String specialization;
}
