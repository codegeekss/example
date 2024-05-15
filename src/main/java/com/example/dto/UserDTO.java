package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String birthDate;
}
