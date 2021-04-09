package com.code.jpr14;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@ToString
public class Address {
    @Column(name = "addresstext")
    String addressText;
    @Column(name = "zipcode")
    String zipCode;
    @Id
    @SequenceGenerator(name = "users_seq", sequenceName =
            "users_sequence", allocationSize = 1)
    @GeneratedValue(generator = "users_seq", strategy =
            GenerationType.SEQUENCE)

    Long id;
}
