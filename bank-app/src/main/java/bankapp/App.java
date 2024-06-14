package bankapp;

import org.json.JSONException;
import org.json.JSONObject;

public class App 
{
    public static void main( String[] args ) throws JSONException
    {
        System.out.println( "Hello World!" );
        JSONObject obj = new JSONObject();
        obj.put("title", "Hello World!");
        String json_string = obj.toString();
        System.out.println("Original JSON: " + json_string);
    }
}
