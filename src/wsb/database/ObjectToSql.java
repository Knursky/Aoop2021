package wsb.database;

import wsb.creatures.Human;
import wsb.creatures.Pet;
import wsb.food.FoodType;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ObjectToSql {
    public String insert(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getFields();
        String name = object.getClass().getName();
        Object[] fieldValues = new Object[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            fieldValues[i] = fields[i].get(object);
        }
        String fieldsAsStrings = Arrays.stream(fields).map(Field::getName).collect(Collectors.joining(", "));
        String fieldValuesAsString = Arrays.stream(fieldValues).map(o -> o == null ? "null" : o.toString()).collect(Collectors.joining(", "));
        return "INSERT INTO " + name + " ( " + fieldsAsStrings + " ) VALUES ( " + fieldValuesAsString + " )";
    }

    public static void main(String[] args) throws SQLException {
        Human human = new Human(2, 2, FoodType.ALL);
        Pet pet = new Pet("Dog", FoodType.MEAT);
        human.pet = pet;
        ObjectToSql converter = new ObjectToSql();
        try {
            System.out.println(converter.insert(human));
            System.out.println(converter.insert(pet));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}