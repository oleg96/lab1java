package lab1java;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Find all tweets that contains given hashtag
 * @see Tweet
 * @author Oleg Fedorov
 */
public class TweetTagReporter implements Reporter<ArrayList<Tweet>, InputParameters> {
    /**
     * Find all tweets that contains given hashtag
     * @see ArrayList<Tweet>
     * @param parameters input parameters for reporter
     * @return collectionOfHashTweets tweet collection that contains given hashtag
     */
    public ArrayList<Tweet> reporter(InputParameters parameters) {
        ArrayList<Tweet> collectionOfHashTweets = new ArrayList<Tweet>();
        for (int i = 0; i < parameters.collectionOfTweets.size(); i++) {
            Pattern pattern = Pattern.compile(parameters.hashtag);
            Matcher matcher = pattern.matcher(parameters.collectionOfTweets.get(i).getMessage().toString());
            while (matcher.find()) {
                collectionOfHashTweets.add(parameters.collectionOfTweets.get(i));
            }
        }
        return collectionOfHashTweets;
    }
}
