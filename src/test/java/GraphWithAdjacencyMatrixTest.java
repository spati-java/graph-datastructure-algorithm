import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class GraphWithAdjacencyMatrixTest {


    GraphWithAdjacencyMatrix graphWithAdjacencyMatrix;

    @Before
    public void init(){
        graphWithAdjacencyMatrix = new GraphWithAdjacencyMatrix();
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
    }

    @org.junit.Test
    public void breadthFirstSearch() throws Exception {

        assertNotNull(graphWithAdjacencyMatrix);
        List<Integer> visitOrderList = this.graphWithAdjacencyMatrix.breadthFirstSearch(0);
        assertEquals('D' , this.graphWithAdjacencyMatrix.displayVertex(visitOrderList.get(2)));
    }

    @Test
    public void depthFirstSearch() throws Exception {

        List<Integer> visitOrderList = this.graphWithAdjacencyMatrix.depthFirstSearch(0);
        System.out.println(visitOrderList);
        assertEquals(6 , visitOrderList.size());
        assertEquals('C' , this.graphWithAdjacencyMatrix.displayVertex(visitOrderList.get(2)));

    }



}