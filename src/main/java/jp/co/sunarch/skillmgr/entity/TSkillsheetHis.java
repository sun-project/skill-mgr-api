package jp.co.sunarch.skillmgr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
 * 経歴情報
 * @author T.Nemoto
 *
 */
@Entity
@IdClass(TSkillsheetHisPrimaryKey.class)
@Table(name = "t_skillsheet_his")
public class TSkillsheetHis extends AbstractEntity{

	/** 経歴情報ID */
	@Id
	@Column(name="skill_sheet_his_id", nullable = false)
	private int skillSheetHisId = -1;

	/** 経歴ID */
	@Column(name="skill_sheet_id", nullable = false)
	@Size(max = 255)
	private String skillSheetId = null;

	/** ユーザーID */
	@Column(name="user_id", nullable = false)
	@Size(max = 255)
	private String userId = null;

	/** 連番 */
	@Column(name="seq", nullable = false)
	private int seq = -1;

	public int getSkillSheetHisId() {
		return skillSheetHisId;
	}
	public void setSkillSheetHisId(int skillSheetHisId) {
		this.skillSheetHisId = skillSheetHisId;
	}
	public String getSkillSheetId() {
		return skillSheetId;
	}
	public void setSkillSheetId(String skillSheetId) {
		this.skillSheetId = skillSheetId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
}
