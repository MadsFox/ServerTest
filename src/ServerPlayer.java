/**
 * Created by Computer on 11-11-2015.
 */
public class ServerPlayer {
    int id, x, y;
    String returnString;

    ServerPlayer(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    void setX(int x){
        this.x = x;
    }

    void setY(int y){
        this.y = y;
    }

    int getId(){
        return id;
    }

    @Override
    public String toString() {
        String newline = System.getProperty("line.separator");
        return  "id" + id +
                "y" + y +
                "x" + x +
                newline;
    }

    public static void main(String[] args) {
        ServerPlayer player0 = new ServerPlayer(1,2,3);
        ServerPlayer player1 = new ServerPlayer(1,50,50);
        System.out.print(player0.toString());
        System.out.print(player1.toString());

    }
}
