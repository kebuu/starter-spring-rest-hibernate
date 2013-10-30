package com.cta.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.cta.i18n.MessageSourceManager;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public static final String DEFAULT_EXCEPTION_CODE = "unhandled.exception";
	
	protected String code = DEFAULT_EXCEPTION_CODE;
	protected String developperMessage;
	protected Object[] arguments;

	public AppException(Throwable cause) {
		this(DEFAULT_EXCEPTION_CODE, cause);
	}

	public AppException(String code, Object... arguments) {
		this(code, (String) null, (Throwable) null, arguments);
	}
	
	public AppException(String code, Throwable cause, Object... arguments) {
		this(code, (String) null, cause, arguments);
	}
	
	public AppException(String code, String developperMessage, Object... arguments) {
		this(code, developperMessage, (Throwable) null, arguments);
	}
	
	public AppException(String code, String developperMessage, Throwable cause, Object... arguments) {
		super(MessageSourceManager.getInstance().getMessage(code, arguments), cause);
		this.code = code;
		this.arguments = arguments;
		this.developperMessage = developperMessage;
	}
}
