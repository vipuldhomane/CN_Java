
package Module3.Graphs;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        // doing this to sort the objects based on weight in ascending order
        return this.weight - o.weight;
    }

}

public class KruskalsAlgo {
    private static Edge[] kruskalsAlgo(Edge[] edges, int n) {
        Arrays.sort(edges);
        Edge mst[] = new Edge[n - 1];
        // create a parent array of size n initially having itself as parent.
        int parent[] = new int[n];
        for (int j = 0; j < n; j++) {
            parent[j] = j;
        }
        int count = 0, i = 0;
        while (count != n - 1) {
            Edge currentEdge = edges[i++];
            int v1Parent = findParent(currentEdge.v1, parent);
            int v2Parent = findParent(currentEdge.v2, parent);
            // proceed only if parents are different
            if (v1Parent != v2Parent) {
                // we are including the edge
                mst[count] = currentEdge;
                count++;
                // update the parent index
                parent[v1Parent] = v2Parent;
            }
        }
        return mst;
    }

    private static int findParent(int v, int parent[]) {
        // check if if parent and index is same
        // if yes then simply return the index;
        if (v == parent[v]) {
            return v;
        }
        // if above case is not met then find the parent recursively
        // find the parent of latest parent
        return findParent(parent[v], parent);

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();

        // create an edges array of number of edges
        Edge edges[] = new Edge[e];
        for (int i = 0; i < e; i++) {
            // System.out.println("Enter values for Edge " + i);
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            Edge edge = new Edge(v1, v2, weight);
            edges[i] = edge;
        }
        Edge mst[] = kruskalsAlgo(edges, n);
        for (int i = 0; i < mst.length; i++) {
            // print the smaller virtex first
            if (mst[i].v1 < mst[i].v2) {
                System.out.println(mst[i].v1 + " " + mst[i].v2 + " " + mst[i].weight);
            } else {
                System.out.println(mst[i].v2 + " " + mst[i].v1 + " " + mst[i].weight);

            }
        }
    }
}
