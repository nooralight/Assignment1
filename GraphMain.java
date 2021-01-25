public class GraphMain {
    public static void main(String[] args) {
        Graph g = new Graph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.addNeighbor(2);
        node2.addNeighbor(3);
        node4.addNeighbor(3);
        g.addNode(node1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        System.out.println(g);
    }
}
