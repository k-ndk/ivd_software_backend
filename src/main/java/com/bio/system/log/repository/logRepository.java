package com.bio.system.log.repository;

import com.bio.system.log.entity.log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface logRepository extends JpaRepository<log,Long> {
}
