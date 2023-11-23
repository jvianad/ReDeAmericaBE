package com.project.ReDeAmericaBE.repositories;

import com.project.ReDeAmericaBE.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iPublicationRepository extends JpaRepository<Publication,Integer> {
}
