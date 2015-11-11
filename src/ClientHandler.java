import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

// ClientHandler is the job that is handled from the threads
public class ClientHandler implements Runnable{

    Socket ourSock;
    BufferedReader IncomingMessage;
    ArrayList clientWriters;
    ServerBoard board;
    PrintWriter clientWriter;

    //
    ClientHandler(Socket clientSocket, ServerBoard board){
        this.clientWriters = clientWriters;
        try {
            this.board = board;
            ourSock = clientSocket;
            System.out.println("Made a client");
            IncomingMessage = new BufferedReader(new InputStreamReader(ourSock.getInputStream()));
            clientWriter = new PrintWriter(ourSock.getOutputStream());
            clientWriters.add(clientWriter);
            board.newPlayer();

        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace(); //???
        }
    }

    public void run(){
        //
        String update;
        try{
            while((update = IncomingMessage.readLine()) != null){
                board.update(update);
                System.out.println("Client: " + update);

                sendToAll(board.allPlayersToString());
                System.out.println(board.allPlayersToString());

            }

        } catch (Exception e){

        }
    }

    public String sendToAll(String message){
        Iterator it = clientWriters.iterator();
        while(it.hasNext()){
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println();
                writer.flush();
            }catch(Exception e){

            }
        }
        return message;
    }

}
