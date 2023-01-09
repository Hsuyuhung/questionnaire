package com.example.questionnaire.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.questionnaire.entity.SList;

@Transactional
@Repository
public interface SDao extends JpaRepository<SList, Integer> {

	public List<SList> findByqId(Integer qId);

	@Modifying
	@Transactional
	public List<SList> deleteByqId(Integer qId);
}
