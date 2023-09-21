import java.util.HashSet;
import java.util.Set;

public class Number_of_Connected_Components_in_an_Undirected_Graph {

    private int count = 0;
    public static void main(String[] args) {
        Number_of_Connected_Components_in_an_Undirected_Graph numberOfConnectedComponentsInAnUndirectedGraph =
                new Number_of_Connected_Components_in_an_Undirected_Graph();
        int[][] edges = {{0,1},{0,2}};
        int[][] matrix = {{0,1},{1,2},{2, 3},{4, 5}};
        numberOfConnectedComponentsInAnUndirectedGraph.countComponents(6,matrix);
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind2 uf = new UnionFind2(n);
        for (int[] edge: edges) {
            uf.union(edge[0],edge[1]);
        }
        System.out.println(uf.numOfComponets);
        return uf.numOfComponets;
    }
}

class UnionFind2 {
    private int[] parents;
    private int[] size;
    int numOfComponets = 0;

    public UnionFind2(int n) {
        parents = new int[n];
        size = new int[n];
        numOfComponets = n;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        if (node1Parent == node2Parent)
            return false;

        if (size[node1Parent] > size[node2Parent]) {
            parents[node2Parent] = node1Parent;
            size[node1Parent] += size[node2Parent];
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += size[node1Parent];
        }
        numOfComponets--;
        return true;
    }

    public int find(int cur) {
        int root = cur;
        while (root != parents[root]) {
            root = parents[root];
        }
        // Path Compression
        while (cur != root) {
            int preParent = parents[cur];
            parents[cur] = root;
            cur = preParent;
        }
        return root;
    }

    public int findComponentSize(int cur) {
        int parent = find(cur);
        return size[parent];
    }
}