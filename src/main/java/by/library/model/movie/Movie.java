package by.library.model.movie;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NonNull private String name;

    @Column(name = "date_time")
    @NonNull private Timestamp date;
}
