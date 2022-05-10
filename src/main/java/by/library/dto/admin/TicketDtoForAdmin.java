package by.library.dto.admin;


import by.library.model.Movie;
import by.library.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDtoForAdmin {

    private Long id;

    private User user;

    private Movie movie;

    private int place;

    private int price;

    private boolean isBought;
}
