package lab1java;

interface Reporter<T> {
    void tweetTag(T t);
    void tweetCost(T t);
    void stateTweetCount(T t);
}
