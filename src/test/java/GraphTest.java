import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class GraphTest {


    Graph graph ;

    @Before
    public void init(){
        graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(1,3);
    }

    @org.junit.Test
    public void breadthFirstSearch() throws Exception {

        assertNotNull(graph);
        List<Integer> visitOrderList = this.graph.breadthFirstSearch(0);
        assertEquals('D' , this.graph.displayVertex(visitOrderList.get(2)));
    }

    @Test
    public void depthFirstSearch() throws Exception {

        List<Integer> visitOrderList = this.graph.depthFirstSearch(0);
        System.out.println(visitOrderList);
        assertEquals(6 , visitOrderList.size());
        assertEquals('C' , this.graph.displayVertex(visitOrderList.get(2)));

    }



}