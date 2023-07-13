package sn.groupeisi.socket;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Server {
    private ServerSocket serverSocket;
    private List<ClientHandler> clientHandlers;
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        this.clientHandlers = new ArrayList<>() ;
    }
    public void startServer(){
        try {
            while (!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                if (clientHandlers.size() < 4 ){
                    ClientHandler clientHandler = new ClientHandler(socket);
                    System.out.printf("Nouveau User connecte au chat");
                    clientHandlers.add(clientHandler);
                    Thread thread = new Thread(clientHandler);
                    thread.start();
                }else {
                    System.out.printf("Desole le chat est plein ");
                }

            }
        }catch (IOException e){

        }
    }
    public void closeServer(){
        try {
            if(serverSocket != null)
                serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8987);
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
