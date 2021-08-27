import java.rmi.server.ObjID;

public class gameObj {
    private String gameId = null;
    private String user1 = null;
    private String user2 = null;
    private int turn = 1;
    private int[][] ground = new int[3][3];

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public int[][] getGround() {
        return ground;
    }

    public void setGround(int[][] ground) {
        this.ground = ground;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void startGame(String user2) {
        this.setUser2(user2);
        int[][] blankGround = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        this.setGround(blankGround);
    }

    public gameObj(String user1) {
        this.user1 = user1;
        this.gameId = new ObjID().toString();
        this.turn = 1;
    }
}
