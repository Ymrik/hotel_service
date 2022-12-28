package com.umarbariev.projects.hotel_service.repositories;

import com.umarbariev.projects.hotel_service.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
