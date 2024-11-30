package ru.ishutin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ishutin.model.UserEntity;
import ru.ishutin.model.UserRequest;
import ru.ishutin.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<UserEntity> getUserById(@RequestParam int id) {
        UserEntity user = userService.getUser(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/get")
    public ResponseEntity<UserEntity> getUserByJson(@RequestBody UserRequest userRequest) {
        UserEntity user = userService.getUser(userRequest.getId());

        return ResponseEntity.ok(user);
    }

    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserRequest userRequest) {
        UserEntity user = userService.addUser(userRequest);

        return ResponseEntity.ok(user);
    }
}
