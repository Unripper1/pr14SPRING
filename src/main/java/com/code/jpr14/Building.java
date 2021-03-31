package com.code.jpr14;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Building {
    String creationDate="10.10.1983";
    String type="house";

    @Override
    public String toString() {
        return "Building{" +
                "creationDate='" + creationDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
