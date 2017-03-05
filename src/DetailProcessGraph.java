import java.util.*;

public class DetailProcessGraph {
    private Map<String, List<DetailProcessEdge>> myGraph = new HashMap<>();

    public DetailProcessGraph(List<DetailProcessVertex> processList) {
        for (DetailProcessVertex vertex : processList) {
            myGraph.put(vertex.getName(), new ArrayList<DetailProcessEdge>());
        }
    }

    public void addEdge(String processName, DetailProcessEdge edge) {
        List<DetailProcessEdge> edgeList = myGraph.get(processName);
        edgeList.add(edge);
    }

    public List<DetailProcessEdge> getEdgeList(String processName) {
        return myGraph.get(processName);
    }

    public void breadthFirstTraverse(DetailProcessVertex origin) {
        Set<DetailProcessVertex> vertexSet = new HashSet<>();
        Queue<DetailProcessVertex> vertexQueue = new PriorityQueue<>();

        origin.setPredecessor(null);
        vertexSet.add(origin);
        vertexQueue.add(origin);

        while (!vertexQueue.isEmpty()) {
            DetailProcessVertex currentVertex = vertexQueue.remove();

            for (DetailProcessEdge edge : getEdgeList(currentVertex.getName())) {
                DetailProcessVertex vertex = edge.getDestination();
                System.out.println(vertex);
                if (!vertexSet.contains(vertex)) {
                    vertexSet.add(vertex);
                    vertex.setPredecessor(currentVertex);
                    vertexQueue.add(vertex);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String key : myGraph.keySet()) {

            List<DetailProcessEdge> edgeList = getEdgeList(key);
            for (DetailProcessEdge edge : edgeList) {
                sb.append(edge.getSource());
                sb.append(" -> ");
                sb.append(edge.getDestination());
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        DetailProcessVertex process1 = new DetailProcessVertex("p1");
        DetailProcessVertex process2 = new DetailProcessVertex("p2");
        DetailProcessVertex process3 = new DetailProcessVertex("p3");
        DetailProcessVertex process4 = new DetailProcessVertex("p4");
        DetailProcessVertex process5 = new DetailProcessVertex("p5");

        List<DetailProcessVertex> processList = new ArrayList<>();
        processList.add(process1);
        processList.add(process2);
        processList.add(process3);
        processList.add(process4);
        processList.add(process5);

        DetailProcessGraph myGraph = new DetailProcessGraph(processList);

        DetailProcessEdge edge_1_3 = new DetailProcessEdge(process1, process3);
        DetailProcessEdge edge_2_3 = new DetailProcessEdge(process2, process3);
        DetailProcessEdge edge_3_4 = new DetailProcessEdge(process3, process4);
        DetailProcessEdge edge_3_5 = new DetailProcessEdge(process3, process5);

        myGraph.addEdge(process1.getName(), edge_1_3);
        myGraph.addEdge(process2.getName(), edge_2_3);
        myGraph.addEdge(process3.getName(), edge_3_4);
        myGraph.addEdge(process3.getName(), edge_3_5);

        //System.out.print(myGraph.toString());
        myGraph.breadthFirstTraverse(process1);
    }
}
