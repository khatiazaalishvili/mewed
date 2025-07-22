package com.example.web.controller;
import com.example.web.model.post.PostRequest;
import com.example.web.model.post.PostResponse;
import com.example.web.service.PostService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostResponse createPost(@RequestParam String userName, @RequestBody @Valid PostRequest request) {
        return postService.createPost(userName, request);
    }

    @PutMapping("/{postId}")
    public PostResponse updatePost(@PathVariable Long postId,
                                   @RequestParam String userName,
                                   @RequestBody @Valid PostRequest request) {
        return postService.updatePost(userName, postId, request);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId, @RequestParam String userName) {
        postService.deletePost(userName, postId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public Page<PostResponse> getAllPosts(@RequestParam Integer page, @RequestParam Integer size) {
        return postService.getAllPosts(page, size);
    }

    @GetMapping("/user")
    public Page<PostResponse> getPostsByUser(@RequestParam String userName,
                                             @RequestParam Integer page,
                                             @RequestParam Integer size) {
        return postService.getPostsByUser(userName, page, size);
    }

    @GetMapping("/{postId}")
    public PostResponse getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }
}
