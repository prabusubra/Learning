package ps.learn.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ps.learn.company.backend.CustomRepository;
import ps.learn.company.domain.Company;
import ps.learn.company.services.CompanyServices;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/company")
public class CompanyController {
	
	@Autowired CompanyServices companyServices;
	@Autowired CustomRepository customRepository;
	
	@PostMapping(value="/{msName}")
	public Flux<Object> letsAdd(@PathVariable("msName") String msName, @RequestBody Flux<Object> data){
		return customRepository.add(data, msName);
		
	}
	
	@GetMapping
	public Flux<Company> getAllCompany(){
		return companyServices.getAllCompany();
	}
	
	@GetMapping(value="/id{companyid}")
	public Mono<Company> getCompany(@PathVariable String companyid){
		return companyServices.getCompanyById(companyid);
	}
	
	@PostMapping
	public Flux<Company> createCompany(@RequestBody Flux<Company> company){
		return companyServices.createCompany(company);
	}
	
	@PutMapping
	public Flux<Company> updateCompany(@RequestBody Flux<Company> company){
		return companyServices.updateCompany(company);
	}
	
	@DeleteMapping
	public Mono<Void> deleteById(String companyid){
		return companyServices.deleteById(companyid);
	}
	
	@PostMapping(value="/custom")
	public Flux<Company> addCompany(@RequestBody Flux<Company> data, @RequestHeader("Content-Type") String contenttype ){
		System.out.println(" content type --> "+contenttype);
		return Flux.empty();
	}
	
	
	@GetMapping("/hello")
	public String letsSayHello() {
		return "Hello World !!!";
	}
}
