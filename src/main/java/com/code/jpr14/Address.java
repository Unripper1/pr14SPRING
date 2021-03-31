package com.code.jpr14;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Address {
    String addressText="5 street N";
    String zipCode="98101";

    @Override
    public String toString() {
        return "Address{" +
                "addressText='" + addressText + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
