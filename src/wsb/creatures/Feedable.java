package wsb.creatures;
import wsb.food.FoodType;
public interface Feedable {

    void feed();

    void feed(Double foodWeight, FoodType foodType);

}