import java.util.*;

public class DetailProcessGraph {
    private Map<String, List<DetailProcessEdge>> myGraph = new HashMap<>();

    public DetailProcessGraph(List<DetailProcessVertex> processList) {
        for (DetailProcessVertex vertex : processList) {
            myGraph.put(vertex.getName(), new ArrayList<>());
        }
    }

    public void addEdge(String processName, DetailProcessEdge edge) {
        List<DetailProcessEdge> edgeList = myGraph.get(processName);
        edgeList.add(edge);
    }

    public List<DetailProcessEdge> getEdgeList(String processName) {
        return myGraph.get(processName);
    }

    public void breadthFirstTraversal(DetailProcessVertex origin) {
        Set<DetailProcessVertex> visitedSet = new HashSet<>();
        Queue<DetailProcessVertex> vertexQueue = new PriorityQueue<>();

        System.out.println(origin);
        origin.setPredecessor(null);
        visitedSet.add(origin);
        vertexQueue.add(origin);

        while (!vertexQueue.isEmpty()) {
            DetailProcessVertex currentVertex = vertexQueue.remove();

            for (DetailProcessEdge edge : getEdgeList(currentVertex.getName())) {
                DetailProcessVertex vertex = edge.getDestination();
                if (!visitedSet.contains(vertex)) {
                    System.out.println(vertex);
                    visitedSet.add(vertex);
                    vertex.setPredecessor(currentVertex);
                    vertexQueue.add(vertex);
                }
            }
        }
    }

    public void depthFirstTraversal(DetailProcessVertex origin) {
        Set<DetailProcessVertex> visitedSet = new HashSet<>();
        Stack<DetailProcessVertex> vertexStack = new Stack<>();

        origin.setPredecessor(null);
        vertexStack.add(origin);

        while (!vertexStack.isEmpty()) {
            DetailProcessVertex currentVertex = vertexStack.pop();

            if (!visitedSet.contains(currentVertex)) {
                System.out.println(currentVertex);
                visitedSet.add(currentVertex);

                for (DetailProcessEdge edge : getEdgeList(currentVertex.getName())) {
                    DetailProcessVertex vertex = edge.getDestination();
                    vertexStack.push(vertex);
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
        DetailProcessVertex process6 = new DetailProcessVertex("p6");

        List<DetailProcessVertex> processList = new ArrayList<>();
        processList.add(process1);
        processList.add(process2);
        processList.add(process3);
        processList.add(process4);
        processList.add(process5);
        processList.add(process6);

        DetailProcessGraph myGraph = new DetailProcessGraph(processList);

        DetailProcessEdge edge_1_2 = new DetailProcessEdge(process1, process2);
        DetailProcessEdge edge_1_3 = new DetailProcessEdge(process1, process3);
        DetailProcessEdge edge_1_4 = new DetailProcessEdge(process1, process4);
        DetailProcessEdge edge_2_5 = new DetailProcessEdge(process2, process5);
        DetailProcessEdge edge_3_5 = new DetailProcessEdge(process3, process5);
        DetailProcessEdge edge_5_6 = new DetailProcessEdge(process5, process6);
        DetailProcessEdge edge_4_6 = new DetailProcessEdge(process4, process6);

        myGraph.addEdge(process1.getName(), edge_1_2);
        myGraph.addEdge(process1.getName(), edge_1_3);
        myGraph.addEdge(process1.getName(), edge_1_4);
        myGraph.addEdge(process2.getName(), edge_2_5);
        myGraph.addEdge(process3.getName(), edge_3_5);
        myGraph.addEdge(process5.getName(), edge_5_6);
        myGraph.addEdge(process4.getName(), edge_4_6);

        //System.out.print(myGraph.toString());
        System.out.print("DFS: \n");
        myGraph.depthFirstTraversal(process1);

        System.out.print("BFS: \n");
        myGraph.breadthFirstTraversal(process1);
    }
}
