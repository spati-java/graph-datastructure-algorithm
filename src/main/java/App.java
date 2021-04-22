
public class App {
    public static void main(String[] args) {

        GraphWithAdjacencyMatrix graphWithAdjacencyMatrix = new GraphWithAdjacencyMatrix();
        graphWithAdjacencyMatrix.addVertex('A');
        graphWithAdjacencyMatrix.addVertex('B');
        graphWithAdjacencyMatrix.addVertex('C');
        graphWithAdjacencyMatrix.addVertex('D');
        graphWithAdjacencyMatrix.addVertex('E');
        graphWithAdjacencyMatrix.addVertex('F');

        graphWithAdjacencyMatrix.addEdge(0,1);
        graphWithAdjacencyMatrix.addEdge(1,2);
        graphWithAdjacencyMatrix.addEdge(0,3);
        graphWithAdjacencyMatrix.addEdge(3,4);
        graphWithAdjacencyMatrix.addEdge(4,5);
        graphWithAdjacencyMatrix.addEdge(1,3);

        System.out.println("Visits using DFS");

       // graphWithAdjacencyMatrix.depthFirstSearch(0);

        System.out.println("Visits using  B.F.S");
        graphWithAdjacencyMatrix.breadthFirstSearch(0);


    }
}
