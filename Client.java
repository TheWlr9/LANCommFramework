import java.net.*;
import java.io.*;

pubilc class Client{
    private static Socket server;
    private static PrintWriter stringOut;
    private static BufferedReader stringIn;
    
    final private static String HOST_ADDRESS= "192.168.1.101";
    final private static int PORT= 42841;
    
    public static void main(String[] args){
        try{
            server= new Socket(HOST_ADDRESS,PORT);
            stringOut= new PrintWriter(new InputStreamReader(server.getInputStream()));
            stringIn= new BufferedReader(new OutputStreamWriter(server.getOutputStream()));
            
            server.setPerformancePreferences(0,0,0); //(Short connection time, low latency, high bandwidth) [Relative priority]
            server.setSoLinger(false,0);
            server.setSoTimeout(0);
            server.setTrafficClass(0x00); //0x02==low cost, 0x04==high reliability, 0x08==high throughput, 0x10==low delay
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            /*
            Insert code here. For example:
            
            stringOut.println("sayGreeting");
            stringOut.flush();
            
            System.out.println(stringIn.readLine());
            
            */
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(stringIn!=null)
                    stringIn.close();
                if(stringOut!=null)
                    stringOut.close();
                if(server!=null)
                    server.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
