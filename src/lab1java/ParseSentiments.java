package lab1java;

public class ParseSentiments implements Parser<Sentiment, String>{
    public Sentiment parser(String str) {
        String splitted[] = str.split(",");
        Sentiment parsedSentiment = new Sentiment(splitted[0], Double.parseDouble(splitted[1]));
        return parsedSentiment;
    }
}