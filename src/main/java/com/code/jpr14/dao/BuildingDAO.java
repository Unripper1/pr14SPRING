package com.code.jpr14.dao;
import com.code.jpr14.Address;
import com.code.jpr14.Building;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingDAO {
    private static int BUILDINGS_COUNT;
    private List<Building> buildings;


    {
        buildings = new ArrayList<>();
    }
    public void save(Building building){
        building.setId( BUILDINGS_COUNT);
        BUILDINGS_COUNT++;
        buildings.add(building);
    }
    public void del(int n){
        buildings.remove(n);
        for (Building a: buildings) {
            if(a.getId()>n)
                a.setId(a.getId()-1);
        }
        BUILDINGS_COUNT--;
    }

    public String show() {
        String str="";
        for (Building b:buildings) {
            str+=b.toString();
            str+="<br/>";
        }
        System.out.print(str);
        return str;
    }
    public List<Building> index() {
        return buildings;
    }
}