package SpringStudy.entity;

import jakarta.persistence.*;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@Entity(name = "USERS")
@Table(name="USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;

    private String password;

    private String role;
}
