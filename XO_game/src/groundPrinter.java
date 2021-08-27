import java.io.IOException;
import java.util.ArrayList;

public class groundPrinter {

    public String printer(int gameNum) throws IOException {

        String gameGround;
        int[][] ground = launchGame.games.get(gameNum).getGround();
        ArrayList<String> XOGround = new ArrayList<>();
        int count = 1;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if(ground[i][j]==0) {
                    XOGround.add(String.valueOf(count));
                }else if (ground[i][j]==1){
                    XOGround.add("X");
                }else if (ground[i][j]==2){
                    XOGround.add("O");
                }
                count++;
            }
        }
        makePicture Picture = new makePicture();
        gameGround = Picture.make(XOGround);

        return gameGround;
    }
}
