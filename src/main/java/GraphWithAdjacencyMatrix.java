import java.util.*;

public class GraphWithAdjacencyMatrix {

    private final int MAX_VERTEX = 20;
    private Vertex[] vertexList;

    // this is to track if there is  an edge between two vertices
    private boolean[][] hasEdge;
    private int vertexId;
    private Stack<Integer> vertexIdStack;
    private Queue<Integer> vertexIdQueue;

    public GraphWithAdjacencyMatrix() {
        this.vertexList = new Vertex[MAX_VERTEX];
        this.hasEdge = new boolean[MAX_VERTEX][MAX_VERTEX];
        this.vertexId = 0;
        this.vertexIdStack = new Stack<Integer>();
        this.vertexIdQueue = new LinkedList<Integer>();
    }

    public void addVertex(char label) {
        vertexList[vertexId++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        hasEdge[start][end] = true;
        hasEdge[end][start] = true;
    }

    public List<Integer> depthFirstSearch(int start) {

        // we need a starting point , assuming it is given
        this.vertexList[start].setVisited(true);

        displayVertex(start);
        vertexIdStack.push(start);

        List<Integer> visitOrder = new LinkedList<Integer>();
        visitOrder.add(start);

        while (!this.vertexIdStack.isEmpty()) {

            int vertexId = getUnvisitedAdjacentVertexId(this.vertexIdStack.peek());

            if (vertexId == -1)
                this.vertexIdStack.pop();
            else {
                this.vertexList[vertexId].setVisited(true);
                displayVertex(vertexId);
                this.vertexIdStack.push(vertexId);
                visitOrder.add(vertexId);

            }

        }

        return visitOrder;
    }

    public List<Integer> breadthFirstSearch(int vertexId){
        this.vertexList[vertexId].setVisited(true);
        displayVertex(vertexId);
        this.vertexIdQueue.offer(vertexId);
        List<Integer> visitOrder = new ArrayList<Integer>();

        while (!vertexIdQueue.isEmpty()) {

            int tempVertexId_1 = vertexIdQueue.poll();
            visitOrder.add(tempVertexId_1);
            while(getUnvisitedAdjacentVertexId(tempVertexId_1) != -1){
                int tempVertexId_2 = getUnvisitedAdjacentVertexId(tempVertexId_1);
                this.vertexList[tempVertexId_2].setVisited(true);
                displayVertex(tempVertexId_2);
                this.vertexIdQueue.offer(tempVertexId_2);
            }
        }

        return visitOrder;
    }

    public char displayVertex(int vertexId) {
        System.out.println("Visiting vertexId " + vertexId + " " + this.vertexList[vertexId].getLabel());
        return this.vertexList[vertexId].getLabel();

    }

    public int getUnvisitedAdjacentVertexId(int vertexId) {

        for (int j = 0; j < this.vertexId; j++) {
            if (this.hasEdge[vertexId][j] && !this.vertexList[j].isVisited()) {
                return j;
            }
        }
        return -1;
    }
}
