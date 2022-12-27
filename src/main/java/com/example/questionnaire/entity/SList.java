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
	@Column(name = "qustion")
	private String qustion;

	@Column(name = "qustion_type")
	private boolean qustionType;

	@Column(name = "option")
	private String option;

	public SList() {

	}

	public SList(Integer qId, String qustion, boolean qustionType, String option) {
		this.qId = qId;
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

	public String getQustion() {
		return qustion;
	}

	public void setQustion(String qustion) {
		this.qustion = qustion;
	}

	public boolean isQustionType() {
		return qustionType;
	}

	public void setQustionType(boolean qustionType) {
		this.qustionType = qustionType;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
}