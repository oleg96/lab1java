package lab1java;

import java.awt.geom.Point2D;
import java.util.List;

import lab1java.State.CollectionOfCoordinates;
/**
 * Define class which contains information about state
 * @see String
 * @see State
 * @author Oleg Fedorov
 */
public class State {
    /**
     * Class constructor
     */
    private String name;
    static class CollectionOfCoordinates {
        private Point2D.Double point;
        public CollectionOfCoordinates(double latitude, double longitude) {
            this.point = new Point2D.Double(latitude, longitude);
        }
        @Override
        public String toString()
        {
            return point.toString();
        }
        public Point2D.Double getPoint() {
            return point;
        }
    }
    private List<List<CollectionOfCoordinates>> listOfcollection;
    public State(String name, List<List<CollectionOfCoordinates>> listOfcollection) {
        this.name = name;
        this.listOfcollection = listOfcollection;
    }
    @Override
    public String toString()
    {
        return name+" "+listOfcollection.toString();
    }
    public List<List<CollectionOfCoordinates>> getCollection() {
        return listOfcollection;
    }
    public String getName() { return name; }
}
