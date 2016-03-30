package lab1java;

class ParseSentiments implements Parser{
    public Sentiment parserSentiments(String str) {
        String splitted[] = str.split(",");
        Sentiment parsedSentiment = new Sentiment(splitted[0], Double.parseDouble(splitted[1]));
        return parsedSentiment;
    }
    public Tweet parserTweets(String str){
        return null;
    }
    public State parserStates(String str, String name) {
        return null;
    }
}