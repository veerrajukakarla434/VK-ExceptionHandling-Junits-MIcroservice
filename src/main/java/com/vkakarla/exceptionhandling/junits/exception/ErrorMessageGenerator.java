package com.vkakarla.exceptionhandling.junits.exception;

import static java.text.MessageFormat.format;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class ErrorMessageGenerator {

	private static final Logger logger = LoggerFactory.getLogger(ErrorMessageGenerator.class);

	@Autowired
	MessageSource messageSource;

	public ServiceException generateError(ServiceException pex) {

		try {

			pex.setStatus(ErrorCode.httpStatusCode(pex.getErrorCode()));
			pex.setShortMessage(messageSource.getMessage(pex.getErrorCode().toString() + ".SHORT", pex.getArgs(), Locale.US));
			pex.setDetailedMessage(messageSource.getMessage(pex.getErrorCode().toString() + ".DETAIL", pex.getArgs(), Locale.US));

		} catch (Exception e) {
			logger.error(format("Unable to generate error:{0}", pex.getErrorCode().toString(), e));
		}
		return pex;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
