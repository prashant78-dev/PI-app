package com.prudentinnovators.prudent.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "lessons_assigned")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Lessons_Assigned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lesson ;
    private String level  ;

    private String assigneduser;
    private String user_id ;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date creation_date ;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date last_modified_date;

    public void setStatus(String status) {
        this.status = status;
    }

    private String status ;

    public Long getId() {
        return id;
    }


    public String getAssigneduser() {
        return assigneduser;
    }

    public void setAssigneduser(String assigneduser) {
        this.assigneduser = assigneduser;
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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Date last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public String getStatus() {
        return status;
    }






}
