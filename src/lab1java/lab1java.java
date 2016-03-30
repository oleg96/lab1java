package lab1java;

public class lab1java {

    public static void start(MyFileReader fileReader, CommandInput inputLine, Worker outLines) {
        try {
            inputLine.inputFromKeyboard();
            if(inputLine.returnParsedStr().length != 3)
            {
                throw new IllegalArgumentException("Some parameter was missed! Please try again");
            }
            else {
                fileReader.MyFileReader(inputLine.returnParsedStr()[0].toString());
                try {
                    if(fileReader.returnLines().size() == 0)
                    {
                        throw new IndexOutOfBoundsException();
                    }
                    if((fileReader.returnLines().size() < Integer.parseInt(inputLine.returnParsedStr()[1]) || fileReader.returnLines().size() < (Integer.parseInt(inputLine.returnParsedStr()[1] + Integer.parseInt(inputLine.returnParsedStr()[2]))) || (Integer.parseInt(inputLine.returnParsedStr()[1]) < 1) || (fileReader.returnLines().size() < Integer.parseInt(inputLine.returnParsedStr()[1]) && fileReader.returnLines().size() < (Integer.parseInt(inputLine.returnParsedStr()[2]) + Integer.parseInt(inputLine.returnParsedStr()[1])))) && (Integer.parseInt(inputLine.returnParsedStr()[1]) < 1))
                    {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    else {
                        if (inputLine.returnParsedStr()[0].toString().contains("all_tweets.txt"))
                        {
                            outLines.searchTweets(fileReader.returnLines(), Integer.parseInt(inputLine.returnParsedStr()[1]), Integer.parseInt(inputLine.returnParsedStr()[2]));
                            outLines.writeTweetsToConsole();
                        }
                        if (inputLine.returnParsedStr()[0].toString().contains("states.json"))
                        {
                            outLines.SearchStates(fileReader.returnLines());
                            outLines.writeStatesToConsole();
                        }
                        if (inputLine.returnParsedStr()[0].toString().contains("sentiments.csv"))
                        {
                            outLines.searchSentiments(fileReader.returnLines());
                            outLines.writeSentimentsToConsole();
                        }
                    }
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.print(e+": Some value was out of range\n");
                    start(fileReader, inputLine, outLines);
                }
                catch (IndexOutOfBoundsException e) {
                    start(fileReader, inputLine, outLines);
                }
            }
        }
        catch (IllegalArgumentException e ) {
            System.out.print(e+"\n");
            inputLine.inputFromKeyboard();
            start(fileReader, inputLine, outLines);
        }
    }

    public static void main(String args[]) {
        MyFileReader fileReader = new MyFileReader();
        CommandInput inputLine = new CommandInput();
        Worker outLines = new Worker();
        start(fileReader, inputLine, outLines);
    }

}