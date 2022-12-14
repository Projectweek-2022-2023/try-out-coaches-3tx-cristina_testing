package domain.service;

import domain.model.Animal;
import util.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;

public class AnimalServiceDBSQL implements AnimalService {
    private final Connection connection;
    private final String schema;

    public AnimalServiceDBSQL() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void addAnimal(Animal animal) {
        String query = String.format("insert into %s.animal (name,type,food) values (?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getType());
            preparedStatement.setInt(3, animal.getFood());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public Animal findAnimalWithName(String name) {
        return null;
    }

    @Override
    public ArrayList<Animal> getAllAnimals() {
        ArrayList<Animal> animals = new ArrayList<>();
        String sql = String.format("SELECT * from %s.animal", schema);
        try {
            PreparedStatement statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String type = result.getString("type");
                int food = result.getInt("food");
                animals.add(new Animal(id, name, type, food));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return animals;
    }

    /**
     * Check the connection and reconnect when necessary
     * @return the connection with the db, if there is one
     */
    private Connection getConnection() {
        return this.connection;
    }
}
