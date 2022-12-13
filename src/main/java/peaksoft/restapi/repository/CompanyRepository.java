package peaksoft.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.restapi.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
