
package com.example.questionnaire.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.questionnaire.entity.Answer;

public class QuestionnaireReq {

	private Integer qId;

	private String qName;

	private String qScript;

	private LocalDate startTime;

	private LocalDate endTime;

	private int page;

	private int size;

	private Integer sId;

	private String question;

	private String questionType;

	private boolean essential;

	private String choice;

	private Integer userId;

	private String name;

	private String gender;

	private String phone;

	private String email;

	private Integer age;

	private String answer;

	private LocalDateTime createTime;

	private List<Integer> qIdList;

	private List<Answer> answers;

	public QuestionnaireReq() {

	}

	public QuestionnaireReq(String qName, String qScript, LocalDate startTime, LocalDate endTime) {
		this.qName = qName;
		this.qScript = qScript;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public QuestionnaireReq(Integer qId, String qName, String qScript, LocalDate startTime, LocalDate endTime) {
		this.qId = qId;
		this.qName = qName;
		this.qScript = qScript;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public QuestionnaireReq(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public QuestionnaireReq(Integer sId, String question, String questionType, String choice) {
		this.sId = sId;
		this.question = question;
		this.questionType = questionType;
		this.choice = choice;
	}

	public QuestionnaireReq(Integer sId, String question, String questionType, boolean essential, String choice) {
		this.sId = sId;
		this.question = question;
		this.questionType = questionType;
		this.essential = essential;
		this.choice = choice;
	}

	public QuestionnaireReq(Integer qId, String name, String gender, String phone, String email, Integer age) {
		this.qId = qId;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.age = age;
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public String getqScript() {
		return qScript;
	}

	public void setqScript(String qScript) {
		this.qScript = qScript;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public boolean isEssential() {
		return essential;
	}

	public void setEssential(boolean essential) {
		this.essential = essential;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Integer> getqIdList() {
		return qIdList;
	}

	public void setqIdList(List<Integer> qIdList) {
		this.qIdList = qIdList;
	}
}