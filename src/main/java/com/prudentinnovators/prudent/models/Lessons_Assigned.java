package com.prudentinnovators.prudent.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "lessons_assigned")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Lessons_Assigned {


}
