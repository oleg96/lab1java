package lab1java;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lab1java.State.CollectionOfCoordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseStates implements Parser {

    public State parserStates(String str, String name) {
        JsonObject jsonObject = new JsonParser().parse(str).getAsJsonObject();

        JsonArray array = new JsonArray();
        array.addAll(jsonObject.get(name).getAsJsonArray());

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < array.size(); i++)
        {
            list.add(array.get(i).toString());
        }
        List<List<CollectionOfCoordinates>> listOfCollections = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
        {
            List<CollectionOfCoordinates> coordinatesCollection = new ArrayList<>();
            String patternCoordinates = "(\\d+\\.\\d+)|(-\\d+\\.\\d+)";
            List<String> arrayOfCoordinates = new ArrayList<String>();
            Pattern pCoord = Pattern.compile(patternCoordinates);
            Matcher mCoord = pCoord.matcher(list.get(i));
            while(mCoord.find()) {
                arrayOfCoordinates.add(list.get(i).substring(mCoord.start(), mCoord.end()));
            }
            for (int j = 0; j < arrayOfCoordinates.size(); j+=2)
            {
                coordinatesCollection.add(new CollectionOfCoordinates(Double.parseDouble(arrayOfCoordinates.get(j)), Double.parseDouble(arrayOfCoordinates.get(j+1))));
            }
            listOfCollections.add(coordinatesCollection);
        }
        State state = new State(name, listOfCollections);
        return state;
    }
    public Tweet parserTweets(String str){
        return null;
    }
    public Sentiment parserSentiments(String str) {
        return null;
    }
}