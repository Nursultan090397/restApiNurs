package peaksoft.restapi.service;

import peaksoft.restapi.dto.company.CompanyRequest;
import peaksoft.restapi.dto.company.CompanyResponse;
import peaksoft.restapi.entities.Company;

import java.util.List;

public interface CompanyService {
    List<CompanyResponse> getAllCompanies();

    CompanyResponse addCompany(CompanyRequest companyRequest);

    CompanyResponse getCompanyById(Long id);

    CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest);

    CompanyResponse deleteCompany(Long companyId);
}
