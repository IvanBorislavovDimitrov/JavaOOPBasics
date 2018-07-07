public abstract class Cell {

    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.setHealth(health);
        this.setPositionRow(positionRow);
        this.setPositionCol(positionCol);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    public void setPositionRow(int positionRow) {
        if (positionRow < 0) {
            throw new IllegalArgumentException();
        }
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    public void setPositionCol(int positionCol) {
        if (positionCol < 0) {
            throw new IllegalArgumentException();
        }
        this.positionCol = positionCol;
    }

    public abstract int getEnergy();

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]", this.getId(), this.getPositionRow(), this.getPositionCol());
    }
}

