package com.example.questionnaire.ifs;

import java.time.LocalDate;
import java.util.List;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.QList;
import com.example.questionnaire.entity.UserInfo;
import com.example.questionnaire.vo.QuestionnaireRes;

public interface QuestionnaireService {

	// 新增問卷
	public QList createQList(String qName, String qScript, LocalDate startTime, LocalDate endTime);

	// 更新問卷
	public QuestionnaireRes updateQList(Integer qId, String qName, String qScript, LocalDate startTime,
			LocalDate endTime);

	// 搜尋問卷
	public QuestionnaireRes searchQList(String qName, LocalDate startTime, LocalDate endTime);

//	public QuestionnaireRes searchQListByQName(String qName);
//
//	public List<QList> getPagedQList(int page, int size);
//
//	public List<QList> getPagedQListbByTime(LocalDate startTime, LocalDate endTime);
//
//	public QuestionnaireRes deleteQList(Integer qId);

	// 刪除多筆問卷
	public QuestionnaireRes deleteQLists(List<Integer> qId);

	// 新增問題
	public QuestionnaireRes createSList(Integer qId, String question, String questionType, boolean essential,
			String choice);

	// 更新問題
	public QuestionnaireRes updateSList(Integer sId, String question, String questionType, boolean essential,
			String choice);

	// 搜尋問題
	public QuestionnaireRes searchQListAndSList(Integer qId);

	// 刪除問題
	public QuestionnaireRes deleteSList(Integer sId);

	// 填寫使用者資料與問卷答案<前台>
	public QuestionnaireRes createUserInfoAndAnswer(UserInfo userInfo, List<Answer> answers);

	// 透過問卷編號搜尋使用者資料
	public QuestionnaireRes searchUserInfoByQId(Integer qId);

	// 透過使用者編號搜尋問卷答案
	public QuestionnaireRes searchAnswerByUserId(Integer userId);

	// 統計(透過問卷編號搜尋所有答案，並計算百分比)
	public QuestionnaireRes calculatePercentage(Integer qId);
}
