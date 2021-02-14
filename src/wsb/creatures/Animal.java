package wsb.creatures;



import java.io.File;
import java.sql.SQLException;

public class Animal implements Feedable, Comparable<Animal> {

    public enum FoodType {
        MEAT,
        CROPS,
        ALL
    }

    final FoodType foodType;
    final String species;
    private Double weight;
    public String name;
    File pic;


    private static Double NEW_DOG_WEIGHT = 4.0;
    private static Double NEW_LION_WEIGHT = 39.2;
    private static Double NEW_OTHER_ANIMAL_WEIGHT = 5.3;

    private static Double DEFAULT_FEED_WEIGHT = 1.0;

    public Animal(String species) {
        System.out.println("we created new Animal");
        this.species = species;


        switch (species) {
            case "dog": {
                weight = NEW_DOG_WEIGHT;
                this.foodType = FoodType.ALL;
                break;
            }
            case "lion": {
                weight = NEW_LION_WEIGHT;
                this.foodType = FoodType.MEAT;
                break;
            }
            default: {
                weight = NEW_OTHER_ANIMAL_WEIGHT;
                this.foodType = FoodType.CROPS;
                break;
            }
        }
        try {
            this.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Animal(String species, Double weight, FoodType FoodType) {
        this.foodType = FoodType;
        this.weight = weight;
        this.species = species;
        try {
            this.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void feed() {
        feed(DEFAULT_FEED_WEIGHT);
    }

    public void feed(Double foodWeight) {
        if (weight == 0) {
            System.out.println("too late, " + name + " is dead");
        } else {
            switch (this.foodType){
                case MEAT: weight += 0.7 * foodWeight;
                break;
                case ALL: weight += 0.5 * foodWeight;
                break;
                case CROPS: weight += 0.3 * foodWeight;
            }
            weight += foodWeight;
            System.out.println(name + " says thx for food");
        }
    }

    public void takeForAWalk() {
        if (weight == 0.0) {
            System.out.println("you can't walk the street with dead animal you freak");
        } else if (weight > 3.0) {
            --weight;
            System.out.println(name + " says thx for a walk");
        } else if (weight > 1.0) {
            --weight;
            System.out.println(name + " says thx for a walk but I'm hungry");
        } else {
            weight = 0.0;
            System.out.println(name + " died");
        }
    }

    Double getWeight() {
        return weight;
    }

    protected void kill() {
        System.out.println("byeeeeeeeeeeeeee");
        this.weight = 0.0;
    }

    public String toString() {
        return "Hi I'm an Animal " + this.species + " " + this.name;
    }

    @Override
    public int compareTo(Animal o) {
        return this.species.compareTo(o.species);
    }

    public void save() throws SQLException {
        String sql = "insert into animal values ('" + this.species + "','" + this.name + "'," + this.weight + ");";
        System.out.println(sql);
       // Connector.executeSQL(sql);
    }
}
