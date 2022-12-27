package com.example.questionnaire.constants;

public enum QuestionnaireRtnCode {

	CREATE_SUCCESSFUL("200", "新增問卷成功。"), 
	UPDATE_SUCCESSFUL("200", "修改問卷成功。"),
	DELETE_SUCCESSFUL("200", "刪除問卷成功。"),
	SEARCH_SUCCESSFUL("200", "搜尋問卷成功。"),
	SEARCH_WRONG("400", "查無此筆問卷。"),
	NAME_EMPTY("400", "請填入問卷標題。"),
	SCRIPT_EMPTY("400", "請填入問卷描述。"),
	START_TIME_EMPTY("400", "請填入開始日期。"),
	START_TIME_WRONG("400", "開始日期不得於小於當前日期。"),
	END_TIME_WRONG("400", "結束日期不得於小於當前日期。"),
	END_TIME_EMPTY("400", "請填入結束日期。"),
	DELETE_WRONG("400", "請選擇欲刪除問卷。");

	private String code;
	private String message;

	private QuestionnaireRtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
