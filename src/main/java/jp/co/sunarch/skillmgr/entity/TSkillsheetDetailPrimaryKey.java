package jp.co.sunarch.skillmgr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TSkillsheetDetailPrimaryKey implements Serializable{

	/** 経歴情報ID */
	@Column(name="skill_sheet_his_id", nullable = false)
	private int skillSheetHisId = -1;

	/** 経歴番号 */
	@Column(name="skill_no", nullable = false)
	private int skillNo = -1;
}
