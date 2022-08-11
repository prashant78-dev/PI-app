package com.prudentinnovators.prudent.repositories;

import com.prudentinnovators.prudent.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
