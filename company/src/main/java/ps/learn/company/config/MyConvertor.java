package ps.learn.company.config;

import java.util.Collection;

import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.util.MimeType;

import ps.learn.company.domain.Company;

public class MyConvertor extends AbstractMessageConverter {

	protected MyConvertor(Collection<MimeType> supportedMimeTypes) {
		super(new MimeType("application","template"));
	}

	@Override
	protected boolean supports(Class<?> arg0) {
		return (Company.class == arg0);
	}

}
