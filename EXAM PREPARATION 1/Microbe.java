public abstract class Microbe extends Cell {

    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    private void setVirulence(int virulence) {
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +  String.format("--------Health: %d | Virulence: %d | Energy: %d",
                this.getHealth(), this.getVirulence(), this.getEnergy());
    }
}
