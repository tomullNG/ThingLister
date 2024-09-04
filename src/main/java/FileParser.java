import java.io.BufferedReader;
import java.io.FileReader;

public class FileParser {
    public void parseFile(String filename, LineHandler handler) throws Exception {
        var reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            handler.handleLine(line);
        }
        reader.close();
    }
}
