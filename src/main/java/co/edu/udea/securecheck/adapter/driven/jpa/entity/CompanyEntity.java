package co.edu.udea.securecheck.adapter.driven.jpa.entity;

import co.edu.udea.securecheck.domain.utils.Generated;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nit", nullable = false)
    private String nit;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nick", nullable = false)
    private String nick;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Column(name = "contact_phone", nullable = false)
    private String contactPhone;

    @Column(name = "register_date", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private UserEntity user;
}
