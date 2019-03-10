package jp.co.sunarch.skillmgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonResponseSkill  implements Serializable{

	@JsonProperty("work_from")
	@JsonFormat(pattern = "yyyy-MM")
	private Date workFrom = null;

	@JsonProperty("work_to")
	@JsonFormat(pattern = "yyyy-MM")
	private Date workTo = null;

	@JsonProperty("system_name")
	private String systemName = null;

	@JsonProperty("step_list")
	private List<String> stepList = new ArrayList<String>();

	@JsonProperty("position_list")
	private List<String> positionList = new ArrayList<String>();

	@JsonProperty("scale_name")
	private String scaleName = null;

	@JsonProperty("environment_list")
	private List<String> environmentList = new ArrayList<String>();

	@JsonProperty("middleware_list")
	private List<String> middlewareList = new ArrayList<String>();

	@JsonProperty("language_list")
	private List<String> languageList = new ArrayList<String>();

	@JsonProperty("other_list")
	private List<String> otherList = new ArrayList<String>();

	public Date getWorkFrom() {
		return workFrom;
	}

	public void setWorkFrom(Date workFrom) {
		this.workFrom = workFrom;
	}

	public Date getWorkTo() {
		return workTo;
	}

	public void setWorkTo(Date workTo) {
		this.workTo = workTo;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public List<String> getStepList() {
		return stepList;
	}

	public void setStepList(List<String> stepList) {
		this.stepList = stepList;
	}

	public List<String> getPositionList() {
		return positionList;
	}

	public void setPositionList(List<String> positionList) {
		this.positionList = positionList;
	}

	public String getScaleName() {
		return scaleName;
	}

	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

	public List<String> getEnvironmentList() {
		return environmentList;
	}

	public void setEnvironmentList(List<String> environmentList) {
		this.environmentList = environmentList;
	}

	public List<String> getMiddlewareList() {
		return middlewareList;
	}

	public void setMiddlewareList(List<String> middlewareList) {
		this.middlewareList = middlewareList;
	}

	public List<String> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<String> languageList) {
		this.languageList = languageList;
	}

	public List<String> getOtherList() {
		return otherList;
	}

	public void setOtherList(List<String> otherList) {
		this.otherList = otherList;
	}

}
