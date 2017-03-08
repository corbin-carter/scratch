package graph;

public class DetailProcessVertex implements Comparable {
    private String name;
    private int scrap;
    DetailProcessVertex predecessor;

    public DetailProcessVertex(String name, int scrap) {
        this.name = name;
        this.scrap = scrap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScrap() {
        return scrap;
    }

    public void setScrap(int scrap) {
        this.scrap = scrap;
    }

    public DetailProcessVertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(DetailProcessVertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return "graph.DetailProcessVertex{" +
                "name='" + name + '\'' +
                "scrap='" + scrap + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
       if (this.toString().equals(o.toString())) {
           return 0;
       } else {
           return 1;
       }
    }
}
