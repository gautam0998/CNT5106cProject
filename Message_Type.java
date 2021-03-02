package  newpackage;

public enum Message_Type {
    choke(0),
    unchoke(1),
    interested(2),
    not_interested(3),
    have(4),
    bitfield(5),
    request(6),
    piece(7);

    private byte msg_val;

    private Message_Type(int msg_val) {
        if (msg_val >= 0 && msg_val <= 7) {   //For valid values
            this.msg_val = (byte) msg_val; //Manual Casting
        } 
    }

    public byte getmsg_val() {
        return this.msg_val;
    }
}


