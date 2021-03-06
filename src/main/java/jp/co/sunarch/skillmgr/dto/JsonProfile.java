package jp.co.sunarch.skillmgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonProfile implements Serializable{

	@JsonProperty("full_name")
	private String fullName = null;

	@JsonProperty("sex_name")
	private String sexName = null;

	@JsonProperty("birthday")
	@JsonFormat(pattern = "yyyy-MM")
	private Date birthday = null;

	@JsonProperty("age")
	private int age = -1;

	@JsonProperty("address")
	private String address = null;

	@JsonProperty("nearest_station")
	private String nearestStation = null;

	@JsonProperty("final_education")
	private String finalEducation = null;

	@JsonProperty("department")
	private String department = null;

	@JsonProperty("graduation")
	@JsonFormat(pattern = "yyyy-MM")
	private Date graduation = null;

	@JsonProperty("graduation_type")
	private String graduationType = null;

	@JsonProperty("license_list")
	private List<String> licenseList = new ArrayList<String>();

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
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

	public String getGraduationType() {
		return graduationType;
	}

	public void setGraduationType(String graduationType) {
		this.graduationType = graduationType;
	}

}
