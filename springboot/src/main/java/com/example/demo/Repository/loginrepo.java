package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.details;

public interface loginrepo extends  JpaRepository <details, Integer> {

	

}