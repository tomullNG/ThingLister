public class ThingsHandler implements LineHandler {

    @Override
    public void handleLine(String line) throws Exception {
        FileParser parser = new FileParser();
        var split = line.split(";");
        String type = split[0];
        String file = split[1];
        switch (type) {
            case "dogs":
                parser.parseFile("src/main/resources/" + file, new DogHandler());
                break;
            case "people":
                parser.parseFile("src/main/resources/" + file, new PeopleHandler());
                break;
        }
    }
}
