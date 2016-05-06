package lab1java;

import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Worker {
    private ArrayList<Tweet> collectionOfTweets = new ArrayList();
    private ArrayList<State> collectionOfStates = new ArrayList();
    private ArrayList<Sentiment> collectionOfSentiments = new ArrayList();
    private ArrayList<Tweet> collectionOfHashedTweets = new ArrayList();
    private double tweetWeight = 0.0;
    private String state = "";
    Parser parserInterfaceTweets = new ParseTweets();
    Parser parserInterfaceSentiments = new ParseSentiments();
    ParserS parserInterfaceStates = new ParseStates();
    Reporter reporterTweetTag = new TweetTagReporter();
    Reporter reporterTweetWeight = new TweetWeightReporter();
    Reporter reporterStateTweetCount = new StateTweetCountReporter();
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
        searchTweetTag();
        searchEmotionalWeight();
        searchState();
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
        AppFrame fr = new AppFrame(collectionOfStates);
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
    public void searchTweetTag() {
        System.out.println("Enter hashtag (#...):");
        Scanner in = new Scanner(System.in);
        String hashtag = in.nextLine();
        InputParameters parameters = new InputParameters(collectionOfTweets, hashtag);
        collectionOfHashedTweets = (ArrayList<Tweet>) reporterTweetTag.reporter(parameters);
        System.out.println(hashtag+" tweets:");
        for(int i = 0; i < collectionOfHashedTweets.size(); i++)
        {
            System.out.println(collectionOfHashedTweets.get(i).toString());
        }
    }
    public void searchEmotionalWeight() {
        MyFileReader sentimentsLoader = new MyFileReader();
        sentimentsLoader.fileReader("C:\\a\\sentiments.csv");
        searchSentiments(sentimentsLoader.returnLines());
        //System.out.println("Enter start date:");
        //Scanner inDate = new Scanner(System.in);
        String date1 = "2011-08-28 19:00:00";
        String date2 = "2011-08-28 19:10:00";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Date start = null;
        Calendar startCalendar;
        try {
            //start = df.parse(inDate.nextLine());
            start = df.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Date end = null;
        Calendar endCalendar;
        try {
            //end = df.parse(inDate.nextLine());
            end = df.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        InputParameters parameters = new InputParameters(collectionOfTweets, collectionOfSentiments, start, end);
        tweetWeight = (double) reporterTweetWeight.reporter(parameters);
        System.out.println("Total weigth of tweets between "+start+" and "+end+": ");
        System.out.println(tweetWeight);
    }
    public void searchState() {
        MyFileReader statesLoader = new MyFileReader();
        statesLoader.fileReader("C:\\a\\states.json");
        searchStates(statesLoader.returnLines());
        //System.out.println("Enter start date:");
        //Scanner inDate = new Scanner(System.in);
        String date1 = "2011-01-01 19:00:00";
        String date2 = "2012-08-28 19:10:00";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Date start = null;
        Calendar startCalendar;
        try {
            //start = df.parse(inDate.nextLine());
            start = df.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        startCalendar = Calendar.getInstance();
        startCalendar.setTime(start);
        Date end = null;
        Calendar endCalendar;
        try {
            //end = df.parse(inDate.nextLine());
            end = df.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        endCalendar = Calendar.getInstance();
        endCalendar.setTime(end);
        InputParameters parameters = new InputParameters(collectionOfTweets, start, end, collectionOfStates);
        state = (String) reporterStateTweetCount.reporter(parameters);
        System.out.println("State with the biggest number of tweets: ");
        System.out.println(state);
    }
}