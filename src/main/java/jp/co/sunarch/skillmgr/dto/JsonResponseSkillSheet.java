package jp.co.sunarch.skillmgr.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonResponseSkillSheet implements Serializable{

	private String id = null;

	@JsonProperty("create_timestamp")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS+9:00")
	private Date createTimestamp = null;

	@JsonProperty("create_user")
	private String createUser = null;

	@JsonProperty("last_update_timestamp")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS+9:00")
	private Date lastUpdateTimestamp = null;

	@JsonProperty("last_update_user")
	private String lastUpdateUser = null;

	@JsonProperty("profile")
	private JsonResponseProfile profile = null;

	@JsonProperty("skill_list")
	private List<JsonResponseSkill> skillList = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public JsonResponseProfile getProfile() {
		return profile;
	}

	public void setProfile(JsonResponseProfile profile) {
		this.profile = profile;
	}

	public List<JsonResponseSkill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<JsonResponseSkill> skillList) {
		this.skillList = skillList;
	}
}
