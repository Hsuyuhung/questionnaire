package com.example.questionnaire.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "q_list")
public class QList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "q_id")
	Integer qId;

	@Column(name = "q_name")
	String qName;

	@Column(name = "q_script")
	String qScript;

	@Column(name = "start_time")
	LocalDate startTime;

	@Column(name = "end_time")
	LocalDate endTime;

	public QList() {

	}

	public QList(String qName, String qScript, LocalDate startTime, LocalDate endTime) {
		this.qName = qName;
		this.qScript = qScript;
		this.startTime = startTime;
		this.endTime = endTime;
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

}
