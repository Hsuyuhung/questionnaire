package com.example.questionnaire.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questionnaire.entity.SList;

public interface SDao extends JpaRepository<SList, Integer>  {

}
