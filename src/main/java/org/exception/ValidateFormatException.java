package org.exception;

public class ValidateFormatException extends ValidateParameterException {

	private static final long serialVersionUID = 7613306272759024482L;

	public ValidateFormatException(String field) {
		this(field, "wrong format!!");
	}

	public ValidateFormatException(String field, String message) {
		super(ValidateParameterException.Type.FORMAT, field, message);
	}

}