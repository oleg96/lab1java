package lab1java;

interface Reporter<T> {
    public void TweetTag(T t);
    public void TweetCost(T t);
    public void StateTweetCount(T t);
}
