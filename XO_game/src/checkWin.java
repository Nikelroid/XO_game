public class checkWin {
    public int checker(int gameNum) {
        int[][] ground = launchGame.games.get(gameNum).getGround();
        for (int i = 0; i < 3; i++) {
            if(ground[i][0]!=0 &&
                    ground[i][0]==ground[i][1] &&
                    ground[i][1]==ground[i][2]){
                return ground[i][0];
            }
        }
        for (int i = 0; i < 3; i++) {
            if(ground[0][i]!=0 &&
                    ground[0][i]==ground[1][i] &&
                    ground[1][i]==ground[2][i]){
                return ground[0][i];
            }
        }
        if (ground[0][0]!=0 &&
                ground[0][0]==ground[1][1] &&
                ground[1][1]==ground[2][2] ){
            return ground[0][0];
        }
        if (ground[0][2]!=0 &&
                ground[0][2]==ground[1][1] &&
                ground[1][1]==ground[2][0] ){
            return ground[0][0];
        }
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if(ground[i][j]==0)break;
                if(i==2&&j==2)return 3;
            }
        }
        return 0;
    }
}
