package com.example.questionnaire.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire.constants.QuestionnaireRtnCode;
import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.QList;
import com.example.questionnaire.entity.SList;
import com.example.questionnaire.entity.UserInfo;
import com.example.questionnaire.ifs.QuestionnaireService;
import com.example.questionnaire.respository.AnswerDao;
import com.example.questionnaire.respository.QDao;
import com.example.questionnaire.respository.SDao;
import com.example.questionnaire.respository.UserInfoDao;
import com.example.questionnaire.vo.QuestionAndAnswerInfo;
import com.example.questionnaire.vo.QuestionnaireRes;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QDao qDao;

	@Autowired
	private SDao sDao;

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private AnswerDao answerDao;

	@Override
	public QList createQList(String qName, String qScript, LocalDate startTime, LocalDate endTime) {

		QList qList = new QList(qName, qScript, startTime, endTime);

		return qDao.save(qList);
	}

	@Override
	public QuestionnaireRes updateQList(Integer qId, String qName, String qScript, LocalDate startTime,
			LocalDate endTime) {

		QuestionnaireRes res = new QuestionnaireRes();
		Optional<QList> qListOp = qDao.findById(qId);
		QList qList = qListOp.get();

		if (!qListOp.isPresent()) {

			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
		}

		setParams(qList, qName, qScript, startTime, endTime);
		qDao.save(qList);
		res.setqList(qList);
		res.setMessage(QuestionnaireRtnCode.UPDATE_SUCCESSFUL.getMessage());
		return res;
	}

	private void setParams(QList qList, String qName, String qScript, LocalDate startTime, LocalDate endTime) {

		// 如有輸入值，則將輸入值存回資料庫
		if (StringUtils.hasText(qName)) {
			qList.setqName(qName);
		}

		if (StringUtils.hasText(qScript)) {
			qList.setqScript(qScript);
		}

		if (startTime != null) {
			qList.setStartTime(startTime);
		}

		if (endTime != null) {
			qList.setEndTime(endTime);
		}
	}

	@Override
	public QuestionnaireRes searchQList(String qName, LocalDate startTime, LocalDate endTime) {

		boolean SearchqName = StringUtils.hasText(qName);

		boolean SearchStartTime = startTime != null;

		boolean SearchEndTime = endTime != null;

		if (SearchqName && SearchStartTime && SearchEndTime) {
			List<QList> list = qDao
					.findByqNameContainingAndStartTimeGreaterThanEqualAndEndTimeLessThanEqualOrderByStartTimeDesc(qName,
							startTime, endTime);
			return new QuestionnaireRes(list);
		}

		if (SearchqName == false && SearchStartTime == false && SearchEndTime == false) {
			List<QList> list = qDao.findAllByOrderByStartTimeDesc();
			return new QuestionnaireRes(list);
		}

		if (SearchqName == true && SearchStartTime == false && SearchEndTime == false) {
			List<QList> list = qDao.findByqNameContaining(qName);
			return new QuestionnaireRes(list);
		}

		if (SearchqName == true && SearchStartTime == false && SearchEndTime == true) {
			List<QList> list = qDao.findByqNameContainingAndEndTimeLessThanEqualOrderByEndTimeDesc(qName, endTime);
			return new QuestionnaireRes(list);
		}

		if (SearchqName == false && SearchStartTime == false && SearchEndTime == true) {
			List<QList> list = qDao.findByqNameContainingAndEndTimeLessThanEqualOrderByEndTimeDesc(qName, endTime);
			return new QuestionnaireRes(list);
		}

		if (SearchqName == true && SearchStartTime == true && SearchEndTime == false) {
			List<QList> list = qDao.findByqNameContainingAndStartTimeGreaterThanEqualOrderByStartTimeDesc(qName,
					startTime);
			return new QuestionnaireRes(list);
		}

		if (SearchqName == false && SearchStartTime == true && SearchEndTime == false) {
			List<QList> list = qDao.findByqNameContainingAndStartTimeGreaterThanEqualOrderByStartTimeDesc(qName,
					startTime);
			return new QuestionnaireRes(list);
		}

		if (SearchqName == false && SearchStartTime == true && SearchEndTime == true) {
			List<QList> list = qDao
					.findByqNameContainingAndStartTimeGreaterThanEqualAndEndTimeLessThanEqualOrderByStartTimeDesc(qName,
							startTime, endTime);
			return new QuestionnaireRes(list);
		}

		return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_EMPTY.getMessage());
	}

