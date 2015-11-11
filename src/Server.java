import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;


public class Server {

    //ArrayList<PrintWriter> print = new ArrayList<PrintWriter>();
    //Thread clients;
    //PrintWriter printer;
    int count = 0;
    ArrayList<Thread> threads;

    public void open(ServerBoard board){
        try {
            ServerSocket serverSock = new ServerSocket(3000);
            System.out.println("Port is open");
            while(true){ // statement will also be true
                Socket clientSocket = serverSock.accept();
                System.out.println("Client connected");
                Thread client = new Thread(new ClientHandler(clientSocket, board));
                client.start();
                threads.add(client);
                System.out.println("Got new client connection");
                count ++;
                if(count >= 10000){
                    Iterator i = threads.iterator();
                    while(i.hasNext()){
                        try {
                            Thread clientClose;
                            clientClose = (Thread)i.next();
                            clientClose.stop();
                        }catch (Exception e){}
                    }

                }
            }

        } catch (Exception e){

        }
    }


}
