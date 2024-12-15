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
    public ResponseEntity<UserEntity> getUserById(
            @RequestParam(required = false) Integer id, 
            @RequestBody(required = false) UserRequest userRequest) {
        
        if (id == null && userRequest == null) {
            return ResponseEntity.badRequest().body(null);
        }

        int userId = (id != null) ? id : userRequest.getId();
        
        UserEntity user = userService.getUser(userId);

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserEntity> getUserByJson(@RequestBody UserRequest userRequest) {
        UserEntity user = userService.getUser(userRequest.getId());

        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserEntity> addUser(@RequestBody UserRequest userRequest) {
        UserEntity user = userService.addUser(userRequest);

        return ResponseEntity.ok(user);
    }
}
