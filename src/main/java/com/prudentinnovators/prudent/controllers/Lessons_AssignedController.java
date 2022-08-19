package com.prudentinnovators.prudent.controllers;

import com.prudentinnovators.prudent.models.Lessons_Assigned;
import com.prudentinnovators.prudent.repositories.Lessons_AssignedRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons_assigned")

public class Lessons_AssignedController {
    @Autowired
    private Lessons_AssignedRepository lessons_AssignedRepository;

    @GetMapping
    private List<Lessons_Assigned> list(){
        return lessons_AssignedRepository.findAll();
    }

  /*  @GetMapping
    @RequestMapping("{id}")
    public Lessons_Assigned get(@PathVariable Long id){
        return lessons_AssignedRepository.getReferenceById(id);
    }
*/
    @GetMapping
    @RequestMapping("{assigneduser}")
    public List<Lessons_Assigned> get(@PathVariable String assigneduser){

        return lessons_AssignedRepository.findByAssigneduser(assigneduser);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lessons_Assigned create (@RequestBody final Lessons_Assigned lessons_Assigned){
        return lessons_AssignedRepository.saveAndFlush(lessons_Assigned);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        lessons_AssignedRepository.deleteById(id);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.PUT)
    public Lessons_Assigned update(@PathVariable Long id, @RequestBody final Lessons_Assigned lessons_Assigned){
        //also need to check for children
        Lessons_Assigned existingUser = lessons_AssignedRepository.getReferenceById(id);
        BeanUtils.copyProperties(lessons_Assigned,existingUser,"id");
        return lessons_AssignedRepository.saveAndFlush(existingUser);
    }

}
