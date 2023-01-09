package com.example.questionnaire.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.constants.QuestionnaireRtnCode;
import com.example.questionnaire.entity.QList;
import com.example.questionnaire.entity.UserInfo;
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

		if (req.getStartTime() == null) {
			return new QuestionnaireRes(QuestionnaireRtnCode.START_TIME_EMPTY.getMessage());
		}

		LocalDate today = LocalDate.now();
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

		if (!StringUtils.hasText(req.getqName()) && !StringUtils.hasText(req.getqScript()) && req.getStartTime() == null
				&& req.getEndTime() == null) {
			return new QuestionnaireRes(QuestionnaireRtnCode.UPDATE_WRONG.getMessage());
		}

		return questionnaireService.updateQList(req.getqId(), req.getqName(), req.getqScript(), req.getStartTime(),
				req.getEndTime());

	}

	@PostMapping(value = "/api/search_q_list")
	public QuestionnaireRes searchQList(@RequestBody QuestionnaireReq req) {

		return questionnaireService.searchQList(req.getqName(), req.getStartTime(), req.getEndTime());

	}

//	@PostMapping(value = "/api/search_q_list_by_q_name")
//	public QuestionnaireRes searchQListByQName(@RequestBody QuestionnaireReq req) {
//
//		if (!StringUtils.hasText(req.getqName())) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.NAME_EMPTY.getMessage());
//		}
//
//		return questionnaireService.searchQListByQName(req.getqName());
//	}
//
//	@PostMapping(value = "/api/get_paged_q_list")
//	public QuestionnaireRes getPagedQList(@RequestBody QuestionnaireReq req) {
//
//		List<QList> list = questionnaireService.getPagedQList(req.getPage(), req.getSize());
//		return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_SUCCESSFUL.getMessage(), list);
//
//	}
//
//	@PostMapping(value = "/api/get_paged_q_list_by_time")
//	public QuestionnaireRes getPagedQListbByTime(@RequestBody QuestionnaireReq req) {
//
//		if (req.getStartTime() == null) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.START_TIME_EMPTY.getMessage());
//		}
//
//		if (req.getEndTime() == null) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.END_TIME_EMPTY.getMessage());
//		}
//
//		if (req.getStartTime() == null && req.getEndTime() == null) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.TIME_EMPTY.getMessage());
//		}
//
//		List<QList> list = questionnaireService.getPagedQListbByTime(req.getStartTime(), req.getEndTime());
//		return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_SUCCESSFUL.getMessage(), list);
//
//	}
//
//	@PostMapping(value = "/api/delete_q_list")
//	public QuestionnaireRes deleteQList(@RequestBody QuestionnaireReq req) {
//		
//		if (req.getqId() == null || req.getqId() == 0) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_WRONG.getMessage());
//		}
//
//		return questionnaireService.deleteQList(req.getqId());
//	}

	@PostMapping(value = "/api/delete_q_lists")
	public QuestionnaireRes deleteQLists(@RequestBody QuestionnaireReq req) {

		if (req.getqIdList() == null) {
			return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_WRONG.getMessage());
		}

		return questionnaireService.deleteQLists(req.getqIdList());

	}

	@PostMapping(value = "/api/create_s_list")
	public QuestionnaireRes createSList(@RequestBody QuestionnaireReq req) {

		if (req.getqId() == null || req.getqId() == 0) {
			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
		}

		if (!StringUtils.hasText(req.getQuestion())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_SCRIPT_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(req.getQuestionType())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_TYPE_EMPTY.getMessage());
		}

		switch (req.getQuestionType()) {

		case "單選":
		case "複選":
			break;

		default:
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_TYPE_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(req.getChoice())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.OPTION_EMPTY.getMessage());
		}

		return questionnaireService.createSList(req.getqId(), req.getQuestion(), req.getQuestionType(),
				req.isEssential(), req.getChoice());
	}

	@PostMapping(value = "/api/update_s_list")
	public QuestionnaireRes updateSList(@RequestBody QuestionnaireReq req) {

		return questionnaireService.updateSList(req.getsId(), req.getQuestion(), req.getQuestionType(),
				req.isEssential(), req.getChoice());

	}

	@PostMapping(value = "/api/search_q_list_and_s_list")
	public QuestionnaireRes searchQListAndSList(@RequestBody QuestionnaireReq req) {

		if (req.getqId() == null || req.getqId() == 0) {
			return new QuestionnaireRes(QuestionnaireRtnCode.ID_EMPTY.getMessage());
		}

		return questionnaireService.searchQListAndSList(req.getqId());
	}

	@PostMapping(value = "/api/delete_s_list")
	public QuestionnaireRes deleteSList(@RequestBody QuestionnaireReq req) {

		if (req.getsId() == null || req.getsId() == 0) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_SCRIPT_EMPTY.getMessage());
		}

		return questionnaireService.deleteSList(req.getsId());
	}

	@PostMapping(value = "/api/create_user_info_and_answer")
	public QuestionnaireRes createUserInfoAndAnswer(@RequestBody QuestionnaireReq req) {

		if (!StringUtils.hasText(req.getName())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_SCRIPT_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(req.getGender())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_TYPE_EMPTY.getMessage());
		}

		switch (req.getGender()) {

		case "男":
		case "女":
			break;

		default:
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_GENDER_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(req.getPhone())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_SCRIPT_EMPTY.getMessage());
		}

		if (!StringUtils.hasText(req.getEmail())) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_SCRIPT_EMPTY.getMessage());
		}

		if (req.getAge() == null || req.getAge() == 0) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_SCRIPT_EMPTY.getMessage());
		}

		if (req.getqId() == null || req.getqId() == 0) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_SCRIPT_EMPTY.getMessage());
		}

		LocalDateTime time = LocalDateTime.now();
		UserInfo userInfo = new UserInfo(req.getqId(), req.getName(), req.getGender(), req.getPhone(), req.getEmail(),
				req.getAge(), time);

		return questionnaireService.createUserInfoAndAnswer(userInfo, req.getAnswers());
	}

	@PostMapping(value = "/api/search_user_info_by_q_id")
	public QuestionnaireRes searchUserInfoByQId(@RequestBody QuestionnaireReq req) {

		if (req.getqId() == null || req.getqId() == 0) {
			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
		}

		return questionnaireService.searchUserInfoByQId(req.getqId());

	}

	@PostMapping(value = "/api/search_answer_by_user_id")
	public QuestionnaireRes searchAnswerByUserId(@RequestBody QuestionnaireReq req) {

		if (req.getUserId() == null || req.getUserId() == 0) {
			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
		}

		return questionnaireService.searchAnswerByUserId(req.getUserId());
	}

	@PostMapping(value = "/api/calculate_percentage")
	public QuestionnaireRes calculatePercentage(@RequestBody QuestionnaireReq req) {
		if (req.getqId() == null || req.getqId() == 0) {
			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
		}

		return questionnaireService.calculatePercentage(req.getqId());
	}
}