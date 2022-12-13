package peaksoft.restapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.restapi.converter.company.CompanyRequestConverter;
import peaksoft.restapi.converter.company.CompanyResponseConverter;
import peaksoft.restapi.dto.company.CompanyRequest;
import peaksoft.restapi.dto.company.CompanyResponse;
import peaksoft.restapi.entities.Company;
import peaksoft.restapi.repository.CompanyRepository;
import peaksoft.restapi.service.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyRequestConverter companyRequestConverter;
    private final CompanyResponseConverter companyResponseConverter;


    @Override
    public List<CompanyResponse> getAllCompanies() {

        return companyResponseConverter.view(companyRepository.findAll());
    }

    @Override
    public CompanyResponse addCompany(CompanyRequest companyRequest) {
        Company company = companyRequestConverter.createCompany(companyRequest);
        companyRepository.save(company);
        return companyResponseConverter.viewCompany(company);
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        Company company = companyRepository.findById(id).get();
        return companyResponseConverter.viewCompany(company);
    }

    @Override
    public CompanyResponse updateCompany(Long companyId, CompanyRequest companyRequest) {
        Company company1 = companyRepository.findById(companyId).get();
        companyRequestConverter.updateCompany(company1, companyRequest);
        companyRepository.save(company1);

        return companyResponseConverter .viewCompany(company1);
    }

    @Override
    public CompanyResponse deleteCompany(Long companyId) {
        Company company = companyRepository.findById(companyId).get();
        companyRepository.delete(company);

        return companyResponseConverter.viewCompany(company);
    }
}
