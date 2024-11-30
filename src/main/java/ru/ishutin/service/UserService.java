package ru.ishutin.service;

import ru.ishutin.model.UserEntity;
import ru.ishutin.model.UserRequest;

public interface UserService {

    public UserEntity getUser(int id);
    public UserEntity addUser(UserRequest userRequest);
}
