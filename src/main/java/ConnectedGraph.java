import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/** A Grapgh is considered connected if all the nodes are reachable from any given node */
public class ConnectedGraph {
    int numONodes;
    List<List<Integer>> neighBours;
    List<Vertex> nodes;
    boolean [] visited;
    Stack<Integer> nodeIdstack;

    ConnectedGraph(int numONodes) {
        this.numONodes = numONodes;
        this.neighBours = new ArrayList<List<Integer>>();
        this.visited = new boolean[numONodes];
        this.nodes = new ArrayList<Vertex>();
        this.nodeIdstack = new Stack<Integer>();

        for(int i = 0; i < numONodes; i++){
            this.neighBours.add(i, new ArrayList<Integer>());
        }
    }

    public void addNode(String name){
        this.nodes.add(new Vertex(name));
    }
    public void addEdge(int start, int end){
        this.neighBours.get(start).add(end);
        this.neighBours.get(end).add(start);
    }

    public void dfs(int startNode){
        this.nodes.get(startNode).setVisited(true);
        this.visited[startNode] = true;
        this.nodeIdstack.push(startNode);

        while(!this.nodeIdstack.isEmpty()) {
            int tempNodeId = this.nodeIdstack.pop();
            for(int neighbourId : this.neighBours.get(tempNodeId)){
                if(!this.visited[neighbourId]){
                    this.nodeIdstack.push(neighbourId);
                    this.visited[neighbourId] = true;
                }
            }
        }
    }

    public boolean isConnectedGrapgh(int startNode) {
        // call dfs to visit all the nodes first;
        dfs(startNode);
        for(int i = 0; i < this.numONodes; i++){
            if(!this.visited[i])
                return false;
        }
        return true;
    }


}
