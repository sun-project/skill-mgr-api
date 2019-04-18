package jp.co.sunarch.skillmgr.controller;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.sunarch.skillmgr.dto.JsonCreateRequest;
import jp.co.sunarch.skillmgr.dto.JsonProfile;
import jp.co.sunarch.skillmgr.dto.JsonRequest;
import jp.co.sunarch.skillmgr.dto.JsonResponse;
import jp.co.sunarch.skillmgr.dto.JsonResponseSkillSheets;
import jp.co.sunarch.skillmgr.dto.JsonSkill;
import jp.co.sunarch.skillmgr.dto.JsonSkillSheet;
import jp.co.sunarch.skillmgr.entity.TSkillsheetDetail;
import jp.co.sunarch.skillmgr.entity.TSkillsheetHis;
import jp.co.sunarch.skillmgr.entity.TSkillsheetProfile;
import jp.co.sunarch.skillmgr.service.SkillMgrApiService;

@Controller
@ResponseBody
@RequestMapping("/skillmgr/api/v1")
public class SkillMgrApiControllerV100 {

	private Log logger = LogFactory.getLog(SkillMgrApiControllerV100.class);

	private static final String AUTH_USER_ID = "X_GATEWAY_USER_ID";

	@Autowired
	SkillMgrApiService service;

