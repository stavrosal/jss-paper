import java.util.ArrayList;
import java.util.List;

// Person.java
public class Person {
    private boolean vegan;

    public Person(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isVegan() {
        return vegan;
    }
}

// Wedding.java
public class Wedding {
    private String venue;
    private List<Person> people;

    public Wedding(String venue) {
        this.venue = venue;
        this.people = new ArrayList<>();
    }

    public void addPerson(Person p) {
        this.people.add(p);
    }

    public String getVenue() {
        return venue;
    }

    public List<Person> getPeople() {
        return people;
    }
}

// CateringService.java
public class CateringService {
    public double calculateFoodCost(List<Person> people) {
        int vegans = 0;
        for (Person p : people) {
            if (p.isVegan()) {
                vegans++;
            }
        }

        int nonVegans = people.size() - vegans;
        double total;

        if (people.size() <= 500) {
            total = nonVegans * 3 + vegans * 3.5;
        } else {
            total = nonVegans * 2 + vegans * 2.5;
        }

        return total;
    }
}

// PhotographyService.java
public class PhotographyService {
    public double calculatePhotosCost(List<Person> people) {
        int count = people.size();
        if (count <= 600) {
            return count * 1.0;
        } else {
            return count * 0.75;
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Wedding wedding = new Wedding("Seaside Villa");
        wedding.addPerson(new Person(false)); // Non-vegan
        wedding.addPerson(new Person(true));  // Vegan

        CateringService cateringService = new CateringService();
        PhotographyService photoService = new PhotographyService();

        double foodCost = cateringService.calculateFoodCost(wedding.getPeople());
        double photoCost = photoService.calculatePhotosCost(wedding.getPeople());

        System.out.println("Food Cost: " + foodCost + "€");
        System.out.println("Photography Cost: " + photoCost + "€");
    }
}
