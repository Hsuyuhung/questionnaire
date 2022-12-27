package com.example.questionnaire.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SListId implements Serializable {

	private Integer sId;

	private Integer qId;

	public SListId(Integer sId, Integer qId) {
		this.sId = sId;
		this.qId = qId;
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
	
	
}
