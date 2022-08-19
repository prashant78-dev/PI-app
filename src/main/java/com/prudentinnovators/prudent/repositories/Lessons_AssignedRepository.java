package com.prudentinnovators.prudent.repositories;

import com.prudentinnovators.prudent.models.Lessons_Assigned;
import com.prudentinnovators.prudent.models.Questions_Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Lessons_AssignedRepository extends JpaRepository<Lessons_Assigned,Long> {

    List<Lessons_Assigned> findByAssigneduser(String assigneduser);
}
