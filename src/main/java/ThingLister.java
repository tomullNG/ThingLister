import java.io.*;

public class ThingLister {
    public void run(String filename) throws Exception {
        FileParser parser = new FileParser();
        var reader = new BufferedReader(new FileReader(filename));
        String line;
        while((line = reader.readLine())!= null) {
            var split = line.split(";");
            String type = split[0];
            String file = split[1];
            switch (type) {
                case "dogs":
                    parser.parseFile(("src/main/resources/" + file),  new DogHandler());
                    break;
                case "people":
                    parser.parseFile(("src/main/resources/" + file),  new PeopleHandler());
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new ThingLister().run("src/main/resources/things.csv");
    }
}
