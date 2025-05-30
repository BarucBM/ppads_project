package com.TCC.domain.customer;

import com.TCC.domain.cart.Cart;
import com.TCC.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "customers")
@Entity()
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private User user;

    private String name;

    private String phone;

    @OneToOne
    private Cart cart;
}
