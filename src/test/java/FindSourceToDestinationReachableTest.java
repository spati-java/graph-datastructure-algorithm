import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class FindSourceToDestinationReachableTest {

    FindSourceToDestinationReachable graph ;

    @Before
    public void setup(){
        graph = new FindSourceToDestinationReachable(5);

    }

    @Test
    public void addEdge() throws Exception {

    }

    @Test
    public void isreachaAbleFromToDesti() throws Exception {

        this.graph.addEdge(0,1);
        this.graph.addEdge(1,2);
        this.graph.addEdge(2,0);
        this.graph.addEdge(3,2);
        this.graph.addEdge(3,0);
        this.graph.addEdge(2,4);


        boolean actual = this.graph.isReachaAbleFromToDesti(0,3);
        boolean expected = true;
        assertEquals(expected, actual);

    }

    @Test
    public void dfs() throws Exception {
    }

}