import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class launchGame {
    operateGround operate = new operateGround();
    groundPrinter groundPrinter = new groundPrinter();
    checkWin checkWin = new checkWin();
    exportInformation Information = new exportInformation();
    JSONObject output = new JSONObject();
    public static jsonCreator jsonCreator = new jsonCreator();
    public static final ArrayList<gameObj> games = new ArrayList<>();
    public JSONObject getObject(String input,String sender) throws IOException {
        if (input.equals("/start")) {
            games.add(new gameObj(sender));
            output = jsonCreator.get("Please send this link to you friend:\n" + "%" + Main.bot_name + "_bot/" +
                            games.get(games.size() - 1).getGameId().substring(0, 25) , sender);
            return output;
        } else if (input.startsWith("%")) {
            onStart onStart = new onStart();
            for (int i = 0; i < games.size(); i++) {
                if (games.get(i).getGameId().substring(0, 25).equals(input.substring(1))
                        && !sender.equals(games.get(i).getUser1())) {
                    games.get(i).startGame(sender);
                    output = onStart.getJson(games.get(i).getUser1(), games.get(i).getUser2());
                    return output;
                }
            }
        } else if (Integer.parseInt(input)>=1 && Integer.parseInt(input)<=9){

            for (int i = 0; i < games.size(); i++) {
                if (games.get(i).getUser1().equals(sender) && games.get(i).getTurn()==1) {
                    int response = operate.changeGround(Integer.parseInt(input)-1,1,i);
                    if (response==1){

                        String gameGround = groundPrinter.printer(i);
                        int win = checkWin.checker(i);
                        output = Information.export(gameGround,win,i);
                        if (win==0)
                            games.get(i).setTurn(2);
                        else
                            games.remove(i);
                        return output;
                    }

                }
                if (games.get(i).getUser2().equals(sender) && games.get(i).getTurn()==2) {
                    int response = operate.changeGround(Integer.parseInt(input)-1,2,i);
                    if (response==1){

                        String gameGround = groundPrinter.printer(i);
                        int win = checkWin.checker(i);
                        output = Information.export(gameGround,win,i);
                        if (win==0)
                        games.get(i).setTurn(1);
                        else
                            games.remove(i);
                        return output;
                    }

                }
            }
        }
        jsonCreator creator = new jsonCreator();
        output = creator.get("Undefined input", sender);
        return output;
    }
}
