package com.example.web.repositories;
import com.example.web.model.post.PostEntity;
import com.example.web.model.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;




public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Page<PostEntity> findAllByUser(UserEntity user, Pageable pageable);
}





