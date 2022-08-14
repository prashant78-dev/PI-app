package com.prudentinnovators.prudent.repositories;

import com.prudentinnovators.prudent.models.Speaker;
import com.prudentinnovators.prudent.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
