package com.example.questionnaire.vo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.questionnaire.entity.Answer;
import com.example.questionnaire.entity.QList;
import com.example.questionnaire.entity.SList;
import com.example.questionnaire.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionnaireRes {

	private String message;

	private QList qList;

	private List<QList> qLists;

	private SList sList;

	private List<SList> sLists;

	private UserInfo userInfo;

	private List<UserInfo> userInfoList;

	private List<Answer> answers;

	private List<QuestionAndAnswerInfo> questionAndAnswerInfo;

	private Map<Integer, Map<String, Integer>> countsMap;
	// 問題編號+問題 //選項+百分比
	private Map<Map<Integer, String>, Map<String, Double>> printTotal;

	public QuestionnaireRes() {

	}

	public QuestionnaireRes(String message) {
		this.message = message;
	}

	public QuestionnaireRes(QList qList) {
		this.qList = qList;
	}

	public QuestionnaireRes(String message, QList qList) {
		this.message = message;
		this.qList = qList;
	}

	public QuestionnaireRes(String message, List<QList> qLists) {
		this.message = message;
		this.qLists = qLists;
	}

	public QuestionnaireRes(List<QList> qLists) {
		super();
		this.qLists = qLists;
	}

	public QuestionnaireRes(String message, SList sList) {

		this.message = message;
		this.sList = sList;
	}

	public void findSList(String message, QList qList, List<SList> sLists) {
		this.message = message;
		this.qList = qList;
		this.sLists = sLists;
	}

	public QuestionnaireRes(String message, UserInfo userInfo) {
		this.message = message;
		this.userInfo = userInfo;
	}

	public void findUserInfoList(String message, List<UserInfo> userInfoList) {
		this.message = message;
		this.userInfoList = userInfoList;
	}

	public void findAnswers(String message, List<Answer> answers) {
		this.message = message;
		this.answers = answers;
	}

	public QuestionnaireRes(String message, UserInfo userInfo, List<Answer> answers) {
		this.message = message;
		this.userInfo = userInfo;
		this.answers = answers;
	}

	public void questionAndAnswer(String message, UserInfo userInfo,
			List<QuestionAndAnswerInfo> questionAndAnswerInfo) {
		this.message = message;
		this.userInfo = userInfo;
		this.questionAndAnswerInfo = questionAndAnswerInfo;
	}

	public QuestionnaireRes(String message, UserInfo userInfo,
			Map<Map<Integer, String>, Map<String, Double>> printTotal) {
		this.message = message;
		this.userInfo = userInfo;
		this.printTotal = printTotal;
	}

//	public QuestionnaireRes(Map<Integer, Map<String, Integer>> countsMap) {
//		this.countsMap = countsMap;
//	}

	public QuestionnaireRes(Map<Map<Integer, String>, Map<String, Double>> printTotal) {
		super();
		this.printTotal = printTotal;
	}

	public QList getqList() {
		return qList;
	}

	public void setqList(QList qList) {
		this.qList = qList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<QList> getqLists() {
		return qLists;
	}

	public void setqLists(List<QList> qLists) {
		this.qLists = qLists;
	}

	public SList getsList() {
		return sList;
	}

	public void setsList(SList sList) {
		this.sList = sList;
	}

	public List<SList> getsLists() {
		return sLists;
	}

	public void setsLists(List<SList> sLists) {
		this.sLists = sLists;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<QuestionAndAnswerInfo> getQuestionAndAnswerInfo() {
		return questionAndAnswerInfo;
	}

	public void setQuestionAndAnswerInfo(List<QuestionAndAnswerInfo> questionAndAnswerInfo) {
		this.questionAndAnswerInfo = questionAndAnswerInfo;
	}

	public Map<Integer, Map<String, Integer>> getCountsMap() {
		return countsMap;
	}

	public void setCountsMap(Map<Integer, Map<String, Integer>> countsMap) {
		this.countsMap = countsMap;
	}

	public Map<Map<Integer, String>, Map<String, Double>> getPrintTotal() {
		return printTotal;
	}

	public void setPrintTotal(Map<Map<Integer, String>, Map<String, Double>> printTotal) {
		this.printTotal = printTotal;
	}
}
