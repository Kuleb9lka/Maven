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

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name = "movie_id")
    private Movie movie;

    @Column(name = "place")
    private int place;

    @Column(name = "price")
    private int price;

    @Column(name = "is_bought")
    private boolean isBought;

    public Ticket(User user, Movie movie, int place, int price, boolean isBought) {
        this.user = user;
        this.movie = movie;
        this.place = place;
        this.price = price;
        this.isBought = isBought;
    }
}