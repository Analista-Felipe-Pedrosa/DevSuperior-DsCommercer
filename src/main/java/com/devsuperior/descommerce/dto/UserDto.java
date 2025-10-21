package com.devsuperior.descommerce.dto;

import com.devsuperior.descommerce.entities.User;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class UserDto {

    private long id;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
    List<String> roles = new ArrayList<>();

    public UserDto(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
        this.birthDate = entity.getBirthDate();
        this.password = entity.getPassword();
        for (GrantedAuthority role : entity.getRoles()){
            roles.add(role.getAuthority());
        }
    }
}
