/**
 * Tiger class to represent the attributes of a Giraffe
 *
 * @author Madipoju Prathyusha, 2322840, madi0061
 */
public class Giraffe extends Animal {

    /**
     * Constructor to initialize the Giraffe attributes
     *
     * @param name
     */
    public Giraffe(String name) {
        super(name, "Giraffe");
    }


    /**
     * provide food for the Giraffe
     */
    @Override
    public void giveFood() {
        super.setHunger(super.getHunger() - 50);
        if (super.getHunger() < 0)
            super.setHunger(0);
        super.setThirst(super.getThirst() + 30);
        super.setBoredom(super.getBoredom() + 20);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 100);
    }

    /**
     * provide water for the Giraffe
     */
    @Override
    public void giveWater() {
        super.setHunger(super.getHunger() + 20);
        super.setThirst(super.getThirst() - 50);
        if (super.getThirst() < 0)
            super.setThirst(0);
        super.setBoredom(super.getBoredom() + 30);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
    }

    /**
     * provide toy for the Giraffe
     */
    @Override
    public void giveToy() {
        super.setHunger(super.getHunger() + 30);
        super.setThirst(super.getThirst() + 10);
        super.setBoredom(super.getBoredom() - 40);
        if (super.getBoredom() < 0)
            super.setBoredom(0);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 75);
    }
}
