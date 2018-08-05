package com.example.alpha;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
@Configuration
public class AppConfig extends AbstractReactiveCassandraConfiguration {

	String followers = "{\n" + 
			"  \"userid\" : \"002\",\n" + 
			"  \"topiclist\": [\"react\",\"webflux\",\"projectreactor\"]\n" + 
			"}";
	
	String topicdata ="{\n" + 
			"  \"topicid\": \"react\",\n" + 
			"  \"content\":\"Intro and operators\",\n" + 
			"  \"author\":\"Josh Long\",\n" + 
			"  \"name\":\"React\"\n" + 
			"}";
	
	@Override
	protected String getKeyspaceName() {
		return "alpha";
	}
	
	@Override
	protected String getContactPoints() {
		return "127.0.0.1";
	}
	
	@Override
	protected int getPort() {
		return 9042;
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
		String cqlscript1 = "CREATE TABLE IF NOT EXISTS "+this.getKeyspaceName()+".Followers ("
				+ "userid TEXT PRIMARY KEY ,"
				+ "topiclist LIST<TEXT>"
				+ ");";
		String cqlscript2 = "CREATE TABLE IF NOT EXISTS "+this.getKeyspaceName()+".alltopics ("
				+ "topicid TEXT PRIMARY KEY ,"
				+ "content TEXT ,"
				+ "author TEXT ,"
				+ "name TEXT "				
				+ ");";
		String cql3 = "INSERT INTO "+this.getKeyspaceName()+".Followers JSON '"+followers+"'";
		String cql4 = "INSERT INTO "+this.getKeyspaceName()+".alltopics JSON '"+topicdata+"'";
		return Arrays.asList(cqlscript1,cqlscript2,cql3,cql4);
	}
	
}
