package com.example.questionnaire.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SListId implements Serializable {

	private Integer qId;

	private String qustion;

	public SListId() {

	}

	public SListId(Integer qId, String qustion) {
		this.qId = qId;
		this.qustion = qustion;
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
}
