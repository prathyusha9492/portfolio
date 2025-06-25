/**
 * Tiger class to represent the attributes of a Monkey
 *
 * @author Madipoju Prathyusha, 2322840, madi0061
 */
public class Monkey extends Animal {

    /**
     * Constructor to initialize the Monkey attributes
     *
     * @param name
     */
    public Monkey(String name) {
        super(name, "Monkey");
    }

    /**
     * provide food for the Monkey
     */
    @Override
    public void giveFood() {
        super.setHunger(super.getHunger() - 30);
        if (super.getHunger() < 0)
            super.setHunger(0);
        super.setThirst(super.getThirst() + 10);
        super.setBoredom(super.getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
    }

    /**
     * provide water for the Monkey
     */
    @Override
    public void giveWater() {
        super.setHunger(super.getHunger() + 10);
        super.setThirst(super.getThirst() - 40);
        if (super.getThirst() < 0)
            super.setThirst(0);
        super.setBoredom(super.getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
    }

    /**
     * provide toy for the Monkey
     */
    @Override
    public void giveToy() {
        super.setHunger(super.getHunger() + 10);
        super.setThirst(super.getThirst() + 10);
        super.setBoredom(super.getBoredom() - 15);
        if (super.getBoredom() < 0)
            super.setBoredom(0);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 15);
    }
}
