package jp.co.sunarch.skillmgr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TSkillsheetProfilePrimaryKey implements Serializable{

	/** 経歴情報ID */
	@Column(name="skill_sheet_his_id")
	private int skillSheetHisId = -1;

}
