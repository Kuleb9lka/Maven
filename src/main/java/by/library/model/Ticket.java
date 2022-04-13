package by.library.model;

import by.library.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "movie_id")
    private Movie movieId;

    @Column(name = "place")
    private int place;

    @Column(name = "price")
    private int price;

    @Column(name = "is_bought")
    private boolean isBought;
}
