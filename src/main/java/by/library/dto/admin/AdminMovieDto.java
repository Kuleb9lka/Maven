package by.library.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminMovieDto {

    private Long id;

    private String name;

    private LocalDateTime dateTime;
}
