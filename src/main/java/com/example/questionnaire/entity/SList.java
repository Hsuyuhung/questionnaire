package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "s_list")
public class SList {

	@Id
	@Column(name = "s_id")
	private Integer sId;

	@Column(name = "q_id")
	private Integer qId;

	@Column(name = "qustion")
	private String qustion;

	@Column(name = "qustion_type")
	private String qustionType;

	@Column(name = "option")
	private String option;

	public SList() {

	}

	public SList(Integer sId, Integer qId, String qustion, String qustionType, String option) {

		this.sId = sId;
		this.qId = qId;
		this.qustion = qustion;
		this.qustionType = qustionType;
		this.option = option;
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
