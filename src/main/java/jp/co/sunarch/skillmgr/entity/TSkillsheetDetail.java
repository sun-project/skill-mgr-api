package jp.co.sunarch.skillmgr.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import jp.co.sunarch.skillmgr.entity.converter.JsonArrayConverter;

/**
 * 経歴詳細情報
 * @author T.Nemoto
 *
 */
@Entity
@IdClass(TSkillsheetDetailPrimaryKey.class)
@Table(name = "t_skillsheet_detail")
public class TSkillsheetDetail {

	/** 経歴情報ID */
	@Id
	@Column(name="skill_sheet_his_id", nullable = false)
	private int skillSheetHisId = -1;

	/** 経歴番号 */
	@Id
	@Column(name="skill_no", nullable = false)
	private int skillNo = -1;

	/** 作業開始年月 */
	@Column(name="work_from_date")
	private Date workFromDate = null;

	/** 作業終了年月 */
	@Column(name="workToDate")
	private Date workToDate = null;

	/** システム名 */
	@Column(name="system_name")
	private String systemName = null;

	/** 工程リスト */
	@Column(name="step_list")
	@Convert(converter=JsonArrayConverter.class)
	private List<String> stepList = new ArrayList<String>();

	/** 役職リスト */
	@Column(name="position_list")
	@Convert(converter=JsonArrayConverter.class)
	private List<String> positionList = new ArrayList<String>();

	/** 体制規模 */
	@Column(name="scale_name")
	private String scaleName = null;

	/** 動作環境リスト */
	@Column(name="environment_list")
	@Convert(converter=JsonArrayConverter.class)
	private List<String> environmentList = new ArrayList<String>();

	/** ミドルウェアリスト */
	@Column(name="middleware_list")
	@Convert(converter=JsonArrayConverter.class)
	private List<String> middlewareList = new ArrayList<String>();

	/** 言語リスト */
	@Column(name="language_list")
	@Convert(converter=JsonArrayConverter.class)
	private List<String> languageList = new ArrayList<String>();

	/** その他リスト */
	@Column(name="other_list")
	@Convert(converter=JsonArrayConverter.class)
	private List<String> otherList = new ArrayList<String>();

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
	public Date getWorkFromDate() {
		return workFromDate;
	}
	public void setWorkFromDate(Date workFromDate) {
		this.workFromDate = workFromDate;
	}
	public Date getWorkToDate() {
		return workToDate;
	}
	public void setWorkToDate(Date workToDate) {
		this.workToDate = workToDate;
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
	public int getSkillNo() {
		return skillNo;
	}
	public void setSkillNo(int skillNo) {
		this.skillNo = skillNo;
	}
	public String getScaleName() {
		return scaleName;
	}
	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

}
