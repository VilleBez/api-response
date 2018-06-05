package idv.villebez.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import idv.villebez.exception.ValidateException;
import idv.villebez.util.JacksonUtils;

/**
 * 標準的API回應結果
 * 
 * @author paul.chen
 *
 */
@JsonInclude(Include.NON_NULL)
public class ApiResponse {

	/** API回傳結果 */
	private Object response;
	/** API錯誤情形 */
	private Error error;
	/** API錯誤情形 */
	private Warning warning;

	public static final String RESPONSE_KEY = "response";

	/**
	 * 標準輸出格式
	 * 
	 * @param result
	 * @return
	 */
	public static String success(Object result) {
		if (result instanceof String) {
			return "{\"" + RESPONSE_KEY + "\":" + result + "}";
		} else {
			ApiResponse resp = new ApiResponse();
			resp.setResponse(result);
			return resp.toString();
		}
	}

	public static String fail(Exception e) {
		ApiResponse resp = new ApiResponse();
		resp.setError(new Error(e.getClass().getName(), e.getMessage()));
		return resp.toString();
	}

	public static String warn(ValidateException e) {
		ApiResponse resp = new ApiResponse();
		resp.setWarning(e.getWarning());
		return resp.toString();
	}

	@Override
	public String toString() {
		return JacksonUtils.writeBeanToJson(this);
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Warning getWarning() {
		return warning;
	}

	public void setWarning(Warning warning) {
		this.warning = warning;
	}

}
