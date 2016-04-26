package lab1java;

import java.util.List;

public class TweetWeightReporter implements Reporter<Double, InputParameters> {
    public Double reporter(InputParameters parameters) {
        double totalEmotionalWeight = 0.0;
        for (int i = 0; i < parameters.collectionOfTweets.size(); i++) {
            if (parameters.collectionOfTweets.get(i).getDate().after(parameters.startDate) && parameters.collectionOfTweets.get(i).getDate().before(parameters.endDate)) {
                totalEmotionalWeight += calculateEmotionalWeightOfTweet(parameters.collectionOfSentiments, parameters.collectionOfTweets.get(i));
            }
        }
        return totalEmotionalWeight;
    }
    public Double calculateEmotionalWeightOfTweet(List<Sentiment> sentiments, Tweet tweet) {
        double emotionalWeigthOfTweet = 0.0;
        for (int i = 0; i < sentiments.size(); i++) {
            if (tweet.getMessage().contains(sentiments.get(i).getName())) {
                emotionalWeigthOfTweet += sentiments.get(i).getValue();
            }
        }
        return emotionalWeigthOfTweet;
    }
}