package graph;

public class DetailProcessEdge {
    private DetailProcessVertex source;
    private DetailProcessVertex destination;

    public DetailProcessEdge(DetailProcessVertex source, DetailProcessVertex destination) {
        this.source = source;
        this.destination = destination;
    }

    public DetailProcessVertex getSource() {
        return source;
    }

    public void setSource(DetailProcessVertex source) {
        this.source = source;
    }

    public DetailProcessVertex getDestination() {
        return destination;
    }

    public void setDestination(DetailProcessVertex destination) {
        this.destination = destination;
    }
}
