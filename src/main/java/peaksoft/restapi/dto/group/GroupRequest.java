package peaksoft.restapi.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class GroupRequest {
    private String groupName;
    private LocalDate dateOfStart;
    private String image;
}