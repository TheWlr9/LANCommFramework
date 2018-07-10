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
                new ServerThread(server.accept()).start(); //Start the new ServerThread
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
        private BufferedReader stringIn; //The stream that will receive commands
        private PrintWriter stringOut; //The stream that will send commands
        
        try{
            //Setup the command streams
            stringIn= new BufferedReader(new InputStreamReader(client.getInputStream()));
            stringOut= new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            
            /*
            Place code here. For example:
            
            String command= stringIn.readLine();
            if(command.equals("sayGreeting")){
                stringOut.println("Hello world!");
                stringOut.flush();
            }
            
            */
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        /* Closes the streams and client socket connection. */
        finally{
            try{
                if(stringIn!=null)
                    stringIn.close();
                if(stringOut!=null)
                    stringOut.close();
                if(client!=null)
                    client.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
