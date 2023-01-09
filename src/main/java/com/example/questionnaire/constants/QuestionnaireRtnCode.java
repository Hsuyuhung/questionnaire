package com.example.questionnaire.constants;

public enum QuestionnaireRtnCode {

	CREATE_SUCCESSFUL("200", "新增問卷成功。"), 
	UPDATE_SUCCESSFUL("200", "修改問卷成功。"),
	DELETE_SUCCESSFUL("200", "刪除問卷成功。"),
	SEARCH_SUCCESSFUL("200", "搜尋問卷成功。"),
	CREATE_QUESTION_SUCCESSFUL("200", "新增問卷問題成功。"), 
	UPDATE_QUESTION_SUCCESSFUL("200", "更新問卷問題成功。"), 
	DELETE_QUESTION_SUCCESSFUL("200", "刪除問卷問題成功。"), 
	SEARCH_QUESTION_SUCCESSFUL("200", "搜尋問卷問題成功。"), 
	CREATE_USERINFO_SUCCESSFUL("200", "新增測試者資訊成功。"),
	SEARCH_USERINFO_SUCCESSFUL("200", "搜尋測試者資訊成功。"),
	QUESTIONNAIRE_COMPLETED("200", "問卷填寫完成。"),
	SEARCH_WRONG("400", "查無此筆問卷。"),
	QLIST_WRONG("400", "此筆問卷不存在。"),
	SEARCH_EMPTY("400", "查無結果。"),
	ID_EMPTY("400", "請填入問卷序號。"),
	NAME_EMPTY("400", "請填入問卷標題。"),
	SCRIPT_EMPTY("400", "請填入問卷描述。"),
	START_TIME_EMPTY("400", "請填入開始日期。"),
	START_TIME_WRONG("400", "開始日期不得於小於當前日期。"),
	END_TIME_WRONG("400", "結束日期不得於小於當前日期。"),
	END_TIME_EMPTY("400", "請填入結束日期。"),
	TIME_EMPTY("400", "請填入欲搜尋日期。"),
	UPDATE_WRONG("400", "請填入欲修改資訊。"),
	DELETE_WRONG("400", "請選擇欲刪除問卷。"),
	DELETE_QUESTION_WRONG("400", "請選擇欲刪除問題。"),
	QUESTION_SCRIPT_EMPTY("400", "請填入問題內容。"),
	QUESTION_SCRIPT_REPEAT("400", "問題內容不得重複。"),
	QUESTION_TYPE_EMPTY("400", "請選擇問題題型。"),
	QUESTION_GENDER_EMPTY("400", "請選擇性別。"),
	OPTION_EMPTY("400", "請填入問題選項，並以「；」區隔。");

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
