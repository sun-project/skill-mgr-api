package jp.co.sunarch.skillmgr.service;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sunarch.skillmgr.entity.TSkillsheetDetail;
import jp.co.sunarch.skillmgr.entity.TSkillsheetHis;
import jp.co.sunarch.skillmgr.entity.TSkillsheetProfile;
import jp.co.sunarch.skillmgr.entity.repository.TSkillsheetDetailRepository;
import jp.co.sunarch.skillmgr.entity.repository.TSkillsheetHisRepository;
import jp.co.sunarch.skillmgr.entity.repository.TSkillsheetProfileRepository;

/**
 * 経歴管理サービス
 * @author T.Nemoto
 *
 */
@Service
@Transactional
public class SkillMgrApiService {

	private Log logger = LogFactory.getLog(SkillMgrApiService.class);

	@Autowired
	TSkillsheetHisRepository skillsheetHisRepo;
	@Autowired
	TSkillsheetProfileRepository profileRepo;
	@Autowired
	TSkillsheetDetailRepository detailRepo;

	/**
	 * 経歴IDから経歴情報を取得する
	 * @param skillSheetId
	 * @return
	 */
	public TSkillsheetHis searchSkillsheet(String skillSheetId){
		return skillsheetHisRepo.findBySkillSheetId(skillSheetId);
	}

	/**
	 * ユーザーIDから経歴情報を取得する
	 * @param skillSheetId
	 * @return
	 */
	public List<TSkillsheetHis> searchSkillSheetUserId(String userId){
		return skillsheetHisRepo.findByUserIdOrderBySeqDesc(userId);
	}

	/**
	 * ユーザーIDから最新の経歴情報を取得する
	 * @param skillSheetId
	 * @return
	 */
	public TSkillsheetHis searchSkillSheetUserIdNewer(String userId){
		return skillsheetHisRepo.findByUserIdNewer(userId);
	}

	/**
	 * 経歴情報IDからプロフィールを取得する
	 * @param skillSheetHisId
	 * @return
	 */
	public TSkillsheetProfile searchSkillSheetProfile(int skillSheetHisId) {
		return profileRepo.findBySkillSheetHisId(skillSheetHisId);
	}

	/**
	 * 経歴情報IDからプロフィールを取得する
	 * @param skillSheetHisId
	 * @return
	 */
	public List<TSkillsheetDetail> searchSkillSheetDetail(int skillSheetHisId) {
		return detailRepo.findBySkillSheetHisIdOrderBySkillNoAsc(skillSheetHisId);
	}

	/**
	 * 経歴情報を作成する
	 * @param userId
	 * @return
	 */
	public TSkillsheetHis saveSkillSheetHis(String userId) {
		Number skillSheetHisId = (Number)skillsheetHisRepo.findByMaxSkillSheetHisId().get("skill_sheet_his_id");

		logger.debug("max skill_sheet_his_id:" + skillSheetHisId);

		TSkillsheetHis entity = new TSkillsheetHis();
		entity.setSkillSheetHisId(skillSheetHisId.intValue());
		entity.setSkillSheetId(RandomStringUtils.randomAlphanumeric(32));
		entity.setUserId(userId);
		entity.setCreateUserId(userId);
		entity.setLastUpdateUserId(userId);

		skillsheetHisRepo.save(entity);

		return entity;
	}

	public TSkillsheetHis saveSkillSheetHis(TSkillsheetHis entity, String userId) {
		entity.setLastUpdateUserId(userId);
		skillsheetHisRepo.save(entity);
		return entity;
	}

	/**
	 * 経歴詳細プロフィール情報を作成する
	 * @param entity
	 * @param userId
	 */
	public TSkillsheetProfile saveSkillSheetProfile(TSkillsheetProfile entity, String userId) {
		entity.setCreateUserId(userId);
		entity.setLastUpdateUserId(userId);

		profileRepo.save(entity);
		return entity;
	}

	public List<TSkillsheetDetail> saveSillSheetDetail(List<TSkillsheetDetail> entityList, String userId){

		for(TSkillsheetDetail entity : entityList) {
			entity.setCreateUserId(userId);
			entity.setLastUpdateUserId(userId);

			detailRepo.save(entity);
		}

		return entityList;
	}

	public void deleteSillSheetDetail(int skillSheetHisId) {
		detailRepo.deleteBySkillSheetHisId(skillSheetHisId);
	}
}