//	@Override
//	public QuestionnaireRes searchQListByQName(String qName) {
//
//		List<QList> list = qDao.findByqNameContaining(qName);
//
//		if (list.isEmpty()) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_EMPTY.getMessage());
//		}
//		return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_SUCCESSFUL.getMessage(), list);
//	}
//
//	@Override
//	public List<QList> getPagedQList(int page, int size) {
//
//		Page<QList> pageResult = qDao.findAll(PageRequest.of(page, // 查詢的頁數，從0起算
//				size, // 查詢的每頁筆數
//				Sort.by("qId").descending())); // 依q_id欄位降冪排序
//
//		pageResult.getNumberOfElements(); // 本頁筆數
//		pageResult.getSize(); // 每頁筆數
//		pageResult.getTotalElements(); // 全部筆數
//		pageResult.getTotalPages(); // 全部頁數
//
//		List<QList> list = pageResult.getContent();
//
//		return list;
//
//	}
//
//	@Override
//	public List<QList> getPagedQListbByTime(LocalDate startTime, LocalDate endTime) {
//
//		return qDao.findByStartTimeAndEndTime(startTime, endTime);
//	}
//
//	@Override
//	public QuestionnaireRes deleteQList(Integer qId) {
//
//		if (!qDao.findById(qId).isPresent()) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
//		}
//
//		qDao.deleteById(qId);
//		sDao.deleteByqId(qId);
//		return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_SUCCESSFUL.getMessage());
//	}

	@Override
	public QuestionnaireRes deleteQLists(List<Integer> qId) {

		for (Integer item : qId) {
			qDao.deleteById(item);
			sDao.deleteByqId(item);
		}

		return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_SUCCESSFUL.getMessage());
	}

	@Override
	public QuestionnaireRes createSList(Integer qId, String question, String questionType, boolean essential,
			String choice) {

		Optional<QList> qListPk = qDao.findById(qId);
		if (!qListPk.isPresent()) {
			return new QuestionnaireRes(QuestionnaireRtnCode.QLIST_WRONG.getMessage());
		}

		SList sList = new SList(qId, question, questionType, essential, choice);
		sDao.save(sList);

		return new QuestionnaireRes(QuestionnaireRtnCode.CREATE_QUESTION_SUCCESSFUL.getMessage(), sList);

	}

	@Override
	public QuestionnaireRes updateSList(Integer sId, String question, String questionType, boolean essential,
			String choice) {

		QuestionnaireRes res = new QuestionnaireRes();
		Optional<SList> sListPk = sDao.findById(sId);
		SList sList = sListPk.get();

		if (!sListPk.isPresent()) {
			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
		}

		if (StringUtils.hasText(question)) {
			sList.setQuestion(question);
		}

		if (StringUtils.hasText(questionType)) {

			switch (questionType) {

			case "單選":
			case "複選":
			case "":
				break;

			default:
				return new QuestionnaireRes(QuestionnaireRtnCode.QUESTION_TYPE_EMPTY.getMessage());
			}
			sList.setQuestionType(questionType);
		}

		sList.setEssential(essential);

		if (StringUtils.hasText(choice)) {
			sList.setChoice(choice);
		}

		sDao.save(sList);

		res.setMessage(QuestionnaireRtnCode.UPDATE_SUCCESSFUL.getMessage());
		res.setsList(sList);
		return res;

	}

	@Override
	public QuestionnaireRes searchQListAndSList(Integer qId) {

		QuestionnaireRes res = new QuestionnaireRes();
		QList qList = qDao.findById(qId).get();
		List<SList> sList = sDao.findByqId(qId);

//		if (qList == null) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
//		}
//
//		if (sList.isEmpty()) {
//			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_EMPTY.getMessage());
//		}
		res.findSList(QuestionnaireRtnCode.SEARCH_QUESTION_SUCCESSFUL.getMessage(), qList, sList);
		return res;
	}

	@Override
	public QuestionnaireRes deleteSList(Integer sId) {

		QuestionnaireRes res = new QuestionnaireRes();
		Optional<SList> sList = sDao.findById(sId);

		if (!sList.isPresent()) {
			return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_QUESTION_WRONG.getMessage());
		}

		sDao.deleteById(sId);
		res.setMessage(QuestionnaireRtnCode.DELETE_QUESTION_SUCCESSFUL.getMessage());
		return res;
	}

	@Override
	public QuestionnaireRes searchUserInfoByQId(Integer qId) {

		QuestionnaireRes res = new QuestionnaireRes();
		List<UserInfo> userInfo = userInfoDao.findByqId(qId);

		res.findUserInfoList(QuestionnaireRtnCode.SEARCH_USERINFO_SUCCESSFUL.getMessage(), userInfo);
		return res;

	}

	@Override
	public QuestionnaireRes createUserInfoAndAnswer(UserInfo userInfo, List<Answer> answers) {

		userInfoDao.save(userInfo);

		for (Answer item : answers) {
			item.setUserId(userInfo.getUserId());
		}

		answerDao.saveAll(answers);

		return new QuestionnaireRes(QuestionnaireRtnCode.QUESTIONNAIRE_COMPLETED.getMessage(), userInfo, answers);
	}

	@Override
	public QuestionnaireRes searchAnswerByUserId(Integer userId) {

//		QuestionnaireRes res = new QuestionnaireRes();

		UserInfo userInfo = userInfoDao.findById(userId).get();
//		userInfo.setUserId(null);
//		userInfo.setqId(null);

		List<Answer> answers = answerDao.findByUserId(userId);

		Map<Map<Integer, String>, Map<String, Double>> printTotal = new LinkedHashMap<>();
		int x =0;
		for (Answer item : answers) {
			x++;
			Map<Integer, String> question = new LinkedHashMap<>();
			Map<String, Double> answer = new LinkedHashMap<>();
			Map<String, Integer> answerMap = new LinkedHashMap<>();
			
			SList sList = sDao.findById(item.getsId()).get();

			question.put(x, sList.getQuestion());

			String[] stringChoiceList = sList.getChoice().split("；"); // 切割選項
			List<String> trimChoiceList = new ArrayList<>(); // 切割&去空白後的選項List

			for (String item1 : stringChoiceList) { // 去空白
				trimChoiceList.add(item1.trim());
			}

			// 找出單一題的List
			List<Answer> list = answerDao.findBysIdAndUserId(item.getsId(), userId);
			List<String> answersList = new ArrayList<>(); // 所有回答的List
			for (Answer ans : list) {
				answersList.add(ans.getAnswer());
			}

			List<String> answerTrimList = new ArrayList<>();
			for (String ans : answersList) {
				String[] answerStringList = ans.split("；");
				for (String trimAnswer : answerStringList) {
					answerTrimList.add(trimAnswer.trim());

				}
			}
			for (String choice : trimChoiceList) {
				answerTrimList.add(choice);
			}

			// 比較選項跟所有回答是否匹配，匹配則加1

			for (String ans : answerTrimList) {
				answerMap.put(ans, answerMap.getOrDefault(ans, 0) + 1); // 放進Map<String, Integer> answerMap
			}

			for (Map.Entry<String, Integer> entry : answerMap.entrySet()) {
				entry.setValue(entry.getValue() - 1);
			}
			
			for (Map.Entry<String, Integer> entry : answerMap.entrySet()) {
				String answerString = entry.getKey();
				int count = entry.getValue();
				double percentsge = 100.0 * count / answerMap.size();
				answer.put(answerString, percentsge);
			}

			printTotal.put(question, answer);
		}

		return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_SUCCESSFUL.getMessage(), userInfo, printTotal);

	}

	@Override
	public QuestionnaireRes calculatePercentage(Integer qId) {

		List<SList> sList = sDao.findByqId(qId);

//		List<Answer> answerList = answerDao.findByqId(qId);

		// 題目編號 , 選項List
//		Map<Integer, List<String>> choicesMap = new HashMap<>();
		// 題目編號 , 回答List
//		Map<Integer, List<String>> answersMap = new HashMap<>();
		// 題目編號 , Map<選項, 回答出現的次數>
		Map<Integer, Map<String, Integer>> countsMap = new HashMap<>();

		Map<Map<Integer, String>, Map<String, Double>> printTotal = new LinkedHashMap<>();
		int x = 0;
		// 遍歷題目List
		for (SList item : sList) {
			x++;
			// 回答的答案, 回答出現次數
			Map<String, Integer> answerMap = new HashMap<>();

			Map<Integer, String> questionMap = new LinkedHashMap<>();

			Map<String, Double> doubleMap = new LinkedHashMap<>();

			questionMap.put(x, item.getQuestion());

//			String[] stringList = item.getChoice().split("；"); // 切割選項
//			List<String> trimList = new ArrayList<>(); // 切割&去空白後的選項List
//
//			for (String item1 : stringList) { // 去空白
//				trimList.add(item1.trim());
//			}

			String[] stringChoiceList = item.getChoice().split("；"); // 切割選項
			List<String> trimChoiceList = new ArrayList<>(); // 切割&去空白後的選項List

			for (String item1 : stringChoiceList) { // 去空白
				trimChoiceList.add(item1.trim());
			}

			// 找出單一題的List
			List<Answer> list = answerDao.findBysId(item.getsId());
			List<String> answersList = new ArrayList<>(); // 所有回答的List
			for (Answer ans : list) {
				answersList.add(ans.getAnswer());
			}

			List<String> answerTrimList = new ArrayList<>();
			for (String ans : answersList) {
				String[] answerStringList = ans.split("；");
				for (String trimAnswer : answerStringList) {
					answerTrimList.add(trimAnswer.trim());

				}
			}
			for (String choice : trimChoiceList) {
				answerTrimList.add(choice);
			}

			// 比較選項跟所有回答是否匹配，匹配則加1

			for (String ans : answerTrimList) {
				answerMap.put(ans, answerMap.getOrDefault(ans, 0) + 1); // 放進Map<String, Integer> answerMap
			}

			int count = 0;
			for (Map.Entry<String, Integer> entry : answerMap.entrySet()) {
				entry.setValue(entry.getValue() - 1);
				count += entry.getValue();
			}
			
			for (Map.Entry<String, Integer> entry : answerMap.entrySet()) {
				String answer = entry.getKey();
//				count += entry.getValue();
				
				
				double percentsge = 100.0 * entry.getValue() / count;
				doubleMap.put(answer, percentsge);
				System.out.println(count);
//				System.out.println(answer + "：" + percentsge + "％" + "（" + entry.getValue() + "）");
			}

			countsMap.put(item.getsId(), answerMap);
			printTotal.put(questionMap, doubleMap);

		}

//		System.out.println(countsMap);
//
//		for (SList item : sList) {
//
//			String[] stringList = item.getChoice().split("；");
//			List<String> trimList = new ArrayList<>();
//
//			for (String item1 : stringList) {
//				trimList.add(item1.trim());
//			}
//			choicesMap.put(item.getsId(), trimList);
//		}
//
//		System.out.println(choicesMap);
//
//		for (Map.Entry<Integer, List<String>> entry : choicesMap.entrySet()) {
//
//			List<Answer> list = answerDao.findBysId(entry.getKey());
//			List<String> stringList = new ArrayList<>();
//
//			for (Answer item : list) {
//				stringList.add(item.getAnswer());
//			}
//
//			answersMap.put(entry.getKey(), stringList);
//		}
//
//		System.out.println(answersMap);

//		// 回答的答案, 回答出現次數
//		Map<String, Integer> counts = new HashMap<>();
//
//		int totalCount = 0;
//
//		for (List<String> questionAnswer : answersMap.values()) {
//			for (String answerCount : questionAnswer) {
//				counts.put(answerCount, counts.getOrDefault(answerCount, 0) + 1);
//			}
//		}
//
//		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
//			String answer = entry.getKey();
//			int count = entry.getValue();
//			double percentsge = 100.0 * count / totalCount;
//			System.out.println(answer + "：" + percentsge + "％");
//		}
		return new QuestionnaireRes(printTotal);
	}
}