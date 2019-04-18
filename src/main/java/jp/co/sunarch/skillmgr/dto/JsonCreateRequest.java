package jp.co.sunarch.skillmgr.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonCreateRequest implements Serializable {

	@JsonProperty("skill_sheet")
	private JsonSkillSheet skillSheet = new JsonSkillSheet();

	public JsonSkillSheet getSkillSheet() {
		return skillSheet;
	}

	public void setSkillSheet(JsonSkillSheet skillSheet) {
		this.skillSheet = skillSheet;
	}
}
