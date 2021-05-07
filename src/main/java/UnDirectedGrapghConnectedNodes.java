import java.util.Arrays;
import java.util.Stack;

public class UnDirectedGrapghConnectedNodes {

     Vertex [] vertices;
     public static  final  int MAX_VERTEX = 7;
     public int nodeCount = 0;
     boolean hasEdge [][];
     boolean [] visited;
     Stack<Integer> stack;

    public UnDirectedGrapghConnectedNodes() {
        this.vertices = new Vertex[MAX_VERTEX];
        this.hasEdge = new boolean[MAX_VERTEX][MAX_VERTEX];
        this.visited = new boolean[MAX_VERTEX];
        this.stack = new Stack<Integer>();
    }

    public  void addVertex(char label){
        this.vertices[nodeCount++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        // since undirected  graph we say has edge for both
        this.hasEdge[start][end] = true;
        this.hasEdge[end][start] = true;
    }

    public void depthFirstSearch(int startNode) {
        this.stack.push(startNode);
        this.visited[startNode] = true;
        System.out.println("Visiting.. " + this.vertices[startNode].getLabel());

        while (!this.stack.isEmpty()) {
            Integer nodeToVisit = getUinVisitedAdjacentNodeId(this.stack.peek());
            if(nodeToVisit == -1){
                this.stack.pop();
            }else {
                System.out.println("Visiting.. " + this.vertices[nodeToVisit].getLabel());
                this.visited[nodeToVisit] = true;
                this.stack.push(nodeToVisit);
            }
        }
        System.out.println(Arrays.toString(visited));
    }

    public int getConnectedNodeCount(){
        int count = 0;
        System.out.println(Arrays.toString(this.visited));
        for(int start = 0; start < nodeCount; start++){

           // System.out.println(Arrays.toString(this.visited));
            if(!this.visited[start]){
                depthFirstSearch(start);
                count++;
            }
        }
        return count;
    }

    public int getUinVisitedAdjacentNodeId(int currentNodeId){
        for(int i = 0; i < nodeCount; i++){
            if(this.hasEdge[i][currentNodeId] && !this.visited[i]){
                return i;
            }
        }
        return -1;
    }

}
