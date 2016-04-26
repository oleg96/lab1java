package lab1java;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InputParameters {
    List<Tweet> collectionOfTweets;
    List<State> collectionOfStates;
    List<Sentiment> collectionOfSentiments;
    Date startDate;
    Date endDate;
    String hashtag;
    public InputParameters(List<Tweet> collectionOfTweets, List<Sentiment> collectionOfSentiments, Date startDate, Date endDate) {
        this.collectionOfTweets = collectionOfTweets;
        this.collectionOfSentiments = collectionOfSentiments;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public InputParameters(List<Tweet> collectionOfTweets, Date startDate, Date endDate, List<State> collectionOfStates) {
        this.collectionOfTweets = collectionOfTweets;
        this.startDate = startDate;
        this.endDate = endDate;
        this.collectionOfStates = collectionOfStates;
    }
    public InputParameters(List<Tweet> collectionOfTweets, String hashtag) {
        this.collectionOfTweets = collectionOfTweets;
        this.hashtag = hashtag;
    }
}
