public class WhiteBloodCell extends BloodCell {

    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getEnergy() {
        return (this.getHealth() + this.getSize()) * 2;
    }

    @Override
    public String toString() {
            return super.toString() + System.lineSeparator() +  String.format("--------Health: %d | Size: %d | Energy: %d",
                    this.getHealth(), this.getSize(), this.getEnergy());
    }
}
