package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "s_list")
@IdClass(SListId.class)
public class SList {

	@Id
	@Column(name = "q_id")
	private Integer qId;

	@Id
	@Column(name = "question")
	private String question;

	@Column(name = "question_type")
	private boolean questionType;

	@Column(name = "option")
	private String option;

	public SList() {

	}

	public SList(Integer qId, String qustion, boolean qustionType, String option) {
		this.qId = qId;
		this.question = qustion;
		this.questionType = qustionType;
		this.option = option;
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public String getQustion() {
		return question;
	}

	public void setQustion(String qustion) {
		this.question = qustion;
	}

	public boolean isQustionType() {
		return questionType;
	}

	public void setQustionType(boolean qustionType) {
		this.questionType = qustionType;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
}