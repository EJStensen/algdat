package Oving13;

import java.util.ArrayList;

public class Heap {

    private ArrayList<Node> list;
    private boolean dijkstra;
    private int right(int i) { return 2 * i + 2; }
    private int left(int i) { return 2 * i + 1; }

    public Heap(boolean dijkstra) {
        this.list = new ArrayList<Node>();
        this.dijkstra = dijkstra;
    }

    public void insert(Node item) {
        list.add(item);
        int i = list.size() - 1;
        int parent = parent(i);
        
        if (dijkstra == true) {
            while (parent != i && ((Predecessor)list.get(i).d).distance < ((Predecessor)list.get(parent).d).distance) {
                swap(i, parent);
                i = parent;
                parent = parent(i);
            }
        } else {
            while (parent != i && ((Predecessor)list.get(i).d).estimatedDistance < ((Predecessor)list.get(parent).d).estimatedDistance) {
                swap(i, parent);
                i = parent;
                parent = parent(i);
            }
        }
    }

    public void buildHeap() {
        for (int i = list.size() / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    public Node extractMin() {
        if (list.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        } else if (list.size() == 1) {
            Node min = list.remove(0);
            return min;
        }
        
        Node min = list.get(0);
        Node lastItem = list.remove(list.size() - 1);
        list.set(0, lastItem);
        minHeapify(0);
        return min;
    }

    private void minHeapify(int i) {
        int left = left(i);
        int right = right(i);
        int smallest = -1;
        
        if (dijkstra == true) {
            if (left <= list.size() - 1 && ((Predecessor)list.get(left).d).distance < ((Predecessor)list.get(i).d).distance) {
                smallest = left;
            } else {
                smallest = i;
            }
            if (right <= list.size() - 1 && ((Predecessor)list.get(right).d).distance < ((Predecessor)list.get(smallest).d).distance) {
                smallest = right;
            }
        } else {
            if (left <= list.size() - 1 && ((Predecessor)list.get(left).d).estimatedDistance < ((Predecessor)list.get(i).d).estimatedDistance) {
                smallest = left;
            } else {
                smallest = i;
            }
            if (right <= list.size() - 1 && ((Predecessor)list.get(right).d).estimatedDistance < ((Predecessor)list.get(smallest).d).estimatedDistance) {
                smallest = right;
            }
        }
        
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public Node getMin() {
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    private int parent(int i) {
        if (i % 2 == 1) {
            return i / 2;
        }
        return (i - 1) / 2;
    }

    private void swap(int i, int parent) {
        Node temp = list.get(parent);
        list.set(parent, list.get(i));
        list.set(i, temp);
    }

    boolean contains(Node n){
        return list.contains(n);
    }
}