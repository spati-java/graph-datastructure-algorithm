import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DirectedGraphStronglyConnectedTest {

    DirectedGraphStronglyConnected graph;

    @Before
    public void setUp() throws Exception {
        graph = new DirectedGraphStronglyConnected(4);
    }

    @Test
    public void addVertex() throws Exception {
        this.graph.addVertex("Chloee");
    }

    @Test
    public void addEdge() throws Exception {

    }

    @Test
    public void dfs() throws Exception {
    }

    @Test
    public void isStronglyConnectedGrapgh() throws Exception {

        this.graph.addVertex("0");
        this.graph.addVertex("1");
        this.graph.addVertex("2");
        this.graph.addVertex("3");

        this.graph.addEdge(0,1);
        this.graph.addEdge(1,2);
        this.graph.addEdge(2,0);
        this.graph.addEdge(0,3);
        this.graph.addEdge(3,2);


        boolean expected = true;
        boolean actual = this.graph.isStronglyConnectedGraph();
        assertEquals(expected, actual);

    }

}