package com.project.ReDeAmericaBE.repositories;

import com.project.ReDeAmericaBE.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iCommentRepository extends JpaRepository<Comment,Integer> {
}
