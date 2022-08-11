package com.prudentinnovators.prudent.repositories;

import com.prudentinnovators.prudent.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}
