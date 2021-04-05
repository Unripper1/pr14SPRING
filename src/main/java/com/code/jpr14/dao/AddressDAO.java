package com.code.jpr14.dao;
import com.code.jpr14.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressDAO {
    private static int ADDRESS_COUNT;
    private List<Address> addresses;


    {
        addresses = new ArrayList<Address>();
    }
    public void save(Address address){
        address.setId( ADDRESS_COUNT);
        ADDRESS_COUNT++;
        addresses.add(address);
    }
    public void del(int n){
        addresses.remove(n);
        for (Address a: addresses) {
            if(a.getId()>n)
                a.setId(a.getId()-1);
        }
        ADDRESS_COUNT--;
    }

    public List<Address> index() {
        return addresses;
    }
}