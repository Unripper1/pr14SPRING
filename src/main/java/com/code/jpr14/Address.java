package com.code.jpr14;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Address {
    String addressText="5 street N";
    String zipCode="98101";
    int id;
    @Override
    public String toString() {
        return "Address{" +
                "addressText='" + addressText + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
