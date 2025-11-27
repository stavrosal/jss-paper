interface FoodPricingStrategy {
    double calculateCost(List<Person> people);
}

class StandardFoodPricing implements FoodPricingStrategy {
    public double calculateCost(List<Person> people) {
        // Logic for <= 500 attendees
    }
}

class DiscountFoodPricing implements FoodPricingStrategy {
    public double calculateCost(List<Person> people) {
        // Logic for > 500 attendees
    }
}

class Wedding {
    FoodPricingStrategy foodPricingStrategy;
    PhotographyPricingStrategy photographyPricingStrategy;
    List<Person> people;

    public double calculateFoodCost() {
        return foodPricingStrategy.calculateCost(people);
    }
}
