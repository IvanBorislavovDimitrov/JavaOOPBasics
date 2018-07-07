import java.util.*;

public class Organism {

    private String name;

    private List<Cluster> clusters;

    private void setName(String name) {
        this.name = name;
    }

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedList<>();
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    public void addCluster(Cluster cluster) {
        this.clusters.add(cluster);
    }

    public String getName() {
        return this.name;
    }

    public Cluster activateCluster() {
        if (this.clusters.isEmpty()) {
            return null;
        }
        Cluster cluster = this.clusters.remove(0);
        this.clusters.add(cluster);

        return cluster;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Organism - ").append(this.getName()).append(System.lineSeparator());
        sb.append("--Clusters: ").append(this.clusters.size()).append(System.lineSeparator());
        int count = 0;
        for (Cluster cluster : this.clusters) {
            count += cluster.getNonNullableCells();
        }
        sb.append("--Cells: ").append(count);
        for (Cluster cluster : this.clusters) {
            sb.append(System.lineSeparator()).append("----Cluster ").append(cluster.getId());
            Cell[][] matrix = cluster.getCells();
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (matrix[row][col] != null) {
                        sb.append(System.lineSeparator())
                                .append(matrix[row][col].toString());
                    }
                }
            }
        }

        return sb.toString();
    }
}
