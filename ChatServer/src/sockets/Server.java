package sockets;

			

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
    
	private static ArrayList<ClientHandler> users = new ArrayList<ClientHandler>(); // przechowuje aktualnych userow
	public static int port=9001;
    
    
    
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        
       
        
        
        try {
            serverSocket = new ServerSocket(port);									//port
            while(true) {
                System.out.println("Waiting for clients...");
                socket = serverSocket.accept();
                System.out.println("Connected");
                ClientHandler clientThread = new ClientHandler(socket, users);
                users.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
