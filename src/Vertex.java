
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mehdi on 29/05/2017.
 */
public class Vertex {
    private String name;
    private boolean isVisited = false;
    private List<Vertex> child;
    private Vertex mother;

    public Vertex(String name){
        this.name = name;
        this.child = new ArrayList<Vertex>( );
    }

    public void makeChild (Vertex vertex){
        this.child.add(vertex);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void setChild(List<Vertex> child) {
        this.child = child;
    }

    public void setMother(Vertex mother) {
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public List<Vertex> getChild() {
        return child;
    }

    public Vertex getMother() {
        return mother;
    }

    @Override
    public String toString() {
        return this.name ;
    }
}
