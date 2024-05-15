package com.example.service;

import com.example.dto.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface UserService {

    Optional<UserDTO> getUserById(Long id);

    List<UserDTO> getAllUsers();

    CompletableFuture<UserDTO> createUser(UserDTO userDTO);

    void deleteUser(Long id);

}
