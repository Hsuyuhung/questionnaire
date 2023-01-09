package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "answer")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private Integer aId;

	@Column(name = "q_id")
	private Integer qId;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "s_id")
	private Integer sId;

	@Column(name = "answer")
	private String answer;

	public Answer() {

	}

	public Answer(Integer qId, Integer userId, Integer sId, String answer) {
		this.qId = qId;
		this.userId = userId;
		this.sId = sId;
		this.answer = answer;
	}

	public Answer(Integer qId, Integer sId, String answer) {
		this.qId = qId;
		this.sId = sId;
		this.answer = answer;
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}