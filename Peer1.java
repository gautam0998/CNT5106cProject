import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Peer1 {
    
    public static void main(String[] args) throws Exception {

        ByteArrayOutputStream handshakeMessage = new ByteArrayOutputStream();
        
        //socket initialized
        Socket socket = new Socket("localhost", 7777);

        //input stream collected from the socket
        InputStream iStream = socket.getInputStream();

        //dataInput intialized
        DataInputStream in = new DataInputStream(socket.getInputStream());

        //read from the data input and store the file size value in length variable
        int fileSize = in.readInt();

        if (fileSize > 0) {
 
            byte[] header = new String("P2PFILESHARINGPROJ").getBytes(); // header
            byte[] zeroBits = new byte[10];
            Arrays.fill(zeroBits,(byte)0); // 10 byte zero bits

            int peerID = 1001; //4 bit PeerID

            byte[] pID = ByteBuffer.allocate(4).putInt(peerID).array();

            handshakeMessage.write(header);
            handshakeMessage.write(zeroBits);
            handshakeMessage.write(pID);

            byte[] handshake = handshakeMessage.toByteArray();

            //if length is >0, send reponse message for acknowledgment
            DataOutputStream dOutputStream1 = new DataOutputStream(socket.getOutputStream());
            dOutputStream1.write(handshake);

            //set the length of fileSize of inputstream to be read
            byte[] outputBytes = new byte[fileSize];

            //output the data to a new file
            FileOutputStream fileOutputStream = new FileOutputStream("./file/received/output.jpg");
            
            //read the input into 'b' byte of length 'fileSize'
            iStream.read(outputBytes);

            //output into 'b'
            fileOutputStream.write(outputBytes);

        }

    }

}
