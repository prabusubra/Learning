package ps.learn.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.stereotype.Service;

import ps.learn.company.domain.Company;
import ps.learn.company.repository.CompanyRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@EnableReactiveCassandraRepositories(repositoryBaseClass=CompanyRepository.class)
public class CompanyServices {
	@Autowired CompanyRepository companyRepository;
	
	public Flux<Company> getAllCompany(){
		return companyRepository.findAll();
	}
	
	public Mono<Company> getCompanyById(String companyid){
		return companyRepository.findById(companyid);
	}
	
	public Flux<Company> updateCompany(Flux<Company> company ){
		return companyRepository.insert(company);
	}
	
	public Flux<Company> createCompany(Flux<Company> company ){
		return companyRepository.insert(company);
	}
	
	public Mono<Void> deleteById(String companyid){
		return companyRepository.deleteById(companyid);
	}
}
