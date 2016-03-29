package lab1java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {
    List<String> lines;

    public void MyFileReader(String path) {
        try {
            lines = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e+": Exception at file reading\n");
        }
    }

    public List<String> returnLines() {
        return lines;
    }
}
