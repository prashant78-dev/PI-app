package com.prudentinnovators.prudent.controllers;

import com.prudentinnovators.prudent.models.Questions_Answer;
import com.prudentinnovators.prudent.models.User;
import com.prudentinnovators.prudent.repositories.Questions_AnswerRepository;
import com.prudentinnovators.prudent.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions_answer")

public class Questions_AnswerController {
    @Autowired
    private Questions_AnswerRepository questions_answerRepository;

    @GetMapping
    private List<Questions_Answer> list(){
        return questions_answerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Questions_Answer get(@PathVariable Long id){
        return questions_answerRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Questions_Answer create (@RequestBody final Questions_Answer questions_Answer){
        return questions_answerRepository.saveAndFlush(questions_Answer);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        questions_answerRepository.deleteById(id);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.PUT)
    public Questions_Answer update(@PathVariable Long q_id, @RequestBody final Questions_Answer questions_Answer){

        Questions_Answer existingUser = questions_answerRepository.getReferenceById(q_id);
        BeanUtils.copyProperties(questions_Answer,existingUser,"q_id");
        return questions_answerRepository.saveAndFlush(existingUser);
    }

}
