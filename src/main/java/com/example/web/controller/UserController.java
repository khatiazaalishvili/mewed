package com.example.web.controller;
import com.example.web.model.user.UserRequest;
import com.example.web.model.user.UserResponse;
import com.example.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public UserResponse register(@RequestBody @Valid UserRequest request) {
        return userService.register(request);
    }
    @GetMapping("/{userName}")
    public UserResponse viewUser(@PathVariable String userName) {
        return userService.view(userName);
    }
}
