package com.trf.beans;

public class TRFMessage {
    private int uid;
    private String msg;
    private int trfid;
    private String flag;
    private String timestamp;

    public TRFMessage() {
        super();
    }



    public TRFMessage(int uid, String msg, int trfid, String flag, String timestamp) {
		super();
		this.uid = uid;
		this.msg = msg;
		this.trfid = trfid;
		this.flag = flag;
		this.setTimestamp(timestamp);
	}



	public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTrfid() {
        return trfid;
    }

    public void setTrfid(int trfid) {
        this.trfid = trfid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTimestamp() {
		return timestamp;
	}



	@Override
	public String toString() {
		return "TRFMessage [uid=" + uid + ", msg=" + msg + ", trfid=" + trfid + ", flag=" + flag + ", timestamp="
				+ timestamp + "]";
	}



	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}