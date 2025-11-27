public interface CostStrategy {
    double calculateCost(List<Person> people);
}


public class FoodCostStrategy implements CostStrategy {
    @Override
    public double calculateCost(List<Person> people) {
        int vegans = 0;
        for (Person p : people) {
            if (p.isVegan()) vegans++;
        }
        int nonVegans = people.size() - vegans;

        if (people.size() <= 500) {
            return nonVegans * 3 + vegans * 3.5;
        } else {
            return nonVegans * 2 + vegans * 2.5;
        }
    }
}


public class PhotoCostStrategy implements CostStrategy {
    @Override
    public double calculateCost(List<Person> people) {
        int size = people.size();
        return size <= 600 ? size * 1.0 : size * 0.75;
    }
}


public class Wedding {
    private String venue;
    private List<Person> people = new ArrayList<>();

    private CostStrategy foodCostStrategy;
    private CostStrategy photoCostStrategy;

    public Wedding(CostStrategy foodCostStrategy, CostStrategy photoCostStrategy) {
        this.foodCostStrategy = foodCostStrategy;
        this.photoCostStrategy = photoCostStrategy;
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public double calculateFoodCost() {
        return foodCostStrategy.calculateCost(people);
    }

    public double calculatePhotoCost() {
        return photoCostStrategy.calculateCost(people);
    }
}


public class Wedding {
    private String venue;
    private List<Person> people = new ArrayList<>();

    private CostStrategy foodCostStrategy;
    private CostStrategy photoCostStrategy;

    public Wedding(CostStrategy foodCostStrategy, CostStrategy photoCostStrategy) {
        this.foodCostStrategy = foodCostStrategy;
        this.photoCostStrategy = photoCostStrategy;
    }

    public void addPerson(Person p) {
        people.add(p);
    }

    public double calculateFoodCost() {
        return foodCostStrategy.calculateCost(people);
    }

    public double calculatePhotoCost() {
        return photoCostStrategy.calculateCost(people);
    }
}