	@RequestMapping(value = "sample", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonResponse> sample(@RequestBody JsonRequest req) {
		JsonResponse res = new JsonResponse();

		res.getRequest().setId(RandomStringUtils.randomAlphanumeric(32));
		res.getRequest().setProcessStartTime(new Date());
		res.getRequest().setProcessEndTime(new Date());
		res.getRequest().setControllerName(this.getClass().getName());

		res.getResult().setCode(200);
		res.getResult().setMessage("This sample api.");

		return ResponseEntity.ok(res);
	}

	/**
	 * 経歴情報取得
	 * @param skillsheetId
	 * @return
	 */
	@RequestMapping(value = "/skillsheets/{skillsheet_id}/detail", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse> skillsheetDetail(@RequestHeader(AUTH_USER_ID) String userId, @PathVariable("skillsheet_id") String skillsheetId) {
		JsonResponse res = new JsonResponse();

		try {
			res.getRequest().setId(RandomStringUtils.randomAlphanumeric(32));
			res.getRequest().setProcessStartTime(new Date());
			res.getRequest().setControllerName(this.getClass().getName());

			TSkillsheetHis dataSkillsheet = service.searchSkillsheet(skillsheetId);
			TSkillsheetProfile dataProfile = service.searchSkillSheetProfile(dataSkillsheet.getSkillSheetHisId());
			List<TSkillsheetDetail> detList = service.searchSkillSheetDetail(dataSkillsheet.getSkillSheetHisId());

			JsonSkillSheet resSkillSheet = new JsonSkillSheet();
			res.getResponse().put("skill_sheet", resSkillSheet);
			resSkillSheet.setId(dataSkillsheet.getSkillSheetId());
			resSkillSheet.setCreateTimestamp(dataSkillsheet.getCreateDate());
			resSkillSheet.setCreateUser(dataSkillsheet.getCreateUserId());
			resSkillSheet.setLastUpdateTimestamp(dataSkillsheet.getLastUpdateDate());
			resSkillSheet.setLastUpdateUser(dataSkillsheet.getLastUpdateUserId());

			JsonProfile profile = new JsonProfile();
			resSkillSheet.setProfile(profile);
			profile.setFullName(dataProfile.getFullName());
			profile.setSexName(dataProfile.getSex());
			profile.setBirthday(dataProfile.getBirthday());
			profile.setAge(dataProfile.getAge());
			profile.setAddress(dataProfile.getAddress());
			profile.setNearestStation(dataProfile.getNearestStation());
			profile.setFinalEducation(dataProfile.getFinalEducation());
			profile.setDepartment(dataProfile.getDepartment());
			profile.setGraduation(dataProfile.getGraduation());
			profile.setGraduationType(dataProfile.getGraduationType());
			profile.setLicenseList(dataProfile.getLicenseList());

			resSkillSheet.setSkillList(new ArrayList<JsonSkill>());
			for(TSkillsheetDetail dataDet : detList) {
				JsonSkill skill = new JsonSkill();

				skill.setWorkFrom(dataDet.getWorkFromDate());
				skill.setWorkTo(dataDet.getWorkToDate());
				skill.setSystemName(dataDet.getSystemName());
				skill.setStepList(dataDet.getStepList());
				skill.setPositionList(dataDet.getPositionList());
				skill.setScaleName(dataDet.getScaleName());
				skill.setEnvironmentList(dataDet.getEnvironmentList());
				skill.setMiddlewareList(dataDet.getMiddlewareList());
				skill.setLanguageList(dataDet.getLanguageList());
				skill.setOtherList(dataDet.getOtherList());

				resSkillSheet.getSkillList().add(skill);
			}

			res.getResult().setCode(HttpURLConnection.HTTP_OK);
			res.getResult().setMessage("成功");
		} catch(Exception e) {
			logger.error(e);
			res.getResult().setCode(HttpURLConnection.HTTP_BAD_REQUEST);
		} finally {
			res.getRequest().setProcessEndTime(new Date());
		}

		return ResponseEntity.ok(res);
	}

	/**
	 * 経歴更新
	 * @param skillsheetId
	 * @return
	 */
	@RequestMapping(value = "/skillsheets/{skillsheet_id}/update", method = RequestMethod.POST)
	public ResponseEntity<JsonResponse> skillsheetUpdate() {
		return sample(new JsonRequest());
	}

	/**
	 * 経歴リスト取得
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/skillsheets/list", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse> userSkillsheetList(@RequestHeader(AUTH_USER_ID) String userId, @RequestParam(name = "limit", required = false, defaultValue = "-1") int limit) {
		JsonResponse res = new JsonResponse();

		try {
			res.getRequest().setId(RandomStringUtils.randomAlphanumeric(32));
			res.getRequest().setProcessStartTime(new Date());
			res.getRequest().setControllerName(this.getClass().getName());

			List<TSkillsheetHis> dataList = service.searchSkillSheetUserId(userId);

			List<JsonResponseSkillSheets> resList = new ArrayList<JsonResponseSkillSheets>();
			for(TSkillsheetHis dataSkillsheet : dataList) {
				JsonResponseSkillSheets resSkillSheet = new JsonResponseSkillSheets();

				resSkillSheet.setId(dataSkillsheet.getSkillSheetId());
				resSkillSheet.setCreateTimestamp(dataSkillsheet.getCreateDate());
				resSkillSheet.setCreateUser(dataSkillsheet.getCreateUserId());
				resSkillSheet.setLastUpdateTimestamp(dataSkillsheet.getLastUpdateDate());
				resSkillSheet.setLastUpdateUser(dataSkillsheet.getLastUpdateUserId());

				resList.add(resSkillSheet);
			}

			res.getResponse().put("skill_sheet_list", resList);

			res.getResult().setCode(HttpURLConnection.HTTP_OK);
			res.getResult().setMessage("成功");
		} catch(Exception e) {
			logger.error(e);
			res.getResult().setCode(HttpURLConnection.HTTP_BAD_REQUEST);
		} finally {
			res.getRequest().setProcessEndTime(new Date());
		}

		return ResponseEntity.ok(res);
	}

	/**
	 * 経歴作成
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/skillsheets/create", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonResponse> userSkillsheetCreate(@RequestHeader(AUTH_USER_ID) String userId, @RequestBody JsonCreateRequest req) {
		JsonResponse res = new JsonResponse();

		try {
			res.getRequest().setId(RandomStringUtils.randomAlphanumeric(32));
			res.getRequest().setProcessStartTime(new Date());
			res.getRequest().setControllerName(this.getClass().getName());

			TSkillsheetHis skillSheetHis = service.saveSkillSheetHis(userId);

			if(req.getSkillSheet().getProfile() != null) {
				TSkillsheetProfile profile = new TSkillsheetProfile();
				profile.setSkillSheetHisId(skillSheetHis.getSkillSheetHisId());
				profile.setFullName(req.getSkillSheet().getProfile().getFullName());
				profile.setSex(req.getSkillSheet().getProfile().getSexName());
				profile.setBirthday(req.getSkillSheet().getProfile().getBirthday());
				profile.setAge(req.getSkillSheet().getProfile().getAge());
				profile.setAddress(req.getSkillSheet().getProfile().getAddress());
				profile.setNearestStation(req.getSkillSheet().getProfile().getNearestStation());
				profile.setFinalEducation(req.getSkillSheet().getProfile().getFinalEducation());
				profile.setDepartment(req.getSkillSheet().getProfile().getDepartment());
				profile.setGraduation(req.getSkillSheet().getProfile().getGraduation());
				profile.setGraduationType(req.getSkillSheet().getProfile().getGraduationType());
				profile.setLicenseList(req.getSkillSheet().getProfile().getLicenseList());
				service.saveSkillSheetProfile(profile, userId);
			}

			if(req.getSkillSheet().getSkillList() != null) {
				List<TSkillsheetDetail> detailList = new ArrayList<TSkillsheetDetail>();
				for(int i=0;i<req.getSkillSheet().getSkillList().size();i++) {
					JsonSkill skill = req.getSkillSheet().getSkillList().get(i);

					TSkillsheetDetail detail = new TSkillsheetDetail();
					detail.setSkillSheetHisId(skillSheetHis.getSkillSheetHisId());
					detail.setSkillNo(i);
					detail.setWorkFromDate(skill.getWorkFrom());
					detail.setWorkToDate(skill.getWorkTo());
					detail.setSystemName(skill.getSystemName());
					detail.setStepList(skill.getStepList());
					detail.setPositionList(skill.getPositionList());
					detail.setScaleName(skill.getScaleName());
					detail.setEnvironmentList(skill.getEnvironmentList());
					detail.setMiddlewareList(skill.getMiddlewareList());
					detail.setLanguageList(skill.getLanguageList());
					detail.setOtherList(skill.getOtherList());

					detailList.add(detail);
				}
				service.saveSillSheetDetail(detailList, userId);
			}

			List<JsonResponseSkillSheets> resList = new ArrayList<JsonResponseSkillSheets>();
			JsonResponseSkillSheets resSkillSheet = new JsonResponseSkillSheets();
			resSkillSheet.setId(skillSheetHis.getSkillSheetId());
			resSkillSheet.setCreateTimestamp(skillSheetHis.getCreateDate());
			resSkillSheet.setCreateUser(skillSheetHis.getCreateUserId());
			resSkillSheet.setLastUpdateTimestamp(skillSheetHis.getLastUpdateDate());
			resSkillSheet.setLastUpdateUser(skillSheetHis.getLastUpdateUserId());
			resList.add(resSkillSheet);

			res.getResponse().put("skill_sheet_list", resList);

			res.getResult().setCode(HttpURLConnection.HTTP_OK);
			res.getResult().setMessage("成功");
		} catch(Exception e) {
			logger.error(e);
			res.getResult().setCode(HttpURLConnection.HTTP_BAD_REQUEST);
		} finally {
			res.getRequest().setProcessEndTime(new Date());
		}

		return ResponseEntity.ok(res);
	}
}
