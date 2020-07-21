import java.lang.*;
import java.io.*;
import javax.json.*;   // Json Parser
import javax.json.stream.*;   // Parser Factory

public class StreamingPrinter {
    PrintStream ps;
    int indentLevel = 0;
    String holdPrevKey;
    InputStream source;
    boolean ready;
    JsonParser parser;
     
    public StreamingPrinter(InputStream is) {
        ps = System.out;
        holdPrevKey="";
        source = is;
        ready = false;
        if (is != null) {
            try {   
                this.parser = Json.createParser(is);
            } catch (Exception e) {
                System.err.println("Cannot create parser.");
                System.err.println(e);
            }
        }
        ready = true;
    }


    void indentedPrint (String words) {
        int i;
        String indentation = "";
        for (i=0; i<indentLevel; i++) {
            indentation += " + ";
        }
        ps.println(indentation + words);
    }
    
    public void endArray () {
        indentLevel--;
        indentedPrint("...End array");
    }
    
    public void startArray () {
        indentedPrint("Start array...");
        indentLevel++;
    }

    public void endObject () {
        indentLevel--;
        indentedPrint("...End object");
    }
    
    public void startObject () {
        indentedPrint("Start object...");
        indentLevel++;
    }

    public void showBoolean (Boolean b) {
        if (b==null) {
            indentedPrint("null");
        } else if (b.booleanValue()) {
            indentedPrint("true");
        } else {
            indentedPrint("false");
        }
    }
    
    public void showKey (String key) {
        holdPrevKey = key;
    }
    
    public void showValue (String value) {
        String display = "key=value "+holdPrevKey + "=" + value;
        indentedPrint(display);
    }
    
    public boolean isReady () {
        return ready;
    }

    public void parseAndPrint () {
        JsonParser.Event event;
        while (parser.hasNext()) {  
            event = parser.next();
            switch(event) {
                case END_ARRAY: {
                    endArray();
                    break;
                }
                case END_OBJECT: {
                    endObject();
                    break;
                }
                case START_ARRAY: {
                    startArray();
                    break;
                }
                case START_OBJECT: {
                    startObject();
                    break;
                }
                case VALUE_FALSE: {
                    showBoolean(new Boolean(false));
                    break;
                }
                case VALUE_NULL:{
                    showBoolean(null);
                    break;
                }
                case VALUE_TRUE:{
                    showBoolean(new Boolean(true));
                    break;
                }
                case KEY_NAME:{
                    showKey(parser.getString());
                    break;
                }
                case VALUE_STRING:
                case VALUE_NUMBER:{
                    showValue(parser.getString());
                    break;
                }
            }
        }
    }

}
