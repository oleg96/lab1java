package lab1java;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * Contains all data for reporters
 * @see StateTweetCountReporter
 * @see TweetTagReporter
 * @see TweetWeightReporter
 * @author Oleg Fedorov
 */
public class InputParameters {
    List<Tweet> collectionOfTweets;
    List<State> collectionOfStates;
    List<Sentiment> collectionOfSentiments;
    Date startDate;
    Date endDate;
    String hashtag;
    /**
     * Initialize input parameters of reporter to get total emotional weight of tweets at some period of time
     * @param collectionOfSentiments list of sentiments
     * @param collectionOfTweets list of tweets
     * @param startDate start date
     * @param endDate end date
     */
    public InputParameters(List<Tweet> collectionOfTweets, List<Sentiment> collectionOfSentiments, Date startDate, Date endDate) {
        this.collectionOfTweets = collectionOfTweets;
        this.collectionOfSentiments = collectionOfSentiments;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    /**
     * Initialize input parameters of reporter to get name of state with the largest number of tweets
     * @param collectionOfTweets list of tweets
     * @param collectionOfStates list of states
     * @param startDate start date
     * @param endDate end date
     */
    public InputParameters(List<Tweet> collectionOfTweets, Date startDate, Date endDate, List<State> collectionOfStates) {
        this.collectionOfTweets = collectionOfTweets;
        this.startDate = startDate;
        this.endDate = endDate;
        this.collectionOfStates = collectionOfStates;
    }
    /**
     * Initialize input parameters of reporter to get all tweets that contains given hashtag
     * @param collectionOfTweets list of tweets
     * @param hashtag given hashtag
     */
    public InputParameters(List<Tweet> collectionOfTweets, String hashtag) {
        this.collectionOfTweets = collectionOfTweets;
        this.hashtag = hashtag;
    }
}
