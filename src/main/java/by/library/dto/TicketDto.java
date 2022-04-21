package by.library.dto;


import by.library.model.Movie;
import by.library.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private Long id;

    private User userId;

    private Movie movieId;

    private int place;

    private int price;

    private boolean isBought;
}
