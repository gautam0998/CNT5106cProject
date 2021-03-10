import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class PeerMain {
    public static void main(String[] args) throws Exception {

        int peerID = 1001; //4 bit PeerID       

        //FileLocation
        String sentLocation = "./file/sent/input.jpg";        
        
        //Create A new server socket for this peer/server with port number 7777
        ServerSocket serverSocket = new ServerSocket(7777);

        //Connect to the created socket
        Socket socket= serverSocket.accept();

        //Provide the file location to be transferred
        File file = new File(sentLocation);

        //File size to be shared for efficient transfer
        int fileSize = (int) file.length();

        //try to send a data output stream to share the file size
        try
         {
             
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            dataOutputStream.writeInt(fileSize);

            //received message code initialization
            byte []receivedMessage= new byte[32];


            //received message data input stream
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte []t = new byte[4];

            //received message stored in the variable
            dataInputStream.read(receivedMessage);

            int serverPeerID = ByteBuffer.wrap(Arrays.copyOfRange(receivedMessage, 28, 32)).getInt();

            System.out.println(serverPeerID);
            
            //check if the received message code is correct
            if(true){
                
                //if correct then initiate file transfer and start the input stream of the file
                FileInputStream fileInputStream = new FileInputStream(sentLocation);
        
                //file size in byte of the file being sent
                byte []b=new byte[fileSize];
                fileInputStream.read(b, 0, fileSize);

                //output stream initialized for the other peer/client
                OutputStream oStream = socket.getOutputStream();
                oStream.write(b, 0, fileSize);
            }

        } catch (Exception e) {
           System.out.println(e);
        }
       
    }
}
