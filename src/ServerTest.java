
public class ServerTest {

    public static void main(String[] args) {
        ServerBoard board = new ServerBoard(500, 500);
        Server server = new Server();
        server.open(board);
    }
}
