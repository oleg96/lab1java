package lab1java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    public ArrayList<Tweet> collectionOfTweets = new ArrayList();
    public ArrayList<State> collectionOfStates = new ArrayList();
    public ArrayList<Sentiment> collectionOfSentiments = new ArrayList();
    Parser parserTweetsInterface = new ParseTweets();
    Parser parserStatesInterface = new ParseStates();
    Parser parserSentimentsInterface = new ParseSentiments();
    public void searchTweets(List<String> lines, int position, int count) {
        for(int i = position-1; i < position-1 + count; i++) {
            collectionOfTweets.add(parserTweetsInterface.parserTweets(lines.get(i)));
        }
    }
    public void writeTweetsToConsole() {
        for(int i = 0; i < collectionOfTweets.size(); i++)
        {
            System.out.println(collectionOfTweets.get(i).toString());
        }
    }
    public void SearchStates(List<String> str) {
        String pattern = "[A-Z][A-Z]";
        List<String> arrayOfStateNames = new ArrayList<String>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str.get(0));
        while(m.find()) {
            arrayOfStateNames.add(str.get(0).substring(m.start(), m.end()));
        }
        for(int i = 0; i < arrayOfStateNames.size(); i++)
        {
            collectionOfStates.add(parserStatesInterface.parserStates(str.get(0), arrayOfStateNames.get(i)));
        }
    }
    public void writeStatesToConsole() {
        for(int i = 0; i < collectionOfStates.size(); i++)
        {
            System.out.println(collectionOfStates.get(i).toString());
        }
    }
    public void searchSentiments(List<String> str) {
        for (int i = 0; i < str.size(); i++)
        {
            collectionOfSentiments.add(parserSentimentsInterface.parserSentiments(str.get(i)));
        }
    }
    public void writeSentimentsToConsole() {
        for(int i = 0; i < collectionOfSentiments.size(); i++)
        {
            System.out.println(collectionOfSentiments.get(i).toString());
        }
    }
}