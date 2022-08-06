package by.library.dto.admin;

import by.library.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoForAdmin {

    private Long id;

    private String login;

    private Set<Role> roles;
}
