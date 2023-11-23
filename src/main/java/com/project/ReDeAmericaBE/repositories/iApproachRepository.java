package com.project.ReDeAmericaBE.repositories;

import com.project.ReDeAmericaBE.entities.Approach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iApproachRepository extends JpaRepository<Approach,Integer> {
}
