import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class MinimumSpanningTreeTest {



    MinimumSpanningTree minimumSpanningTree;

    @Before
    public void init(){
        this.minimumSpanningTree = new MinimumSpanningTree();

    }
    @Test
    public void addVertex() throws Exception {
        this.minimumSpanningTree.addVertex('A');
        this.minimumSpanningTree.addVertex('B');
        assertEquals(this.minimumSpanningTree.currentNumOfVertices,2);
    }

    @Test
    public void addEdge() throws Exception {
        this.minimumSpanningTree.addVertex('A');
        this.minimumSpanningTree.addVertex('B');
        this.minimumSpanningTree.addEdge(0,1);
        assertEquals(this.minimumSpanningTree.hasEdge[0][1] , true);
        assertEquals(this.minimumSpanningTree.hasEdge[1][0] , true);
    }

    @Test
    public void getAdjacentUnVisitedVertex() throws Exception {
        this.minimumSpanningTree.addVertex('A');
        this.minimumSpanningTree.addVertex('B');
    }

    @Test
    public void mst() throws Exception {
        this.minimumSpanningTree.addVertex('A');
        this.minimumSpanningTree.addVertex('B');
        this.minimumSpanningTree.addVertex('C');
        this.minimumSpanningTree.addVertex('D');
        this.minimumSpanningTree.addVertex('E');

        this.minimumSpanningTree.addEdge(0,1);
        this.minimumSpanningTree.addEdge(0,3);
        this.minimumSpanningTree.addEdge(0,2);
        this.minimumSpanningTree.addEdge(0,4);
        this.minimumSpanningTree.addEdge(1,2);
        this.minimumSpanningTree.addEdge(1,3);
        this.minimumSpanningTree.addEdge(1,4);
        this.minimumSpanningTree.addEdge(2,3);
        this.minimumSpanningTree.addEdge(2,4);
        this.minimumSpanningTree.addEdge(3,4);

        List<String>  reuslt = this.minimumSpanningTree.mst(0);

        assertEquals(4, reuslt.size());



    }


}