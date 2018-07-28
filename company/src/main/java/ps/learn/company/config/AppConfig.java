package ps.learn.company.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;

@Configuration
public class AppConfig {
	public MessageConverter customeconvertor() {
		return new myConvertor();
	}
}
