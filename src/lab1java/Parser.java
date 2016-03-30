package lab1java;

interface Parser {
    Tweet parserTweets(String str);
    State parserStates(String str, String name);
    Sentiment parserSentiments(String str);
}
