package jp.co.sunarch.skillmgr.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sunarch.skillmgr.entity.TSkillsheetDetail;
import jp.co.sunarch.skillmgr.entity.TSkillsheetDetailPrimaryKey;

/**
 * 経歴詳細情報
 * @author T.Nemoto
 *
 */
public interface TSkillsheetDetailRepository extends JpaRepository<TSkillsheetDetail, TSkillsheetDetailPrimaryKey>{

	public List<TSkillsheetDetail> findBySkillSheetHisIdOrderBySkillNoAsc(int skillSheetHisId);

	public int deleteBySkillSheetHisId(int skillSheetHisId);
}
