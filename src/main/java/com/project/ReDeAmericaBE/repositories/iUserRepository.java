package com.project.ReDeAmericaBE.repositories;

import com.project.ReDeAmericaBE.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String Email);
}
