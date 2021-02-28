package wsb.creatures;

import wsb.food.FoodType;

import java.sql.SQLException;

public class Pet extends Animal {
    public Pet(String species, FoodType foodType) throws SQLException {
        super(species, foodType);
    }
}