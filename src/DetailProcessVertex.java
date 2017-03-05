
public class DetailProcessVertex {
    private String name;
    private boolean visited;
    DetailProcessVertex predecessor;

    public DetailProcessVertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public DetailProcessVertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(DetailProcessVertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return "DetailProcessVertex{" +
                "name='" + name + '\'' +
                ", visited=" + visited +
                ", predecessor=" + predecessor +
                '}';
    }
}
