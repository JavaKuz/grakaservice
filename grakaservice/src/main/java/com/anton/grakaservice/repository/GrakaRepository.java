package com.anton.grakaservice.repository;

import com.anton.grakaservice.repository.model.Graka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrakaRepository extends JpaRepository<Graka, Long> {
}
