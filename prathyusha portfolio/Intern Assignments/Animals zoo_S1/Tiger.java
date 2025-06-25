/**
 * Tiger class to represent the attributes of a Tiger
 *
 * @author Madipoju Prathyusha, 2322840, madi0061
 */
public class Tiger extends Animal {

    /**
     * Constructor to initialize the Tiger attributes
     *
     * @param name
     */
    public Tiger(String name) {
        super(name, "Tiger");
    }

    /**
     * provide food for the Tiger
     */
    @Override
    public void giveFood() {
        super.setHunger(super.getHunger() - 30);
        if (super.getHunger() < 0)
            super.setHunger(0);
        super.setThirst(super.getThirst() + 15);
        super.setBoredom(super.getBoredom() + 15);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 30);
    }

    /**
     * provide water for the Tiger
     */
    @Override
    public void giveWater() {
        super.setHunger(super.getHunger() +15);
        super.setThirst(super.getThirst() - 30);
        if (super.getThirst() < 0)
            super.setThirst(0);
        super.setBoredom(super.getBoredom() + 15);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 20);
    }

    /**
     * provide toy for the Tiger
     */
    @Override
    public void giveToy() {
        super.setHunger(super.getHunger() + 15);
        super.setThirst(super.getThirst() + 15);
        super.setBoredom(super.getBoredom() - 30);
        if (super.getBoredom() < 0)
            super.setBoredom(0);
        VirtualZoo.setTotalCost(VirtualZoo.getTotalCost() + 40);
    }
}
