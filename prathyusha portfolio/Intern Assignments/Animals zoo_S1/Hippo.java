/**
 * Tiger class to represent the attributes of a Hippo
 *
 * @author Madipoju Prathyusha, 2322840, madi0061
 */
public class Hippo extends Animal {

    /**
     * Constructor to initialize the Hippo attributes
     *
     * @param name
     */
    public Hippo(String name) {
        super(name, "Hippo");
    }

    /**
     * provide food for the Hippo
     */
    @Override
    public void giveFood() {
        super.setHunger(super.getHunger() - 25);
        if (super.getHunger() < 0)
            super.setHunger(0);
        super.setThirst(super.getThirst() + 5);
        super.setBoredom(super.getBoredom() + 25);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);
    }

    /**
     * provide water for the Hippo
     */
    @Override
    public void giveWater() {
        super.setHunger(super.getHunger() + 5);
        super.setThirst(super.getThirst() - 25);
        if (super.getThirst() < 0)
            super.setThirst(0);
        super.setBoredom(super.getBoredom() + 25);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 50);
    }

    /**
     * provide toy for the Hippo
     */
    @Override
    public void giveToy() {
        super.setHunger(super.getHunger() + 20);
        super.setThirst(super.getThirst() + 20);
        super.setBoredom(super.getBoredom() - 50);
        if (super.getBoredom() < 0)
            super.setBoredom(0);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
    }
}
