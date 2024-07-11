package com.demo.quiz_service.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.quiz_service.Entity.Question;
import com.demo.quiz_service.Services.questionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/question")
public class QuestionController {
  
  @Autowired
  questionService questionService;

  @GetMapping("/allQuestions")
public ResponseEntity<List<Question>> getAllQuestion()
{
  return questionService.getAllQuestions();
}

   @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category)
    {
        return questionService.getQuestionByCategory(category);
    }

   
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)  //requestBody beacuse we are sending the from client side to server
    {
      return questionService.addQuestion(question);
    }

  
    
}
