package org.exception;

public class ValidateRequiredException extends ValidateParameterException {

	private static final long serialVersionUID = 3259872948995972547L;

	public ValidateRequiredException(String field) {
		this(field, "can not be null!!");
	}

	public ValidateRequiredException(String field, String message) {
		super(ValidateParameterException.Type.REQUIRED, field, message);
	}

}