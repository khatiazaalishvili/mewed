package com.example.web.service;
import com.example.web.mappers.CommentMapper;
import com.example.web.model.comment.CommentEntity;
import com.example.web.model.comment.CommentRequest;
import com.example.web.model.comment.CommentResponse;
import com.example.web.model.post.PostEntity;
import com.example.web.model.user.UserEntity;
import com.example.web.repositories.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;




@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, PostService postService, UserService userService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public CommentResponse create(String userName, CommentRequest request) {
        UserEntity user = userService.findByUserName(userName);
        PostEntity post = postService.findByIdInternal(request.getPostId());
        CommentEntity comment = new CommentEntity();
        comment.setText(request.getText());
        comment.setPost(post);
        comment.setUser(user);
        CommentEntity saved = commentRepository.save(comment);
        return CommentMapper.mapEntityToResponse(saved);
    }

    public Page<CommentResponse> getCommentsForPost(Long postId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return commentRepository.findAllByPostId(postId, pageable).map(CommentMapper::mapEntityToResponse);
    }

    public CommentResponse update(String userName, Long commentId, CommentRequest request) {
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ეს კომენტარი არ არსებობს!;"));
        if (!comment.getUser().getUserName().equals(userName)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "წვდომა უარყოფილია!;");
        }
        comment.setText(request.getText());
        CommentEntity updated = commentRepository.save(comment);
        return CommentMapper.mapEntityToResponse(updated);
    }

    public void delete(String userName, Long commentId) {
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ეს კომენტარი არ არსებობს!;"));
        if (!comment.getUser().getUserName().equals(userName)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "წვდომა უარყოფილია!;");
        }
        commentRepository.delete(comment);
    }
}

