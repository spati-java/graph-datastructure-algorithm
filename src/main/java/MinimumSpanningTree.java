import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumSpanningTree {

    public final int  MAX_VERTEX;
    public Vertex [] vertices;
    public boolean [][] hasEdge;
    public int currentNumOfVertices;
    public Stack<Integer> vertexIdStack;

    public MinimumSpanningTree(){
        this.MAX_VERTEX = 20;
        this.vertices = new Vertex[MAX_VERTEX];
        this.hasEdge = new boolean[MAX_VERTEX][MAX_VERTEX];
        this.currentNumOfVertices = 0;
        this.vertexIdStack = new Stack<Integer>();
    }

    public void addVertex(char label){
        this.vertices[currentNumOfVertices++] = new Vertex(label);
    }

    public  void addEdge(int start, int end){
        this.hasEdge[start][end] = true;
        // undirected graph
        this.hasEdge[end][start] = true;
    }

    // like the depth first search algo
    public List<String> mst(int start){

        this.vertices[start].setVisited(true);
        this.vertexIdStack.push(start);
        List<String> result = new ArrayList<String>();
        while(!this.vertexIdStack.isEmpty()){

            int currentId = this.vertexIdStack.peek();
            int tempId = getAdjacentUnVisitedVertex(currentId);

            if(tempId  == -1) {
                this.vertexIdStack.pop();
            }
            else {
                this.vertices[tempId].setVisited(true);
                this.vertexIdStack.push(tempId);
                result.add(this.vertices[currentId].getLabel() + "" + this.vertices[tempId].getLabel());
            }
        }

        return  result;
    }

    public int getAdjacentUnVisitedVertex(int start) {
        for(int i = 0; i < currentNumOfVertices; i++) {
            if( hasEdge[start][i] && !vertices[i].isVisited()){
                return i;
            }
        }
        return -1;
    }



}
