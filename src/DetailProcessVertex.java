
public class DetailProcessVertex implements Comparable {
    private String name;
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
