package com.demo.quiz_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.quiz_service.Entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
    
}
