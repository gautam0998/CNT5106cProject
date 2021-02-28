
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