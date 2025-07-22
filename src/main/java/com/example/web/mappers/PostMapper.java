package com.example.web.mappers;
import com.example.web.model.post.PostEntity;
import com.example.web.model.post.PostRequest;
import com.example.web.model.post.PostResponse;
import java.time.LocalDateTime;





public class PostMapper {

    public static PostEntity mapRequestToEntity(PostRequest request) {
        PostEntity entity = new PostEntity();
        entity.setText(request.getText());
        entity.setCreatedAt(LocalDateTime.now());
        return entity;
    }

    public static PostResponse mapEntityToResponse(PostEntity entity) {
        PostResponse response = new PostResponse();
        response.setId(entity.getId());
        response.setText(entity.getText());
        response.setUserName(entity.getUser().getUserName());
        response.setCreatedAt(entity.getCreatedAt());
        return response;
    }
}

