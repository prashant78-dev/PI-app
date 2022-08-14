package com.prudentinnovators.prudent.controllers;


import com.prudentinnovators.prudent.models.Session;
import com.prudentinnovators.prudent.models.Speaker;
import com.prudentinnovators.prudent.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    private List<Speaker> list(){
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
        return speakerRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create (@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody final Speaker speaker){
        //also need to check for children
        Speaker existingSpeaker = speakerRepository.getReferenceById(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }


}
