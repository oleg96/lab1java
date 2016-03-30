package lab1java;

import java.util.Scanner;

class CommandInput {

    String parsedStr[];

    public void inputFromKeyboard() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter command (usage: filename begin_from_line count_of_lines): ");
        String str = in.nextLine();
        parsedStr = str.split(" ");
    }

    public String[] returnParsedStr() {
        return parsedStr;
    }

}