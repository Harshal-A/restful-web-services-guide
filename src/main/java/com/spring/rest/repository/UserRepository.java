package com.spring.rest.repository;

import com.spring.rest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

public interface UserRepository extends JpaRepository<User, Integer> {
}
