import java.util.*;

public class GraphWithAdjacencyList {

    private List<List<Integer>> neighbours;

    private List<Vertex> vertexList;

    // for depth first search
    private Stack<Integer> stack;

    // for breadth first search
    private Queue<Integer> queue;

    public GraphWithAdjacencyList(int numberOfNodes) {

        this.vertexList = new ArrayList<Vertex>();
        this.neighbours = new ArrayList<List<Integer>>();
        this.stack = new Stack<Integer>();
        this.queue = new LinkedList<Integer>();

        for (int i = 0; i < numberOfNodes; i++) {
            neighbours.add(i, new ArrayList<Integer>());
        }

    }

    public void addNeighbours(int startNodeId, int endNodeId) {

        if (this.vertexList.isEmpty())
            throw new RuntimeException("Please create node first");

        this.neighbours.get(startNodeId).add(endNodeId);
    }

    public void addNode(char label) {
        this.vertexList.add(new Vertex(label));
    }

    public void displayNodeData(int nodeId) {
        Vertex vertex = vertexList.get(nodeId);
        System.out.println(vertex.getLabel());
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public List<Integer> getNeighbours(int nodeId) {
        return neighbours.get(nodeId);
    }


    public List<Character> depthFirstSearch(int startNodeId) {

        List<Character> resultList = new ArrayList<Character>();

        this.vertexList.get(startNodeId).setVisited(true);
        this.stack.push(startNodeId);

        while (!this.stack.isEmpty()) {

            int tempNodeId = this.stack.pop();
            resultList.add(this.vertexList.get(tempNodeId).getLabel());

            for (Integer neighbourId : getNeighbours(tempNodeId)) {
                Vertex vertex = this.vertexList.get(neighbourId);
                if (!vertex.isVisited()) {
                    this.stack.push(neighbourId);
                    vertex.setVisited(true);
                }
            }
        }

        return resultList;
    }


    public List<Character> breadthFirstSearch(int startNodeId) {

        List<Character> result = new ArrayList<Character>();

        this.vertexList.get(startNodeId).setVisited(true);
        this.queue.offer(startNodeId);
        this.displayNodeData(startNodeId);

        while (!this.queue.isEmpty()) {

            Integer tempNodeId = this.queue.poll();
            result.add(this.vertexList.get(tempNodeId).getLabel());

            for (Integer neighbourId : getNeighbours(tempNodeId)) {
                Vertex vertex = this.vertexList.get(neighbourId);
                if (!vertex.isVisited()) {
                    vertex.setVisited(true);
                    displayNodeData(neighbourId);
                    this.queue.offer(neighbourId);
                }
            }
        }

        return result;
    }
}