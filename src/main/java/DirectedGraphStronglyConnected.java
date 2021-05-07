

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * A directed graph is considered as strongly connected if
 * starting at any node it is possible to visit all the nodes in the gra
 */
public class DirectedGraphStronglyConnected {

    private List<Vertex> vertices;
    private List<List<Integer>> neighbours;
    private int numOfNodes;
    private Stack<Integer> vertexIdStack;
    private boolean[] visited;

    DirectedGraphStronglyConnected(int numOfNodes) {
        this.numOfNodes = numOfNodes;
        this.neighbours = new ArrayList<List<Integer>>();
        this.vertices = new ArrayList<Vertex>();
        this.vertexIdStack = new Stack<Integer>();
        this.visited = new boolean[this.numOfNodes];
        initializeGraph();
    }

    public void addVertex(String name) {
        this.vertices.add(new Vertex(name));
    }

    public void addEdge(int start, int end) {
        this.neighbours.get(start).add(end);
    }

    private void initializeGraph() {
        for (int i = 0; i < this.numOfNodes; i++) {
            this.neighbours.add(i, new ArrayList<Integer>());
        }
    }

    public void dfs(int start) {
        this.vertexIdStack.push(start);
        this.visited[start] = true;

        while (!this.vertexIdStack.isEmpty()) {

            int tempId = this.vertexIdStack.pop();
            for (Integer neighbourId : this.neighbours.get(tempId)) {

                if (!this.visited[neighbourId]) {
                    this.visited[neighbourId] = true;
                    // this.vertices.get(neighbourId).setVisited(true);
                    this.vertexIdStack.push(neighbourId);
                }
            }
        }
    }

    public boolean isStronglyConnectedGraph() {

        for (int i = 0; i < this.numOfNodes; i++) {
            dfs(i);
            for (int j = 0; j < this.numOfNodes; j++) {
                if (!this.visited[j]) {
                    return false;
                }
            }
            Arrays.fill(this.visited, false);
        }

        return true;
    }


}
