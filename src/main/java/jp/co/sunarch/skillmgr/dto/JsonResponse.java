package jp.co.sunarch.skillmgr.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JsonResponse implements Serializable{

	private JsonResponseRequest request = new JsonResponseRequest();

	private JsonResponseResult result = new JsonResponseResult();

	private Map<String, Object> response = new HashMap<String, Object>();

	public JsonResponseRequest getRequest() {
		return request;
	}

	public void setRequest(JsonResponseRequest request) {
		this.request = request;
	}

	public JsonResponseResult getResult() {
		return result;
	}

	public void setResult(JsonResponseResult result) {
		this.result = result;
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}
}
