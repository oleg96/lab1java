package lab1java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    private ArrayList<Tweet> collectionOfTweets = new ArrayList();
    private ArrayList<State> collectionOfStates = new ArrayList();
    private ArrayList<Sentiment> collectionOfSentiments = new ArrayList();
    Parser parserInterfaceTweets = new ParseTweets();
    Parser parserInterfaceSentiments = new ParseSentiments();
    ParserS parserInterfaceStates = new ParseStates();
    public void searchTweets(List<String> lines, int position, int count) {
        for(int i = position-1; i < position-1 + count; i++) {
            collectionOfTweets.add((Tweet)parserInterfaceTweets.parser(lines.get(i)));
        }
    }
    public void writeTweetsToConsole() {
        for(int i = 0; i < collectionOfTweets.size(); i++)
        {
            System.out.println(collectionOfTweets.get(i).toString());
        }
    }
    public void searchStates(List<String> str) {
        String pattern = "[A-Z][A-Z]";
        List<String> arrayOfStateNames = new ArrayList<String>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str.get(0));
        while(m.find()) {
            arrayOfStateNames.add(str.get(0).substring(m.start(), m.end()));
        }
        for(int i = 0; i < arrayOfStateNames.size(); i++)
        {
            collectionOfStates.add((State)parserInterfaceStates.parser(str.get(0), arrayOfStateNames.get(i)));
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
            collectionOfSentiments.add((Sentiment)parserInterfaceSentiments.parser(str.get(i)));
        }
    }
    public void writeSentimentsToConsole() {
        for(int i = 0; i < collectionOfSentiments.size(); i++)
        {
            System.out.println(collectionOfSentiments.get(i).toString());
        }
    }
}