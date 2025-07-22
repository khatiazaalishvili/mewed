package com.example.web.repositories;
import com.example.web.model.comment.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
  Page<CommentEntity> findAllByPostId(Long postId, Pageable pageable);
}
