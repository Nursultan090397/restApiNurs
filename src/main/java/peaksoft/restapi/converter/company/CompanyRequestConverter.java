package peaksoft.restapi.converter.company;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.company.CompanyRequest;
import peaksoft.restapi.entities.Company;

@Component
public class CompanyRequestConverter  {
    public Company createCompany (CompanyRequest companyRequest){
        if (companyRequest == null){
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }
    public void updateCompany (Company company,CompanyRequest companyRequest){
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
    }
}