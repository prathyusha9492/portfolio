/**
 * Animal class to represent the attributes of a Animal
 *
 * @author Madipoju Prathyusha, 2322840, madi0061
 */
public abstract class Animal {
    private String name;
    private String species;
    private int hunger = 50;
    private int thirst = 50;
    private int boredom = 50;
    private String lastGivenItem;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    /**
     * returns the name of the Animal
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * assign name for the Animal
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the species of the Animal
     *
     * @return
     */
    public String getSpecies() {
        return species;
    }

    /**
     * assign species for the Animal
     *
     * @param species
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * returns the hunger value of the Animal
     *
     * @return
     */
    public int getHunger() {
        return hunger;
    }

    /**
     * assign hunger value for the Animal
     *
     * @param hunger
     */
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    /**
     * returns the thirst value of the Animal
     *
     * @return
     */
    public int getThirst() {
        return thirst;
    }

    /**
     * assign thirst value for the Animal
     *
     * @param thirst
     */
    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    /**
     * returns the boredom value of the Animal
     *
     * @return
     */
    public int getBoredom() {
        return boredom;
    }

    /**
     * assign boredom value for the Animal
     *
     * @param boredom
     */
    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public String getLastGivenItem() {
        return lastGivenItem;
    }

    public void setLastGivenItem(String lastGivenItem) {
        this.lastGivenItem = lastGivenItem;
    }

    /**
     * checks whether the animal is dead or not based on the thirst value
     *
     * @return
     */
    public boolean isDead() {
        return (this.hunger > 100 || this.thirst > 100 || this.boredom > 100);
    }

    public abstract void giveFood();
    public abstract void giveWater();
    public abstract void giveToy();

    public String toString() {
        String statusMessage = isDead() ? "Name = " + getName() + " (Dead)\n" : "Name = " + getName() + "\n";
        statusMessage += "Species = " + getSpecies() + "\n";
        statusMessage += "Hunger = " + getHunger() + "\n";
        statusMessage += "Thirst = " + getThirst() + "\n";
        statusMessage += "Boredom = " + getBoredom() + "\n";
        return statusMessage;
    }
}
