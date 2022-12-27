package com.example.questionnaire.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.constants.QuestionnaireRtnCode;
import com.example.questionnaire.entity.QList;
import com.example.questionnaire.entity.SList;
import com.example.questionnaire.ifs.QuestionnaireService;
import com.example.questionnaire.vo.QuestionnaireReq;
import com.example.questionnaire.vo.QuestionnaireRes;

@CrossOrigin
@RestController
//@RequestMapping("/getPaging")
public class QuestionnaireController {

	@Autowired
	private QuestionnaireService questionnaireService;

	@PostMapping(value = "/api/create_q_List")
	public QuestionnaireRes createQList(@RequestBody QuestionnaireReq req) {

		if (!StringUtils.hasText(req.getqName())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.NAME_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(req.getqScript())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.SCRIPT_EMPTY.getMessage());
		}

//		LocalDate startTime = req.getStartTime(); 
//		Optional<LocalDate> startTime = Optional.of(req.getStartTime());

		if (req.getStartTime() == null) {
			return new QuestionnaireRes(QuestionnaireRtnCode.START_TIME_EMPTY.getMessage());
		}

//		if (req.getEndTime() == null) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.END_TIME_EMPTY.getMessage());
//		}

		LocalDate today = LocalDate.now();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (req.getStartTime().isBefore(today)) {
			return new QuestionnaireRes(QuestionnaireRtnCode.START_TIME_WRONG.getMessage());
		}

		if (req.getEndTime().isBefore(today)) {
			return new QuestionnaireRes(QuestionnaireRtnCode.END_TIME_WRONG.getMessage());
		}

		QList qList = questionnaireService.createQList(req.getqName(), req.getqScript(), req.getStartTime(),
				req.getEndTime());

		return new QuestionnaireRes(QuestionnaireRtnCode.CREATE_SUCCESSFUL.getMessage(), qList);
	}

	@PostMapping(value = "/api/update_q_List")
	public QuestionnaireRes updateQList(@RequestBody QuestionnaireReq req) {

		LocalDate today = LocalDate.now();
		if (req.getStartTime().isBefore(today)) {
			return new QuestionnaireRes(QuestionnaireRtnCode.START_TIME_WRONG.getMessage());
		}

		if (req.getEndTime().isBefore(today)) {
			return new QuestionnaireRes(QuestionnaireRtnCode.END_TIME_WRONG.getMessage());
		}
		return questionnaireService.updateQList(req.getqId(), req.getqName(), req.getqScript(), req.getStartTime(),
				req.getEndTime());

	}

	@PostMapping(value = "/api/get_paged_q_list")
	public QuestionnaireRes getPagedQList(@RequestBody QuestionnaireReq req) {

		List<QList> list = questionnaireService.getPagedQList(req.getPage(), req.getSize());
		return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_SUCCESSFUL.getMessage(), list);

	}

	@PostMapping(value = "/api/get_paged_q_list_by_time")
	public QuestionnaireRes getPagedQListbByTime(@RequestBody QuestionnaireReq req) {

		if (req.getStartTime() == null) {
			return new QuestionnaireRes(QuestionnaireRtnCode.START_TIME_EMPTY.getMessage());
		}

		if (req.getEndTime() == null) {
			return new QuestionnaireRes(QuestionnaireRtnCode.END_TIME_EMPTY.getMessage());
		}

		List<QList> list = questionnaireService.getPagedQListbByTime(req.getStartTime(), req.getEndTime());
		return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_SUCCESSFUL.getMessage(), list);

	}

	@PostMapping(value = "/api/delete_q_list")
	public QuestionnaireRes deleteQList(@RequestBody QuestionnaireReq req) {
		if (req.getqId() == null || req.getqId() == 0) {
			return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_WRONG.getMessage());
		}

		return questionnaireService.deleteQList(req.getqId());

	}

	@PostMapping(value = "/api/create_s_list")
	public QuestionnaireRes createSList(@RequestBody QuestionnaireReq req, HttpSession httpSession) {

		if (!StringUtils.hasText(req.getQustion())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_WRONG.getMessage());
		}

		if (!StringUtils.hasText(req.getQustionType())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_WRONG.getMessage());
		}

		if (!StringUtils.hasText(req.getOption())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_WRONG.getMessage());
		}

		SList sList = questionnaireService.createSList(req.getsId(), req.getqId(), req.getQustion(),
				req.getQustionType(), req.getOption());
		httpSession.setAttribute("sListInfo", sList);
		return new QuestionnaireRes(QuestionnaireRtnCode.CREATE_SUCCESSFUL.getMessage(), sList);

	}
}
