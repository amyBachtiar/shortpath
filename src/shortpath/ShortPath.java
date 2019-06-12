package shortpath;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amy
 */
public class ShortPath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Edge edgeA = new Edge("A");
        Edge edgeB = new Edge("B");
        Edge edgeC = new Edge("C");
        Edge edgeD = new Edge("D");
        Edge edgeE = new Edge("E");
        Edge edgeF = new Edge("F");

        edgeA.addDirection(edgeB, 10);
        edgeA.addDirection(edgeC, 15);
        edgeB.addDirection(edgeD, 12);
        edgeB.addDirection(edgeF, 15);
        edgeC.addDirection(edgeE, 10);
        edgeD.addDirection(edgeE, 2);
        edgeD.addDirection(edgeF, 1);
        edgeF.addDirection(edgeE, 5);

        List <Edge> edges = new ArrayList<>();
        edges.add(edgeA);
        edges.add(edgeB);
        edges.add(edgeC);
        edges.add(edgeD);
        edges.add(edgeE);
        edges.add(edgeF);
        
        Edge source = edgeB;
        
        calculatepath(source);
        
        for (Edge edge : edges) {
            System.out.println("jarak dari " +source.getName()+" ke " +edge.getName() +" = " + (edge.getDistance() == null ? "tak hinggga" : edge.getDistance()));
        }
    }

    public static void calculatepath( Edge source) {
        source.setDistance(0);

        List<Edge> passedge = new ArrayList<>();
        List<Edge> unpassedge = new ArrayList<>();

        unpassedge.add(source);

        while (!unpassedge.isEmpty()) {
            Edge currentedge = getLowestDistance(unpassedge);
            unpassedge.remove(currentedge);
            currentedge.getPairEdge().entrySet().forEach((adjacencyPair) -> {
                Edge adjacentedge = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!passedge.contains(adjacentedge)) {
                    hitungJarak(adjacentedge, edgeWeight, currentedge);
                    unpassedge.add(adjacentedge);
                }
            });
            passedge.add(currentedge);
        }
    }

    private static Edge getLowestDistance(List< Edge> unsettlededges) {
        Edge lowestDistanceedge = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Edge edge : unsettlededges) {
            int edgeDistance = edge.getDistance();
            if (edgeDistance < lowestDistance) {
                lowestDistance = edgeDistance;
                lowestDistanceedge = edge;
            }
        }
        return lowestDistanceedge;
    }

    private static void hitungJarak(Edge evaluationedge,
            Integer edgeWeigh, Edge sourceedge) {
        evaluationedge.setDistance(Integer.MAX_VALUE);
        Integer sourceDistance = sourceedge.getDistance();
        if (sourceDistance + edgeWeigh < evaluationedge.getDistance()) {
            evaluationedge.setDistance(sourceDistance + edgeWeigh);
        }
    }

}
