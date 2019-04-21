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

import jp.co.sunarch.skillmgr.entity.converter.JsonArrayConverter;

/**
 * 経歴詳細情報
 * @author T.Nemoto
 *
 */
@Entity
@IdClass(TSkillsheetDetailPrimaryKey.class)
@Table(name = "t_skillsheet_detail")
public class TSkillsheetDetail extends AbstractEntity{

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
}
