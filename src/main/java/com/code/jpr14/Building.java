package com.code.jpr14;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "buildings")
@Getter
@Setter
public class Building {
    @Id
    @SequenceGenerator(name = "users_seq", sequenceName =
            "users_sequence", allocationSize = 1)
    @GeneratedValue(generator = "users_seq", strategy =
            GenerationType.SEQUENCE)
    Long id;
    @Column(name = "creationDate")
    String creationDate="10.10.1983";
    @Column(name = "type")
    String type="house";

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
