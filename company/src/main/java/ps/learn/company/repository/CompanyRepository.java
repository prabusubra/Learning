package ps.learn.company.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import ps.learn.company.domain.Company;

@Repository
public interface CompanyRepository extends ReactiveCassandraRepository<Company, String>{
	
}
