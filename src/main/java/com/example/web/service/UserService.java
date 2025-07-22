package com.example.web.service;
import com.example.web.mappers.UserMapper;
import com.example.web.model.user.UserEntity;
import com.example.web.model.user.UserRequest;
import com.example.web.model.user.UserResponse;
import com.example.web.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;




@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse register(UserRequest request) {
        if (userRepository.existsByUserName(request.getUserName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "მომხმარებელი ამ სახელით უკვე არსებობს!");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setSurname(request.getSurname());
        userEntity.setUserName(request.getUserName());
        userEntity.setBirthDate(request.getBirthDate());

        UserEntity saved = userRepository.save(userEntity);
        return UserMapper.mapEntityToResponse(saved);
    }

    public UserEntity findByUserName(String userName) {
        Optional<UserEntity> userOpt = userRepository.findByUserName(userName);
        return userOpt.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "მომხმარებელი არ მოიძებნა!"));
    }

    public UserResponse view(String userName) {
        return UserMapper.mapEntityToResponse(findByUserName(userName));
    }
}

