package com.example.service;

import com.example.dto.UserDTO;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::mapToUserDTO); // Map User to UserDTO if found
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .parallel()
                .map(this::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompletableFuture<UserDTO> createUser(UserDTO userDTO) {
        User newUser = new User();
        newUser.setName(userDTO.getName());
        newUser.setEmail(userDTO.getEmail());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        newUser.setBirthDate(LocalDate.parse(userDTO.getBirthDate(),dateTimeFormatter)); // Parse LocalDate from String

        return CompletableFuture.supplyAsync(() -> userRepository.save(newUser))
                .thenApply(this::mapToUserDTO);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthDate(user.getBirthDate().toString());
        return userDTO;
    }
}
