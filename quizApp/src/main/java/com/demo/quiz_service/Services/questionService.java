package com.demo.quiz_service.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.demo.quiz_service.Entity.Question;
import com.demo.quiz_service.dao.QuestionDao;

@Service
public class questionService {
    
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
        return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
       
    }

 public  List<Question> getQuestionByCategory(String category) {
        
       return questionDao.findByCategory(category);
    }


    public ResponseEntity<String> addQuestion(Question question) 
    {
          questionDao.save(question);
          return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    
}
