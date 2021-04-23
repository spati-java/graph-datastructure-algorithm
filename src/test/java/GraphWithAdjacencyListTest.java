
import org.junit.Before;
import org.junit.Test;

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
    }


    @Test
    public void addNeighbours() throws Exception {

        this.graph.addNeighbours(1, 3);
        assertEquals(3, this.graph
                .getNeighbours(1)
                .get(0)
                .intValue());

    }

    @Test
    public void testGetNeighbours() {

        this.graph.addNeighbours(0, 4);

        List<Integer> neighbours = this.graph.getNeighbours(0);

        assertEquals(1, neighbours.size());
        assertEquals(4, neighbours.get(0).intValue());

    }

    @Test
    public void addNode() throws Exception {
        assertNotNull(this.graph);
        assertEquals(5, this.graph.getVertexList().size());
    }

    @Test
    public void displayNodeData() throws Exception {

    }


    @Test
    public void depthFirstSearch() throws Exception {

        this.graph.addNeighbours(0, 4);
        this.graph.addNeighbours(4, 3);
        this.graph.addNeighbours(3, 1);
        this.graph.addNeighbours(1, 2);

        char[] expectedArray = {'A', 'E', 'D', 'B', 'C'};
        List<Character> actualVisitOrder = this.graph.depthFirstSearch(0);

        assertNotNull(actualVisitOrder);

        char[] actualArray = new char[actualVisitOrder.size()];

        for (int i = 0; i < actualVisitOrder.size(); i++)
            actualArray[i] = actualVisitOrder.get(i);

        assertArrayEquals(expectedArray, actualArray);

    }

    @Test
    public void breadthFirstSearch() {

        this.graph.addNeighbours(0, 1);
        this.graph.addNeighbours(0, 4);
        this.graph.addNeighbours(0, 3);
        this.graph.addNeighbours(1, 2);
        this.graph.addNeighbours(3, 2);
        this.graph.addNeighbours(4, 3);

        List<Character> charList = this.graph.breadthFirstSearch(0);

        char[] expectedVisitOrder = {'A', 'B', 'E', 'D', 'C'};
        char[] actualVisitOrder = new char[charList.size()];

        for (int i = 0; i < charList.size(); i++)
            actualVisitOrder[i] = charList.get(i);

        assertArrayEquals(expectedVisitOrder, actualVisitOrder);

    }

}