package lab1java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParseTweets implements Parser {

    public Tweet parserTweets(String str) {
        Tweet tweet;
        String pattern = "(\\d+\\.\\d+)|(-\\d+\\.\\d+)|(\\d\\d+.\\d+.\\d+)";
        List<String> arrayOfStrings = new ArrayList<String>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        while(m.find()) {
            arrayOfStrings.add(str.substring(m.start(), m.end()));
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Date result = null;
        try {
            result = df.parse(arrayOfStrings.get(2)+" "+arrayOfStrings.get(3));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String removeData = arrayOfStrings.get(0)+" "+arrayOfStrings.get(1)+"	6	"+arrayOfStrings.get(2)+" "+arrayOfStrings.get(3);
        str = str.replaceAll("(\\p{Ps})(\\d+\\.\\d+\\,)|(-\\d+\\.\\d+)(\\p{Pe})|(\\d\\d+.\\d+.\\d+)", "");
        str = str.replaceFirst("([6].)", "");
        str = str.replaceAll("[\\s]{2,}", " ");
        tweet = new Tweet(Double.parseDouble(arrayOfStrings.get(0)), Double.parseDouble(arrayOfStrings.get(1)), result, str);
        return tweet;
    }
    public State parserStates(String str, String name){
        return null;
    }
    public Sentiment parserSentiments(String str) {
        return null;
    }
}
