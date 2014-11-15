package jpm.codeforgood.model;

public class chatsetup {
	
	private String UserName1;
	private String UserName2;
	private String Created;
	
	
	public chatsetup(String userName1, String userName2, String created) {
		super();
		UserName1 = userName1;
		UserName2 = userName2;
		Created = created;
	}
	
	
	
	public String getUserName1() {
		return UserName1;
	}
	public void setUserName1(String userName1) {
		UserName1 = userName1;
	}
	public String getUserName2() {
		return UserName2;
	}
	public void setUserName2(String userName2) {
		UserName2 = userName2;
	}
	public String getCreated() {
		return Created;
	}
	public void setCreated(String created) {
		Created = created;
	}

}
