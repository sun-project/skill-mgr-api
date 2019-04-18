package jp.co.sunarch.skillmgr.entity;

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
 * 経歴詳細プロフィール情報
 * @author T.Nemoto
 *
 */
@Entity
@IdClass(TSkillsheetHisPrimaryKey.class)
@Table(name = "t_skillsheet_profile")
public class TSkillsheetProfile {

	/** 経歴情報ID */
	@Id
	@Column(name="skill_sheet_his_id", nullable = false)
	private int skillSheetHisId = -1;

	/** 氏名 */
	@Column(name="full_name")
	@Size(max = 255)
	private String fullName = null;

	/** 性別 */
	@Column(name="sex")
	@Size(max = 255)
	private String sex = null;

	/** 生年月 */
	@Column(name="birthday")
	private Date birthday = null;

	/** 年齢 */
	@Column(name="age")
	private int age = -1;

	/** 住所 */
	@Column(name="address")
	@Size(max = 255)
	private String address = null;

	/** 最寄り駅 */
	@Column(name="nearest_station")
	@Size(max = 255)
	private String nearestStation = null;

	/** 最終学歴 */
	@Column(name="final_education")
	@Size(max = 255)
	private String finalEducation = null;

	/** 学部学科 */
	@Column(name="department")
	@Size(max = 255)
	private String department = null;

	/** 卒業年月 */
	@Column(name="graduation")
	private Date graduation = null;

	/** 卒業年月 */
	@Column(name="graduation_type")
	@Size(max = 255)
	private String graduationType = null;

	/** 資格 */
	@Column(name="license_list")
	@Convert(converter=JsonArrayConverter.class)
	private List<String> licenseList = null;

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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNearestStation() {
		return nearestStation;
	}
	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}
	public String getFinalEducation() {
		return finalEducation;
	}
	public void setFinalEducation(String finalEducation) {
		this.finalEducation = finalEducation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getGraduation() {
		return graduation;
	}
	public void setGraduation(Date graduation) {
		this.graduation = graduation;
	}
	public List<String> getLicenseList() {
		return licenseList;
	}
	public void setLicenseList(List<String> licenseList) {
		this.licenseList = licenseList;
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
	public String getGraduationType() {
		return graduationType;
	}
	public void setGraduationType(String graduationType) {
		this.graduationType = graduationType;
	}
	public int getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(int delFlg) {
		this.delFlg = delFlg;
	}
}
