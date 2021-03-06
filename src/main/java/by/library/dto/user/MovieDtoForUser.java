package by.library.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDtoForUser {

    private String name;

    private LocalDateTime sessionDateTime;
}
