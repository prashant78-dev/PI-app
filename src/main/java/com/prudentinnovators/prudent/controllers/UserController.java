package com.prudentinnovators.prudent.controllers;

import com.prudentinnovators.prudent.models.User;
import com.prudentinnovators.prudent.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    private List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public User get(@PathVariable String id){
        return userRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create (@RequestBody final User user){
        return userRepository.saveAndFlush(user);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        userRepository.deleteById(id);
    }

    @RequestMapping(value="{id}" , method = RequestMethod.PUT)
    public User update(@PathVariable String user_id, @RequestBody final User user){
        //also need to check for children
        User existingUser = userRepository.getReferenceById(user_id);
        BeanUtils.copyProperties(user,existingUser,"user_id");
        return userRepository.saveAndFlush(existingUser);
    }

}
