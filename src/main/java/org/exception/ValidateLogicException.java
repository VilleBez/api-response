package org.exception;

import org.apache.commons.lang3.StringUtils;

public class ValidateLogicException extends ValidateException {

	private static final long serialVersionUID = 8362987233908270648L;
	private Type type = Type.DEFAULT;
	private String message;

	public enum Type {
		DUPLICATE("10"), NODATA("11"), UPTOLIMIT("12"), DEFAULT("");

		private String value;

		private Type(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		public static Type getEnum(String value) {
			for (Type v : values())
				if (v.getValue().equalsIgnoreCase(value))
					return v;
			
			return DEFAULT;
		}
	}

	public ValidateLogicException(String code, String message) {
		super(message);
		if (StringUtils.isNotBlank(code)) {
			this.type = Type.getEnum(code);
		}
		this.message = message;
	}

	public ValidateLogicException(Type type, String message) {
		super(message);
		if (type != null)
			this.type = type;
		this.message = message;
	}

	@Override
	protected String getCode() {
		return ValidateException.Type.LOGIC.getValue() + type.value;
	}

	@Override
	protected String getDesc() {
		return message;
	}

}