import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HealthManager {

    private List<Organism> organisms;

    public HealthManager() {
        this.organisms = new ArrayList<>();
    }

    public String checkCondition(String organismName) {
        Optional<Organism> organismOpt = this.organisms.stream().filter(o -> o.getName().equals(organismName)).findFirst();
        return organismOpt.map(Organism::toString).orElse(null);
    }

    public String createOrganism(String name) {
        if (this.organisms.stream().anyMatch(o -> o.getName().equals(name))) {
            return String.format("Organism %s already exists", name);
        }
        Organism organism = new Organism(name);

        this.organisms.add(organism);

        return String.format("Created organism %s", name);
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        Optional<Organism> organismOpt = this.organisms.stream().filter(o -> o.getName().equals(organismName)).findFirst();
        if (organismOpt.isPresent()) {
            if (organismOpt.get().getClusters().stream().anyMatch(c -> c.getId().equals(id))) {
                return "";
            }

            Cluster cluster = new Cluster(id, rows, cols);
            organismOpt.get().addCluster(cluster);
            return String.format("Organism %s: Created cluster %s", organismName, id);
        }

        return "";
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId,
                          int health, int positionRow, int positionCol, int additionalProperty) {
        Optional<Organism> opt = this.organisms.stream().filter(o -> o.getName().equals(organismName)).findFirst();
        if (!opt.isPresent()) {
            return "";
        }
        Organism organism = opt.get();
        Optional<Cluster> cl = organism.getClusters().stream().filter(c -> c.getId().equals(clusterId)).findFirst();
        if (!cl.isPresent()) {
            return "";
        }
        Cluster cluster = cl.get();
        try {
            switch (cellType) {
                case "WhiteBloodCell":
                    Cell whiteBloodCell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    cluster.addCell(whiteBloodCell);
                    return String.format("Organism %s: Created cell %s in cluster %s",
                            organismName, cellId, clusterId);
                case "RedBloodCell":
                    Cell redBloodCell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    cluster.addCell(redBloodCell);
                    return String.format("Organism %s: Created cell %s in cluster %s",
                            organismName, cellId, clusterId);
                case "Bacteria":
                    Cell bacteria = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                    cluster.addCell(bacteria);
                    return String.format("Organism %s: Created cell %s in cluster %s",
                            organismName, cellId, clusterId);
                case "Fungi":
                    Cell fungi = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                    cluster.addCell(fungi);
                    return String.format("Organism %s: Created cell %s in cluster %s",
                            organismName, cellId, clusterId);
                case "Virus":
                    Cell virus = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                    cluster.addCell(virus);
                    return String.format("Organism %s: Created cell %s in cluster %s",
                            organismName, cellId, clusterId);
            }
        } catch (IllegalArgumentException e) {
        }

        return "";
    }

    public String activateCluster(String organismName) {
        Optional<Organism> organismOrg = this.organisms.stream().filter(o -> o.getName().equals(organismName)).findFirst();
        if (!organismOrg.isPresent()) {
            return "";
        }
        Organism organism = organismOrg.get();
        Cluster cluster = organism.activateCluster();
        if (cluster == null) {
            return "";
        }
        Cell[][] matrix = cluster.getCells();
        Cell fighter = null;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (fighter == null) {
                    fighter = matrix[row][col];
                    matrix[row][col] = null;
                } else {
                    if (fighter instanceof BloodCell) {
                        if (matrix[row][col] != null) {
                            fighter.setHealth(fighter.getHealth() + matrix[row][col].getHealth());
                            fighter.setPositionRow(row);
                            fighter.setPositionCol(col);
                            matrix[row][col] = null;
                        }
                    } else if (fighter instanceof Microbe) {
                        int fighterStrike = fighter.getEnergy();
                        if (matrix[row][col] != null) {
                            while (true) {
                                matrix[row][col].setHealth(matrix[row][col].getHealth() - fighterStrike);
                                if (matrix[row][col].getHealth() > 0) {
                                    fighter.setHealth(fighter.getHealth() - matrix[row][col].getEnergy());
                                    if (fighter.getHealth() <= 0) {
                                        fighter = matrix[row][col];
                                        matrix[row][col] = null;
                                        break;
                                    }
                                } else {
                                    matrix[row][col] = null;
                                    break;
                                }
                            }
                            if (fighter != null) {
                                fighter.setPositionRow(row);
                                fighter.setPositionCol(col);
                            }
                        }
                    }
                }
            }
        }

        if (fighter != null) {
            matrix[fighter.getPositionRow()][fighter.getPositionCol()] = fighter;
        }

        return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName,
                cluster.getId(), cluster.getNonNullableCells());
    }
}
