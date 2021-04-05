package com.code.jpr14;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Getter
@Setter
public class Building {
    int id;
    String creationDate="10.10.1983";
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
