package by.library.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_role",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"}))
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "role_id")
    private Long roleId;

}
