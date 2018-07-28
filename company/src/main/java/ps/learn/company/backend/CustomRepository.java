package ps.learn.company.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.cql.ReactiveCqlOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;

@Service
public class CustomRepository {
	
	@Autowired private ReactiveCqlOperations reactiveCqlOperations;
	
	public Flux<Object> add(Flux<Object> data, String msName) {
		return data.doOnNext(d ->{
			ObjectMapper mapper = new ObjectMapper();
			String input;
			try {
				
				input = mapper.writeValueAsString(d);
				System.out.println(" --------- "+input+" ----------- ");
				String query= "INSERT INTO "+msName+" JSON " +d;
				reactiveCqlOperations.execute("INSERT INTO "+msName+" JSON ?",input).subscribe();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
		
	}
}
