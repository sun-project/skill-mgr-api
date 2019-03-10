package jp.co.sunarch.skillmgr.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 経歴詳細情報
 * @author T.Nemoto
 *
 */
@Entity
@IdClass(TSkillsheetHisPrimaryKey.class)
@Table(name = "t_skillsheet_detail")
public class TSkillsheetDetail {

	/** 経歴情報ID */
	@Id
	@Column(name="skill_sheet_his_id", nullable = false)
	private int skillSheetHisId = -1;






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

}
