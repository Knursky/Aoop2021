package wsb.food;

public enum FoodType {
    MEAT(0.7),
    CROPS(0.3),
    ALL(0.5);

    double foodToBodyRatio;

    FoodType(double foodToBodyRatio) {
        this.foodToBodyRatio = foodToBodyRatio;
    }

    public double getFoodToBodyRatio() {
        return foodToBodyRatio;
    }
}