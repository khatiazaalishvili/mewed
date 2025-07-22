package com.example.web.controller;
import com.example.web.model.comment.CommentRequest;
import com.example.web.model.comment.CommentResponse;
import com.example.web.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public CommentResponse create(@RequestParam String userName, @RequestBody @Valid CommentRequest request) {
        return commentService.create(userName, request);
    }

    @PutMapping("/{commentId}")
    public CommentResponse update(@PathVariable Long commentId,
                                  @RequestParam String userName,
                                  @RequestBody @Valid CommentRequest request) {
        return commentService.update(userName, commentId, request);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> delete(@PathVariable Long commentId, @RequestParam String userName) {
        commentService.delete(userName, commentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/post")
    public Page<CommentResponse> getCommentsByPost(@RequestParam Long postId,
                                                   @RequestParam Integer page,
                                                   @RequestParam Integer size) {
        return commentService.getCommentsForPost(postId, page, size);
    }
}

