public class operateGround {
    public int changeGround(int response , int turn,int gameNum) {
        try {
            int[][] ground = launchGame.games.get(gameNum).getGround();
            int i = response % 3;
            int j = response / 3;
            if (ground[i][j] == 0) {
                ground[i][j] = turn;
                return 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
