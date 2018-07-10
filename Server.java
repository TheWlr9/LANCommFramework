import java.net.*;
import java.io.*;

public class Server{
    private static ServerSocket server;
    
    final private static int PORT= 42841 //Change to your desired port #
    
    public static void main(String[] args){
        try{
            server= new ServerSocket(PORT);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        //To be changed to your liking
        server.setPerformancePreferences(0,0,0); //(Short connection time, low latency, high bandwidth) [Relative importance]
        server.setSoTimeout(0); //0 is infinite
        
        try{
            while(true){
                new ServerThread(server.accept()).start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread{
    private Socket client;
    
    ServerThread(Socket connectedSO){
        client= connectedSO;
    }
    
    public void run(){
        private BufferedReader stringIn;
        private PrintWriter stringOut;
        
        try{
            stringIn= new BufferedReader(new InputStreamReader(client.getInputStream()));
            stringOut= new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
