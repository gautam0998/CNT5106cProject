import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        
        //Create A new server socket for this peer/server with port number 7777
        ServerSocket serverSocket = new ServerSocket(7777);

        //Connect to the created socket
        Socket socket= serverSocket.accept();

        //Provide the file location to be transferred
        File file = new File("C:\\Users\\Shubham\\Desktop\\bike pic.jpg");

        //File size to be shared for efficient transfer
        int fileSize = (int) file.length();

        //try to send a data output stream to share the file size
        try {
            DataOutputStream dOutputStream = new DataOutputStream(socket.getOutputStream());
            dOutputStream.writeInt(fileSize);

            //received message code initialization
            int receivedMessage;

            //received message data input stream
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte []t = new byte[32];

            //received message stored in the variable
            receivedMessage = dataInputStream.read();

            

            System.out.println(receivedMessage);
            
            //check if the received message code is correct
            if(true){
                
                //if correct then initiate file transfer and start the input stream of the file
                FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Shubham\\Desktop\\bike pic.jpg");
        
                //file size in byte of the file being sent
                byte []b=new byte[fileSize];
                fileInputStream.read(b, 0, fileSize);

                //output stream initialized for the other peer/client
                OutputStream oStream = socket.getOutputStream();
                oStream.write(b, 0, fileSize);
            }

        } catch (Exception e) {
            //TODO: handle exception
        }
       
    }
}
