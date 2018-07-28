package ps.learn.company.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.kafka.annotation.EnableKafka;

import com.datastax.driver.core.querybuilder.QueryBuilder;

@PropertySource("classpath:application.properties")
@Configuration
public class CompanyConfig extends AbstractReactiveCassandraConfiguration{

	@Value("${spring.data.cassandra.keyspace-name}")
	private String keyspace;
	@Value("${spring.data.cassandra.contact-points}")
	private String contactpoint;
	
	@Value("${spring.data.cassandra.port}")
	private int port;
	
	@Override
	protected String getKeyspaceName() {
		return keyspace;
	}
	
	@Override
	protected String getContactPoints() {
		System.out.println("------------------------------------------");
		System.out.println(System.getenv());
		System.out.println("-----------------------------------------");
		return contactpoint;
		//return System.getenv("CASSANDRADB_SERVICE_HOST");
	}
	
	@Override
	protected int getPort() {
		return port;
	}
	
	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		
		return Arrays.asList(CreateKeyspaceSpecification
			.createKeyspace(getKeyspaceName())
				.ifNotExists()
					.withSimpleReplication(3));
	}
	
	@Override
	protected List<String> getStartupScripts() {
		String cqlscript1 = "CREATE TABLE IF NOT EXISTS "+keyspace+".company ("
				+ "companyid TEXT PRIMARY KEY,"
				+ "companyname TEXT,"
				+ "employee LIST<TEXT>,"
				+ "schemainfo MAP<TEXT,TEXT>"
				+ ");";
		
		String cqlscript2 = "CREATE INDEX IF NOT EXISTS icompanyname on "+keyspace+".company ("
				+ " companyname);";
		String cqlscript3 = "CREATE INDEX IF NOT EXISTS iemployee on "+keyspace+".company ("
				+ " employee);";
		return Arrays.asList(cqlscript1,cqlscript2,cqlscript3);
	}
	
	
	
}
