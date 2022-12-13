package peaksoft.restapi.dto.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CompanyResponse {

    private Long id;

    private String companyName;

    private String locatedCountry;

    private int numberOfStudents;

}