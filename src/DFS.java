
import java.util.*;

public class DFS {


    private Stack<Vertex> stack;

    public DFS() {
        this.stack = new Stack<>();
    }

    public void run(Vertex root , Sorted temp){

        stack.add(root);
        root.setVisited(true);


        while (  !stack.isEmpty()  ){

            Vertex vertex = stack.pop();
            System.out.print(vertex + " ");
            temp.add(Integer.parseInt(String.valueOf(vertex)));
            for (Vertex v : vertex.getChild()){
                if ( !v.isVisited() ){
                    v.setVisited(true);
                    v.setMother(vertex);
                    stack.push(v);

                }
            }
        }


    }
}
