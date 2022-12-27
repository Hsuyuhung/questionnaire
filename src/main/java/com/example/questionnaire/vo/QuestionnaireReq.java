package com.example.questionnaire.vo;

import java.time.LocalDate;

public class QuestionnaireReq {

	private Integer qId;

	private String qName;

	private String qScript;

	private LocalDate startTime;

	private LocalDate endTime;

	private int page;

	private int size;

	private Integer sId;

	private String qustion;

	private String qustionType;

	private String option;

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

	public QuestionnaireReq(String qustion, String qustionType, String option) {

		this.qustion = qustion;
		this.qustionType = qustionType;
		this.option = option;
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

	public String getQustion() {
		return qustion;
	}

	public void setQustion(String qustion) {
		this.qustion = qustion;
	}

	public String getQustionType() {
		return qustionType;
	}

	public void setQustionType(String qustionType) {
		this.qustionType = qustionType;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
}