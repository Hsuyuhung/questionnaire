package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "s_list")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "s_id")
	private Integer sId;

	@Column(name = "q_id")
	private Integer qId;

	@Column(name = "question")
	private String question;

	@Column(name = "question_type")
	private String questionType;

	@Column(name = "essential")
	private boolean essential;

	@Column(name = "choice")
	private String choice;

	public SList() {

	}

	public SList(Integer qId, String question, String questionType, boolean essential, String choice) {
		this.qId = qId;
		this.question = question;
		this.questionType = questionType;
		this.essential = essential;
		this.choice = choice;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
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
}