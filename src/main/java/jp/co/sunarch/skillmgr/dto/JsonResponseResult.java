package jp.co.sunarch.skillmgr.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonResponseResult implements Serializable{

	private int code = -1;

	private String message = "";

	@JsonProperty("error_list")
	private List<JsonResponseError> errorList = null;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<JsonResponseError> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<JsonResponseError> errorList) {
		this.errorList = errorList;
	}
}
