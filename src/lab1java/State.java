package lab1java;

import java.awt.geom.Point2D;
import java.util.List;

import lab1java.State.CollectionOfCoordinates;

public class State {
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
}
