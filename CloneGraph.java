import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node4);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);
        node3.neighbors.add(node1);
        node3.neighbors.add(node4);

        Set<Node> visited = new HashSet<>();

        // Call the printGraph function to print the cyclic graph
//        printGraph(node1, visited);

        cloneGraph(node1);
    }

    public static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        visited.add(node);

        System.out.print("Node " + node.val + " -> ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }

    static  Map<Node,Node> map = new HashMap<>();
    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        for(Node n : node.neighbors){
            if (map.containsKey(n)){
                newNode.neighbors.add(map.get(n));
            } else {
                newNode.neighbors.add(cloneGraph(n));
            }
        }
        Set<Node> visited = new HashSet<>();
        printGraph(newNode,visited);
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
