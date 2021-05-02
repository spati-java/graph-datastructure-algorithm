import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by souravpati on 5/2/21.
 */
public class ConnectedGraphTest {



    @Test
    public void addNode() throws Exception {
    }

    @Test
    public void addEdge() throws Exception {
    }

    @Test
    public void dfs() throws Exception {
    }

    @Test
    public void isConnectedGrapgh() throws Exception {
        ConnectedGraph graph = new ConnectedGraph(7);
        graph.addNode("John");
        graph.addNode("Sarah");
        graph.addNode("Conny");
        graph.addNode("Lucy");
        graph.addNode("Molly");
        graph.addNode("Watson");
        graph.addNode("Olive");


        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);

        boolean expected = true;
        boolean actual = graph.isConnectedGrapgh(0);

        assertEquals(expected, actual);

    }

}