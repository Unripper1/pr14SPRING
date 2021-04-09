package com.code.jpr14.dao;
import com.code.jpr14.Address;
import com.code.jpr14.Building;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingDAO {
    private static final String URL="jdbc:postgresql://localhost:5432/CityDB";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "159753";
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private static int BUILDINGS_COUNT;
    private List<Building> buildings;


    {
        buildings = new ArrayList<>();
    }
    public void save(Building building){
        try {
            Statement statement = connection.createStatement();
            String SQLMAX="SELECT MAX(id) as max FROM buildings";
            ResultSet resultSet = statement.executeQuery(SQLMAX);
            int count=0;
            while(resultSet.next()) {
                count = resultSet.getInt("max");
            }
            System.out.println(count);
            String SQL = "INSERT INTO buildings VALUES(" + ++count + ",'" + building.getCreationDate() +
                    " ', '" + building.getType() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void del(int n) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL="DELETE FROM buildings WHERE id="+n;
        statement.executeUpdate(SQL);
    }

    public List<Building> index() {
        List<Building> buildingsIND = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM buildings";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Building building = new Building();
                building.setId(resultSet.getInt("id"));

                building.setCreationDate(resultSet.getString("creationdate"));
                building.setType(resultSet.getString("type"));

                buildingsIND.add(building);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return buildingsIND;
    }
}