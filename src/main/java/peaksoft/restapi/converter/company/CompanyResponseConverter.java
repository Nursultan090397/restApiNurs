package peaksoft.restapi.converter.company;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.company.CompanyResponse;
import peaksoft.restapi.entities.Company;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyResponseConverter {
    public CompanyResponse viewCompany(Company company){
        if (company==null){
            return null;
        }

        CompanyResponse companyResponse = new CompanyResponse();

        companyResponse.setId(company.getId());
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        companyResponse.setNumberOfStudents(company.getNumberOfStudents());

        return companyResponse;
    }

    public List<CompanyResponse> view(List<Company> companies){
        List<CompanyResponse> companyResponses = new ArrayList<>();

        for (Company company: companies) {
            companyResponses.add(viewCompany(company));
        }

        return  companyResponses;
    }
}