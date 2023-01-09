package com.example.questionnaire.respository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.questionnaire.entity.QList;

//@Modifying
@Transactional
@Repository
public interface QDao extends JpaRepository<QList, Integer> {
	
//	@Modifying
//	@Query(value = "SELECT * FROM`q_list` WHERE `start_time` >=? AND `end_time` <=? ORDER BY `start_time` DESC", nativeQuery = true)
//	List<QList> findByStartTimeAndEndTime(LocalDate startTime, LocalDate endTime);
	
	List<QList> findByqNameContaining(String qName);
	
	List<QList> findAllByOrderByStartTimeDesc();
	
	List<QList> findByqNameContainingAndStartTimeGreaterThanEqualOrderByStartTimeDesc(String qName, LocalDate startTime);
	
	List<QList> findByqNameContainingAndEndTimeLessThanEqualOrderByEndTimeDesc(String qName, LocalDate endTime);
	
	List<QList> findByqNameContainingAndStartTimeGreaterThanEqualAndEndTimeLessThanEqualOrderByStartTimeDesc(String qName, LocalDate startTime, LocalDate endTime);
	
//	@Modifying
//	@Query(value = "SELECT * FROM`q_list` WHERE `start_time` >=? AND `end_time` <=?", nativeQuery = true)
//	Page<QList> findAll(LocalDate startTime, LocalDate endTime, Pageable pageable);
	
//	public Page<QList> findByQNameContaining(String qName, Pageable pageable);
	
//	@Query("FROM q_list as q")
//	public List<QList> findByQNamePaging(Pageable pageable);
	
//	Page<QList> findAii(Specification specification, Pageable pageable);
	
//	@Query("select a from q_list a where a.")
//	public List<QList> findByQNameInAndStartTimeBetween(String qName, LocalDate startTime, LocalDate endTime);
	
//	public List<QList> findAll(Pageable pageable, LocalDate startTime, LocalDate endTime);


}
