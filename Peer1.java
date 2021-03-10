import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Peer1 {

    public static void main(String[] args) throws Exception {

        int peerID = 1002; //4 bit PeerID

        
        //socket initialized
        Socket socket = new Socket("localhost", 7777);

        //input stream collected from the socket
        InputStream iStream = socket.getInputStream();

        //dataInput intialized
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        //read from the data input and store the file size value in length variable
        int fileSize = dataInputStream.readInt();

        if (fileSize > 0) {
 
            byte[] header = new String("P2PFILESHARINGPROJ").getBytes(); // header
            
            byte[] zeroBits = new byte[10];
       
            
            Arrays.fill(zeroBits,(byte)0); // 10 byte zero bits Array
      
 
            byte[] pID = ByteBuffer.allocate(4).putInt(peerID).array(); // peer ID in byte array

            ByteArrayOutputStream handshakeMessageBytes = new ByteArrayOutputStream();
        
            handshakeMessageBytes.write(header);
            handshakeMessageBytes.write(zeroBits);
            handshakeMessageBytes.write(pID);

            byte[] handshakeMessage = handshakeMessageBytes.toByteArray();

            int asd = ByteBuffer.wrap(Arrays.copyOfRange(handshakeMessage, 28, 32)).getInt();

            System.out.println(asd);

            //send handshakeMessage message for connection
            DataOutputStream dOutputStream1 = new DataOutputStream(socket.getOutputStream());

            dOutputStream1.write(handshakeMessage);

            //set the length of fileSize of inputstream to be read
            byte[] outputFileBytes = new byte[fileSize];

            //output the data to a new file
            FileOutputStream fileOutputStream = new FileOutputStream("./file/received/output.jpg");
            
            //read the input into 'b' byte of length 'fileSize' 
            iStream.read(outputFileBytes);

            //output into 'b'
            fileOutputStream.write(outputFileBytes);

            //close OutputStream
            fileOutputStream.close();

            //close Socket
            socket.close();

        }

    }

}
