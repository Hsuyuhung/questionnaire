package com.example.questionnaire.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.questionnaire.entity.Answer;

@Transactional
@Repository
public interface AnswerDao extends JpaRepository<Answer, Integer> {

	public List<Answer> findByqId(Integer qId);

	public List<Answer> findByUserId(Integer userId);

	public List<Answer> findBysId(Integer sId);

	public List<Answer> findBysIdAndUserId(Integer sId, Integer userId);
}