package jp.co.sunarch.skillmgr.controller;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.sunarch.skillmgr.dto.JsonRequest;
import jp.co.sunarch.skillmgr.dto.JsonResponse;
import jp.co.sunarch.skillmgr.dto.JsonResponseProfile;
import jp.co.sunarch.skillmgr.dto.JsonResponseSkill;
import jp.co.sunarch.skillmgr.dto.JsonResponseSkillSheet;
import jp.co.sunarch.skillmgr.entity.TSkillsheetHis;
import jp.co.sunarch.skillmgr.entity.TSkillsheetProfile;
import jp.co.sunarch.skillmgr.service.SkillMgrApiService;

@Controller
@ResponseBody
@RequestMapping("/skillmgr/api/v1")
public class SkillMgrApiControllerV100 {

	private Log logger = LogFactory.getLog(SkillMgrApiControllerV100.class);

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
	@RequestMapping(value = "/{skillsheet_id}/detail", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse> skillsheetDetail(@PathVariable("skillsheet_id") String skillsheetId) {
		JsonResponse res = new JsonResponse();

		try {
			res.getRequest().setId(RandomStringUtils.randomAlphanumeric(32));
			res.getRequest().setProcessStartTime(new Date());
			res.getRequest().setControllerName(this.getClass().getName());

			TSkillsheetHis dataSkillsheet = service.searchSkillsheet(skillsheetId);
			TSkillsheetProfile dataProfile = service.searchSkillSheetProfile(dataSkillsheet.getSkillSheetHisId());

			JsonResponseSkillSheet resSkillSheet = new JsonResponseSkillSheet();
			res.getResponse().put("skill_sheet", resSkillSheet);

			JsonResponseProfile profile = new JsonResponseProfile();
			JsonResponseSkill skill = new JsonResponseSkill();

			resSkillSheet.setProfile(profile);
			resSkillSheet.setSkillList(new ArrayList<JsonResponseSkill>());
			resSkillSheet.getSkillList().add(skill);

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
	@RequestMapping(value = "/{skillsheet_id}/update", method = RequestMethod.POST)
	public ResponseEntity<JsonResponse> skillsheetUpdate(@PathVariable("skillsheet_id") String skillsheetId) {
		return sample(new JsonRequest());
	}

	/**
	 * 経歴リスト取得
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{user_id}/skillsheet/list", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse> userSkillsheetList(@PathVariable("user_id") String userId) {
		JsonResponse res = new JsonResponse();

		try {
			res.getRequest().setId(RandomStringUtils.randomAlphanumeric(32));
			res.getRequest().setProcessStartTime(new Date());
			res.getRequest().setControllerName(this.getClass().getName());





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
	 * 最新経歴取得
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{user_id}/skillsheet/lastupdate", method = RequestMethod.GET)
	public ResponseEntity<JsonResponse> userSkillsheetLastUpdate(@PathVariable("user_id") String userId) {
		JsonResponse res = new JsonResponse();

		try {
			res.getRequest().setId(RandomStringUtils.randomAlphanumeric(32));
			res.getRequest().setProcessStartTime(new Date());
			res.getRequest().setControllerName(this.getClass().getName());



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
	@RequestMapping(value = "/{user_id}/skillsheet/create", method = RequestMethod.PUT)
	public ResponseEntity<JsonResponse> userSkillsheetCreate(@PathVariable("user_id") String userId) {
		return sample(new JsonRequest());
	}
}
