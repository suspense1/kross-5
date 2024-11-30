package ru.ishutin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ishutin.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {  }
