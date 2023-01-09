package com.example.questionnaire;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.QList;
import com.example.questionnaire.entity.SList;
import com.example.questionnaire.entity.UserInfo;
import com.example.questionnaire.ifs.QuestionnaireService;
import com.example.questionnaire.respository.AnswerDao;
import com.example.questionnaire.respository.QDao;
//import com.example.questionnaire.entity.QList;
//import com.example.questionnaire.entity.SList;
//import com.example.questionnaire.entity.SListId;
//import com.example.questionnaire.ifs.QuestionnaireService;
//import com.example.questionnaire.respository.QDao;
import com.example.questionnaire.respository.SDao;
import com.example.questionnaire.respository.UserInfoDao;

@SpringBootTest
class QuestionnaireApplicationTests {

	@Autowired
	private QuestionnaireService questionnaireService;

	
	@Autowired
	private QDao qDao;

	@Autowired
	private SDao sDao;

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private AnswerDao answerDao;

	@Test
	void createQList() {

		LocalDate start = LocalDate.parse("2023-01-04");
		QList qList = new QList("班代選舉", "請選出班級班代代表(每票珍貴，僅選一位！！)", start);

		qDao.save(qList);
	}
	
	@Test
	void updateQList() {
		
	}

	@Test
	void createSList() {
//		SList sList1 = new SList(1, "學習此課程是否有符合您的期待？", "單選", "是；否");
//		SList sList2 = new SList(1, "是否會推薦朋友參與此課程？", "單選", "是；否");
//		SList sList3 = new SList(1, "是否願意收到相關課程訊息？", "單選", "是；否");
//		SList sList4 = new SList(1, "此課程學習之技能是否對就職有幫助？", "單選", "是；否");
//		SList sList5 = new SList(1, "請選出學習到的技能。", "複選", "Java；MySQL；GO；Python");
//
//		List<SList> list = Arrays.asList(sList1, sList2, sList3, sList4, sList5);
//
//		sDao.saveAll(list);
	}

	@Test
	void calculatePercentage() {
		List<SList> sList = sDao.findByqId(1);

		ArrayList<String> questionList = new ArrayList<String>();

		for (SList item : sList) {

			questionList.add(item.getChoice());

		}

		System.out.println(questionList);
	}

	@Test
	void createUserInfoAndAnswer() {

		LocalDateTime now = LocalDateTime.now();
		UserInfo userInfo = new UserInfo(1, "黃露露", "女", "0977845961", "hruru@gmail.com", 25, now);
		userInfoDao.save(userInfo);
		List<Integer> list = new ArrayList<>();
		List<SList> sList = sDao.findByqId(1);
		for (SList item : sList) {
			list.add(item.getsId());
		}

		List<Answer> answers = new ArrayList<>();

//		回傳(Integer qId, UUID uuid, String answer)
//		Answer a1 = new Answer(1, "2bd79053-7616-4bbb-be61-a69108a91182" , "是");

		answers.add(null);
		for (Answer item : answers) {
			item.setUserId(userInfo.getUserId());
		}

		answerDao.saveAll(answers);
	}
	
	@Test
	void choicesListTest() {
		questionnaireService.calculatePercentage(1);

	}
	
	@Test
	void findByqIdContainingAndStartTimeTest() {
		LocalDate day1 = LocalDate.of(2022, 12, 20);
		LocalDate day2 = LocalDate.of(2023, 12, 10);
		List<QList> list = qDao.findByqNameContainingAndStartTimeGreaterThanEqualAndEndTimeLessThanEqualOrderByStartTimeDesc("", day1, day2);
		
		for(QList item : list) {
			System.out.println(item.getStartTime());
		}	
	}
	
	@Test
	void deleteQListsTest() {
		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(10);
		list.add(11);
		
		questionnaireService.deleteQLists(list);
	}
	
	@Test
	void searchQListAndSListTest() {
		QList qList = qDao.findById(1).get();
		List<SList> sList = sDao.findByqId(1);
		
		System.out.println(qList);
		
		for(SList item : sList) {
			System.out.println(item);
		}
		
	}
}
