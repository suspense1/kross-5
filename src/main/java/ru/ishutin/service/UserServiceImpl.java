package ru.ishutin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ishutin.model.UserEntity;
import ru.ishutin.model.UserRequest;
import ru.ishutin.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity addUser(UserRequest userRequest) {
        UserEntity user = new UserEntity();

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setJob(userRequest.getJob());

        return userRepository.save(user);
    }
}
