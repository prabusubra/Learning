package ps.learn.company.config;

import org.springframework.messaging.Message;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.util.MimeType;

import ps.learn.company.domain.Company;
import reactor.core.publisher.Flux;

public class MyConvertor extends AbstractMessageConverter {
	MimeType mimetype= new MimeType("application","template");
	protected MyConvertor() {
		super(new MimeType("application","template"));
		MimeType mt = new MimeType("application","template");
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz "+mt.toString());
	}

	@Override
	protected boolean supports(Class<?> arg0) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		return (Flux.class == arg0);
	}
	
	@Override
	protected Object convertFromInternal(Message<?> message, Class<?> targetClass, Object conversionHint) {
		System.out.println("yyyyyyyyyyyyyyyyyyyyyy");
		Object payload = message.getPayload();
		return (payload instanceof Flux ? payload : Flux.just((byte[]) payload));
	}
}
