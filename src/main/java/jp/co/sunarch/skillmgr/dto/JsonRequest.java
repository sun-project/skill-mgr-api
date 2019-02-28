package jp.co.sunarch.skillmgr.dto;

import java.io.Serializable;

public class JsonRequest implements Serializable{

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
