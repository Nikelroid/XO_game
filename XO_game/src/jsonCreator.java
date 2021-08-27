import org.json.JSONObject;

public class jsonCreator {
    public JSONObject get(String text,String user) {
        JSONObject jsonOutput = new JSONObject();
        jsonOutput.put("text",text).put("user",user);
        return jsonOutput;
    }
}
