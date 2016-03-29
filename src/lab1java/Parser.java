package lab1java;

public interface Parser {
    public Tweet parserTweets(String str);
    public State parserStates(String str, String name);
    public Sentiment parserSentiments(String str);
}
