/**
 * Tiger class to represent the attributes of a Panda
 *
 * @author Madipoju Prathyusha, 2322840, madi0061
 */
public class Panda extends Animal {

    /**
     * Constructor to initialize the Panda attributes
     *
     * @param name
     */
    public Panda(String name) {
        super(name, "Panda");
    }

    /**
     * provide food for the Panda
     */
    @Override
    public void giveFood() {
        super.setHunger(super.getHunger() - 25);
        if (super.getHunger() < 0)
            super.setHunger(0);
        super.setThirst(super.getThirst() + 15);
        super.setBoredom(super.getBoredom() - 5);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 70);
    }

    /**
     * provide water for the Panda
     */
    @Override
    public void giveWater() {
        super.setHunger(super.getHunger() + 40);
        super.setThirst((super.getThirst() - 80) < 0 ? 0 : (super.getThirst() - 80));
        super.setBoredom(super.getBoredom() + 10);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 5);
    }

    /**
     * provide toy for the Panda
     */
    @Override
    public void giveToy() {
        super.setHunger(super.getHunger() + 40);
        super.setThirst(super.getThirst() + 15);
        super.setBoredom(super.getBoredom() - 40);
        if (super.getBoredom() < 0)
            super.setBoredom(0);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
    }
}
