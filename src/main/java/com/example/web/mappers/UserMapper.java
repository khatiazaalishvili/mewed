package com.example.web.mappers;
import com.example.web.model.user.UserEntity;
import com.example.web.model.user.UserResponse;



public class UserMapper {
    public static UserResponse mapEntityToResponse(UserEntity entity) {
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSurname(entity.getSurname());
        response.setUserName(entity.getUserName());
        response.setBirthDate(entity.getBirthDate());
        return response;
    }
}

