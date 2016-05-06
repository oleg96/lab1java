package lab1java;

import java.util.List;
import java.util.Locale;
/**
 * Calculate total emotional weight of tweets at some period of time
 * @see Tweet
 * @see Sentiment
 * @author Oleg Fedorov
 */
public class TweetWeightReporter implements Reporter<Double, InputParameters> {
    /**
     * Calculate total emotional weight of tweets at some period of time
     * @see Tweet
     * @see Sentiment
     * @param parameters input parameters for reporter
     * @return totalEmotionalWeight total emotional weight of tweets at some period of time
     */
    public Double reporter(InputParameters parameters) {
        double totalEmotionalWeight = 0.0;
        for (int i = 0; i < parameters.collectionOfTweets.size(); i++) {
            if (parameters.collectionOfTweets.get(i).getDate().after(parameters.startDate) && parameters.collectionOfTweets.get(i).getDate().before(parameters.endDate)) {
                totalEmotionalWeight += calculateEmotionalWeightOfTweet(parameters.collectionOfSentiments, parameters.collectionOfTweets.get(i));
            }
        }
        return totalEmotionalWeight;
    }
    /**
     * Calculate emotional weight of one tweet
     * @see Tweet
     * @see Sentiment
     * @param sentiments
     * @param tweet
     * @return totalEmotionalWeight total emotional weight of tweets at some period of time
     */
    public Double calculateEmotionalWeightOfTweet(List<Sentiment> sentiments, Tweet tweet) {
        double emotionalWeigthOfTweet = 0.0;
        for (int i = 0; i < sentiments.size(); i++) {
            if (tweet.getMessage().toLowerCase().contains(sentiments.get(i).getName())) {
                emotionalWeigthOfTweet += sentiments.get(i).getValue();
            }
        }
        return emotionalWeigthOfTweet;
    }
}