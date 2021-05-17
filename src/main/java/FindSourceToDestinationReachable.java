import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindSourceToDestinationReachable {

    public List<List<Integer>> neihbours;
    public boolean [] visited;
    int nodes;
    Stack<Integer> stack;


    public FindSourceToDestinationReachable(int nodes) {

            this.nodes = nodes;
            this.neihbours = new ArrayList<List<Integer>>();
            this.visited = new boolean[nodes];
            this.stack = new Stack<Integer>();

            for(int i = 0; i < nodes; i++) {
                    this.neihbours.add(i, new ArrayList<Integer>());
            }
    }

    public void addEdge(int start, int end){
        this.neihbours.get(start).add(end);
        //this.neihbours.get(end).add(start);
    }

    public boolean isReachaAbleFromToDesti(int source, int destination){

        System.out.println(Arrays.toString(this.visited));

               this.dfs(source);

        System.out.println(Arrays.toString(this.visited));
               return this.visited[destination];

    }

    public void dfs(int start) {
        this.visited[start] = true;
        this.stack.push(start);

        while(!this.stack.isEmpty()){



            Integer id = this.stack.pop();
            System.out.println("visiting.. " + id);

            List<Integer> neighbourIds = this.neihbours.get(id);
            for(Integer neighbourId: neighbourIds){
                if(!this.visited[neighbourId]){
                    this.visited[neighbourId] = true;
                    this.stack.push(neighbourId);
                }
            }
        }
    }


}
