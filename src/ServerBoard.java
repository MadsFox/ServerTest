import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Marc Zbinden Hansen on 10/11/2015.
 */
public class ServerBoard {
    int width, height, depth;
    int id = 0;
    ArrayList<ServerPlayer> players;

    ServerBoard(int width, int height){
        this.width = width;
        this.height = height;
        this.players = new ArrayList<ServerPlayer>();
    }

    ServerBoard(int width, int height, int depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.players = new ArrayList<ServerPlayer>();
    }

    void update(String updateString){
        //logic that decodes the string is missing and replaced with 0's for now.

        int id = 0;
        int x = 0;
        int y = 0;

        for (ServerPlayer player: players){
            if (player.getId() == id){
                player.setX(x);
                player.setY(y);
            }
        }
    }

    String allPlayersToString(){
        String allPlayers = "";
        for (ServerPlayer player: players){
            allPlayers = allPlayers+ player.toString();
        }
        return allPlayers;
    }

    void newPlayer(){
        ServerPlayer player = new ServerPlayer(++id, randInt(0,width), randInt(0, height));
        players.add(player);
    }

    int randInt(int min, int max){
        Random rn = new Random();
        int randomNum = rn.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static void main(String[] args) {
        ServerBoard board = new ServerBoard(50, 100, 0);
        board.newPlayer();
        board.newPlayer();
        board.newPlayer();

        System.out.println(board.allPlayersToString());
    }

}


