package com.example.questionnaire.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "q_list")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "q_id")
	private Integer qId;

	@Column(name = "q_name")
	private String qName;

	@Column(name = "q_script")
	private String qScript;

	@Column(name = "start_time")
	private LocalDate startTime;

	@Column(name = "end_time")
	private LocalDate endTime;

	public QList() {

	}

	public QList(String qName, String qScript, LocalDate startTime, LocalDate endTime) {
		this.qName = qName;
		this.qScript = qScript;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public QList(String qName, String qScript, LocalDate startTime) {
		this.qName = qName;
		this.qScript = qScript;
		this.startTime = startTime;
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
