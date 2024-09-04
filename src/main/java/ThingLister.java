public class ThingLister {
    public void run(String filename) throws Exception {
        ThingsHandler thingsHandler = new ThingsHandler();

        thingsHandler.registerHandler("dogs", new DogHandler());
        thingsHandler.registerHandler("people", new PeopleHandler());

        FileParser parser = new FileParser();
        parser.parseFile(filename, thingsHandler);
    }

    public static void main(String[] args) throws Exception {
        new ThingLister().run("src/main/resources/things.csv");
    }
}
