public class ThingLister {
    public void run(String filename) throws Exception {
        FileParser parser = new FileParser();
        parser.parseFile(filename, new ThingsHandler());
    }

    public static void main(String[] args) throws Exception {
        new ThingLister().run("src/main/resources/things.csv");
    }
}
