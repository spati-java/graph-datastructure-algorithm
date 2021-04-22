import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class GraphWithAdjacencyListTest {


    private GraphWithAdjacencyList graph;

    @Before
    public void init() {

        this.graph = new GraphWithAdjacencyList(20);

        this.graph.addNode('A');
        this.graph.addNode('B');
        this.graph.addNode('C');
        this.graph.addNode('D');
        this.graph.addNode('E');


        this.graph.addNeighbours(0, 4);
        this.graph.addNeighbours(4, 3);
        this.graph.addNeighbours(3, 1);
        this.graph.addNeighbours(1, 2);

    }


    @Test
    public void addNeighbours() throws Exception {

        this.graph.addNeighbours(1, 7);
        assertEquals(7, this.graph
                .getNeighbours(1)
                .get(2)
                .intValue());

    }

    @Test
    public void addNode() throws Exception {
        assertNotNull(this.graph);
        assertEquals(8, this.graph.getVertexList().size());
    }

    @Test
    public void displayNodeData() throws Exception {

    }

    @Test
    public void testGetNeighbours() {

        List<Integer> neighbours = this.graph.getNeighbours(0);

        assertEquals(3, neighbours.size());
        assertEquals(5, neighbours.get(0).intValue());

    }


    @Test
    public void depthFirstSearch() throws Exception {

        char[] expectedArray = {'A', 'E', 'D', 'B', 'C'};
        List<Character> actualVisitOrder = this.graph.depthFirstSearch(0);

        assertNotNull(actualVisitOrder);

        char[] actualArray = new char[actualVisitOrder.size()];

        for (int i = 0; i < actualVisitOrder.size(); i++)
            actualArray[i] = actualVisitOrder.get(i);

        assertArrayEquals(expectedArray, actualArray);

    }

}