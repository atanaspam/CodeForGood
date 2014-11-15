/**
 * 
 */
package jpm.codeforgood.model;

/**
 * @author Atanas
 *
 */
public class chatlog {
	
	private String MsgFrom;
	private String MsgTo;
	private String Msg;
	private String Msg_Sent;
	
	
	public chatlog(String msgFrom, String msgTo, String msg, String msg_Sent) {
		super();
		MsgFrom = msgFrom;
		MsgTo = msgTo;
		Msg = msg;
		Msg_Sent = msg_Sent;
	}
	
	
	public String getMsgFrom() {
		return MsgFrom;
	}
	public void setMsgFrom(String msgFrom) {
		MsgFrom = msgFrom;
	}
	public String getMsgTo() {
		return MsgTo;
	}
	public void setMsgTo(String msgTo) {
		MsgTo = msgTo;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public String getMsg_Sent() {
		return Msg_Sent;
	}
	public void setMsg_Sent(String msg_Sent) {
		Msg_Sent = msg_Sent;
	}

}
