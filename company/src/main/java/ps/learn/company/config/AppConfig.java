package ps.learn.company.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;

@Configuration
public class AppConfig {
	
	@Bean
	public MessageConverter customeconvertor() {
		return new MyConvertor();
	}
}
