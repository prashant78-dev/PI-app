package com.prudentinnovators.prudent.controllers;

import com.prudentinnovators.prudent.models.Session;
import com.prudentinnovators.prudent.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    private List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{assigned_user_id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getReferenceById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create (@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //also need to check for children
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.PUT)
    public Session update(@PathVariable Long id,@RequestBody final Session session){
        //also need to check for children
        Session existingSession = sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

}
