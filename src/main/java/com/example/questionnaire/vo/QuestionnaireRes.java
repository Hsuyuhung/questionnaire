package com.example.questionnaire.vo;

import java.util.List;

import com.example.questionnaire.entity.QList;
import com.example.questionnaire.entity.SList;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionnaireRes {

	private String message;

	private QList qList;

	private List<QList> qLists;
	
	private SList sList;

	private List<SList> sLists;

	public QuestionnaireRes() {

	}

	public QuestionnaireRes(String message) {
		this.message = message;
	}

	public QuestionnaireRes(QList qList) {
		this.qList = qList;
	}

	public QuestionnaireRes(String message, QList qList) {
		this.message = message;
		this.qList = qList;
	}

	public QuestionnaireRes(String message, List<QList> qLists) {
		this.message = message;
		this.qLists = qLists;
	}

	public QuestionnaireRes(String message, SList sList) {
		super();
		this.message = message;
		this.sList = sList;
	}
	
	public void QuestionnaireRes(String message, List<SList> sLists) {
		this.message = message;
		this.sLists = sLists;
	}

	public QList getQlist() {
		return qList;
	}

	public void setQlist(QList qList) {
		this.qList = qList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public QList getqList() {
		return qList;
	}

	public void setqList(QList qList) {
		this.qList = qList;
	}

	public List<QList> getqLists() {
		return qLists;
	}

	public void setqLists(List<QList> qLists) {
		this.qLists = qLists;
	}

	public SList getsList() {
		return sList;
	}

	public void setsList(SList sList) {
		this.sList = sList;
	}

	public List<SList> getsLists() {
		return sLists;
	}

	public void setsLists(List<SList> sLists) {
		this.sLists = sLists;
	}	
}
