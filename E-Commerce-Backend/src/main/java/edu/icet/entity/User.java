package edu.icet.entity;

import edu.icet.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Please Enter Your Name...!")
    private String name;

    @Column(unique = true)
    @NotBlank(message = "Please Enter Your Email...!")
    private String email;

    @NotBlank(message = "Please Enter Your Password...!")
    private String password;

    @Column(name = "phone_number")
    @NotBlank(message = "Please Enter Your Phone Number...!")
    private String phoneNumber;

    private UserRole role;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem>orderItemList;

    @OneToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    private Address address;

    @Column(name = "created_at")
    private final LocalDateTime createdAt=LocalDateTime.now();

}
