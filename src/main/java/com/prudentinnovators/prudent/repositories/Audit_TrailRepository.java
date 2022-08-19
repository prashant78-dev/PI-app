package com.prudentinnovators.prudent.repositories;

import com.prudentinnovators.prudent.models.Audit_Trail;
import com.prudentinnovators.prudent.models.Lessons_Assigned;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Audit_TrailRepository extends JpaRepository<Audit_Trail,Long> {
}
