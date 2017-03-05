
public class DetailProcessVertex {
    private String name;

    public DetailProcessVertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DetailProcessVertex{" +
                "name='" + name + '\'' +
                '}';
    }
}
