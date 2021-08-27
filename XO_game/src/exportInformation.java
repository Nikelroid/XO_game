import org.json.JSONObject;

import java.util.ArrayList;

public class exportInformation {
    public JSONObject export(String ground,int win,int numberGame) {
        String user1 = launchGame.games.get(numberGame).getUser1();
        String user2 = launchGame.games.get(numberGame).getUser2();
        int turn = launchGame.games.get(numberGame).getTurn();

        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> texts = new ArrayList<>();

        users.add(user1);
        users.add(user2);

        ArrayList<Integer> lengths = new ArrayList<>();
        lengths.add("You won :)".length());
        lengths.add("You lose :(".length());
        lengths.add(("You lose :(".length()));
        lengths.add(("You won :)".length()));
        lengths.add(("Game over. Tie! :|".length()));
        lengths.add(("Game over. Tie! :|".length()));
        lengths.add(("Your turn.".length()));
        lengths.add(("'s turn.".length()+user1.length()));
        lengths.add(("'s turn".length())+user2.length());
        lengths.add(("Your turn.".length()));


        if (win==1){
            texts.add("~"+lengths.get(0)+"~You won :)"+ground);
            texts.add("~"+lengths.get(1)+"~You lose :("+ground);
        }else if(win==2){
            texts.add("~"+lengths.get(2)+"~You lose :("+ground);
            texts.add("~"+lengths.get(3)+"~You won :)"+ground);
        }else if(win==3){
            texts.add("~"+lengths.get(4)+"~Game over. Tie! :|"+ground);
            texts.add("~"+lengths.get(5)+"~Game over. Tie! :|"+ground);
        }else{
            if (turn==2){
                texts.add("~"+lengths.get(6)+"~Your turn."+ground);
                texts.add("~"+lengths.get(7)+"~"+user1+"'s turn."+ground);
            }else{
                texts.add("~"+lengths.get(8)+"~"+user2+"'s turn"+ground);
                texts.add("~"+lengths.get(9)+"~Your turn."+ground);
            }
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user",users)
                .put("text",texts);
        return jsonObject;
    }
}
