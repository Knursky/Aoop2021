package wsb.database;
import wsb.annotations.Mapped;
import wsb.creatures.Human;
import wsb.creatures.Pet;
import wsb.food.FoodType;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectToSql {
    public String insert(Object object) throws IllegalAccessException {
        List<Field> fields = Arrays.stream(object.getClass().getFields())
                .filter(field -> field.isAnnotationPresent(Mapped.class))
                .collect(Collectors.toList());
        String name = object.getClass().getName();
        Object[] fieldValues = new Object[fields.size()];
        for (int i = 0; i < fields.size(); i++) {
            fields.get(i).setAccessible(true);
            fieldValues[i] = fields.get(i).get(object);
        }
        String fieldsAsStrings = fields
                .stream()
                .map(Field::getName)
                .collect(Collectors.joining(", "));
        String fieldValuesAsString = Arrays.stream(fieldValues).map(o -> o == null ? "null" : o.toString()).collect(Collectors.joining(", "));
        return "INSERT INTO " + name + " ( " + fieldsAsStrings + " ) VALUES ( " + fieldValuesAsString + " )";
    }

    public static void main(String[] args) {
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