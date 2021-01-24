public class Node {
    private int id;
    private List<Integer> neighbors;

    public Node(int id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(int e) {
        this.neighbors.add(e);
    }

    public int getId() {
        return id;
    }

    public List<Integer> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", neighbors=" + neighbors +
                "}"+ "\n";
    }
}
