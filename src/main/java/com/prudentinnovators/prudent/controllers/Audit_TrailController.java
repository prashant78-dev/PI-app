package com.prudentinnovators.prudent.controllers;

import com.prudentinnovators.prudent.models.Audit_Trail;
import com.prudentinnovators.prudent.repositories.Audit_TrailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audit_trail")

public class Audit_TrailController {
    @Autowired
    private Audit_TrailRepository audit_TrailRepository;

    @GetMapping
    private List<Audit_Trail> list(){
        return audit_TrailRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Audit_Trail get(@PathVariable Long id){
        return audit_TrailRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Audit_Trail create (@RequestBody final Audit_Trail audit_Trail){
        return audit_TrailRepository.saveAndFlush(audit_Trail);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        audit_TrailRepository.deleteById(id);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.PUT)
    public Audit_Trail update(@PathVariable Long id, @RequestBody final Audit_Trail audit_Trail){
        //also need to check for children
        Audit_Trail existingUser = audit_TrailRepository.getReferenceById(id);
        BeanUtils.copyProperties(audit_Trail,existingUser,"id");
        return audit_TrailRepository.saveAndFlush(existingUser);
    }

}
