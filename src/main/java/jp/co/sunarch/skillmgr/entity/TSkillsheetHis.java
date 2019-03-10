package jp.co.sunarch.skillmgr.entity;

import java.util.Date;

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
public class TSkillsheetHis {

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

	/** 削除フラグ */
	@Column(name="del_flg", nullable = false)
	private int delFlg = -1;
	/** 作成者 */
	@Column(name="create_user_id", nullable = false)
	@Size(max = 255)
	private String createUserId = null;
	/** 作成日時 */
	@Column(name="create_date", nullable = false)
	private Date createDate = null;
	/** 最終更新者 */
	@Column(name="last_update_user_id", nullable = false)
	@Size(max = 255)
	private String lastUpdateUserId = null;
	/** 最終更新日時 */
	@Column(name="last_update_date", nullable = false)
	private Date lastUpdateDate = null;

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
	public int getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(int delFlg) {
		this.delFlg = delFlg;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
}
