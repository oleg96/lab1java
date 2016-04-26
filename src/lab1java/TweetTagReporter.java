package lab1java;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetTagReporter implements Reporter<ArrayList<Tweet>, InputParameters> {
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
