package shortpath;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author amy
 */
public class Edge {

    private String name;

    private Integer distance;

    Map<Edge, Integer> pairEdge = new HashMap<>();

    public void addDirection(Edge destination, int distance) {
        pairEdge.put(destination, distance);
    }

    public Edge(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Edge, Integer> getPairEdge() {
        return pairEdge;
    }

    public void setPairEdge(Map<Edge, Integer> pairEdge) {
        this.pairEdge = pairEdge;
    }
    
    
}
