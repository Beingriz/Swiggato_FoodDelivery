package com.example.Swiggato.model;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.example.Swiggato.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customer")
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Size(min = 2, message ="{validation.name.size.too_short}")
    @Size(max = 40, message ="{validation.name.size.too_long}")
    String name;

    @Email
    @Column(unique = true)
    String email;

    String address;

    @OneToOne (mappedBy = "customer", cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    List<OrderEntity> orders = new ArrayList<>();


    @Column(unique = true, nullable = false)
    @Size(min = 10, max = 10)
    String phoneNo;


    @Enumerated(EnumType.STRING)
    Gender gender;

}
