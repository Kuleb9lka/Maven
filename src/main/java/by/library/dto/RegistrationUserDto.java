package by.library.dto;

import by.library.model.Role;
import by.library.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationUserDto {

    private String login;

    private String password;

    private Set<Role> roles;

    private Status status;
}
