import java.util.Stack;

public class Graph {

    private final int MAX_VERTEX = 20;
    private Vertex [] vertexList ;
    private int [][] adjMat;
    private int vertexId;

    private Stack<Integer> vertexStack;

    public Graph(){
        this.vertexList = new Vertex[MAX_VERTEX];
        this.adjMat = new int[MAX_VERTEX][MAX_VERTEX];
        this.vertexId = 0;
        this.vertexStack = new Stack<Integer>();
    }

    public void addVertex(char label){
        vertexList[vertexId++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void depthFirstSearch(int start) {

        // we need a starting point , assuming it is given

        this.vertexList[start].setVisited(true);

        displayVertex(start);
        vertexStack.push(start);

        while(!this.vertexStack.isEmpty()) {

            int vertexId = getUnvisitedAdjacentVertexId(this.vertexStack.peek());

            if(vertexId == -1)
                this.vertexStack.pop();
            else{
                this.vertexList[vertexId].setVisited(true);
                displayVertex(vertexId);
                this.vertexStack.push(vertexId);
            }

        }

    }

    public void displayVertex(int vertexId) {
        System.out.println("Visiting vertexId " + vertexId);
        System.out.println(this.vertexList[vertexId].getLabel());
    }

    public int getUnvisitedAdjacentVertexId(int vertexId) {

        for(int j = 0; j < this.vertexId; j++){
            if(this.adjMat[vertexId][j] == 1 && !this.vertexList[j].isVisited()){
                return j;
            }
        }
        return -1;
    }
}
