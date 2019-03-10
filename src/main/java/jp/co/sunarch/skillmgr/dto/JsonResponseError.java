package jp.co.sunarch.skillmgr.dto;

import java.io.Serializable;

public class JsonResponseError implements Serializable{

	private String code = "";

	private String message = "";

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
