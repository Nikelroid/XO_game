import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class onStart {

    public JSONObject getJson(String user1,String user2) throws IOException {

        ArrayList<String> users = new ArrayList<String>();
        ArrayList<String> texts = new ArrayList<String>();
        makePictureOnStart makePictureOnStart = new makePictureOnStart();
        String pictue = makePictureOnStart.make();
        users.add(user1);
        users.add(user2);
        int length1 = ("Game Started, You are (X).  -Your turn- Insert a number between 1 and 9. inserted house will be yours").length();
        int length2 = ("Game Started, You are (O).  -'s turn- Insert a number between 1 and 9. inserted house will be yours").length()+user1.length();

        texts.add("~"+length1+"~Game Started, You are (X).  -Your turn- Insert a number between 1 and 9. inserted house will be yours"+pictue);
        texts.add("~"+length2+"~Game Started, You are (O).  -"+user1+"'s turn- Insert a number between 1 and 9. inserted house will be yours"+pictue);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",users)
                .put("text",texts);
        return jsonObject;
    }
}
