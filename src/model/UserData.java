package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;   // https://www.geeksforgeeks.org/working-with-json-data-in-java/#
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
// https://www.geeksforgeeks.org/parse-json-java/#:~:text=JSON%20(JavaScript%20Object%20Notation)%20is,or%20more%20name%2Fvalue%20pairs.

public class UserData {

    public static void ReadPlayerData() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("D:\\DummyDir\\Dreamworld\\src\\model\\UserData.json"));
        JSONObject userFile = (JSONObject) obj;
        JSONArray players = (JSONArray) userFile.get("Players");
        Iterator playerIterator = players.iterator();
//        userFile.get(obj);
        /*System.out.println(playerIterator.next());
        System.out.println(playerIterator.next());*/
        while (playerIterator.hasNext())
        {
            playerIterator = ((Map) playerIterator.next()).entrySet().iterator();

            while (playerIterator.hasNext()) {
                Map.Entry pair = (Map.Entry) playerIterator.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
            /*playerIterator = ((Map) playerIterator.next()).entrySet().iterator();
            while (playerIterator.hasNext()) {
                Map.Entry pair = (Map.Entry) playerIterator.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }*/
        }


    }


}
