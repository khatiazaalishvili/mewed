package com.example.web.mappers;
import com.example.web.model.comment.CommentEntity;
import com.example.web.model.comment.CommentResponse;



public class CommentMapper {

    public static CommentResponse mapEntityToResponse(CommentEntity entity) {
        CommentResponse response = new CommentResponse();
        response.setId(entity.getId());
        response.setText(entity.getText());
        response.setUserName(entity.getUser().getUserName());
        response.setPostText(entity.getPost().getText());
        response.setPostId(entity.getPost().getId());
        response.setCreatedAt(entity.getCreatedAt());
        return response;
    }
}

