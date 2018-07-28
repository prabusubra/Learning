package ps.learn.company.domain;

import java.util.List;
import java.util.Map;

public class Company {
	private String companyid;
	private String companyname;
	private List<String> employee;
	private Map<String,Object> schemainfo;
	
	public Map getSchemainfo() {
		return schemainfo;
	}
	public void setSchemainfo(Map schemainfo) {
		this.schemainfo = schemainfo;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public List getEmployee() {
		return employee;
	}
	public void setEmployee(List employee) {
		this.employee = employee;
		
	}
	
	
}
