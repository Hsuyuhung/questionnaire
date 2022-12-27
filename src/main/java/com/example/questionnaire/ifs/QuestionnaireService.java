package com.example.questionnaire.ifs;

import java.time.LocalDate;
import java.util.List;

import com.example.questionnaire.entity.QList;
import com.example.questionnaire.entity.SList;
import com.example.questionnaire.vo.QuestionnaireRes;

public interface QuestionnaireService {

	public QList createQList(String qName, String qScript, LocalDate startTime, LocalDate endTime);
	
	public QuestionnaireRes updateQList(Integer qId, String qName, String qScript, LocalDate startTime, LocalDate endTime);
	
	public QuestionnaireRes searchQListByQName(String qName);
	
	public List<QList> getPagedQList(int page, int size);
	
	public List<QList> getPagedQListbByTime(LocalDate startTime, LocalDate endTime);
	
//	public QuestionnaireRes searchQList(String qName, LocalDate startTime, LocalDate endTime); 
	 
//	 public List<QList> getPagedQListbByName(int page, int size, String qName); 
	 
//	 Page<QList> findByTime(LocalDate startTime, LocalDate endTime, Pageable pageable);
	 
	 public QuestionnaireRes deleteQList(Integer qId);
	
//	public ResponseResultPage<QList> searchQList(String qName, Integer page, Integer size, String startTime, String endTime);

	 public SList createSList(Integer qId, String qustion, boolean qustionType, String option);
	
	 public QuestionnaireRes updateSList(Integer qId, String qustion, boolean qustionType, String option);
	 
	 public QuestionnaireRes deleteSList(Integer qId, String qustion);
}
