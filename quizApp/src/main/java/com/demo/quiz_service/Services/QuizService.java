package com.demo.quiz_service.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.quiz_service.Entity.Question;
import com.demo.quiz_service.Entity.QuestionWrapper;
import com.demo.quiz_service.Entity.Quiz;
import com.demo.quiz_service.Entity.Response;
import com.demo.quiz_service.dao.QuestionDao;
import com.demo.quiz_service.dao.QuizDao;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createquiz(String category, int numQ, String title) {
        
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);


        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("sucess", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       
       Optional<Quiz> quiz = quizDao.findById(id);
       List<Question> questionFromDB = quiz.get().getQuestions();
       List<QuestionWrapper> questionsForUser = new ArrayList<>();
       for(Question q: questionFromDB)
       {
        QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(), q.getOption1(),q.getOption2(), q.getOption3(),q.getOption4());
        questionsForUser.add(qw);
       }


       return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
       
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right =0;
        int i=0;
        for(Response response :responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswe()))
            right++;

            i++;

        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
    
}
