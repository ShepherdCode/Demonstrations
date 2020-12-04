import java.net.*;  // url
import java.io.*;    // stream
import javax.json.*;   // Json Parser

public class ParserDemo {
    static String MY_FILE = "bike_example.json";
    static String MY_URL = "https://bikewise.org:443/api/v2/incidents?page=1&proximity=60647&proximity_square=10";

    public static void main() {
        System.out.println("Please run one of the demo methods.");
    }
    
    public static void demo_ObjectsFromURL () {
        System.out.println("This demonstration will parse JSON from this URL:");
        System.out.println(MY_URL);
        InputStream is = openURL (MY_URL);
        JsonReader jsonReader = Json.createReader(is);
        JsonStructure js = jsonReader.read();
        jsonReader.close();       
        closeStream(is);

        System.out.println("We have loaded a generic json structure.");
        System.out.println("ETL: extract, transform, load...");

        JsonArray jsa = null;        
        JsonObject jso = null;
        if (js instanceof JsonObject) {
            jso= (JsonObject) js;
            jsa = jso.getJsonArray("incidents");
        } else {
            jsa = (JsonArray)js;
        }
        int s = jsa.size();
        BikeTheft [ ] bikeData = new BikeTheft [ s ];
        for (int i=0; i<s; i++) {
            JsonObject jo = jsa.getJsonObject(i);
            // Extract
            int id = jo.getInt("id");
            String place = jo.getString("address");
            String title = jo.getString("title");
            long time = jo.getInt("occurred_at");
            // Transform
            BikeTheft theft = new BikeTheft (id,title,place);
            theft.setTime(time);
            // Load
            bikeData[i] = theft;
        }
        System.out.println("Here is our array of bike thefts.");
        for (int i=0; i<bikeData.length; i++) {
            BikeTheft theft = bikeData[i];
            System.out.println(i + ") "+ theft);
        }
    }

    public static void demo_StreamFromURL () {
        System.out.println("This demonstration will parse JSON from this URL:");
        System.out.println(MY_URL);
        System.out.println("This demo parses one character at a time (streaming mode).");
        System.out.println("To prove the JSON was parsed, this demonstration ");
        System.out.println("will print indented text to the console.");
        System.out.println();
        InputStream is = openURL (MY_URL);
        StreamingPrinter sp = new StreamingPrinter(is);
        if (!sp.isReady()) {
            System.out.println("Sorry, we could not parse the JSON.");
        }
        sp.parseAndPrint();
        closeStream(is);
    }

    public static void demo_StreamFromFile () {
        System.out.println("This demonstration will parse JSON from this file:");
        System.out.println(MY_FILE);
        System.out.println("This demo parses one character at a time (streaming mode).");
        System.out.println("To prove the JSON was parsed, this demonstration ");
        System.out.println("will print indented text to the console.");
        System.out.println();
        InputStream is = openFile (MY_FILE);
        StreamingPrinter sp = new StreamingPrinter(is);
        if (!sp.isReady()) {
            System.out.println("Sorry, we could not parse the JSON.");
        }
        sp.parseAndPrint();
        closeStream(is);
    }

    public static void demo_LoadEntireFile () {
        System.out.println("This demonstration will parse JSON from this file:");
        System.out.println(MY_FILE);
        System.out.println("This demo will fail if JSON is too big for RAM.");
        System.out.println("Loading...");
        InputStream is = openFile (MY_FILE);
        JsonReader jsonReader = Json.createReader(is);
        JsonStructure js = jsonReader.read();
        jsonReader.close();       
        closeStream(is);
        System.out.println("Done. File closed.");
        if (js.getValueType()==JsonValue.ValueType.ARRAY) {
            int s = ((JsonArray)js).size();
            System.out.println("An array of size "+s+" is in RAM.");
        }
        if (js.getValueType()==JsonValue.ValueType.OBJECT) {
            System.out.println("An object is in RAM.");
        }
        System.out.println("Here is the data in RAM converted to a (long) string...");
        System.out.println(js);
    }

    private static void closeStream (InputStream is) {
        try {
            is.close();
        } catch (Exception e) {
            System.err.println("Could not close the input stream.");
            System.err.println(e);
        }
    }

    private static InputStream openURL (String http) {
        URL url;
        InputStream source = null;
        try {
            url = new URL(http);
            source = url.openStream();
        } catch (Exception e) {
            System.err.println("Cannot open URL "+http);
            System.err.println(e);
        }
        return source;
    }

    private static InputStream openFile (String filename) {
        InputStream source = null;
        try {
            source = new FileInputStream(filename);
        } catch (Exception e) {
            System.err.println("Cannot open file "+filename);
            System.err.println(e);
        }
        return source;
    }

}
