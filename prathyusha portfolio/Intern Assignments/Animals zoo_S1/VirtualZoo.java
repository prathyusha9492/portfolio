import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Madipoju Prathyusha, 2322840, madi0061
 */
public class VirtualZoo {

    private final Scanner scan;
    private ArrayList<String> animalNames;
    private static int totalCost;
    private static final String[] WEEKDAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private static final Set<String> VALID_ITEMS = Set.of("water", "food", "toy");

    /**
     * return the total cost
     *
     * @return
     */
    public static int getTotalCost() {
        return totalCost;
    }

    /**
     * assign the total cost
     *
     * @param totalCost
     */
    public static void setTotalCost(int totalCost) {
        VirtualZoo.totalCost = totalCost;
    }

    public VirtualZoo() {
        scan = new Scanner(System.in);
        animalNames = new ArrayList<>();
    }

    public void beginSimulation() {
        displayWelcome();
        ArrayList<Animal> zooAnimals = animalSelection();
        weekCycle(zooAnimals);
    }

    /**
     * Defines the Welcome Message text
     */
    public void displayWelcome() {
        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                     Welcome to the Virtual Zoo!                      |");
        System.out.println("|     Use this application to simulate running a zoo over one week     |");
        System.out.println("|           This program is intended for zoo employees only!           |");
        System.out.println("+----------------------------------------------------------------------+");
    }

    /**
     * validate number of animals given by user and return if it is valid
     *
     * @return
     */
    public int askNumberAnimals() {
        int numberOfAnimals;

        while (true) {
            try {
                System.out.println("How many animals are at your zoo?");
                numberOfAnimals = Integer.parseInt(scan.nextLine());
                if (numberOfAnimals > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number of animals");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number of animals");
            }
        }

        return numberOfAnimals;
    }

    /**
     * validate the animal name given by user and returns it if it is unique
     *
     * @param id
     * @return
     */
    public String askAnimalName(int id) {
        String animalName;

        while (true) {
            System.out.println("What is the name of animal #" + id + "?");
            animalName = scan.nextLine();
            if (animalNames.contains(animalName)) {
                System.out.println("That name is already taken");
            } else {
                animalNames.add(animalName);
                break;
            }
        }

        return animalName;
    }

    /**
     * validate the animal species given by user and returns it if it is a valid species
     *
     * @param name
     * @return
     */
    public Animal askAnimalSpecies(String name) {
        Animal zooAnimal;

        while (true) {
            System.out.println("What is the species of " + name + "?");
            String animalSpecies = scan.nextLine().trim().toLowerCase();

            zooAnimal = createAnimal(name, animalSpecies);

            if (zooAnimal != null) {
                break;
            }
        }
        return zooAnimal;
    }

    private Animal createAnimal(String name, String animalSpecies) {
        switch (animalSpecies) {
            case "tiger":
                return new Tiger(name);
            case "giraffe":
                return new Giraffe(name);
            case "hippo":
                return new Hippo(name);
            case "panda":
                return new Panda(name);
            case "monkey":
                return new Monkey(name);
            default:
                System.out.println("That is not a valid species");
                return null;
        }
    }

    /**
     * return array list of Animal attributes
     *
     * @return
     */
    public ArrayList<Animal> animalSelection() {

        ArrayList<Animal> animals = new ArrayList<>();
        int animalsCount = askNumberAnimals();
        System.out.println();

        for (int i = 1; i <= animalsCount; i++) {
            animals.add(askAnimalSpecies(askAnimalName(i)));
        }
        return animals;
    }

    /**
     * the item can be received from the user to give to the animal
     *
     * @param animal
     */
    public void askItem(Animal animal) {
        String input;
        do {
            System.out.printf("What item would you like to give to %s?%n", animal.getName());
            input = scan.nextLine().trim().toLowerCase();

            if (!VALID_ITEMS.contains(input)) {
                System.out.println("That is not a valid item");
            } else if (input.equalsIgnoreCase(animal.getLastGivenItem())) {
                System.out.println("You cannot give the same item as yesterday");
            }

        } while (!VALID_ITEMS.contains(input) || input.equalsIgnoreCase(animal.getLastGivenItem()));

        handleItem(animal, input);

        if (animal.isDead()) {
            System.out.println(animal.getName() + " has died");
            totalCost += 1000;
        }
        animal.setLastGivenItem(input);
    }

    private static void handleItem(Animal animal, String item) {
        switch (item) {
            case "water":
                animal.giveWater();
                break;
            case "food":
                animal.giveFood();
                break;
            case "toy":
                animal.giveToy();
                break;
        }
    }

    /**
     * display week and ask items for each animal for all the days
     * @param zooAnimals
     */
    public void weekCycle(ArrayList<Animal> zooAnimals) {
        for (String currentDay : WEEKDAYS) {
            System.out.printf("%nThe current day is %s%n%n", currentDay);

            zooAnimals.forEach(System.out::println);

            zooAnimals.stream()
                    .filter(animal -> !animal.isDead())
                    .forEach(this::askItem);
        }
        System.out.println("\nTotal week cost = $" + getTotalCost());
    }
}
