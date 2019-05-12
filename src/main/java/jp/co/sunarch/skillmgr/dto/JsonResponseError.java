package jp.co.sunarch.skillmgr.dto;

import java.io.Serializable;

public class JsonResponseError implements Serializable{

	private String code = "";

	private String message = "";

	public JsonResponseError() {

	}

	public JsonResponseError(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
