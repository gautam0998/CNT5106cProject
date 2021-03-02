package  newpackage;

import java.net.Socket;

public class Peer {
    private int peerID;
    private String hostName;
    private int portNumber;
    private boolean isFile;
    private byte[] bitField;
    private boolean choked;
    private long downloadSpeed;
    private Socket hostSocket;


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
 * @param choked Boolean value to determine if the peer is chocked or unchoked
 * 
 * @param downloadSpeed To determine the download speed of peer
 * 
 * @param hostSocket The socket of host to be connected to
 */

 /**
  * Constructor
  */
public Peer() {

}

/**
* Setting and getting values
*/

/**
* peerID
*/

public void setpeerID(int peerID) {
    this.peerID = peerID;
}

public int getpeerID() {
    return peerID;
}


/**
* hostName
*/

public void sethostName(String hostName) {
    this.hostName = hostName;
}

public String gethostName() {
    return hostName;
}


/**
* portNumber
*/

public void setportNumber(int portNumber) {
    this.portNumber = portNumber;
}

public int getportNumber() {
    return portNumber;
}


/**
* isFile
*/

public void setisFile(boolean isFile) {
    this.isFile = isFile;
}

public void setisFile(String isFile) {
    this.isFile = Integer.parseInt(isFile) == 0 ? false : true ;
}

public boolean getisFile() {
    return isFile;
}


/**
* bitField
*/

public void setbitField (byte[] bitField) {
    this.bitField = bitField;
}

public byte[] getbitField () {
    return bitField;
}


/**
* Choked
*/

public void setchoked (boolean choked) {
    this.choked = choked;
}

public boolean getchoked () {
    return choked;
}


/**
* downloadSpeed
*/

public void setdownloadSpeed (long downloadSpeed) {
    this.downloadSpeed = downloadSpeed;
}

public long getdownloadSpeed () {
    return downloadSpeed;
}


/**
* hostSocket
*/

public void sethostSocket (Socket hostSocket) {
    this.hostSocket = hostSocket;
}

public Socket gethostSocket () {
    return hostSocket;
}

}