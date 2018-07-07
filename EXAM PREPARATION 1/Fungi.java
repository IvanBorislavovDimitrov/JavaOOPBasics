public class Fungi extends Microbe {

    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return (this.getHealth() + this.getVirulence()) / 4;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
