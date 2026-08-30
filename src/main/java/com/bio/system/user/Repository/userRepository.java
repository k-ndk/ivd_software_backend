package com.bio.system.user.Repository;

import com.bio.system.user.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user,Integer> {


    Optional<user> findByUserIds(String userIds);
}
