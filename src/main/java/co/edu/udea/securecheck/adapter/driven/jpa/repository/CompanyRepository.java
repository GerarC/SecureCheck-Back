package co.edu.udea.securecheck.adapter.driven.jpa.repository;

import co.edu.udea.securecheck.adapter.driven.jpa.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {
}
