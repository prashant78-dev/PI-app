package com.prudentinnovators.prudent.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "audit_trail")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Audit_Trail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String lesson;

    private String level;
    private String user_id;
    Long q_id;



    String isCorrect;
    @JsonFormat(pattern="dd-MM-yyyy")
    Date creation_date;


    public Long getId() {
        return id;
    }



    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Long getQ_id() {
        return q_id;
    }

    public void setQ_id(Long q_id) {
        this.q_id = q_id;
    }

    public String isCorrect() {
        return isCorrect;
    }

    public void setCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Date getDate() {
        return creation_date;
    }

    public void setDate(Date creation_date) {
        this.creation_date = creation_date;
    }

}
