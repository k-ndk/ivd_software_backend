package com.bio.system.result.repository;

import com.bio.system.result.entity.result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface resultRepository extends JpaRepository<result,Long> {
}
