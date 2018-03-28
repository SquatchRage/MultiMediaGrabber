

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;



public class Talker 
{
    private BufferedReader buffRead;
    private DataOutputStream dos;   
   
    
    //constucter for client
    @SuppressWarnings("resource")
	Talker (String serverName, int port, String id) throws Throwable
    {
    	     Socket clientSocket;
        	clientSocket = new Socket(serverName, port);
           
            dos = new DataOutputStream (clientSocket.getOutputStream());
            buffRead = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
     }
    
    //constructor for server
    Talker (Socket socket, String id) throws Throwable
    {

            dos = new DataOutputStream (socket.getOutputStream());
            buffRead = new BufferedReader (new InputStreamReader(socket.getInputStream()));

    }
    
    void send (String message) throws IOException
    {
        dos.writeBytes(message + "\n");
        System.out.println("Sent by " + message );
                
    }
    
    String recieve (String id) throws IOException
    {
        String received;
        received = buffRead.readLine();
        System.out.println("Received by " +id+ received);

        return received;
    }
    
}

    
    

