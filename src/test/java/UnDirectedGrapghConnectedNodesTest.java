import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by souravpati on 5/7/21.
 */
public class UnDirectedGrapghConnectedNodesTest {

    UnDirectedGrapghConnectedNodes graph;

    @Before
    public void setUp() throws Exception {
        this.graph = new UnDirectedGrapghConnectedNodes();
    }

    @Test
    public void addVertex() throws Exception {
        this.graph.addVertex('A');
        int nodeCount = this.graph.nodeCount;
        assertEquals(1, nodeCount);
    }

    @Test
    public void addEdge() throws Exception {

    }

    @Test
    public void depthFirstSearch() throws Exception {
        this.graph.addVertex('A'); // 0
        this.graph.addVertex('B'); // 1
        this.graph.addVertex('C'); // 2
        this.graph.addVertex('D'); // 3
        this.graph.addVertex('E'); // 4
        this.graph.addVertex('F'); // 5
        this.graph.addVertex('G'); // 6

        this.graph.addEdge(0, 1);
        this.graph.addEdge(0, 2);
        this.graph.addEdge(1, 3);
        this.graph.addEdge(2, 4);
        this.graph.addEdge(3, 5);
        this.graph.addEdge(4, 5);
        this.graph.addEdge(4, 6);
        this.graph.depthFirstSearch(0);
    }

    @Test
    public void getConnectedNodeCount() throws Exception {

        this.graph.addVertex('A'); // 0
        this.graph.addVertex('B'); // 1
        this.graph.addVertex('C'); // 2
        this.graph.addVertex('D'); // 3
        this.graph.addVertex('E'); // 4
        this.graph.addVertex('F'); // 5
        this.graph.addVertex('G'); // 6

        this.graph.addEdge(0, 1);
        this.graph.addEdge(0, 2);
        this.graph.addEdge(1, 3);
        this.graph.addEdge(4, 5);
        this.graph.addEdge(4, 6);

        int result = this.graph.getConnectedNodeCount();
        System.out.println(result);

    }

}