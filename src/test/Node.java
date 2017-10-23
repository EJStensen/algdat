package test;

public class Node {
    private int connection;
    private Node nextNode;

    public Node(int connection) {
        this.connection = connection;
    }

    public int getConnection() {
        return connection;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void addConnection(int connection) {
        if (nextNode == null) nextNode = new Node(connection);
        else nextNode.addConnection(connection);
    }
}