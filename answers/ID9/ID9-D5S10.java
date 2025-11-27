import java.util.ArrayList;
import java.util.List;

// --- Domain Classes ---
class Person {
    private boolean vegan;

    public Person(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegan() {
        return vegan;
    }
}

// --- Strategy Interfaces ---
interface FoodCostStrategy {
    double calculate(List<Person> people);
}

interface PhotoCostStrategy {
    double calculate(int numberOfPeople);
}

// --- Concrete Strategies ---
class StandardFoodCostStrategy implements FoodCostStrategy {
    public double calculate(List<Person> people) {
        int vegans = 0;
        for (Person p : people) {
            if (p.isVegan()) {
                vegans++;
            }
        }
        int nonVegans = people.size() - vegans;

        if (people.size() <= 500) {
            return nonVegans * 3 + vegans * 3.5;
        } else {
            return nonVegans * 2 + vegans * 2.5;
        }
    }
}

class StandardPhotoCostStrategy implements PhotoCostStrategy {
    public double calculate(int numberOfPeople) {
        if (numberOfPeople <= 600) {
            return numberOfPeople * 1.0;
        } else {
            return numberOfPeople * 0.75;
        }
    }
}

// --- Wedding Class ---
class Wedding {
    private String venue;
    private List<Person> people;
    private FoodCostStrategy foodCostStrategy;
    private PhotoCostStrategy photoCostStrategy;

    private Wedding(String venue, List<Person> people,
                    FoodCostStrategy foodCostStrategy,
                    PhotoCostStrategy photoCostStrategy) {
        this.venue = venue;
        this.people = people;
        this.foodCostStrategy = foodCostStrategy;
        this.photoCostStrategy = photoCostStrategy;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public double calculateFoodCost() {
        return foodCostStrategy.calculate(people);
    }

    public double calculatePhotoCost() {
        return photoCostStrategy.calculate(people.size());
    }

    public String getVenue() {
        return venue;
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }

    // --- Builder ---
    public static class Builder {
        private String venue;
        private List<Person> people = new ArrayList<>();
        private FoodCostStrategy foodCostStrategy = new StandardFoodCostStrategy();
        private PhotoCostStrategy photoCostStrategy = new StandardPhotoCostStrategy();

        public Builder setVenue(String venue) {
            this.venue = venue;
            return this;
        }

        public Builder addPerson(Person person) {
            this.people.add(person);
            return this;
        }

        public Builder setFoodCostStrategy(FoodCostStrategy strategy) {
            this.foodCostStrategy = strategy;
            return this;
        }

        public Builder setPhotoCostStrategy(PhotoCostStrategy strategy) {
            this.photoCostStrategy = strategy;
            return this;
        }

        public Wedding build() {
            return new Wedding(venue, people, foodCostStrategy, photoCostStrategy);
        }
    }
}

// --- Example Usage ---
class Main {
    public static void main(String[] args) {
        Wedding wedding = new Wedding.Builder()
                .setVenue("Sunset Beach")
                .addPerson(new Person(false))
                .addPerson(new Person(true))
                .build();

        System.out.println("Food Cost: " + wedding.calculateFoodCost());
        System.out.println("Photo Cost: " + wedding.calculatePhotoCost());
    }
}