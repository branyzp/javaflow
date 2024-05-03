package dev.branyzp.flow.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

// @Entity annotation is used here to mark a Java class as a JPA Entity representing a Database Table in a relational DB
@Entity
@Table(name = "users")
// @Data annotation is used by Lombok to generate getters, setters, constructor etc to reduce boilerplate code
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // @Id annotation is to indicate that the field below is used as primary key of current entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstname;

    private String lastname;

    private String password;

    @CreatedDate
    private LocalDate createdDt;

}
