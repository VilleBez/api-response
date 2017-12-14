package org.exception;

import org.apache.commons.lang3.StringUtils;

public class ValidateParameterException extends ValidateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 895526538873991131L;
	
	public enum Type {
		REQUIRED("01"), LENGTH("02"), FORMAT("03"), OTHER("99");

		private String value;

		private Type(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}
	private Type type;
	private String message = "";
	private String field = "";
	
	public ValidateParameterException(Type type, String field, String message) {
		super(message);
		this.type = type;
		if(StringUtils.isNoneBlank(message)) this.message = message;
		if(StringUtils.isNoneBlank(field)) this.field = field;
	}

	@Override
	protected String getCode() {
		return ValidateException.Type.PARAMETER.getValue() + type.value;
	}

	@Override
	protected String getDesc() {
		String desc = field;
		if(StringUtils.isNoneBlank(message)) desc = desc + " : " + message;
		return desc;
	}
	

}