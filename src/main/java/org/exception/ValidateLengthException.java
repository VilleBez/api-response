package org.exception;

public class ValidateLengthException extends ValidateParameterException {

	private static final long serialVersionUID = 4945065758437430420L;

	public ValidateLengthException(String field) {
		this(field, "parameter length error!!");
	}

	public ValidateLengthException(String field, String message) {
		super(ValidateParameterException.Type.LENGTH, field, message);
	}

}