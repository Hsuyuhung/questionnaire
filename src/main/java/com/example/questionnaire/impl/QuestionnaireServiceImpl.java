package com.example.questionnaire.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire.constants.QuestionnaireRtnCode;
import com.example.questionnaire.entity.QList;
import com.example.questionnaire.entity.SList;
import com.example.questionnaire.ifs.QuestionnaireService;
import com.example.questionnaire.respository.QDao;
import com.example.questionnaire.respository.SDao;
import com.example.questionnaire.vo.QuestionnaireRes;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QDao qDao;

	@Autowired
	private SDao sDao;

	@Override
	public QList createQList(String qName, String qScript, LocalDate startTime, LocalDate endTime) {

		QList qList = new QList(qName, qScript, startTime, endTime);

		return qDao.save(qList);
	}

	@Override
	public QuestionnaireRes updateQList(Integer qId, String qName, String qScript, LocalDate startTime,
			LocalDate endTime) {

		QuestionnaireRes res = new QuestionnaireRes();
		Optional<QList> qListOp = qDao.findById(qId);
		QList qList = qListOp.get();

		if (!qListOp.isPresent()) {

			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
		}

		setParams(qList, qName, qScript, startTime, endTime);
		qDao.save(qList);
		res.setQlist(qList);
		res.setMessage(QuestionnaireRtnCode.UPDATE_SUCCESSFUL.getMessage());
		return res;
	}

	private void setParams(QList qList, String qName, String qScript, LocalDate startTime, LocalDate endTime) {

		// 如有輸入值，則將輸入值存回資料庫
		if (StringUtils.hasText(qName)) {
			qList.setqName(qName);
		}

		if (StringUtils.hasText(qScript)) {
			qList.setqScript(qScript);
		}

		if (startTime != null) {
			qList.setStartTime(startTime);
		}

		if (endTime != null) {
			qList.setEndTime(endTime);
		}
	}

	@Override
	public QuestionnaireRes searchQListByQName(String qName) {

		List<QList> list = qDao.findByqNameContaining(qName);
		return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_SUCCESSFUL.getMessage(), list);
	}

	public List<QList> getPagedQList(int page, int size) {

		Page<QList> pageResult = qDao.findAll(PageRequest.of(page, // 查詢的頁數，從0起算
				size, // 查詢的每頁筆數
				Sort.by("qId").descending())); // 依q_id欄位降冪排序

		pageResult.getNumberOfElements(); // 本頁筆數
		pageResult.getSize(); // 每頁筆數
		pageResult.getTotalElements(); // 全部筆數
		pageResult.getTotalPages(); // 全部頁數

		List<QList> list = pageResult.getContent();

		return list;

	}

	@Override
	public List<QList> getPagedQListbByTime(LocalDate startTime, LocalDate endTime) {

		return qDao.findAll(startTime, endTime);
	}

//	@Override
//	public QuestionnaireRes searchQList(String qName, LocalDate startTime, LocalDate endTime) {
//
//		List<QList> list = qDao.findByQNameContaining(qName);
//
//		return null;
//	}

//	@Override
//	public List<QList> getPagedQListbByName(int page, int size, String qName) {
//		return null;
//
//		Page<QList> pageResult = qDao.findByQNameContaining(
//                PageRequest.of(page,  // 查詢的頁數，從0起算
//                                size, // 查詢的每頁筆數
//                                Sort.by("qId").descending())); // 依q_id欄位降冪排序
//        
//        pageResult.getNumberOfElements(); // 本頁筆數
//        pageResult.getSize();             // 每頁筆數 
//        pageResult.getTotalElements();    // 全部筆數
//        pageResult.getTotalPages();       // 全部頁數
//        
//        List<QList> list =  pageResult.getContent();
//    
//        return list;
//
//	}

//	@Override
//	public Page<QList> findByTime(LocalDate startTime, LocalDate endTime, Pageable pageable) {
//
//		return qDao.findAll(startTime, endTime, pageable);
//	}

	@Override
	public QuestionnaireRes deleteQList(Integer qId) {

		if (!qDao.findById(qId).isPresent()) {
			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
		}

		qDao.deleteById(qId);
		return new QuestionnaireRes(QuestionnaireRtnCode.DELETE_SUCCESSFUL.getMessage());
	}

	@Override
	public SList createSList(Integer qId, String qustion, boolean qustionType, String option) {

		SList sList = new SList(qId, qustion, qustionType, option);
		return sDao.save(sList);
		
	}

	@Override
	public QuestionnaireRes updateSList(Integer qId, String qustion, boolean qustionType, String option) {
//		QuestionnaireRes res = new QuestionnaireRes();
//		Optional<SList> sListOp = sDao.findById(sId);
//		SList sList = sListOp.get();
//
//		if (!sListOp.isPresent()) {
//
//			return new QuestionnaireRes(QuestionnaireRtnCode.SEARCH_WRONG.getMessage());
//		}
//		
//		if (StringUtils.hasText(qustion)) {
//			sList.setQustion(qustion);
//		}
//		
//		if (StringUtils.hasText(qustionType)) {
//			sList.setQustionType(qustionType);
//		}
//
//		if (StringUtils.hasText(option)) {
//			sList.setOption(option);
//		}
//		
//		sDao.save(sList);
//		res.setsList(sList);;
//		res.setMessage(QuestionnaireRtnCode.UPDATE_SUCCESSFUL.getMessage());
//		return res;
		return null;

	}

	@Override
	public QuestionnaireRes deleteSList(Integer qId, String qustion) {
		// TODO Auto-generated method stub
		return null;
	}
}