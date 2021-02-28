
import java.net.Socket;

public class Peer {
    private int peerID;
    private String hostName;
    private int portNumber;
    private boolean isFile;
    private byte[] bitField;
    private boolean chocked;
    private long downloadSpeed;
    private Socket hostSocket;

}

/**
 * @param peerID Special Peer ID assigned to each Peer
 * 
 * @param hostName The Hostname given to each host
 * 
 * @param portNumber The port number used for connection
 * 
 * @param isFile Boolean value to see if the peer has the file or not
 * 
 * @param bitField To show which all pieces are present
 * 
 * @param chocked Boolean value to determine if the peer is chocked or unchocked
 * 
 * @param downloadSpeed To determine the download speed of peer
 * 
 * @param hostSocket The socket of host to be connected to
 */