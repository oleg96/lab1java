package lab1java;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateTweetCountReporter implements Reporter<String, InputParameters> {
    List<Point2D.Double> listOfCoord;
    Map<String, Integer> PopularState = new HashMap<String, Integer>();
    public String reporter(InputParameters parameters) {
        for (int i = 0; i < parameters.collectionOfStates.size(); i++) {
            int countOfTweets = 0;
            for (int t = 0; t < parameters.collectionOfTweets.size(); t++) {
                if (parameters.collectionOfTweets.get(t).getDate().after(parameters.startDate) && parameters.collectionOfTweets.get(t).getDate().before(parameters.endDate)) {
                    listOfCoord = new ArrayList<>();
                    for (int j = 0; j < parameters.collectionOfStates.get(i).getCollection().size(); j++) {
                        for (int k = 0; k < parameters.collectionOfStates.get(i).getCollection().get(j).size(); k++) {
                            listOfCoord.add(parameters.collectionOfStates.get(i).getCollection().get(j).get(k).getPoint());
                        }
                    }
                    Path2D state = pathBuilder();
                    double x = parameters.collectionOfTweets.get(t).getLatitude() * 1000000;
                    double y = parameters.collectionOfTweets.get(t).getLongitude()* 1000000;
                    if (state.contains(y,x)) {
                        countOfTweets++;
                    }
                }
            }
            PopularState.put(parameters.collectionOfStates.get(i).getName(), countOfTweets);
        }
        Map.Entry<String,Integer> maxEntry=null;
        for (Map.Entry<String,Integer> temp:PopularState.entrySet()){
            if(maxEntry==null||temp.getValue()>maxEntry.getValue())
            {
                maxEntry=temp;
            }
        }
        return maxEntry.getKey();
    }

    public Path2D pathBuilder() {
        Path2D path = new Path2D.Double();
        boolean isFirst = true;
        for (int i = 0; i < listOfCoord.size(); i++) {
            double x = listOfCoord.get(i).getX() * 1000000;
            double y = listOfCoord.get(i).getX() * 1000000;
            if (isFirst) {
                path.moveTo(x, y);
                isFirst = false;
            } else {
                path.lineTo(x, y);
            }
        }
        path.closePath();
        return path;
    }
}
