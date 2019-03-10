package jp.co.sunarch.skillmgr.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sunarch.skillmgr.entity.TSkillsheetProfile;
import jp.co.sunarch.skillmgr.entity.TSkillsheetProfilePrimaryKey;

/**
 * 経歴詳細プロフィール情報
 * @author T.Nemoto
 *
 */
public interface TSkillsheetProfileRepository extends JpaRepository<TSkillsheetProfile, TSkillsheetProfilePrimaryKey>{

	public TSkillsheetProfile findOneSkillSheetHisId(int skillSheetHisId);

}
