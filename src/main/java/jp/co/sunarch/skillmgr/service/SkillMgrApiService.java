package jp.co.sunarch.skillmgr.service;

import java.util.List;

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
}
