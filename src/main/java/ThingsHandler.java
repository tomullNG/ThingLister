import java.util.HashMap;
import java.util.Map;

public class ThingsHandler implements LineHandler {

    Map<String, LineHandler> handlers = new HashMap<>();

    public void registerHandler(String type, LineHandler handler) {
        handlers.put(type, handler);
    }

    @Override
    public void handleLine(String line) throws Exception {
        var split = line.split(";");
        String type = split[0];
        String file = split[1];

        LineHandler handler = handlers.get(type);
        if (handler != null) {
            FileParser parser = new FileParser();
            parser.parseFile("src/main/resources/" + file, handler);
        } else {
            System.out.println("No handler registered for type: " + type);
        }
    }
}
