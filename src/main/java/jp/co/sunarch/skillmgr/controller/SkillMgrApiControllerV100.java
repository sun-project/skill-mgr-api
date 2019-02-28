package jp.co.sunarch.skillmgr.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.sunarch.skillmgr.dto.JsonRequest;
import jp.co.sunarch.skillmgr.dto.JsonResponse;

@Controller
@ResponseBody
@RequestMapping("/api/v100/")
public class SkillMgrApiControllerV100 {

	@RequestMapping(value = "sample", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonResponse> sample(@RequestBody JsonRequest req) {
		JsonResponse res = new JsonResponse();

		res.setResponseCode(0);
		res.setMessage("sample api");
		res.setExecTime(new Date());

		return ResponseEntity.ok(res);
	}
}
