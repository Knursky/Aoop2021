package wsb.creatures;

import wsb.food.FoodType;

public class FarmAnimal extends Animal implements Edible {

    public FarmAnimal(String species, FoodType foodType) {
        super(species, foodType);
    }

    @Override
    public void beEaten() throws Exception {
        this.kill();
        System.out.println("that was yuammy");
    }
}