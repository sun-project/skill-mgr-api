package jp.co.sunarch.skillmgr.entity.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.sunarch.skillmgr.entity.TSkillsheetHis;
import jp.co.sunarch.skillmgr.entity.TSkillsheetHisPrimaryKey;

/**
 * 経歴情報
 * @author T.Nemoto
 *
 */
public interface TSkillsheetHisRepository extends JpaRepository<TSkillsheetHis, TSkillsheetHisPrimaryKey>{

	public TSkillsheetHis findBySkillSheetHisId(int skillSheetHisId);

	public TSkillsheetHis findBySkillSheetId(String skillSheetId);

	public List<TSkillsheetHis> findByUserIdOrderBySeqDesc(@Param("user_id") String userId);

	@Query(value = "select skill_sheet_his_id,skill_sheet_id,user_id,seq,del_flg,create_user_id,create_date,last_update_user_id,last_update_date from t_skillsheet_his where user_id = :user_id order by seq desc limit 1",nativeQuery = true)
	public TSkillsheetHis findByUserIdNewer(@Param("user_id") String userId);

	@Query(value = "select max(skill_sheet_his_id) + 1 as skill_sheet_his_id from t_skillsheet_his",nativeQuery = true)
	public Map<String, Object> findByMaxSkillSheetHisId();
}
