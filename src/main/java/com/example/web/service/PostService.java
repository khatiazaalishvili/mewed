package com.example.web.service;
import com.example.web.mappers.PostMapper;
import com.example.web.model.post.PostEntity;
import com.example.web.model.post.PostRequest;
import com.example.web.model.post.PostResponse;
import com.example.web.model.user.UserEntity;
import com.example.web.repositories.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public PostResponse createPost(String userName, PostRequest request) {
        UserEntity user = userService.findByUserName(userName);
        PostEntity entity = PostMapper.mapRequestToEntity(request);
        entity.setUser(user);
        PostEntity saved = postRepository.save(entity);
        return PostMapper.mapEntityToResponse(saved);
    }

    public PostResponse updatePost(String userName, Long postId, PostRequest request) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ასეთი პოსტი არ არსებობს !"));
        if (!post.getUser().getUserName().equals(userName)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "წვდომა უარყოფილია!");
        }
        post.setText(request.getText());
        PostEntity updated = postRepository.save(post);
        return PostMapper.mapEntityToResponse(updated);
    }

    public void deletePost(String userName, Long postId) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ასეთი პოსტი არ არსებობს!"));
        if (!post.getUser().getUserName().equals(userName)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "წვდომა უარყოფილია!");
        }
        postRepository.delete(post);
    }

    public Page<PostResponse> getAllPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return postRepository.findAll(pageable).map(PostMapper::mapEntityToResponse);
    }

    public Page<PostResponse> getPostsByUser(String userName, int page, int size) {
        UserEntity user = userService.findByUserName(userName);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return postRepository.findAllByUser(user, pageable).map(PostMapper::mapEntityToResponse);
    }

    public PostResponse getPostById(Long postId) {
        PostEntity post = postRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ასეთი პოსტი არ არსებობს"));
        return PostMapper.mapEntityToResponse(post);
    }


    public PostEntity findByIdInternal(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ასეთი პოსტი არ არსებობს!"));
    }
}

