package com.example.questionnaire.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.questionnaire.entity.UserInfo;

@Transactional
@Repository
public interface UserInfoDao  extends JpaRepository<UserInfo, Integer> {

	public List<UserInfo> findByqId(Integer qId);
}
