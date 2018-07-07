public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.setRows(rows);
        this.setCols(cols);
        this.cells = new Cell[rows][cols];
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setRows(int rows) {
        if (rows <= 0) {
            throw new IllegalArgumentException();
        }

        this.rows = rows;
    }

    private void setCols(int cols) {
        if (cols <= 0) {
            throw new IllegalArgumentException();
        }

        this.cols = cols;
    }

    public int getNonNullableCells() {
        int count = 0;
        for (Cell[] cell : this.cells) {
            for (Cell cell1 : cell) {
                if (cell1 != null) {
                    count++;
                }
            }
        }

        return count;
    }

    public void addCell(Cell cell) {
        if (cell.getPositionRow() < 0 || cell.getPositionRow() >= this.getRows() || cell.getPositionCol() < 0 ||
                cell.getPositionCol() >= this.getCols()) {
            throw new IllegalArgumentException();
        }
        this.cells[cell.getPositionRow()][cell.getPositionCol()] = cell;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
